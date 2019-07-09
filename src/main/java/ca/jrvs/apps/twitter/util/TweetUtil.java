package ca.jrvs.apps.twitter.util;

import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;

import java.util.Arrays;
import java.util.function.Predicate;

public class TweetUtil {
    private final static  Double MAX_LAT = 90d;
    private final static Double MIN_LAT = -90d;
    private final static Double MAX_LON = 180d;
    private final static Double MIN_LON = -180d;

    private final static Integer MAX_TWEET_CHAR = 140;

    public static Predicate<String> validId = (id) -> !StringUtil.isEmpty(id) && id.chars().noneMatch(c -> c < '0' || c > '9');

    public static void validatePostTweet(String text,Double Longitude,Double Latitude){
        if(StringUtil.isEmpty(text) || text.toCharArray().length > MAX_TWEET_CHAR){
            throw new IllegalArgumentException("Illegal Access");
        }
        if(Latitude < MIN_LAT || Latitude > MAX_LAT || Longitude < MIN_LON || Longitude > MAX_LON){
            throw new IllegalArgumentException("Invalid Logitude and latitude");
        }
    }
    public static Tweet buildTweet(String text,double Longitude,double Latitude){
        Tweet tweet = new Tweet();
        tweet.setText(text);
        Coordinates coordinates = new Coordinates();
        coordinates.setCoordinates(Arrays.asList(Longitude,Latitude));
        tweet.setCoordinates(((Coordinates) coordinates));
        return tweet;
    }

}
