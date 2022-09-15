package com.sparta.dr.framework.connection_manager;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {

    private static final int longitude = ConnectionManagerUtils.getRandomLongitude();
    private static final int latitude = ConnectionManagerUtils.getRandomLatitude();
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

    /**
     * Return HttpResponse by passing latitude and longitude as Strings
     * @return HttpResponse
     */
    public static HttpResponse<String> getResponseByCoord(String lat, String lon) {

        String url = BASEURL + "lat=" + lat + "&lon=" + lon + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }
    public static HttpResponse<String> getResponseByRandomCoord() {
        String url = BASEURL + "lat=" + latitude + "&lon=" + longitude + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    /**
     * Return HttpResponse by passing latitude and longitude as ints
     * @return HttpResponse
     */
    public static HttpResponse<String> getResponseByCoord(int lat, int lon) {
        String url = BASEURL + "lat=" + lat + "&lon=" + lon + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    /**
     * Return HttpResponse by passing a city name
     * @return HttpResponse
     */
    public static HttpResponse<String> getResponseByCity(String city) {
        city = city.replaceAll("\s","%20" );
        String url = BASEURL + "q=" + city + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    /**
     * Return HttpResponse by passing a unique city id as a String
     * @return HttpResponse
     */
    public static HttpResponse<String> getResponseByCityId(String cityid) {
        String url = BASEURL + "id=" + cityid + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    /**
     * Return HttpResponse by passing a unique city id as an Integer
     * @return HttpResponse
     */
    public static HttpResponse<String> getResponseByCityId(Integer cityid) {
        String url = BASEURL + "id=" + cityid.toString() + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    /**
     * Return HttpResponse for a specific city by passing a city name and country code
     * @return HttpResponse
     */
    public static HttpResponse<String> getResponseByCityAndCountry(String city, String country) {
        String url = BASEURL + "q=" + city + "," + country + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    /**
     * Return HttpResponse for a specific city by passing a city name and country code
     * @return HttpResponse
     */
    public static HttpResponse<String> getResponseByCityAndStateAndCountry(String city, String stateCode, String country) {
        city = city.replaceAll("\s","%20" );
        String url = BASEURL + "q=" + city + "," + stateCode + "," + country + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    /**
     * Return HttpResponse by passing Zip code as a String, works for USA only
     * @return HttpResponse
     */
    public static HttpResponse<String> getResponseByZipId(String zipid) {
        String url = BASEURL + "q=" + zipid + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    /**
     * Return HttpResponse by passing Zip code as an Integer, works for USA only
     * @return HttpResponse
     */
    public static HttpResponse<String> getResponseByZipId(Integer zipid) {
        String url = BASEURL + "q=" + zipid.toString() + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    /**
     * Return HttpResponse by passing Zip code as an Integer and country code, if country is not specified then the
     * search works for USA as a default
     * @return boolean
     */
    public static HttpResponse<String> getResponseByZipIdAndCountryCode(Integer zipid, String countryCode) {
        String url = BASEURL + "q=" + zipid.toString() + "," + countryCode + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    /**
     * Return HttpResponse by passing Zip code as a String and country code, if country is not specified then the
     * search works for USA as a default
     * @return boolean
     */
    public static HttpResponse<String> getResponseByZipIdAndCountryCode(String zipid, String countryCode) {
        String url = BASEURL + "q=" + zipid + "," + countryCode + "&appid=" + APIKEY + buildParams();
        return getResponse(url);
    }

    /**
     * Set the Units parameter with values of standard (kelvins), metric and imperial, if no parameter is set,
     * standard is the default
     */
    public static void setUnits(Units units) {
        unitsParam = "&units=" + units.getValue();
    }

    /**
     * Set the Mode parameter with values of xml and html, which sets the return type, if no parameter is set,
     * return type is json
     */
    public static void setMode(Mode mode) {
        modeParams = "&mode=" + mode.getValue();
    }

    /**
     * Set the Language parameter of the return object, available languages are:
     *     AFRIKAANS("af"),
     *     ALBANIAN("al"),
     *     ARABIC("ar"),
     *     AZERBAIJANI("az"),
     *     BULGARIAN("bg"),
     *     CATALAN("ca"),
     *     CZECH("cz"),
     *     DANISH("da"),
     *     GERMAN("de"),
     *     GREEK("el"),
     *     ENGLISH("en"),
     *     BASQUE("eu"),
     *     PERSIAN_FARSI("fa"),
     *     FINNISH("fi"),
     *     FRENCH("fr"),
     *     GALICIAN("gl"),
     *     HEBREW("he"),
     *     HINDI("hi"),
     *     CROATIAN("hr"),
     *     HUNGARIAN("hu"),
     *     INDONESIAN("id"),
     *     ITALIAN("it"),
     *     JAPANESE("ja"),
     *     KOREAN("kr"),
     *     LATVIAN("la"),
     *     LITHUANIAN("lt"),
     *     MACEDONIAN("mk"),
     *     NORWEGIAN("no"),
     *     DUTCH("nl"),
     *     POLISH("pl"),
     *     PORTUGUESE("pt"),
     *     PORTUGUÊS_BRASIL("pt_br"),
     *     ROMANIAN("ro"),
     *     RUSSIAN("ru"),
     *     SWEDISH("sv, se"),
     *     SLOVAK("sk"),
     *     SLOVENIAN("sl"),
     *     SPANISH("sp, es"),
     *     SERBIAN("sr"),
     *     THAI("th"),
     *     TURKISH("tr"),
     *     UKRAINIAN("ua, uk"),
     *     VIETNAMESE("vi"),
     *     CHINESE_SIMPLIFIED("zh_cn"),
     *     CHINESE_TRADITIONAL("zh_tw"),
     *     ZULU("zu");
     */
    public static void setLanguage(Language lang) {
        languageParams = "&lang=" + lang.getValue();
    }

    /**
     * Builds the optional parameters into a single String
     */
    private static String buildParams() {
        optionalParams = unitsParam + modeParams  + languageParams;
        return optionalParams;
    }

    /**
     * Resets all the parameter variables
     */
    public static void resetOptionalParams() {
        optionalParams = "";
        unitsParam = "";
        modeParams = "";
        languageParams = "";
    }

    /**
     * Return a HttpResponse from the built url
     * @return HttpResponse
     */
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
