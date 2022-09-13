package com.sparta.dr;

import com.sparta.dr.DTO.*;
import com.sparta.dr.connectionmanager.ConnectionManager;
import com.sparta.dr.connectionmanager.Mode;
import com.sparta.dr.connectionmanager.PropertiesLoader;
import net.bytebuddy.agent.VirtualMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.mock;

public class DTOInjectorTests {
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
            WeatherResponseDTO weatherDTO = DTOInjector.injectWeatherDTO(connection());
            Assertions.assertNotNull(weatherDTO);
        }

        @Test
        @DisplayName("Given a HttpRequest check that cloud injector return a dto that is not null")
        void givenAHttpRequestCheckThatCloudInjectorReturnADtoThatIsNotNull() {
            Clouds clouds = DTOInjector.injectCloudDTO(connection());
            Assertions.assertNotNull(clouds);
        }

        @Test
        @DisplayName("Given a HttpRequest check that Main injector return a dto that is not null")
        void givenAHttpRequestCheckThatMainInjectorReturnADtoThatIsNotNull() {
            Main main = DTOInjector.injectMainDTO(connection());
            Assertions.assertNotNull(main);
        }

        @Test
        @DisplayName("Given a HttpRequest check that Coord injector return a dto that is not null")
        void givenAHttpRequestCheckThatCoordInjectorReturnADtoThatIsNotNull() {
            Coord coord = DTOInjector.injectCoordDTO(connection());
            Assertions.assertNotNull(coord);
        }

        @Test
        @DisplayName("Given a HttpRequest check that Rain injector return a dto that is not null")
        void givenAHttpRequestCheckThatRainInjectorReturnADtoThatIsNotNull() {
            Rain rain = DTOInjector.injectRainDTO(connection());
            Assertions.assertNotNull(rain);
        }

        @Test
        @DisplayName("Given a HttpRequest check that Sys injector return a dto that is not null")
        void givenAHttpRequestCheckThatSysInjectorReturnADtoThatIsNotNull() {
            Sys sys = DTOInjector.injectSysDTO(connection());
            Assertions.assertNotNull(sys);
        }

        @Test
        @DisplayName("Given a HttpRequest check that WeatherItem injector return a dto that is not null")
        void givenAHttpRequestCheckThatWeatherItemInjectorReturnADtoThatIsNotNull() {
            WeatherItem weatherItem = DTOInjector.injectWeatherItemDTO(connection());
            Assertions.assertNotNull(weatherItem);
        }

        @Test
        @DisplayName("Given a HttpRequest check that WeatherResponseDTO injector return a dto that is not null")
        void givenAHttpRequestCheckThatWeatherResponseDTOInjectorReturnADtoThatIsNotNull() {
            WeatherResponseDTO weatherResponseDTO = DTOInjector.injectWeatherDTO(connection());
            Assertions.assertNotNull(weatherResponseDTO);
        }
    }
}
