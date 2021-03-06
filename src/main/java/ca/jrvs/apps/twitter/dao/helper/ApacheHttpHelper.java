package ca.jrvs.apps.twitter.dao.helper;

import ca.jrvs.apps.twitter.util.StringUtil;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;

//Tell Intellij ignore duplicate code check
@SuppressWarnings("Duplicates")
@Component
public class ApacheHttpHelper implements HttpHelper {

    private OAuthConsumer consumer;
    private HttpClient httpClient;

    public ApacheHttpHelper(OAuthConsumer consumer, HttpClient httpClient) {
        this.consumer = consumer;
        this.httpClient = httpClient;
    }

    /**
     * Default constructor. Getting key and tokens from env
     */
    public ApacheHttpHelper() {
        String CONSUMER_KEY = System.getenv("CONSUMER_KEY");
        String CONSUMER_SECRET = System.getenv("CONSUMER_SECRET");
        String ACCESS_TOKEN = System.getenv("ACCESS_TOKEN");
        String TOKEN_SECRET = System.getenv("TOKEN_SECRET");

        if (StringUtil.isEmpty(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, TOKEN_SECRET)) {
            throw new RuntimeException("Unable to detect key and tokens from System env");
        }

        consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,
                CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);
        /**
         * Default = single connection. Discuss source code if time permit
         */
        httpClient = new DefaultHttpClient();
    }

    public ApacheHttpHelper(String consumerKey, String consumerSecret, String accessToken,
                            String tokenSecret) {
        consumer = new CommonsHttpOAuthConsumer(consumerKey,
                consumerSecret);
        consumer.setTokenWithSecret(accessToken, tokenSecret);
        /**
         * Default = single connection. Discuss source code if time permit
         */
        httpClient = new DefaultHttpClient();
    }

    @Override
    public HttpResponse httpPost(URI uri) {
        try {
            return executeHttpRequest(HttpMethod.POST, uri, null);
        } catch (OAuthException | IOException e) {
            throw new RuntimeException("Failed to execute", e);
        }
    }

    @Override
    public HttpResponse httpPost(URI uri, StringEntity stringEntity) {
        try {
            return executeHttpRequest(HttpMethod.POST, uri, stringEntity);
        } catch (OAuthException | IOException e) {
            throw new RuntimeException("Failed to execute", e);
        }
    }

    @Override
    public HttpResponse httpGet(URI uri) {
        try {
            return executeHttpRequest(HttpMethod.GET, uri, null);
        } catch (OAuthException | IOException e) {
            throw new RuntimeException("Failed to execute", e);
        }
    }

    public HttpResponse executeHttpRequest(HttpMethod method, URI uri, StringEntity stringEntity)
            throws OAuthException, IOException {
        if (method == HttpMethod.GET) {
            HttpGet request = new HttpGet(uri);
            consumer.sign(request);
            return httpClient.execute(request);
        } else if (method == HttpMethod.POST) {
            HttpPost request = new HttpPost(uri);
            if (stringEntity != null) {
                request.setEntity(stringEntity);
            }
            consumer.sign(request);
            return httpClient.execute(request);
        } else {
            throw new IllegalArgumentException("Unknown HTTP method: " + method.name());
        }

    }
}
