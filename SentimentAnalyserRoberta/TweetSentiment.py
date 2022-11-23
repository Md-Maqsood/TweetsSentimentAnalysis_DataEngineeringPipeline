from transformers import AutoTokenizer, AutoModelForSequenceClassification
from scipy.special import softmax



class TweetSentiment:

    def __init__(self):
        self.model = AutoModelForSequenceClassification.from_pretrained("cardiffnlp/twitter-roberta-base-sentiment")
        self.tokenizer = AutoTokenizer.from_pretrained("cardiffnlp/twitter-roberta-base-sentiment")

    def getSentimentOf(self, tweet):
        encoded_tweet = self.tokenizer(tweet, return_tensors = 'pt')
        output = self.model(**encoded_tweet)
        scores = output[0][0].detach().numpy()
        probabilities = softmax(scores)
        return ' '.join(map(lambda x: str(x), probabilities))
        
#print(getSentimentOf('He is a good man but he is poor.'))
