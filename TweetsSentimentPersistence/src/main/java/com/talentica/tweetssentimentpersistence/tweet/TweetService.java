package com.talentica.tweetssentimentpersistence.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentica.tweetssentimentpersistence.tweet.infra.Tweet;
import com.talentica.tweetssentimentpersistence.tweet.infra.TweetRepository;

@Service
public class TweetService {
	
	@Autowired
	private TweetRepository tweetRepository;

	public Boolean createTweet(Tweet tweet) {
		tweetRepository.save(tweet);
		return true;
	}

}
