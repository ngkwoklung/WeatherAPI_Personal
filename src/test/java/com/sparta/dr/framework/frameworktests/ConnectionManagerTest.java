package com.sparta.dr.framework.frameworktests;

import com.sparta.dr.framework.connectionmanager.ConnectionManager;
import com.sparta.dr.framework.connectionmanager.Language;
import com.sparta.dr.framework.connectionmanager.Units;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConnectionManagerTest {

    @BeforeAll
    public static void setup() {
        ConnectionManager.setUnits(Units.METRIC);
    }
    @Test
    @DisplayName("Test name")
    void testName() {
//        "lon": -0.1257, "lat": 51.5085
        System.out.println(ConnectionManager.getResponseByCoord("51.5085", "-0.1257"));
    }

    @Test
    @DisplayName("Test getConnection with metric unit")
    void testGetConnectionWithMetricUnit() {
        ConnectionManager.setUnits(Units.METRIC);
        ConnectionManager.setLanguage(Language.CHINESE_TRADITIONAL);
//        ConnectionManager.setMode(Mode.XML);
        System.out.println(ConnectionManager.getResponseByCoord("51.5085", "-0.1257"));
    }

    @Test
    @DisplayName("Test getResponseByCity returns valid response")
    void testGetResponseByCityReturnsValidResponse() {
        System.out.println(ConnectionManager.getResponseByCity("New%20York%20City"));
//        Assertions.assertEquals("NewYork", ConnectionManager.getResponseByCity());
    }

//    @Test
//    @DisplayName("Check that url is correct when passing City ID")
//    void checkThatUrlIsCorrectWhenPassingCityId() {
//        ConnectionManager.
//    }
}
