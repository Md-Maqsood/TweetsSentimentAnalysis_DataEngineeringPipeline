package com.talentica.tweetssentimentpersistence.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentica.tweetssentimentpersistence.tweet.TweetService;
import com.talentica.tweetssentimentpersistence.tweet.infra.Tweet;

@RestController
@RequestMapping(TweetController.BASE_URL)
public class TweetController {
	
	public static final String BASE_URL = "/api/tweet";
	
	@Autowired
	private TweetService tweetService;

	@PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Boolean> createTweet(@RequestBody Tweet tweet) throws Exception{
		return ResponseEntity.ok(tweetService.createTweet(tweet));
	}
}
