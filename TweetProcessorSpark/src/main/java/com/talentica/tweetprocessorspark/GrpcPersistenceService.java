package com.talentica.tweetprocessorspark;

import java.util.List;

import com.talentica.tweetsservicegrpc.SaveResponse;
import com.talentica.tweetsservicegrpc.TweetData;
import com.talentica.tweetsservicegrpc.TweetsServiceGrpc;
import com.talentica.tweetsservicegrpc.TweetsServiceGrpc.TweetsServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class GrpcPersistenceService {
	
	private ManagedChannel channel;
	
	private TweetsServiceStub asyncStub;
	
	public GrpcPersistenceService(String address, int port) {
		this.channel = ManagedChannelBuilder.forAddress(address, port)
				.usePlaintext()
				.build();
		this.asyncStub = TweetsServiceGrpc.newStub(this.channel);
	}
	
	public void saveTweetsData(List<String[]> tweetsdata) {
		 StreamObserver<TweetData> streamObserver = asyncStub.saveTweets(new StreamObserver<SaveResponse>() {

			@Override
			public void onNext(SaveResponse value) {
				System.out.println(value);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println(t);
			}

			@Override
			public void onCompleted() {}
		});
		 
		 tweetsdata.forEach((tweetdata)->{
			 String[] sentiments = tweetdata[10].split(" ");
			 streamObserver.onNext(TweetData.newBuilder()
						.setId(tweetdata[0])
						.setText(tweetdata[1])
						.setAuthorId(tweetdata[2])
						.setCreatedAt(tweetdata[3])
						.setUserLocation(tweetdata[4])
						.setUserName(tweetdata[5])
						.setUserHandle(tweetdata[6])
						.setIsVerified(Boolean.parseBoolean(tweetdata[7]))
						.setFollowersCount(Integer.parseInt(tweetdata[8]))
						.setTweetCount(Integer.parseInt(tweetdata[9]))
						.setNegativeScore(Double.parseDouble(sentiments[0]))
						.setNeutralScore(Double.parseDouble(sentiments[1]))
						.setPositiveScore(Double.parseDouble(sentiments[2]))
						.build());
		 	});
		 
		 streamObserver.onCompleted();
	}

}
