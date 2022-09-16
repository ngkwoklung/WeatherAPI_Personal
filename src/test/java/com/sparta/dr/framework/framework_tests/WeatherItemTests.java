package com.sparta.dr.framework.framework_tests;

import com.sparta.dr.framework.DTO.WeatherItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeatherItemTests {

    private final WeatherItem validWeatherItem = new WeatherItem("02n", "few clouds", "Clouds", 801);
    private final WeatherItem idAndMainAndDescriptionDoNotMatchWeatherItem = new WeatherItem("03d", " light rain", "Thunderstorm", 301);
    private final WeatherItem partialInvalidWeatherItem = new WeatherItem("08d", "hail", "Hurricane", 808);


    @Test
    @DisplayName("Check that the method to check id is working")
    void checkThatTheMethodToCheckIdIsWorking() {
        Assertions.assertTrue(validWeatherItem.idIsValid());
        Assertions.assertFalse(idAndMainAndDescriptionDoNotMatchWeatherItem.idIsValid());
        Assertions.assertFalse(partialInvalidWeatherItem.idIsValid());
    }

    @Test
    @DisplayName("Check that the method to check description is working")
    void checkThatTheMethodToCheckDescriptionIsWorking() {
        Assertions.assertTrue(validWeatherItem.descriptionIsValid());
        Assertions.assertFalse(idAndMainAndDescriptionDoNotMatchWeatherItem.descriptionIsValid());
        Assertions.assertFalse(partialInvalidWeatherItem.descriptionIsValid());
    }

    @Test
    @DisplayName("Check that the method to check the icon is working")
    void checkThatTheMethodToCheckTheIconIsWorking() {
        Assertions.assertTrue(validWeatherItem.iconIsValid());
        Assertions.assertTrue(idAndMainAndDescriptionDoNotMatchWeatherItem.iconIsValid());
        Assertions.assertFalse(partialInvalidWeatherItem.iconIsValid());
    }

    @Test
    @DisplayName("Check that the method to check the main is working")
    void checkThatTheMethodToCheckTheMainIsWorking() {
        Assertions.assertTrue(validWeatherItem.mainIsValid());
        Assertions.assertTrue(idAndMainAndDescriptionDoNotMatchWeatherItem.mainIsValid());
        Assertions.assertFalse(partialInvalidWeatherItem.mainIsValid());
    }
}