package com.sparta.dr.framework.injector;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.dr.framework.DTO.*;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class Injector {
    /**
     * Fills DTO array with all the relevant information that has been downloaded from the website.
     *
     * Pass HttpResponse in order to make the injector work successfully.
     * @param response
     * @return DTO object
     */
    public static WeatherResponse injectWeatherDTO(HttpResponse<String> response){
        WeatherResponse weatherDTO = new WeatherResponse();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            weatherDTO = objectMapper.readValue(response.body(), WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherDTO;
    }
}