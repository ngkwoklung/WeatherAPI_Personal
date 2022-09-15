package com.sparta.dr.api_tests;

import com.sparta.dr.framework.DTO.WeatherResponse;
import com.sparta.dr.framework.connection_manager.ConnectionManager;
import com.sparta.dr.framework.connection_manager.Units;
import com.sparta.dr.framework.injector.Injector;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.junit.jupiter.api.*;

public class WeatherAPITest {
    private static WeatherResponse weatherResponse;

    @BeforeAll
    static void setupAll() {
         weatherResponse = Injector.injectWeatherDTO(ConnectionManager.getResponseByRandomCoord());
    }

    @Nested
    @DisplayName("Clouds tests")
    class CloudsTests {

        @Test
        @DisplayName("Check cloud all field is not null")
        void checkCloudAllFieldIsNotNull() {
            Assertions.assertTrue(weatherResponse.getClouds().isCloudsNull());
        }

        @Test
        @DisplayName("Check clouds all field is positive")
        void checkCloudsAllFieldIsPositive() {
            Assertions.assertTrue(weatherResponse.getClouds().isCloudPositive());
        }
    }

    @Nested
    @DisplayName("Coord tests")
    class CoordTests {

        @Test
        @DisplayName("Check that lat is not null")
        void checkThatLatIsNotNull() {
            Assertions.assertTrue(weatherResponse.getCoord().latIsNotNull());
        }

        @Test
        @DisplayName("Check that lon is not null")
        void checkThatLonIsNotNull() {
            Assertions.assertTrue(weatherResponse.getCoord().lonIsNotNull());
        }

        @Test
        @DisplayName("Check that lat is a valid range")
        void checkThatLatIsAValidRange() {
            Assertions.assertTrue(weatherResponse.getCoord().latIsBetweenValidRange());
        }

        @Test
        @DisplayName("Check that lon is a valid range")
        void checkThatLonIsAValidRange() {
            Assertions.assertTrue(weatherResponse.getCoord().lonIsBetweenValidRange());
        }
    }

    @Nested
    @DisplayName("Main tests")
    class MainTests {

        @Test
        @DisplayName("Check that pressure is within Reasonable range")
        void checkThatPressureIsWithinReasonableRange() {
            Assertions.assertTrue(weatherResponse.getMain().isPressureWithinReasonableRange(weatherResponse.getMain().getPressure()));
        }

        @Test
        @DisplayName("Check that fahrenheit is within Reasonable range")
        void checkThatFahrenheitIsWithinReasonableRange() {
            ConnectionManager.setUnits(Units.IMPERIAL);
            WeatherResponse imperial = Injector.injectWeatherDTO(ConnectionManager.getResponseByRandomCoord());
            //Assertions.assertTrue(imperial.getMain().isFahrenheitWithinReasonableRange();
        }
    }

    @Nested
    @DisplayName("Rain tests")
    class RainTests{
        @Test
        @DisplayName("Check rain is not null")
        void checkRainIsNotNull() {
            Assertions.assertTrue(weatherResponse.getRain().isRainNull());
        }

        @Test
        @DisplayName("Check rain after 1hr is positive")
        void checkRainAfter1HrIsPositive() {
            Assertions.assertTrue(weatherResponse.getRain().isRainPositive());
        }
    }

    @Nested
    @DisplayName("Snow tests")
    class SnowTests{
        @Test
        @DisplayName("Check snow 1hr is in the range")
        void checkSnowIsInTheRange() {
            Assertions.assertTrue(weatherResponse.getSnow().isSnow1hBetweenRange0To107());
        }

        @Test
        @DisplayName("Check snow 3hr is in range")
        void checkSnow3HrIsInRange() {
            Assertions.assertTrue(weatherResponse.getSnow().isSnow3hBetweenRange0To320());
        }
    }

    @Nested
    @DisplayName("Sys tests")
    class SysTests{
        @Test
        @DisplayName("Check sunrise is not null")
        void checkSunriseIsNotNull() {
            Assertions.assertTrue(weatherResponse.getSys().sunriseIsNotNull());
        }

        @Test
        @DisplayName("Check sunset is not null")
        void checkSunsetIsNotNull() {
            Assertions.assertTrue(weatherResponse.getSys().sunsetIsNotNull());
        }

        @Test
        @DisplayName("Check that type is not null")
        void checkThatTypeIsNotNull() {
            Assertions.assertTrue(weatherResponse.getSys().typeIsNotNull());
        }

        @Test
        @DisplayName("Check that id is not null")
        void checkThatIdIsNotNull() {
            Assertions.assertTrue(weatherResponse.getSys().idIsNotNull());
        }

        @Test
        @DisplayName("Check that country is not null")
        void checkThatCountryIsNotNull() {
            Assertions.assertTrue(weatherResponse.getSys().countryIsNotNull());
        }

        @Test
        @DisplayName("Check that sunrise is today")
        void checkThatSunriseIsToday() {
            Assertions.assertTrue(weatherResponse.getSys().sunriseIsToday());
        }

        @Test
        @DisplayName("Check that sunset is today")
        void checkThatSunsetIsToday() {
            Assertions.assertTrue(weatherResponse.getSys().sunsetIsToday());
        }
    }

    @Nested
    @DisplayName("Weather Items tests")
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

    @Nested
    @DisplayName("Weather Response")
    class WeatherResponseTest {

        @Test
        @DisplayName("check that rain is valid ")
        void checkThatRainIsValid() {
            Assertions.assertTrue(weatherResponse.isRainValid());
        }

        @Test
        @DisplayName("Check that rain range is valid")
        void checkThatRainRangeIsValid() {
            Assertions.assertTrue(weatherResponse.isRainRangeValid());
        }

        @Test
        @DisplayName("Check that the visibility is valid")
        void checkThatTheVisibilityIsValid() {
            Assertions.assertTrue(weatherResponse.isVisibilityValid());
        }

        @Test
        @DisplayName("Check that visibility is between valid ranges")
        void checkThatVisibilityIsBetweenValidRanges() {
            Assertions.assertTrue(weatherResponse.visibilityIsBetweenValidRange())
        }

        @Test
        @DisplayName("Check that the time zone is valid")
        void checkThatTheTimeZoneIsValid() {
            Assertions.assertTrue(weatherResponse.isTimeZoneValid());
        }

        @Test
        @DisplayName("Check that dt is today")
        void checkThatDtIsToday() {
            Assertions.assertTrue(weatherResponse.dtIsToday());
        }

        @Test
        @DisplayName("Check that wind is valid")
        void checkThatWindIsValid() {
            Assertions.assertTrue(weatherResponse.isWindValid());
        }

        @Test
        @DisplayName("Check that cod is 200")
        void checkThatCodIs200() {
            Assertions.assertTrue(weatherResponse.isCOD200());
        }

        @Test
        @DisplayName("Check that sys is valid ")
        void checkThatSysIsValid() {
            Assertions.assertTrue(weatherResponse.isSysValid());
        }

        @Test
        @DisplayName("Check that Id is valid")
        void checkThatIdIsValid() {
            Assertions.assertTrue(weatherResponse.isIdValid());
        }
    }

}
