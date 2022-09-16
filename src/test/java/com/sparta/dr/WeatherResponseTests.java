package com.sparta.dr;

import com.sparta.dr.framework.DTO.WeatherResponse;
import com.sparta.dr.framework.connection_manager.ConnectionManager;
import com.sparta.dr.framework.connection_manager.Units;
import com.sparta.dr.framework.injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class WeatherResponseTests {
    private static WeatherResponse dto;

    @BeforeAll
    public static void setup() {
        ConnectionManager.setUnits(Units.METRIC);
        dto = Injector.injectWeatherDTO(ConnectionManager.getResponseByCity("london"));
    }

    @Test
    @DisplayName("Check that dt is today")
    void checkThatDtIsToday(){
        Assertions.assertTrue(dto.dtIsToday());
    }

    @Test
    @DisplayName("Check that TimeZone is between valid range")
    void checkThatTimeZoneIsBetweenValidRange(){
        Assertions.assertTrue(dto.timezoneIsBetweenValidRange());
    }
}