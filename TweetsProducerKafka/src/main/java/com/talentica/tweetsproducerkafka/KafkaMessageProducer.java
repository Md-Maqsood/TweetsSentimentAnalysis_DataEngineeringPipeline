package com.talentica.tweetsproducerkafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;


public class KafkaMessageProducer {
	
	public static KafkaProducer<String, String> getNewKafkaProducer(){
		Properties properties = new Properties();
		
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfigs.BOOTSTRAP_SERVERS);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	    properties.setProperty(ProducerConfig.ACKS_CONFIG, KafkaConfigs.ACKS_CONFIG);
	    properties.setProperty(ProducerConfig.RETRIES_CONFIG, KafkaConfigs.RETRIES_CONFIG);
	    properties.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, KafkaConfigs.MAX_IN_FLIGHT_CONN);
	    properties.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, KafkaConfigs.COMPRESSION_TYPE);
	    properties.setProperty(ProducerConfig.LINGER_MS_CONFIG, KafkaConfigs.LINGER_CONFIG);
	    properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, KafkaConfigs.BATCH_SIZE);
	    
	    return new KafkaProducer<String, String>(properties);
	}
}
