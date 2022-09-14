package com.sparta.dr.framework.framework_tests;

import com.sparta.dr.framework.DTO.*;
import com.sparta.dr.framework.connection_manager.PropertiesLoader;
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
    class Injector {
        @Test
        @DisplayName("Given a HttpRequest check that Weather injector return a dto that is not null")
        void givenAHttpRequestCheckThatWeatherInjectorReturnADtoThatIsNotNull() {
            WeatherResponse weatherDTO = com.sparta.dr.framework.injector.Injector.injectWeatherDTO(connection());
            Assertions.assertNotNull(weatherDTO);
        }
    }
}
