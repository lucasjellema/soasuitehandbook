package saibot.airport.services.spring;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.logging.Level;

import oracle.soa.platform.component.spring.beans.ILoggerBean;

import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import twitter4j.conf.ConfigurationBuilder;

public class TwitterClient implements TwitterMessageSender {

    private final String consumerKey = "provideYourValue";
    private final String consumerSecret = "provideYourValue";
    private final String accessToken = "provideYourValue";
    private final String accessTokenSecret = "provideYourValue";
    
    private ILoggerBean logger;

    public void setLogger(ILoggerBean logger) {
        this.logger = logger;
    }

    public void sendDirectMessage(String message, String recipient) {
        Twitter sender = constructTwitterInstance();
        //    StatusUpdate su = new StatusUpdate("Trying to create a Java Class against the Twitter API");
        //                       Status status = sender.updateStatus(su);
        //                           System.out.println("Successfully updated the status to [" + status.getText() + "].");

        DirectMessage directmessage;
        try {
            directmessage = sender.sendDirectMessage(recipient, message);
                System.out.println("SOP Sent: " + directmessage.getText() + " to @" + directmessage.getRecipientScreenName());
            if (logger!=null) {
                logger.log(Level.INFO, "Sent: " + directmessage.getText() + " to @" + directmessage.getRecipientScreenName());
            }
            } catch (TwitterException e) {
                
                e.printStackTrace();
                if (logger!=null) {
                    logger.log(Level.WARNING, "Failed to send Direct Twitter Message to "+recipient,e);
                }

            }
         catch (Exception e) {
            
            e.printStackTrace();
            if (logger!=null) {
                logger.log(Level.WARNING, "Failed to send Direct Twitter Message to "+recipient,e);
            }

        }


    }

    private Twitter constructTwitterInstance() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret).setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret);
        Twitter sender = new TwitterFactory(cb.build()).getInstance();
        return sender;
    }

    public static void main(String[] args) throws TwitterException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
        new TwitterClient().sendDirectMessage("FLight - KL 423 - Status Update at " + sdf.format(new Date()) +
                                                    " - Boarding at Gate 45 ", "lucasjellema");
    }
//
//    @Override
//    public void updateStatus(String message) {
//        Twitter sender = constructTwitterInstance();
//        try {
//            sender.updateStatus(message);
//            System.out.println("Updated Twitter Status to "+message);
//        } catch (TwitterException e) {
//            e.printStackTrace();
//            if (logger!=null) {
//                logger.log(Level.WARNING, "Failed to update Twitter Status",e);
//            }
//        }
//        catch (Exception e) {
//           
//           e.printStackTrace();
//           if (logger!=null) {
//               logger.log(Level.WARNING, "Failed to update Twitter Status",e);
//           }
//
//        }
//
//    }
}
