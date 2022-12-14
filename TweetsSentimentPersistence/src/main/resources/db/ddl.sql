CREATE TABLE TWEETS(
	ID VARCHAR(25) PRIMARY KEY,
	TEXT VARCHAR(3000),
	AUTHOR_ID VARCHAR(25),
	CREATED_AT VARCHAR(30),
	USER_NAME VARCHAR(80),
	USER_HANDLE VARCHAR(80),
	USER_LOCATION VARCHAR(100),
	FOLLOWERS_COUNT INTEGER,
	TWEET_COUNT INTEGER,
	IS_VERIFIED BOOLEAN,
	NEGATIVE_SCORE FLOAT8,
	NEUTRAL_SCORE FLOAT8,
	POSITIVE_SCORE FLOAT8);