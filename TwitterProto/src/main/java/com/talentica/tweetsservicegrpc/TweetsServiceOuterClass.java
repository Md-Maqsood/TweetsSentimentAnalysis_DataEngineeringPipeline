// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TweetsService.proto

package com.talentica.tweetsservicegrpc;

public final class TweetsServiceOuterClass {
  private TweetsServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TweetData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TweetData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SaveResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SaveResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023TweetsService.proto\"\216\001\n\tTweetData\022\n\n\002i" +
      "d\030\001 \001(\t\022\014\n\004text\030\002 \001(\t\022\020\n\010authorId\030\003 \001(\t\022" +
      "\021\n\tcreatedAt\030\004 \001(\t\022\025\n\rnegativeScore\030\005 \001(" +
      "\001\022\024\n\014neutralScore\030\006 \001(\001\022\025\n\rpositiveScore" +
      "\030\007 \001(\001\"\037\n\014SaveResponse\022\017\n\007isSaved\030\001 \001(\0102" +
      "d\n\rTweetsService\022&\n\tsaveTweet\022\n.TweetDat" +
      "a\032\r.SaveResponse\022+\n\nsaveTweets\022\n.TweetDa" +
      "ta\032\r.SaveResponse(\0010\001B#\n\037com.talentica.t" +
      "weetsservicegrpcP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_TweetData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_TweetData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TweetData_descriptor,
        new java.lang.String[] { "Id", "Text", "AuthorId", "CreatedAt", "NegativeScore", "NeutralScore", "PositiveScore", });
    internal_static_SaveResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_SaveResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SaveResponse_descriptor,
        new java.lang.String[] { "IsSaved", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
