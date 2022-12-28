package com.talentica.tweetssentimentpersistence.tweet.infra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tweets")
public class Tweet {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "author_id")
	private String authorId;
	
	@Column(name = "created_at")
	private String createdAt;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_handle")
	private String userHandle;
	
	@Column(name = "user_location")
	private String userLocation;
	
	@Column(name = "is_verified")
	private Boolean isVerified;
	
	@Column(name = "followers_count")
	private Integer followersCount;
	
	@Column(name = "tweet_count")
	private Integer tweetCount;
	
	@Column(name = "negative_score")
	private Double negativeScore;
	
	@Column(name = "neutral_score")
	private Double neutralScore;
	
	@Column(name = "positive_score")
	private Double positiveScore;
	
	public Tweet() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHandle() {
		return userHandle;
	}

	public void setUserHandle(String userHandle) {
		this.userHandle = userHandle;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Integer getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(Integer followersCount) {
		this.followersCount = followersCount;
	}

	public Integer getTweetCount() {
		return tweetCount;
	}

	public void setTweetCount(Integer tweetCount) {
		this.tweetCount = tweetCount;
	}

	public Double getNegativeScore() {
		return negativeScore;
	}

	public void setNegativeScore(Double negativeScore) {
		this.negativeScore = negativeScore;
	}

	public Double getNeutralScore() {
		return neutralScore;
	}

	public void setNeutralScore(Double neutralScore) {
		this.neutralScore = neutralScore;
	}

	public Double getPositiveScore() {
		return positiveScore;
	}

	public void setPositiveScore(Double positiveScore) {
		this.positiveScore = positiveScore;
	}

	public Tweet(String id, String text, String authorId, String createdAt, String userName, String userHandle,
			String userLocation, Boolean isVerified, Integer followersCount, Integer tweetCount, Double negativeScore,
			Double neutralScore, Double positiveScore) {
		super();
		this.id = id;
		this.text = text;
		this.authorId = authorId;
		this.createdAt = createdAt;
		this.userName = userName;
		this.userHandle = userHandle;
		this.userLocation = userLocation;
		this.isVerified = isVerified;
		this.followersCount = followersCount;
		this.tweetCount = tweetCount;
		this.negativeScore = negativeScore;
		this.neutralScore = neutralScore;
		this.positiveScore = positiveScore;
	}
}
