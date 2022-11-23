from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from TweetSentiment import TweetSentiment

origins = ['*']
app = FastAPI()
app.add_middleware(CORSMiddleware, allow_origins = origins, allow_credentials = True, allow_methods = ['*'], allow_headers = ['*'])

tweetSentiment = TweetSentiment();

@app.get("/sentiment")
def root(tweet): return tweetSentiment.getSentimentOf(tweet)
