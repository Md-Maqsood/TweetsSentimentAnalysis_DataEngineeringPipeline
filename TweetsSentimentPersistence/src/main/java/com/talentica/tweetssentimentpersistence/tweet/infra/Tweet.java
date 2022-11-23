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

	public Tweet(String id, String text, String authorId, String createdAt, Double negativeScore, Double neutralScore,
			Double positiveScore) {
		super();
		this.id = id;
		this.text = text;
		this.authorId = authorId;
		this.createdAt = createdAt;
		this.negativeScore = negativeScore;
		this.neutralScore = neutralScore;
		this.positiveScore = positiveScore;
	}
	
}
