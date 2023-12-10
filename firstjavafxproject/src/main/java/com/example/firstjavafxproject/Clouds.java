package com.example.firstjavafxproject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Clouds {
    private int all;

    public int getAll() {
        return all;
    }

    public static class Coord {

            private double lon;
            private double lat;

            public double getLon() {
                return lon;
            }

            public double getLat() {
                return lat;
            }

    }
}
