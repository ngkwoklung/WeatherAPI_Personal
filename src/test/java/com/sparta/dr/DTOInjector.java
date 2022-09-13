package com.sparta.dr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.dr.DTO.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DTOInjector {
    public static WeatherResponseDTO injectDTO(HttpResponse<String> response){
        WeatherResponseDTO weatherDTO = new WeatherResponseDTO();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            weatherDTO = objectMapper.readValue(response.body(), WeatherResponseDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherDTO;
    }
}