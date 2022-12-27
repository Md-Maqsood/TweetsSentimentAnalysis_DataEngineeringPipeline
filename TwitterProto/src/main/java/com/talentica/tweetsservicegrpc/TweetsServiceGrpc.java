package com.talentica.tweetsservicegrpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: TweetsService.proto")
public final class TweetsServiceGrpc {

  private TweetsServiceGrpc() {}

  public static final String SERVICE_NAME = "TweetsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.talentica.tweetsservicegrpc.TweetData,
      com.talentica.tweetsservicegrpc.SaveResponse> getSaveTweetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveTweet",
      requestType = com.talentica.tweetsservicegrpc.TweetData.class,
      responseType = com.talentica.tweetsservicegrpc.SaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.talentica.tweetsservicegrpc.TweetData,
      com.talentica.tweetsservicegrpc.SaveResponse> getSaveTweetMethod() {
    io.grpc.MethodDescriptor<com.talentica.tweetsservicegrpc.TweetData, com.talentica.tweetsservicegrpc.SaveResponse> getSaveTweetMethod;
    if ((getSaveTweetMethod = TweetsServiceGrpc.getSaveTweetMethod) == null) {
      synchronized (TweetsServiceGrpc.class) {
        if ((getSaveTweetMethod = TweetsServiceGrpc.getSaveTweetMethod) == null) {
          TweetsServiceGrpc.getSaveTweetMethod = getSaveTweetMethod = 
              io.grpc.MethodDescriptor.<com.talentica.tweetsservicegrpc.TweetData, com.talentica.tweetsservicegrpc.SaveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TweetsService", "saveTweet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.talentica.tweetsservicegrpc.TweetData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.talentica.tweetsservicegrpc.SaveResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TweetsServiceMethodDescriptorSupplier("saveTweet"))
                  .build();
          }
        }
     }
     return getSaveTweetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.talentica.tweetsservicegrpc.TweetData,
      com.talentica.tweetsservicegrpc.SaveResponse> getSaveTweetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveTweets",
      requestType = com.talentica.tweetsservicegrpc.TweetData.class,
      responseType = com.talentica.tweetsservicegrpc.SaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.talentica.tweetsservicegrpc.TweetData,
      com.talentica.tweetsservicegrpc.SaveResponse> getSaveTweetsMethod() {
    io.grpc.MethodDescriptor<com.talentica.tweetsservicegrpc.TweetData, com.talentica.tweetsservicegrpc.SaveResponse> getSaveTweetsMethod;
    if ((getSaveTweetsMethod = TweetsServiceGrpc.getSaveTweetsMethod) == null) {
      synchronized (TweetsServiceGrpc.class) {
        if ((getSaveTweetsMethod = TweetsServiceGrpc.getSaveTweetsMethod) == null) {
          TweetsServiceGrpc.getSaveTweetsMethod = getSaveTweetsMethod = 
              io.grpc.MethodDescriptor.<com.talentica.tweetsservicegrpc.TweetData, com.talentica.tweetsservicegrpc.SaveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "TweetsService", "saveTweets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.talentica.tweetsservicegrpc.TweetData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.talentica.tweetsservicegrpc.SaveResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TweetsServiceMethodDescriptorSupplier("saveTweets"))
                  .build();
          }
        }
     }
     return getSaveTweetsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TweetsServiceStub newStub(io.grpc.Channel channel) {
    return new TweetsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TweetsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TweetsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TweetsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TweetsServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TweetsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void saveTweet(com.talentica.tweetsservicegrpc.TweetData request,
        io.grpc.stub.StreamObserver<com.talentica.tweetsservicegrpc.SaveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveTweetMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.talentica.tweetsservicegrpc.TweetData> saveTweets(
        io.grpc.stub.StreamObserver<com.talentica.tweetsservicegrpc.SaveResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSaveTweetsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSaveTweetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.talentica.tweetsservicegrpc.TweetData,
                com.talentica.tweetsservicegrpc.SaveResponse>(
                  this, METHODID_SAVE_TWEET)))
          .addMethod(
            getSaveTweetsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.talentica.tweetsservicegrpc.TweetData,
                com.talentica.tweetsservicegrpc.SaveResponse>(
                  this, METHODID_SAVE_TWEETS)))
          .build();
    }
  }

  /**
   */
  public static final class TweetsServiceStub extends io.grpc.stub.AbstractStub<TweetsServiceStub> {
    private TweetsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TweetsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TweetsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TweetsServiceStub(channel, callOptions);
    }

    /**
     */
    public void saveTweet(com.talentica.tweetsservicegrpc.TweetData request,
        io.grpc.stub.StreamObserver<com.talentica.tweetsservicegrpc.SaveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveTweetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.talentica.tweetsservicegrpc.TweetData> saveTweets(
        io.grpc.stub.StreamObserver<com.talentica.tweetsservicegrpc.SaveResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSaveTweetsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TweetsServiceBlockingStub extends io.grpc.stub.AbstractStub<TweetsServiceBlockingStub> {
    private TweetsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TweetsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TweetsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TweetsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.talentica.tweetsservicegrpc.SaveResponse saveTweet(com.talentica.tweetsservicegrpc.TweetData request) {
      return blockingUnaryCall(
          getChannel(), getSaveTweetMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TweetsServiceFutureStub extends io.grpc.stub.AbstractStub<TweetsServiceFutureStub> {
    private TweetsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TweetsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TweetsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TweetsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.talentica.tweetsservicegrpc.SaveResponse> saveTweet(
        com.talentica.tweetsservicegrpc.TweetData request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveTweetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE_TWEET = 0;
  private static final int METHODID_SAVE_TWEETS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TweetsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TweetsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE_TWEET:
          serviceImpl.saveTweet((com.talentica.tweetsservicegrpc.TweetData) request,
              (io.grpc.stub.StreamObserver<com.talentica.tweetsservicegrpc.SaveResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE_TWEETS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.saveTweets(
              (io.grpc.stub.StreamObserver<com.talentica.tweetsservicegrpc.SaveResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TweetsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TweetsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.talentica.tweetsservicegrpc.TweetsServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TweetsService");
    }
  }

  private static final class TweetsServiceFileDescriptorSupplier
      extends TweetsServiceBaseDescriptorSupplier {
    TweetsServiceFileDescriptorSupplier() {}
  }

  private static final class TweetsServiceMethodDescriptorSupplier
      extends TweetsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TweetsServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TweetsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TweetsServiceFileDescriptorSupplier())
              .addMethod(getSaveTweetMethod())
              .addMethod(getSaveTweetsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
