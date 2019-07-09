package ca.jrvs.apps.twitter.dto;

import java.util.List;

public class Coordinates {
    private List<Double> coordinates;
    private String type;

    @Override
    public String toString() {
        return "Coordinates{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                '}';
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

