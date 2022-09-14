package com.sparta.dr.framework.DTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    public boolean isSnow1hBetweenRange0To107(){
        return getJsonMember1h()>=0 && getJsonMember1h()<=107;
    }

    public boolean isSnow3hBetweenRange0To320(){
        return getJsonMember3h()>=0 && getJsonMember3h()<=320;
    }
}
