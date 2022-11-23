package com.talentica.tweetprocessorspark;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ExternalAPIServices {
	
	private static final String PERSISTENCE_API_URI = "http://localhost:8080/api/tweet/create";

	private static final String SENTIMENT_API_URI = "http://localhost:8000/sentiment";
	
	public static void saveTweetData(String id, String text, String authorId, String createdAt, Double negativeScore, Double neutralScore, Double positiveScore)
			throws URISyntaxException, IOException {
		HttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build();

		URIBuilder uriBuilder = new URIBuilder(PERSISTENCE_API_URI);

		HttpPost httpPost = new HttpPost(uriBuilder.build());
		httpPost.setHeader("content-type", "application/json");
		text = text.replace("\n", "\\n");
		String jsonStringBody = String.format("{\"id\": \"%s\",\"text\": \"%s\",\"authorId\": \"%s\",\"createdAt\": \"%s\",\"negativeScore\": %s,\"neutralScore\": %s,\"positiveScore\": %s}",
												id,
												text,
												authorId,
												createdAt,
												negativeScore,
												neutralScore,
												positiveScore);
		StringEntity body = new StringEntity(jsonStringBody);
		httpPost.setEntity(body);
		HttpResponse response = httpClient.execute(httpPost);
		if(response.getStatusLine().getStatusCode()==400) {
			text = "tweet text";
			jsonStringBody = String.format("{\"id\": \"%s\",\"text\": \"%s\",\"authorId\": \"%s\",\"createdAt\": \"%s\",\"negativeScore\": %s,\"neutralScore\": %s,\"positiveScore\": %s}",
												id,
												text,
												authorId,
												createdAt,
												negativeScore,
												neutralScore,
												positiveScore);
			body = new StringEntity(jsonStringBody);
			httpPost.setEntity(body);
			httpClient.execute(httpPost);
		}
	}
	
	public static String getSentiment(String text) throws URISyntaxException, IOException {
		HttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build();
		URIBuilder uriBuilder = new URIBuilder(SENTIMENT_API_URI).addParameter("tweet", text);
		HttpGet httpGet = new HttpGet(uriBuilder.build());
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (null != entity)
			return EntityUtils.toString(entity, "UTF-8");
		return "";
	}
}
