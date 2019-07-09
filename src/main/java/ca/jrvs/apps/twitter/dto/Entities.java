package ca.jrvs.apps.twitter.dto;

import java.util.List;

public class Entities {
    private List<Hashtag> hashtags;
    private List<UserMention> Usermention;

    @Override
    public String toString() {
        return "Entities{" +
                "hashtags=" + hashtags +
                ", Usermention=" + Usermention +
                '}';
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public List<UserMention> getUsermention() {
        return Usermention;
    }

    public void setUsermention(List<UserMention> usermention) {
        Usermention = usermention;
    }
}
