package ca.jrvs.apps.twitter.dao.helper;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URI;

public class ApacheHttpHelper implements HttpHelper {

    private OAuthConsumer consumer;
    private HttpClient httpclient;
    private String request;

    public ApacheHttpHelper() {
        String CONSUMER_KEY = System.getenv("ConsumerKey");
        String CONSUMER_SECRET = System.getenv("ConsumerSecret");
        String ACCESS_TOKEN = System.getenv("AccessToken");
        String TOKEN_SECRET = System.getenv("TokenSecret");

        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);
        httpclient = new DefaultHttpClient();
    }


    @Override
    public HttpResponse httpPost(URI uri) throws IOException {
        HttpGet request = new HttpGet(uri);
        try {
            consumer.sign(uri);
        } catch (OAuthExpectationFailedException | OAuthMessageSignerException | OAuthCommunicationException e) {
            e.printStackTrace();
        }
        return (HttpResponse) httpclient.execute(request);
    }

    @Override
    public HttpResponse httpPost(URI uri, StringEntity stringEntity) throws IOException {
        HttpGet request = new HttpGet(uri);
        HttpResponse response = (HttpResponse) httpclient.execute(request);
        return response;
    }

    @Override
    public HttpResponse httpGet(URI uri) {
        HttpGet request = new HttpGet(uri);
        return (HttpResponse) request;
    }

}
