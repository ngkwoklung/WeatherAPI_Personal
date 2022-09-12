package com.sparta.dr.connectionmanager;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
    private static final Logger logger = Logger.getLogger("my logger");
    private static final ConsoleHandler consoleHandler = new ConsoleHandler();
    private static final String BASEURL = "https://api.openweathermap.org/data/2.5/weather?";
    private static final String APIKEY = PropertiesLoader.getProperty("apikey");
    private static String optionalParams = "";

    {
        logger.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
        consoleHandler.setLevel(Level.INFO);
    }

    public static HttpResponse<String> getConnection(String lat, String lon) {
        String url = BASEURL + "lat=" + lat + "&lon=" + lon + "&appid=" + APIKEY + optionalParams;
        return getResponse(url);
    }

    public static HttpResponse<String> getConnection(String lat, String lon, Units units) {
        String url = getConnection(lat, lon).uri() + "&" + units.getValue();
        return getResponse(url);
    }

    public static String getConnectionURL(String lat, String lon) {
        return BASEURL + "lat=" + lat + "&lon=" + lon + "&appid=" + APIKEY + optionalParams;
    }

    public static void setUnits(Units units) {
        optionalParams = optionalParams + "&units=" + units.getValue();
    }

    public static void setMode(Mode mode) {
        optionalParams = optionalParams + "&mode=" + mode.getValue();
    }

    public static void setLanguage(Language lang) {
        optionalParams = optionalParams + "&lang=" + lang.getValue();
    }


    public static HttpResponse<String> getResponse(String url) {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        logger.log(Level.FINE, "Response is: " + response.body());
        return response;
    }
}
