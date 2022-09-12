package com.sparta.dr.connectionmanager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConnectionManagerTest {
    @Test
    @DisplayName("Test name")
    void testName() {
//        "lon": -0.1257, "lat": 51.5085
        System.out.println(ConnectionManager.getConnection("51.5085", "-0.1257"));

    }

    @Test
    @DisplayName("Test getConnection with metric unit")
    void testGetConnectionWithMetricUnit() {
        ConnectionManager.setUnits(Units.METRIC);
        ConnectionManager.setLanguage(Language.ZH_TW);
//        ConnectionManager.setMode(Mode.XML);
        System.out.println(ConnectionManager.getConnection("51.5085", "-0.1257"));
    }
}
