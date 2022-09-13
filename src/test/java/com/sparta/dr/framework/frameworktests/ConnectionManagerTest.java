package com.sparta.dr.framework.frameworktests;

import com.sparta.dr.framework.connectionmanager.ConnectionManager;
import com.sparta.dr.framework.connectionmanager.Language;
import com.sparta.dr.framework.connectionmanager.Mode;
import com.sparta.dr.framework.connectionmanager.Units;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConnectionManagerTest {

    @BeforeAll
    public static void setup() {
        ConnectionManager.setUnits(Units.METRIC);
    }

    @Test
    @DisplayName("Coordinate Test")
    void coordinateTest() {
        String expected = "https://api.openweathermap.org/data/2.5/weather?lat=51.5085&lon=-0.1257&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric";
        String actual = ConnectionManager.getResponseByCoord("51.5085", "-0.1257").toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get response by coord with imperial")
    void getResponseByCoordWithImperial() {
        ConnectionManager.setUnits(Units.IMPERIAL);
        String expected = "https://api.openweathermap.org/data/2.5/weather?lat=51.5085&lon=-0.1257&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric&units=imperial";
        String actual = ConnectionManager.getResponseByCoord("51.5085", "-0.1257").toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get response by by coord with different mode")
    void getResponseByByCoordWithDifferentMode() {
        ConnectionManager.setMode(Mode.HTML);
        String actual = ConnectionManager.getResponseByCoord("51.5085", "-0.1257").toString();
        System.out.println(actual);
        //
    }

    @Test
    @DisplayName("Test getConnection with metric unit with different language")
    void testGetConnectionWithMetricUnitWithLanguage() {
        ConnectionManager.setUnits(Units.METRIC);
        ConnectionManager.setLanguage(Language.CHINESE_TRADITIONAL);
        String expected = "https://api.openweathermap.org/data/2.5/weather?lat=51.5085&lon=-0.1257&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric&units=metric&lang=zh_tw";
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
    @DisplayName("Check that url is correct when passing city and country")
    void checkThatUrlIsCorrectWhenPassingCityAndCountry() {
        String actual = "(GET https://api.openweathermap.org/data/2.5/weather?id=2643743&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric) 200";
        String expected = String.valueOf(ConnectionManager.getResponseByCityAndCountry("London", "EN"));
        Assertions.assertEquals(expected, actual);
    }

}
