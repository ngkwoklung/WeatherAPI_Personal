package com.sparta.dr.framework.framework_tests;

import com.sparta.dr.framework.connection_manager.ConnectionManager;
import com.sparta.dr.framework.connection_manager.Language;
import com.sparta.dr.framework.connection_manager.Mode;
import com.sparta.dr.framework.connection_manager.Units;
import org.junit.Assert;
import org.junit.jupiter.api.*;

public class ConnectionManagerTest {

    @BeforeEach
    void init() {
        ConnectionManager.setUnits(Units.METRIC);
    }

    @AfterEach
    void tearDown() {
        ConnectionManager.resetOptionalParams();
    }

    @Test
    @DisplayName("Coordinate Test")
    void coordinateTest() {
        String expected = "(GET https://api.openweathermap.org/data/2.5/weather?lat=51.5085&lon=-0.1257&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric) 200";
        String actual = ConnectionManager.getResponseByCoord("51.5085", "-0.1257").toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get response by coord with imperial")
    void getResponseByCoordWithImperial() {
        ConnectionManager.resetOptionalParams();
        ConnectionManager.setUnits(Units.IMPERIAL);
        String expected = "(GET https://api.openweathermap.org/data/2.5/weather?lat=51.5085&lon=-0.1257&appid=a39a8ef364461dd7292792ea50bba6a1&units=imperial) 200";
        String actual = ConnectionManager.getResponseByCoord("51.5085", "-0.1257").toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get response by by coord with different mode")
    void getResponseByByCoordWithDifferentMode() {
        ConnectionManager.setMode(Mode.HTML);
        String actual = ConnectionManager.getResponseByCoord("51.5085", "-0.1257").toString();
        String expected = "(GET https://api.openweathermap.org/data/2.5/weather?lat=51.5085&lon=-0.1257&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric&mode=html) 200";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Test getConnection with metric unit with different language")
    void testGetConnectionWithMetricUnitWithLanguage() {
        ConnectionManager.setLanguage(Language.CHINESE_TRADITIONAL);
        String expected = "(GET https://api.openweathermap.org/data/2.5/weather?lat=51.5085&lon=-0.1257&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric&lang=zh_tw) 200";
        String actual = ConnectionManager.getResponseByCoord("51.5085", "-0.1257").toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getResponseByCity returns valid response")
    void testGetResponseByCityReturnsValidResponse() {
        Assertions.assertEquals("(GET https://api.openweathermap.org/data/2.5/weather?q=New%20York%20City&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric) 200", ConnectionManager.getResponseByCity("New York City").toString());
    }

    @Test
    @DisplayName("Check that url is correct when passing City ID")
    void checkThatUrlIsCorrectWhenPassingCityId() {
        String expected = "(GET https://api.openweathermap.org/data/2.5/weather?id=2643743&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric) 200";
        String actual = ConnectionManager.getResponseByCityId("2643743").toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that url is correct when passing City ID in Integer")
    void checkThatUrlIsCorrectWhenPassingCityIdInInteger() {
        String expected = "(GET https://api.openweathermap.org/data/2.5/weather?id=2643743&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric) 200";
        String actual = ConnectionManager.getResponseByCityId(2643743).toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that url is correct when passing city and country")
    void checkThatUrlIsCorrectWhenPassingCityAndCountry() {
        String actual = "(GET https://api.openweathermap.org/data/2.5/weather?q=London,England&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric) 200";
        String expected = String.valueOf(ConnectionManager.getResponseByCityAndCountry("London", "England"));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check url for getResponseByCityAndStateAndCountry is correct and 200")
    void checkUrlForGetResponseByCityAndStateAndCountryIsCorrectAnd200() {
        String actual = ConnectionManager.getResponseByCityAndStateAndCountry("Las Vegas", "702", "USA").toString();
        String expected = "(GET https://api.openweathermap.org/data/2.5/weather?q=Las%20Vegas,702,USA&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric) 200";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that url for getResponseByZipID passing Integer is correct and 200")
    void checkThatUrlForGetResponseByZipIdPassingIntegerIsCorrectAnd200() {
        String actual = String.valueOf(ConnectionManager.getResponseByZipId(94040));
        String expected = "(GET https://api.openweathermap.org/data/2.5/weather?q=94040&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric) 200";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that url for getResponseByZipID passing String is correct and 200")
    void checkThatUrlForGetResponseByZipIdPassingStringIsCorrectAnd200() {
        String actual = String.valueOf(ConnectionManager.getResponseByZipId("94040"));
        String expected = "(GET https://api.openweathermap.org/data/2.5/weather?q=94040&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric) 200";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check getResponseByZipIdAndCountryCode with units returns correct url and status 200")
    void checkGetResponseByZipIdAndCountryCodeWithUnitsReturnsCorrectUrlAndStatus200() {
        String actual = String.valueOf(ConnectionManager.getResponseByZipIdAndCountryCode("94040", "us"));
        String expected = "(GET https://api.openweathermap.org/data/2.5/weather?q=94040,us&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric) 200";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("check Get Response by Coords taking long and lat")
    void checkGetResponseByCoordsTakingLongAndLat() {
        String actual = ConnectionManager.getResponseByCoord("51.5085", "-0.1257").toString();
        String expected = ("(GET https://api.openweathermap.org/data/2.5/weather?lat=51.5085&lon=-0.1257&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric) 200");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that setting optional parameters multiple times works")
    void checkThatSettingOptionalParametersMultipleTimesWorks() {
        ConnectionManager.setUnits(Units.IMPERIAL);
        ConnectionManager.setUnits(Units.METRIC);
        String actual = ConnectionManager.getResponseByCoord("51.5085", "-0.1257").toString();
        String expected = "(GET https://api.openweathermap.org/data/2.5/weather?lat=51.5085&lon=-0.1257&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric) 200";
        Assertions.assertEquals(expected, actual);
    }
}