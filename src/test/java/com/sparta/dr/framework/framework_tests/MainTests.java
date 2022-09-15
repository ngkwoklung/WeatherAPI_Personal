package com.sparta.dr.framework.framework_tests;

import com.sparta.dr.framework.DTO.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//Double temp, Double tempMin, Integer grndLevel, Integer humidity, Integer pressure, Integer seaLevel, Double feelsLike, Double tempMax

public class MainTests {
    private final Main validKelvinMain = new Main(295.72, 295.86, 290.8, 298.29, 1007, 70, 1007, 926);
    private final Main validCelsiusMain = new Main(22.93, 23.08, 17.65, 25.14, 1007, 69, 1007, 926);
    private final Main validFahrenheitMain = new Main(73.27, 73.54, 63.77, 77.25, 1007, 69, 1007, 926);
    private final Main invalidKelvinMain = new Main(-12.0, -1.0, 350.0, -0.0, 1300, 101, 1300, 1300);
    private final Main invalidCelsiusMain = new Main(-100.0, -100.0, 80.0, -100.0, 1300, 101, 1300, 1300);
    private final Main invalidFahrenheitMain = new Main(-150.0, -150.0, 150.0, -140.0, 1300, 101, 1300, 1300);


    @Test
    @DisplayName("Check that the methods to check the temp are working")
    void checkThatTheMethodsToCheckTheTempAreWorking() {
        Assertions.assertTrue(validKelvinMain.isKelvinWithinReasonableRange(validKelvinMain.getTemp()));
        Assertions.assertTrue(validCelsiusMain.isCelsiusWithinReasonableRange(validCelsiusMain.getTemp()));
        Assertions.assertTrue(validFahrenheitMain.isFahrenheitWithinReasonableRange(validFahrenheitMain.getTemp()));
        Assertions.assertFalse(invalidKelvinMain.isKelvinWithinReasonableRange(invalidKelvinMain.getTemp()));
        Assertions.assertFalse(invalidCelsiusMain.isCelsiusWithinReasonableRange(invalidCelsiusMain.getTemp()));
        Assertions.assertFalse(invalidFahrenheitMain.isFahrenheitWithinReasonableRange(invalidFahrenheitMain.getTemp()));
    }

    @Test
    @DisplayName("Check that the methods to check the feels like temp are working")
    void checkThatTheMethodsToCheckTheFeelsLikeTempAreWorking() {
        Assertions.assertTrue(validKelvinMain.isKelvinWithinReasonableRange(validKelvinMain.getFeelsLike()));
        Assertions.assertTrue(validCelsiusMain.isCelsiusWithinReasonableRange(validCelsiusMain.getFeelsLike()));
        Assertions.assertTrue(validFahrenheitMain.isFahrenheitWithinReasonableRange(validFahrenheitMain.getFeelsLike()));
        Assertions.assertFalse(invalidKelvinMain.isKelvinWithinReasonableRange(invalidKelvinMain.getFeelsLike()));
        Assertions.assertFalse(invalidCelsiusMain.isCelsiusWithinReasonableRange(invalidCelsiusMain.getFeelsLike()));
        Assertions.assertFalse(invalidFahrenheitMain.isFahrenheitWithinReasonableRange(invalidFahrenheitMain.getFeelsLike()));
    }

    @Test
    @DisplayName("Check that the methods to check the min temp are working")
    void checkThatTheMethodsToCheckTheMinTempAreWorking() {
        Assertions.assertTrue(validKelvinMain.isKelvinWithinReasonableRange(validKelvinMain.getFeelsLike()));
        Assertions.assertTrue(validCelsiusMain.isCelsiusWithinReasonableRange(validCelsiusMain.getFeelsLike()));
        Assertions.assertTrue(validFahrenheitMain.isFahrenheitWithinReasonableRange(validFahrenheitMain.getFeelsLike()));
        Assertions.assertFalse(invalidKelvinMain.isKelvinWithinReasonableRange(invalidKelvinMain.getFeelsLike()));
        Assertions.assertFalse(invalidCelsiusMain.isCelsiusWithinReasonableRange(invalidCelsiusMain.getFeelsLike()));
        Assertions.assertFalse(invalidFahrenheitMain.isFahrenheitWithinReasonableRange(invalidFahrenheitMain.getFeelsLike()));
    }

    @Test
    @DisplayName("Check that the methods to check the max temp are working")
    void checkThatTheMethodsToCheckTheMaxTempAreWorking() {
        Assertions.assertTrue(validKelvinMain.isKelvinWithinReasonableRange(validKelvinMain.getTempMax()));
        Assertions.assertTrue(validCelsiusMain.isCelsiusWithinReasonableRange(validCelsiusMain.getTempMax()));
        Assertions.assertTrue(validFahrenheitMain.isFahrenheitWithinReasonableRange(validFahrenheitMain.getTempMax()));
        Assertions.assertFalse(invalidKelvinMain.isKelvinWithinReasonableRange(invalidKelvinMain.getTempMax()));
        Assertions.assertFalse(invalidCelsiusMain.isCelsiusWithinReasonableRange(invalidCelsiusMain.getTempMax()));
        Assertions.assertFalse(invalidFahrenheitMain.isFahrenheitWithinReasonableRange(invalidFahrenheitMain.getTempMax()));
    }

    @Test
    @DisplayName("Check that the methods to check the max temp is greater than min temp are working")
    void checkThatTheMethodsToCheckTheMaxTempIsGreaterThanMinTempAreWorking() {
        Assertions.assertTrue(validKelvinMain.isMinTempLowerThanMaxTemp());
        Assertions.assertTrue(validCelsiusMain.isMinTempLowerThanMaxTemp());
        Assertions.assertTrue(validFahrenheitMain.isMinTempLowerThanMaxTemp());
        Assertions.assertFalse(invalidKelvinMain.isMinTempLowerThanMaxTemp());
        Assertions.assertFalse(invalidCelsiusMain.isMinTempLowerThanMaxTemp());
        Assertions.assertFalse(invalidFahrenheitMain.isMinTempLowerThanMaxTemp());
    }

    @Test
    @DisplayName("Check that the methods to check pressure are working")
    void checkThatTheMethodsToCheckPressureAreWorking() {
        Assertions.assertTrue(validKelvinMain.isPressureWithinReasonableRange(validKelvinMain.getPressure()));
        Assertions.assertTrue(validCelsiusMain.isPressureWithinReasonableRange(validCelsiusMain.getPressure()));
        Assertions.assertTrue(validFahrenheitMain.isPressureWithinReasonableRange(validFahrenheitMain.getPressure()));
        Assertions.assertFalse(invalidKelvinMain.isPressureWithinReasonableRange(invalidKelvinMain.getPressure()));
        Assertions.assertFalse(invalidCelsiusMain.isPressureWithinReasonableRange(invalidCelsiusMain.getPressure()));
        Assertions.assertFalse(invalidFahrenheitMain.isPressureWithinReasonableRange(invalidFahrenheitMain.getPressure()));
    }

    @Test
    @DisplayName("Check that the methods to check sea level are working")
    void checkThatTheMethodsToCheckSeaLevelAreWorking() {
        Assertions.assertTrue(validKelvinMain.isPressureWithinReasonableRange(validKelvinMain.getSeaLevel()));
        Assertions.assertTrue(validCelsiusMain.isPressureWithinReasonableRange(validCelsiusMain.getSeaLevel()));
        Assertions.assertTrue(validFahrenheitMain.isPressureWithinReasonableRange(validFahrenheitMain.getSeaLevel()));
        Assertions.assertFalse(invalidKelvinMain.isPressureWithinReasonableRange(invalidKelvinMain.getSeaLevel()));
        Assertions.assertFalse(invalidCelsiusMain.isPressureWithinReasonableRange(invalidCelsiusMain.getSeaLevel()));
        Assertions.assertFalse(invalidFahrenheitMain.isPressureWithinReasonableRange(invalidFahrenheitMain.getSeaLevel()));
    }

    @Test
    @DisplayName("Check that the methods to check ground level are working")
    void checkThatTheMethodsToCheckGroundLevelAreWorking() {
        Assertions.assertTrue(validKelvinMain.isPressureWithinReasonableRange(validKelvinMain.getGrndLevel()));
        Assertions.assertTrue(validCelsiusMain.isPressureWithinReasonableRange(validCelsiusMain.getGrndLevel()));
        Assertions.assertTrue(validFahrenheitMain.isPressureWithinReasonableRange(validFahrenheitMain.getGrndLevel()));
        Assertions.assertFalse(invalidKelvinMain.isPressureWithinReasonableRange(invalidKelvinMain.getGrndLevel()));
        Assertions.assertFalse(invalidCelsiusMain.isPressureWithinReasonableRange(invalidCelsiusMain.getGrndLevel()));
        Assertions.assertFalse(invalidFahrenheitMain.isPressureWithinReasonableRange(invalidFahrenheitMain.getGrndLevel()));
    }

    @Test
    @DisplayName("Check that the methods to check humidity are working")
    void checkThatTheMethodsToCheckHumidityAreWorking() {
        Assertions.assertTrue(validKelvinMain.isHumidityValid());
        Assertions.assertTrue(validCelsiusMain.isHumidityValid());
        Assertions.assertTrue(validFahrenheitMain.isHumidityValid());
        Assertions.assertFalse(invalidKelvinMain.isHumidityValid());
        Assertions.assertFalse(invalidCelsiusMain.isHumidityValid());
        Assertions.assertFalse(invalidFahrenheitMain.isHumidityValid();
    }



}
