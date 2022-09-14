package com.sparta.dr.framework.connectionmanager;

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
    private static String unitsParam = "";
    private static String modeParams = "";
    private static String languageParams = "";

    {
        logger.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
        consoleHandler.setLevel(Level.INFO);
    }

    public static HttpResponse<String> getResponseByCoord(String lat, String lon) {
        String url = BASEURL + "lat=" + lat + "&lon=" + lon + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }
    public static HttpResponse<String> getResponseByCoord(int lat, int lon) {
        String url = BASEURL + "lat=" + lat + "&lon=" + lon + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    public static HttpResponse<String> getResponseByCity(String city) {
        city = city.replaceAll("\s","%20" );
        String url = BASEURL + "q=" + city + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    public static HttpResponse<String> getResponseByCityId(String cityid) {
        String url = BASEURL + "id=" + cityid + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    public static HttpResponse<String> getResponseByCityAndCountry(String city, String country) {
        String url = BASEURL + "q=" + city + "," + country + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }
    public static HttpResponse<String> getResponseByCityAndStateAndCountry(String city, String stateCode, String country) {
        city = city.replaceAll("\s","%20" );
        String url = BASEURL + "q=" + city + "," + stateCode + "," + country + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    public static HttpResponse<String> getResponseByCityId(Integer cityid) {
        String url = BASEURL + "id=" + cityid.toString() + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    public static HttpResponse<String> getResponseByZipId(String zipid) {
        String url = BASEURL + "q=" + zipid + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    public static HttpResponse<String> getResponseByZipId(Integer zipid) {
        String url = BASEURL + "q=" + zipid.toString() + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    public static HttpResponse<String> getResponseByZipIdAndCountryCode(Integer zipid, String countryCode) {
        String url = BASEURL + "q=" + zipid.toString() + "," + countryCode + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    public static HttpResponse<String> getResponseByZipIdAndCountryCode(String zipid, String countryCode) {
        String url = BASEURL + "q=" + zipid + "," + countryCode + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    public static void setUnits(Units units) {
        unitsParam = "&units=" + units.getValue();
    }

    public static void setMode(Mode mode) {
        modeParams = "&mode=" + mode.getValue();
    }

    public static void setLanguage(Language lang) {
        languageParams = "&lang=" + lang.getValue();
    }

    private static String buildParams() {
        optionalParams = unitsParam + modeParams  + languageParams;
        return optionalParams;
    }

    public static void resetOptionalParams() {
        optionalParams = "";
        unitsParam = "";
        modeParams = "";
        languageParams = "";
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
