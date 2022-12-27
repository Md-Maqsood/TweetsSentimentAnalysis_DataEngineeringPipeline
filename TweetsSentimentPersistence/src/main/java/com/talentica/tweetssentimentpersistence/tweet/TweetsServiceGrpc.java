package com.talentica.tweetssentimentpersistence.tweet;

import org.springframework.beans.factory.annotation.Autowired;

import com.talentica.tweetssentimentpersistence.tweet.infra.Tweet;
import com.talentica.tweetsservicegrpc.SaveResponse;
import com.talentica.tweetsservicegrpc.TweetData;
import com.talentica.tweetsservicegrpc.TweetsServiceGrpc.TweetsServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class TweetsServiceGrpc extends TweetsServiceImplBase{
	
	@Autowired
	TweetService tweetService;

	@Override
	public void saveTweet(TweetData request, StreamObserver<SaveResponse> responseObserver) {
		Tweet tweet = new Tweet(request.getId(),
				request.getText(),
				request.getAuthorId(),
				request.getCreatedAt(),
				request.getNegativeScore(),
				request.getNeutralScore(),
				request.getPositiveScore());
		boolean isCreated = tweetService.createTweet(tweet);
		SaveResponse saveResponse = SaveResponse.newBuilder().setIsSaved(isCreated).build();
		responseObserver.onNext(saveResponse);
		responseObserver.onCompleted();
	}

	@Override
	public StreamObserver<TweetData> saveTweets(StreamObserver<SaveResponse> responseObserver) {
		return new StreamObserver<TweetData>() {

			@Override
			public void onNext(TweetData value) {
				Tweet tweet = new Tweet(value.getId(),
								value.getText(),
								value.getAuthorId(),
								value.getCreatedAt(),
								value.getNegativeScore(),
								value.getNeutralScore(),
								value.getPositiveScore());
				boolean isCreated = tweetService.createTweet(tweet);
				SaveResponse saveResponse = SaveResponse.newBuilder().setIsSaved(isCreated).build();
				responseObserver.onNext(saveResponse);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println(t);
			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();
			}
		};
	}
	
	

}
