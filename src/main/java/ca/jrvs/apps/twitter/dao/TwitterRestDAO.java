package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dto.Tweet;
import ca.jrvs.apps.twitter.util.JsonUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@Repository
public class TwitterRestDAO implements CrdRepository<Tweet, String> {

    //URI constants
    private static final String API_BASE_URI = "https://api.twitter.com";
    private static final String POST_PATH = "/1.1/statuses/update.json";
    private static final String SHOW_PATH = "/1.1/statuses/show.json";
    private static final String DELETE_PATH = "/1.1/statuses/destroy";
    //URI symbols
    private static final String QUERY_SYM = "?";
    private static final String AMPERSAND = "&";
    private static final String EQUAL = "=";

    //Response code
    private static final int HTTP_OK = 200;

    private HttpHelper httpHelper;


    public TwitterRestDAO(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    /**
     * Post a tweet with a geotag to timeline
     *
     * @throws IllegalArgumentException when text is empty or invalid latitude or invalid longitude
     */
    @Override
    public Tweet create(Tweet tweet) {
        //Construct URI
        URI uri;
        try {
            uri = getPostUri(tweet);
        } catch (URISyntaxException | UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Invalid tweet input", e);
        }

        //Execute HTTP Request
        HttpResponse response = null;
        try {
            response = (HttpResponse) httpHelper.httpPost(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Validate response and deser response to Tweet object
        return parseResponseBody(response, HTTP_OK);
    }

    @Override
    public Tweet findById(String id) {
        //Construct URI
        URI uri;
        try {
            uri = getShowUri(id);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Unable to construct URI", e);
        }

        //Execute HTTP Request
        HttpResponse response;
        response = (HttpResponse) httpHelper.httpGet(uri);

        //Validate response and deser response to Tweet object
        return parseResponseBody(response, HTTP_OK);
    }

    @Override
    public Tweet deleteById(String id) throws IOException {
        //Construct URI
        URI uri;
        try {
            uri = getDeleteUri(id);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Unable to construct URI", e);
        }

        //Execute HTTP Request
        HttpResponse response;

        response = (HttpResponse) httpHelper.httpPost(uri);

        //Validate response and deser response to Tweet object
        return parseResponseBody(response, HTTP_OK);
    }

    /**
     * e.g. https://api.twitter.com/1.1/statuses/destroy/240854986559455234.json
     */
    protected URI getDeleteUri(String id) throws URISyntaxException {
        StringBuilder sb = new StringBuilder();
        sb.append(API_BASE_URI)
                .append(DELETE_PATH)
                .append("/")
                .append(id)
                .append(".json");

        return new URI(sb.toString());
    }

    /**
     *
     * @param id
     * @return
     * @throws URISyntaxException
     */
    protected URI getShowUri(String id) throws URISyntaxException {
        StringBuilder sb = new StringBuilder();
        sb.append(API_BASE_URI)
                .append(SHOW_PATH)
                .append(QUERY_SYM);
        appendQueryParam(sb, "id", id, true);
        return new URI(sb.toString());
    }

    /**
     *
     * @param tweet
     * @return
     * @throws URISyntaxException
     * @throws UnsupportedEncodingException
     */
    protected URI getPostUri(Tweet tweet) throws URISyntaxException, UnsupportedEncodingException {
        String text = tweet.getText();
        Double longitude = tweet.getCoordinates().getCoordinates().get(0);
        Double latitude = tweet.getCoordinates().getCoordinates().get(1);

        StringBuilder sb = new StringBuilder();
        sb.append(API_BASE_URI).append(POST_PATH).append(QUERY_SYM);

        appendQueryParam(sb, "status", URLEncoder.encode(text, StandardCharsets.UTF_8.name()), true);
        appendQueryParam(sb, "long", longitude.toString(), false);
        appendQueryParam(sb, "lat", latitude.toString(), false);

        return new URI(sb.toString());
    }

    /**
     *
     * @param sb
     * @param key
     * @param value
     * @param firstParam
     */
    private void appendQueryParam(StringBuilder sb, String key, String value,
                                  boolean firstParam) {
        if (!firstParam) {
            sb.append(AMPERSAND);
        }
        sb.append(key)
                .append(EQUAL)
                .append(value);
    }

    /**
     * Check response status code Convert Response Entity to Tweet
     */
    protected Tweet parseResponseBody(HttpResponse response, Integer expectedStatusCode) {
        Tweet tweet = null;

        //Check response status
        int status = response.getStatusLine().getStatusCode();
        if (status != expectedStatusCode) {
            throw new RuntimeException("Unexpected HTTP status:" + status);
        }

        if (response.getEntity() == null) {
            throw new RuntimeException("Empty response body");
        }

        //Convert Response Entity to str
        String jsonStr;
        try {
            jsonStr = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert entity to String", e);
        }

        //Deser JSON string to Tweet object
        try {
            tweet = (Tweet) JsonUtil.toObjectFromJson(jsonStr, Tweet.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to convert JSON str to Object", e);
        }

        return tweet;
    }

}