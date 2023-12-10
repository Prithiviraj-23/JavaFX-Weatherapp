package com.example.firstjavafxproject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
    @JsonProperty("1h")
    private double rain1h;

    public double getRain1h() {
        return rain1h;
    }

}
