package com.sparta.dr;

import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
// when we create a dto package ; import com.sparta.dr.framework.dto.WeatherDTO;

import java.io.IOException;
import java.net.http.HttpResponse;

public class DTOInjector {
    public static WeatherDTO injectDTO(HttpResponse<String> response){
        WeatherDTO weatherDTO = new WeatherDTO();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            weatherDTO = objectMapper.readValue(response.body(), WeatherDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherDTO;
    }
}