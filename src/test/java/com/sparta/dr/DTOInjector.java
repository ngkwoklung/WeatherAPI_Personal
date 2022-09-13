package com.sparta.dr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.dr.DTO.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DTOInjector {
    public static WeatherResponseDTO injectWeatherDTO(HttpResponse<String> response){
        WeatherResponseDTO weatherDTO = new WeatherResponseDTO();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            weatherDTO = objectMapper.readValue(response.body(), WeatherResponseDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherDTO;
    }

    public static Clouds injectCloudDTO(HttpResponse<String> response){
        Clouds clouds = new Clouds();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            clouds = objectMapper.readValue(response.body(), Clouds.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clouds;
    }

    public static Coord injectCoordDTO(HttpResponse<String> response){
        Coord coord = new Coord();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            coord = objectMapper.readValue(response.body(), Coord.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coord;
    }

    public static Main injectMainDTO(HttpResponse<String> response){
        Main main = new Main();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            main = objectMapper.readValue(response.body(), Main.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return main;
    }

    public static Rain injectRainDTO(HttpResponse<String> response){
        Rain rain = new Rain();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            rain = objectMapper.readValue(response.body(), Rain.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rain;
    }

    public static Sys injectSysDTO(HttpResponse<String> response){
        Sys sys = new Sys();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            sys = objectMapper.readValue(response.body(), Sys.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sys;
    }

    public static WeatherItem injectWeatherItemDTO(HttpResponse<String> response){
        WeatherItem weatherItem = new WeatherItem();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            weatherItem = objectMapper.readValue(response.body(), WeatherItem.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherItem;
    }

    public static Wind injectWindDTO(HttpResponse<String> response){
        Wind wind = new Wind();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            wind = objectMapper.readValue(response.body(), Wind.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wind;
    }
}