package ca.jrvs.apps.jdbc.twitter.example;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;

public class TwitterApiTest {
    private static String CONSUMER_KEY = "A9q2xBJlfjnYROJyFsZZrsF5s";
    private static String CONSUMER_SECRET = "64wcCyCazK5W5iYAUFDYNxLqD6nEtNV5pxBv28OQZNNEzpM89U";
    private static String ACCESS_TOKEN = "1145790418153627649-tnnn0lm2kgH7T8ADEUkXBAbetkXcFI";
    private static String TOKEN_SECRET = "t2VzqbSzBcni1caLQ3utTipvpl6OmuMar9Z7eUB5VDcid";

    public static void main(String[] args) throws Exception {
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);
        //create an HTTP GET Request
        HttpGet request = new HttpGet("https://api.twitter.com/1.1/users/search.json?q=realDonaldTrump");
        // sign the request (add headers)
        consumer.sign(request);
        System.out.println("Http Request Headers:");
        Arrays.stream(request.getAllHeaders()).forEach(System.out::println);
        // send/execute the request
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

}


