package com.sparta.dr.DTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Snow {

    @JsonProperty("1h")
    private Double jsonMember1h;

    @JsonProperty("3h")
    private Double jsonMember3h;

    public double getJsonMember1h() {
        return jsonMember1h;
    }

    public double getJsonMember3h() {
        return jsonMember3h;
    }
}
