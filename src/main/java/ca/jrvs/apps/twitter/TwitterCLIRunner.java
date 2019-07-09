package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.util.StringUtil;

public class TwitterCLIRunner {
    private final static String COORD_SEP = ":";
    private final static String COMMA = ",";
    private TwitterService service;

    public TwitterCLIRunner(TwitterService service){
        this.service = service;
    }
    public void run(String[] args){
        if(args.length < 2){
            throw new RuntimeException("Usage: TwitterCLI post|tweet|delete");
        }
        switch(args[0].toLowerCase()){
            case "post":
                postTweet(args);
                break;
            case "tweet":
                showTweet(args);
                break;
            case "delete":
                deleteTweet(args);
                break;
            default:
                System.out.println("Usage: TwitterCLI post|tweet|delete");

        }
    }
    protected void postTweet(String[] args){
        if(args.length != 3){
            throw new RuntimeException("Usage: post tweet");
        }
        String tweet_text = args[1];
        String coord = args[2];
        String[] coordArray = coord.split(COORD_SEP);
        if(args.length != 2 || StringUtil.isEmpty(tweet_text)){
            throw new RuntimeException("Invalid location format");
        }
        Double Lat = null;
        Double Long = null;
        try{
            Lat = Double.parseDouble(coordArray[0]);
            Long = Double.parseDouble(coordArray[1]);
        }catch(Exception e){
            throw new RuntimeException("Invalid location format");
        }
        service.postTweet(tweet_text,Lat,Long);
    }
    protected void showTweet(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("Invalid fields");
        }
        String[] fieldsArray = null;
        String tweet_id = null;

        switch (args.length) {
            case 3:
                String fields = args[2];
                if (StringUtil.isEmpty(fields)) {
                    throw new RuntimeException("Invalid empty fields");
                }
                fieldsArray = fields.split(COMMA);

            case 2:
                tweet_id = args[1];
                if (StringUtil.isEmpty(tweet_id)) {
                    throw new RuntimeException("error : show tweet id");
                }
                service.showTweet(tweet_id, fieldsArray);
        }
    }
    protected void deleteTweet(String[] args){
        if(args.length !=2 || StringUtil.isEmpty(args[1])){
            throw new RuntimeException("Usage: Delete tweets");
        }
        String tweetids = args[1];
        String[] ids = tweetids.split(COMMA);
        service.deleteTweets(ids);
    }
}
