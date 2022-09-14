package com.sparta.dr.framework.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTOUtils {

    private static final String[] iconList = {"01d", "02d", "03d", "04d", "09d", "10d", "11d", "13d", "50d",
            "01n", "02n", "03n", "04n", "09n", "10n", "11n", "13n", "50n"};
    private static final Integer[] thunderstormIdCodes = {200,201,202,210,211,212,221,230,231,232};
    private static final Integer[] drizzleIdCodes = {300,301,302,310,311,312,313,314,321};
    private static final Integer[] rainIdCodes = {500,501,502,503,504,511,520,521,522,531};
    private static final Integer[] snowIdCodes = {600,601,602,611,612,613,615,616,620,621,622};
    private static final Integer[] atmosphereIdCodes = {701,711,721,731,741,751,761,762,771,781};
    private static final Integer[] clearIdCodes = {800};
    private static final Integer[] cloudsIdCodes = {801,802,803,804};
    private static final String[] WeatherItemsMainList = {"Clouds", "Rain", "Thunderstorms", "Drizzle", "Snow", "Atmosphere", "Clear"};

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
        return WeatherItemsMainList;
    }
    public static Integer[] getCorrespondingIdCodeArray(String type) {
        switch (type){
            case "Rain":
                return rainIdCodes;
            case "Thunderstorm":
                return thunderstormIdCodes;
            case "Drizzle":
                return drizzleIdCodes;
            case "Snow":
                return snowIdCodes;
            case "Atmosphere":
                return atmosphereIdCodes;
            case "Clear":
                return clearIdCodes;
            case "Clouds":
                return cloudsIdCodes;
            default: return null;
        }
    }
}
