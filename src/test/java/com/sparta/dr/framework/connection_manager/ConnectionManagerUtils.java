package com.sparta.dr.framework.connection_manager;

import java.util.Random;

public class ConnectionManagerUtils {
    protected static int getRandomLatitude(){
        Random random = new Random();
        return random.nextInt(-90,90);
    }
    protected static int getRandomLongitude(){
        Random random = new Random();
        return random.nextInt(-180,180);
    }
}