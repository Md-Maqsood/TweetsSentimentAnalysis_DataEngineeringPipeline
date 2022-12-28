package com.talentica.tweetprocessorspark;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;

public class App {

	private static final Integer BUFFER = 30;
	
	private static final int SERVER_PORT = 9000;
	
	private static final String SERVER_ADDRESS = "localhost";
			
	public static void main(String[] args) {
				
		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("SparkKafkaTwitter");
		
		JavaStreamingContext streamingContext = new JavaStreamingContext(conf, Durations.seconds(BUFFER));
				
		JavaInputDStream<ConsumerRecord<String, String>> messageStream = KafkaUtils.createDirectStream(
				streamingContext,
				LocationStrategies.PreferConsistent(),
				ConsumerStrategies.<String, String>Subscribe(
						Arrays.asList("Twitter-Messages"),
						Arrays.stream(new Object[][] {
							{"bootstrap.servers","localhost:9092"},
							{"key.deserializer",StringDeserializer.class},
							{"value.deserializer",StringDeserializer.class},
							{"group.id","id1"},
							{"auto.offset.reset","latest"},
							{"enable.auto.commit","false"}
						}).collect(Collectors.toMap(entry->(String)entry[0], entry->entry[1]))));
		
		messageStream.map(record-> record.value().split("\\-\\|\\|\\-"))
		.<String[]>map(tweet->{
			String tweetText = Arrays.stream(tweet[1].split(" ")).map((word)->{
				if(word.startsWith("@") && word.length()>1) return "@user";
				else if(word.startsWith("http")) return "http";
				return word;
			}).collect(Collectors.joining(" "));
			String sentiment = ExternalAPIServices.getSentiment(tweetText);
			return new String[] {tweet[0],
								tweet[1],
								tweet[2],
								tweet[3],
								tweet[4],
								tweet[5],
								tweet[6],
								tweet[7],
								tweet[8],
								tweet[9],
								sentiment.substring(1, sentiment.length()-1)};
		}).foreachRDD((javaRdd) -> { new GrpcPersistenceService(SERVER_ADDRESS, SERVER_PORT).saveTweetsData(javaRdd.collect());});
		
		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {
				System.out.println("Stopping spark app..");
				streamingContext.close();
				System.out.println("Spark application stopped. Exiting application.");
			}
        	
        });
		
		streamingContext.start();
		try {
			streamingContext.awaitTermination();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
