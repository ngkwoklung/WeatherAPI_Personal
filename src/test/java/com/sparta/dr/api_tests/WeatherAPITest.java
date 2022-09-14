package com.sparta.dr.api_tests;

import com.sparta.dr.framework.DTO.WeatherItem;
import com.sparta.dr.framework.DTO.WeatherResponse;
import com.sparta.dr.framework.connection_manager.ConnectionManager;
import com.sparta.dr.framework.injector.Injector;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.util.List;
import java.util.Random;

public class WeatherAPITest {
    private static WeatherResponse weatherResponse;

    private static int getRandomLatitude(){
        Random random = new Random();
        return random.nextInt(-90,90);
    }
    private static int getRandomLongitude(){
        Random random = new Random();
        return random.nextInt(-180,180);
    }

    private static final int longitude = getRandomLongitude();
    private static final int latitude = getRandomLatitude();


    @BeforeAll
    static void setupAll() {
         weatherResponse = Injector.injectWeatherDTO(ConnectionManager.getResponseByCoord(latitude, longitude));
    }

    @Nested
    @DisplayName("Weather Items Tests")
    class WeatherItemsTest {


        @Test
        @DisplayName("check that the id is valid")
        void checkThatTheIdIsValid() {
            Assertions.assertTrue(weatherResponse.areIdsInWeatherItemValid());
        }

        @Test
        @DisplayName("Check that the main is valid")
        void checkThatTheMainIsValid() {
            Assertions.assertTrue(weatherResponse.areMainsInWeatherItemValid());
        }

        @Test
        @DisplayName("Check that the icons are valid")
        void checkThatTheIconsAreValid() {
            Assertions.assertTrue(weatherResponse.areIconsInWeatherItemValid());
        }

        @Test
        @DisplayName("Check that the description are valid")
        void checkThatTheDescriptionAreValid() {
            Assertions.assertTrue(weatherResponse.areDescriptionsInWeatherItemValid());
        }
    }
}
