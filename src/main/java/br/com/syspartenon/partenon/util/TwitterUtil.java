package br.com.syspartenon.partenon.util;

import br.com.syspartenon.partenon.domain.Site;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterUtil {
    private static Twitter twitter;

    private TwitterUtil(){}
    
    public static Twitter getTwitter(TwitterAuthData authData) throws TwitterException {
        if (twitter == null) {
            twitter = TwitterFactory.getSingleton();
            twitter.setOAuthConsumer(authData.getConsumerKey(), authData.getConsumerSecret());
            twitter.setOAuthAccessToken(new AccessToken(authData.getAccessToken(), authData.getAccessTokenSecret()));
        }
        return twitter;
    }
    
    public static TwitterAuthData convert(Site site){
        TwitterAuthData authData = new TwitterAuthData();
        authData.setAccessToken(site.getSitTwtAccessToken());
        authData.setAccessTokenSecret(site.getSitTwtAccessTokenSecret());
        authData.setConsumerKey(site.getSitTwtConsumerKey());
        authData.setConsumerSecret(site.getSitTwtConsumerSecret());
        return authData;
    }
}
