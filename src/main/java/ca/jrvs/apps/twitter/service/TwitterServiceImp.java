package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dto.Tweet;
import ca.jrvs.apps.twitter.util.TweetUtil;

import java.io.IOException;

public class TwitterServiceImp implements TwitterService {

    private CrdRepository dao;

    public TwitterServiceImp(CrdRepository dao){this.dao = dao;}
    @Override
    public Tweet postTweet(String text, Double Latitude, Double Longitude) {
        Tweet postTweet = TweetUtil.buildTweet(text,Longitude,Latitude);
        TweetUtil.validatePostTweet(postTweet.getText(),Longitude,Latitude);
        try{
            Tweet responseTweet = (Tweet) dao.create(postTweet);
            printTweet(responseTweet);
    }catch(Exception e){
        throw new RuntimeException("Failure",e);}
        return postTweet;
    }

    private void printTweet(Tweet responseTweet) {
        System.out.println(responseTweet);
    }


    @Override
    public void showTweet(String id, String[] fields) {
        if(!TweetUtil.validId.test(id)){
            throw new IllegalArgumentException("ID must be number");
        }
        try{
            Tweet tweet = (Tweet) dao.findById(id);
            printTweet(selectFields(tweet,fields));
        }catch(IOException e){
            throw new RuntimeException("Failure",e);
        }

    }
    protected Tweet selectFields(Tweet tweet, String[]
            fields) throws IOException{
        return tweet;
    }

    @Override
    public void deleteTweets(String[] Objectids){

    }

}
