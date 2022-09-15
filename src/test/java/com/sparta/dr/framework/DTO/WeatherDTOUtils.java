package com.sparta.dr.framework.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTOUtils {

    private static final String[] iconList = {"01d", "02d", "03d", "04d", "09d", "10d", "11d", "13d", "50d",
            "01n", "02n", "03n", "04n", "09n", "10n", "11n", "13n", "50n"};
    private static final String[] iconDayList = {"01d", "02d", "03d", "04d", "09d", "10d", "11d", "13d", "50d",};
    private static final String[] getIconNightList = {"01n", "02n", "03n", "04n", "09n", "10n", "11n", "13n", "50n"};
    private static final Integer[] thunderstormIdCodes = {200,201,202,210,211,212,221,230,231,232};
    private static final Integer[] drizzleIdCodes = {300,301,302,310,311,312,313,314,321};
    private static final Integer[] rainIdCodes = {500,501,502,503,504,511,520,521,522,531};
    private static final Integer[] snowIdCodes = {600,601,602,611,612,613,615,616,620,621,622};
    private static final Integer[] atmosphereIdCodes = {701,711,721,731,741,751,761,762,771,781};
    private static final Integer[] clearIdCodes = {800};
    private static final Integer[] cloudsIdCodes = {801,802,803,804};
    private static final String[] weatherItemsMainList = {"Clouds", "Rain", "Thunderstorm", "Drizzle", "Snow", "Atmosphere", "Clear", "Mist", "Smoke", "Haze", "Dust", "Fog", "Sand", "Dust", "Ash", "Squall", "Tornado" };
    private static final String[] clearDescriptions = {"clear sky"};
    private static final String[] thunderstormDescriptions = {"thunderstorm with light rain", "thunderstorm with rain", "thunderstorm with heavy rain", "light thunderstorm", "thunderstorm,", "heavy thunderstorm", "ragged thunderstorm", "thunderstorm with light drizzle", "thunderstorm with drizzle", " thunderstorm with heavy drizzle"};
    private static final String[] drizzleDescriptions = {"light intensity drizzle", "drizzle", "heavy intensity drizzle", "light intensity drizzle rain", "drizzle rain", "heavy intensity drizzle rain", "shower intensity and drizzle", "heavy shower rain and drizzle", "shower drizzle"};
    private static final String[] rainDescriptions = {"light rain", "moderate rain", "heavy intensity rain", "very heavy rain", "extreme rain", "freezing rain", "low intensity shower rain", "shower rain", "heavy intensity shower rain", "ragged shower rain"};
    private static final String[] snowDescriptions = {"light snow", "Snow", "Heavy snow", "Sleet", "Light shower sleet", "Shower sleet", "Light rain and snow", "Rain and snow", "Light shower snow", "Shower snow", "Heavy shower snow"};
    private static final String[] atmosphereDescriptions = {"mist", "Smoke", "Haze", "sand/ dust whirls", "fog", "sand", "dsut", "volcanic ash", "squalls", "tornado"};
    private static final String[] cloudsDescriptions = {"few clouds", "scattered clouds", "broken clouds", "overcast clouds"};

    public static String[] getIconList() {
        return iconList;
    }

    public static Integer[] getThunderstormIdCodes() {
        return thunderstormIdCodes;
    }

    public static Integer[] getDrizzleIdCodes() {
        return drizzleIdCodes;
    }

    public static Integer[] getRainIdCodes() {
        return rainIdCodes;
    }

    public static Integer[] getSnowIdCodes() {
        return snowIdCodes;
    }

    public static Integer[] getAtmosphereIdCodes() {
        return atmosphereIdCodes;
    }

    public static Integer[] getClearIdCodes() {
        return clearIdCodes;
    }

    public static Integer[] getCloudsIdCodes() {
        return cloudsIdCodes;
    }

    public static String[] getWeatherItemsMainList(){
        return weatherItemsMainList;
    }

    public static String[] getIconDayList() {
        return iconDayList;
    }

    public static String[] getGetIconNightList() {
        return getIconNightList;
    }

    public static Integer[] getCorrespondingIdCodeArray(String type) {
        switch (type) {
            case "Rain":
                return rainIdCodes;
            case "Thunderstorm":
                return thunderstormIdCodes;
            case "Drizzle":
                return drizzleIdCodes;
            case "Snow":
                return snowIdCodes;
            case "Clear":
                return clearIdCodes;
            case "Clouds":
                return cloudsIdCodes;
            default:
                return atmosphereIdCodes;
        }
    }

    public static String[] getCorrespondingWeatherDescriptions(String main) {
        switch (main){
            case "Rain":
                return rainDescriptions;
            case "Thunderstorm":
                return thunderstormDescriptions;
            case "Drizzle":
                return drizzleDescriptions;
            case "Snow":
                return snowDescriptions;
            case "Clear":
                return clearDescriptions;
            case "Clouds":
                return cloudsDescriptions;
            default: return atmosphereDescriptions;
        }
    }
}
