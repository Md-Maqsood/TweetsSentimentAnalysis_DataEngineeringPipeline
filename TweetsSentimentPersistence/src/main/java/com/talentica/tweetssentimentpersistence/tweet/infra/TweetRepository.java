package com.talentica.tweetssentimentpersistence.tweet.infra;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, String>{
	
}
