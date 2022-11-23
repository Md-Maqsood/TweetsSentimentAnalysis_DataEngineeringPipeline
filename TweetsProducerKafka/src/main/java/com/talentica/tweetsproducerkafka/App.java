package com.talentica.tweetsproducerkafka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONException;
import org.json.JSONObject;

public class App {
	
	private static final String KEYWORDS_FILE_PATH="keywords.txt";

	private static KafkaProducer<String, String> kafkaProducer;

	public static void main(String[] args) {
		kafkaProducer = KafkaMessageProducer.getNewKafkaProducer();
		Map<String, String> rules = new HashMap<>();
		rules.put("("+getWordsToTrack().replace(" "," OR ").replace("-"," ")+") -is:retweet -is:nullcast","economy");
		try {
			TwitterClientUtil.setupRules(TwitterConfigs.BEARER_TOKEN, rules);
			connectStream(TwitterConfigs.BEARER_TOKEN);
		} catch (IOException | URISyntaxException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private static void connectStream(String bearerToken) throws IOException, URISyntaxException {

		HttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build();

		URIBuilder uriBuilder = new URIBuilder("https://api.twitter.com/2/tweets/search/stream?tweet.fields=created_at&expansions=author_id");

		HttpGet httpGet = new HttpGet(uriBuilder.build());
		httpGet.setHeader("Authorization", String.format("Bearer %s", bearerToken));

		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (null != entity) {
			BufferedReader reader = new BufferedReader(new InputStreamReader((entity.getContent())));
			String line = reader.readLine();
			while (line != null) {
				try {
					JSONObject data = new JSONObject(line);
					JSONObject tweet = data.getJSONObject("data");
					String authorId = (String)tweet.get("author_id");
					String tweetId = (String)tweet.get("id");
					String createdAt = (String)tweet.get("created_at");
					String tweetText = (String)tweet.get("text");
					String msg = tweetId+"-||-"+tweetText+"-||-"+authorId+"-||-"+createdAt;
//					System.out.println(msg);
					kafkaProducer.send(new ProducerRecord<String, String>(KafkaConfigs.TOPIC, msg));
					}
				catch(JSONException e) {
					System.out.println(e.getMessage()+", Line: "+line);
				}
				line = reader.readLine();
			}
		}
		System.out.println("Application ended");
	}
	
	private static String getWordsToTrack() {
		try (BufferedReader reader = new BufferedReader(new FileReader(KEYWORDS_FILE_PATH))) {
			return reader.readLine();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return "";
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return "";
		}
	}
}
