package com.sparta.dr;

import com.sparta.dr.DTO.WeatherResponseDTO;
import com.sparta.dr.connectionmanager.ConnectionManager;
import com.sparta.dr.connectionmanager.Mode;
import com.sparta.dr.connectionmanager.PropertiesLoader;
import net.bytebuddy.agent.VirtualMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("Given a HttpRequest check that injector return a dto that is not null")
    void givenAHttpRequestCheckThatInjectorReturnADtoThatIsNotNull() {
        WeatherResponseDTO weatherDTO = DTOInjector.injectDTO(connection());
        System.out.println(weatherDTO.toString());
        Assertions.assertNotNull(weatherDTO);
    }

    @Test
    @DisplayName("Given a HttpRequest check that the injector populates the DTO correctly")
    void givenAHttpRequestCheckThatTheInjectorPopulatesTheDtoCorrectly() {

    }
}
