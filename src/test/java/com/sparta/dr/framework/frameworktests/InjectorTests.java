package com.sparta.dr.framework.frameworktests;

import com.sparta.dr.framework.DTO.*;
import com.sparta.dr.framework.connectionmanager.PropertiesLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.mockito.Mockito.mock;

public class InjectorTests {
    private static String APIKEY = PropertiesLoader.getProperty("apikey");
    private static HttpResponse connection(){
        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://api.openweathermap.org/data/2.5/weather?lat=0&lon=0&appid=" + APIKEY))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }


    @Nested
    @DisplayName("Checking all injector methods are not null")
    class Injector{
        @Test
        @DisplayName("Given a HttpRequest check that Weather injector return a dto that is not null")
        void givenAHttpRequestCheckThatWeatherInjectorReturnADtoThatIsNotNull() {
            WeatherResponse weatherDTO = com.sparta.dr.framework.injector.Injector.injectWeatherDTO(connection());
            Assertions.assertNotNull(weatherDTO);
        }

        @Test
        @DisplayName("Given a HttpRequest check that cloud injector return a dto that is not null")
        void givenAHttpRequestCheckThatCloudInjectorReturnADtoThatIsNotNull() {
            Clouds clouds = com.sparta.dr.framework.injector.Injector.injectCloudDTO(connection());
            Assertions.assertNotNull(clouds);
        }

        @Test
        @DisplayName("Given a HttpRequest check that Main injector return a dto that is not null")
        void givenAHttpRequestCheckThatMainInjectorReturnADtoThatIsNotNull() {
            Main main = com.sparta.dr.framework.injector.Injector.injectMainDTO(connection());
            Assertions.assertNotNull(main);
        }

        @Test
        @DisplayName("Given a HttpRequest check that Coord injector return a dto that is not null")
        void givenAHttpRequestCheckThatCoordInjectorReturnADtoThatIsNotNull() {
            Coord coord = com.sparta.dr.framework.injector.Injector.injectCoordDTO(connection());
            Assertions.assertNotNull(coord);
        }

        @Test
        @DisplayName("Given a HttpRequest check that Rain injector return a dto that is not null")
        void givenAHttpRequestCheckThatRainInjectorReturnADtoThatIsNotNull() {
            Rain rain = com.sparta.dr.framework.injector.Injector.injectRainDTO(connection());
            Assertions.assertNotNull(rain);
        }

        @Test
        @DisplayName("Given a HttpRequest check that Sys injector return a dto that is not null")
        void givenAHttpRequestCheckThatSysInjectorReturnADtoThatIsNotNull() {
            Sys sys = com.sparta.dr.framework.injector.Injector.injectSysDTO(connection());
            Assertions.assertNotNull(sys);
        }

        @Test
        @DisplayName("Given a HttpRequest check that WeatherItem injector return a dto that is not null")
        void givenAHttpRequestCheckThatWeatherItemInjectorReturnADtoThatIsNotNull() {
            WeatherItem weatherItem = com.sparta.dr.framework.injector.Injector.injectWeatherItemDTO(connection());
            Assertions.assertNotNull(weatherItem);
        }

        @Test
        @DisplayName("Given a HttpRequest check that WeatherResponseDTO injector return a dto that is not null")
        void givenAHttpRequestCheckThatWeatherResponseDTOInjectorReturnADtoThatIsNotNull() {
            WeatherResponse weatherResponseDTO = com.sparta.dr.framework.injector.Injector.injectWeatherDTO(connection());
            Assertions.assertNotNull(weatherResponseDTO);
        }
    }
}
