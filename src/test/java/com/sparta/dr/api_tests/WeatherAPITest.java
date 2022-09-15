package com.sparta.dr.api_tests;

import com.sparta.dr.framework.DTO.WeatherResponse;
import com.sparta.dr.framework.connection_manager.ConnectionManager;
import com.sparta.dr.framework.injector.Injector;
import org.junit.jupiter.api.*;


public class WeatherAPITest {
    private static WeatherResponse weatherResponse;

    @BeforeAll
    static void setupAll() {
         weatherResponse = Injector.injectWeatherDTO(ConnectionManager.getResponseByRandomCoord());
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
