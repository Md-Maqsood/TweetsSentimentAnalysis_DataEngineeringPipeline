package com.talentica.tweetprocessorspark;

import java.io.IOException;
import java.net.URISyntaxException;
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

	private static final Integer BUFFER = 60;	
		
	public static void main(String[] args) {
		
		SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("SparkKafkaTwitter");
		JavaStreamingContext streamingContext = new JavaStreamingContext(conf, Durations.seconds(BUFFER));
		
		JavaInputDStream<ConsumerRecord<String, String>> messageStream = KafkaUtils.createDirectStream(streamingContext,
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
								sentiment.substring(1, sentiment.length()-1)};
		}).foreachRDD(javaRdd->{javaRdd.collect().forEach(tweet->{
//				writer.write(Arrays.stream(tweet).collect(Collectors.joining("\n"))+"\n-----\n");
				String[] sentiments = tweet[4].split(" ");
				try {
					ExternalAPIServices.saveTweetData(tweet[0],
								tweet[1],
								tweet[2],
								tweet[3],
								Double.parseDouble(sentiments[0]),
								Double.parseDouble(sentiments[1]),
								Double.parseDouble(sentiments[2]));
				} catch (NumberFormatException | URISyntaxException | IOException e) {
					e.printStackTrace();
				}
			
		});});
		
		streamingContext.start();
		try {
			streamingContext.awaitTermination();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
