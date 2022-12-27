# TweetsSentimentAnalysis_DataEngineeringPipeline

The data pipeline live streams tweets based on keywords in a keywords file (currently terms are related to economy) from the twitter API, processes it using apache spark, performs sentiment analysis of the tweet using NLP model Roberta and stores the results in a postgres database.

Structure and Tech Stack is as follows:


						      (Java)            (Java)            	(Java, Springboot)
					Twitter API----->Apache Kafka------>Apache Spark------------------>Postgres
									    ||\			GRPC
									    ||
									    ||
									    ||
									    || REST
									    ||
									    ||
									   \||
							    Sentiment Analysis Model Roberta
								    (Python, FastAPI)



TweetsProducerKafka: Java Maven project with kafka producer that accesses the twitter API V2 and sends data about tweets to kafka topic. Replace the bearer token inside TwitterConfigs.java with proper bearer token of a twitter developer account to connect to the API.

SentimentAnalyserRoberta: REST API developed wiht FastAPI in python to access the ROBERTA sentiment analysis machine-learning model. IT accepts the text of the tweet     and return the probablity scores of tweet being negative, neutral or positive

  Start the api with this command in the project directory: python -m uvicorn main:app --reload
  
  
TweetProcessorSpark: Java maven project with kafka consumers that picks up tweets data from kafka topic and processes it using spark making api call to other services. To run it you need to perform maven build and spark-submit the jar from project directory as follows:
  
  spark-submit --class com.talentica.tweetprocessorspark.App --master local[2] target\TweetProcessorSpark-0.0.1-SNAPSHOT.jar --jars kafka-clients-0.10.0.1.jar spark-streaming_2.11-2.4.7.jar spark-streaming-kafka-0-10_2.11-2.3.0.jar
  
  You must have the additional jars mentioned in the command in the project directory
  
TweetsSentimentPersistence: Java Springboot GRPC Server that persists the tweets analysis data in a postgres database.
