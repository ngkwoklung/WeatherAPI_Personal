package com.sparta.dr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.dr.DTO.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DTOInjector {



    public static void main(String[] args) {
        System.out.println(connection().toString());
        // (GET https://api.openweathermap.org/data/2.5/weather?lat=0&lon=0&appid=a39a8ef364461dd7292792ea50bba6a1) 200
    }

    private static HttpResponse connection(){
        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://api.openweathermap.org/data/2.5/weather?lat=0&lon=0&appid=a39a8ef364461dd7292792ea50bba6a1"))
                .build();

        HttpResponse<String> response =null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

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