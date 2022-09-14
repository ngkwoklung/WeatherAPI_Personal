package com.sparta.dr.framework.frameworktests;

import com.sparta.dr.framework.DTO.WeatherItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class WeatherItemTests {

    private final WeatherItem validWeatherItem = new WeatherItem("02n", "few clouds", "Clouds", 801);
    private final WeatherItem iconAndDescriptionDoNotMatchWeatherItem = new WeatherItem("03d", "rain", "Thunderstorm", 201);
    private final WeatherItem partialInvalidWeatherItem = new WeatherItem("08d", "hail", "Hurricane", 808);


    @Test
    @DisplayName("Check that the method to check id is working")
    void checkThatTheMethodToCheckIdIsWorking() {
        Assertions.assertTrue(validWeatherItem.idIsValid());
        Assertions.assertTrue(iconAndDescriptionDoNotMatchWeatherItem.idIsValid());
        Assertions.assertFalse(partialInvalidWeatherItem.idIsValid());
    }

    @Test
    @DisplayName("Check that the method to check description is working")
    void checkThatTheMethodToCheckDescriptionIsWorking() {
        Assertions.assertTrue(validWeatherItem.descriptionIsValid());
        Assertions.assertTrue(iconAndDescriptionDoNotMatchWeatherItem.descriptionIsValid());
        Assertions.assertFalse(partialInvalidWeatherItem.descriptionIsValid());
    }

    @Test
    @DisplayName("Check that the method to check the icon is working")
    void checkThatTheMethodToCheckTheIconIsWorking() {
        Assertions.assertTrue(validWeatherItem.iconIsValid());
        Assertions.assertTrue(iconAndDescriptionDoNotMatchWeatherItem.iconIsValid());
        Assertions.assertFalse(partialInvalidWeatherItem.iconIsValid());
    }

    @Test
    @DisplayName("Check that the method to check the main is working")
    void checkThatTheMethodToCheckTheMainIsWorking() {
        Assertions.assertTrue(validWeatherItem.mainIsValid());
        Assertions.assertTrue(iconAndDescriptionDoNotMatchWeatherItem.mainIsValid());
        Assertions.assertFalse(partialInvalidWeatherItem.mainIsValid());
    }

    @Test
    @DisplayName("Check that the method to check that the description and icon match is working")
    void checkThatTheMethodToCheckThatTheDescriptionAndIconMatchIsWorking() {
        Assertions.assertTrue(validWeatherItem.descriptionAndIconMatch());
        Assertions.assertFalse(iconAndDescriptionDoNotMatchWeatherItem.descriptionAndIconMatch());
        Assertions.assertFalse(partialInvalidWeatherItem.descriptionAndIconMatch());
    }
}
