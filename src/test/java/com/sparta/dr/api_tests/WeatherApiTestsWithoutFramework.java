package com.sparta.dr.api_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.dr.framework.DTO.WeatherDTOUtils;
import com.sparta.dr.framework.DTO.WeatherResponse;
import com.sparta.dr.framework.connection_manager.ConnectionManager;
import com.sparta.dr.framework.connection_manager.PropertiesLoader;
import com.sparta.dr.framework.injector.Injector;
import com.sparta.dr.pojo.WeatherResponsePojo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.TimeZone;

public class WeatherApiTestsWithoutFramework { //Uses Pojo in main
    private static WeatherResponsePojo weatherResponse;
    private static final String APIKEY = PropertiesLoader.getProperty("apikey");

    public static HttpResponse<String> getResponse(String url) {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static HttpResponse<String> getResponseByCoord(String lat, String lon) {

        String url = "https://api.openweathermap.org/data/2.5/weather?" + "lat=" + lat + "&lon=" + lon + "&appid=" + APIKEY ;
        return getResponse(url);
    }

    public static WeatherResponsePojo injectWeatherPojo(HttpResponse<String> response){
        WeatherResponsePojo weatherPojo = new WeatherResponsePojo();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            weatherPojo = objectMapper.readValue(response.body(), WeatherResponsePojo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherPojo;
    }

    @BeforeAll
    static void setupAll() {
        weatherResponse = injectWeatherPojo(getResponseByCoord("50","20"));
    }

    @Test
    @DisplayName("Check that the ID is valid ")
    void checkThatTheIdIsValid(){
        String[] iconList = {"01d", "02d", "03d", "04d", "09d", "10d", "11d", "13d", "50d",
                "01n", "02n", "03n", "04n", "09n", "10n", "11n", "13n", "50n"};
        String icon = weatherResponse.getWeather().get(0).getIcon();
        Assertions.assertTrue(Arrays.asList(iconList).contains(icon));
    }

    @Test
    @DisplayName("Is clouds all null")
    void isCloudsAllNull(){
        Integer all = weatherResponse.getClouds().getAll();
        Assertions.assertTrue(all != null);
    }

    @Test
    @DisplayName("Lat is between valid range in coord")
    void latIsBetweenValidRangeInCoord(){
        Integer lat = weatherResponse.getCoord().getLat();
        Assertions.assertTrue(lat >= -90 && lat <= 90);
    }

    @Test
    @DisplayName("Sunrise is today")
    void sunriseIsToday(){
        Integer sunrise = weatherResponse.getSys().getSunrise();
        Assertions.assertEquals(LocalDate.ofInstant(Instant.ofEpochSecond(sunrise), TimeZone.getDefault().toZoneId()), LocalDate.now());
    }

    @Test
    @DisplayName("Is degree between 0 and 360")
    void isDegreeBetween0And360(){
        Integer degree = weatherResponse.getWind().getDeg();
        Assertions.assertTrue(degree >= 0 && degree <= 360);
    }

    @Test
    @DisplayName("Is speed valid")
    void isSpeedValid(){
        Double speed = weatherResponse.getWind().getSpeed();
        Assertions.assertTrue(speed >= 0);
    }

    @Test
    @DisplayName("Is main valid")
    void isMainValid(){
        String[] weatherItemsMainList = {"Clouds", "Rain", "Thunderstorm", "Drizzle", "Snow", "Atmosphere", "Clear", "Mist", "Smoke", "Haze", "Dust", "Fog", "Sand", "Dust", "Ash", "Squall", "Tornado" };
        String main = weatherResponse.getWeather().get(0).getMain();
        Assertions.assertTrue(Arrays.asList(weatherItemsMainList).contains(main));
    }
}
