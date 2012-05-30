package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@ViewController
public class TesteMB {
    
    private Twitter twitter;

    @PostConstruct
    public void iniciarTwitter(){
        twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer("UmLHkNzpWAIpX9DRGQkgA", "WGahcHnORPbfshrxluIQeHCg7Gk6NEoERTT7aRKao");
        AccessToken at = new AccessToken("395297459-a71hXYH0NNdS8jUyB8yqzhudZPTsksmK0k4L3Dha", "rEx85hBJXEUBQnM2YD7hzRrAtRTrxWUDJy5ctG5k");
        twitter.setOAuthAccessToken(at);
    }
    
    
    
    private String message;
    @Inject
    private MessageContext messageContext;
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public List<Status> getMessages(){
        try {
            return twitter.getHomeTimeline();
        } catch (TwitterException ex) {
            ex.printStackTrace();
            return new ArrayList<Status>();
        }
    } 
    
    public void sendTwitt(){
        try {
            Status s = twitter.updateStatus(message);
            messageContext.add("Postado no  Twitter: " + s.getText(), SeverityType.INFO);
        } catch (TwitterException ex) {
            messageContext.add(ex.getMessage(), SeverityType.ERROR);
        }
    }
}
