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
    private static final String APIKEY = PropertiesLoader.getProperty("apikey");

    private static String BASEURL = "https://api.openweathermap.org/data/2.5/weather?";

    {
        logger.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
        consoleHandler.setLevel(Level.INFO);
    }

    public static String getConnectionURL() {
        return BASEURL;
    }

    public static String getConnectionURL(String lat, String lon) {
        return BASEURL + "lat=" + lat + "lon=" + lon + "appid=" + APIKEY;
    }

    public static String getConnectionURL(String url) {
        return BASEURL = url;
    }

//    private static HttpResponse<String> getResponse() {
//        var client = HttpClient.newHttpClient();
//        var request = HttpRequest
//                .newBuilder()
//                .uri(URI.create(BASEURL))
//                .build();
//
//        HttpResponse<String> response =null;
//
//        try {
//            response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        } catch (IOException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        logger.log(Level.FINE, "Response is: " + response.body());
//        return response;
//    }
    private static HttpResponse<String> getResponse(String lat, String lon) {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create(getConnectionURL(lat, lon)))
                .build();

        HttpResponse<String> response =null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.log(Level.FINE, "Response is: " + response.body());
        return response;
    }

    public static HttpResponse<String> getResponse(String resource) {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create(resource))
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

    public static String getResponseBody(String resource, String id) {
        return getResponse(resource, id).body();
    }

    public static String getResponseBody(String resource, int id) {
        return getResponse(resource, String.valueOf(id)).body();
    }

    public static String getResponseBody(String resource) {
        return getResponse(resource).body();
    }

//    public static int getStatusCode() {
//        return getResponse().statusCode();
//    }


    public static int getStatusCode(String url) {
        return getResponse(url).statusCode();
    }

//    public static String getHeader(String key) {
//        return getResponse()
//                .headers()
//                .firstValue(key)
//                .orElse("Key not found");
//    }

}
