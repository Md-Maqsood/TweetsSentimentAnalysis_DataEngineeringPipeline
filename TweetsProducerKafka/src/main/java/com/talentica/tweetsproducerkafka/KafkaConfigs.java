package com.talentica.tweetsproducerkafka;

public class KafkaConfigs {
	public static final String BOOTSTRAP_SERVERS  = "127.0.0.1:9092";
	public static final String TOPIC = "Twitter-Messages";
	public static final String ACKS_CONFIG = "all";
	public static final String MAX_IN_FLIGHT_CONN = "5";
	public static final String COMPRESSION_TYPE = "snappy";
	public static final String RETRIES_CONFIG = Integer.toString(Integer.MAX_VALUE);
	public static final String LINGER_CONFIG = "20";
	public static final String BATCH_SIZE = Integer.toString(32*1024);
}
