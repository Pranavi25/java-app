package ca.jrvs.apps.twitter.dto;

import java.math.BigInteger;
import java.util.List;

public class UserMention {
    private String name;
    private List<Integer> indices;
    private String screen_name;
    private BigInteger id;
    private BigInteger id_str;

    @Override
    public String toString() {
        return "UserMention{" +
                "name='" + name + '\'' +
                ", indices=" + indices +
                ", screen_name='" + screen_name + '\'' +
                ", id=" + id +
                ", id_str=" + id_str +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId_str() {
        return id_str;
    }

    public void setId_str(BigInteger id_str) {
        this.id_str = id_str;
    }
}
