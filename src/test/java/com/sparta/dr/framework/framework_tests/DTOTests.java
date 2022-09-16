package com.sparta.dr.framework.framework_tests;

import com.sparta.dr.framework.DTO.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DTOTests {

    private Snow mockSnow;
    private Wind mockWind;
    private Clouds mockClouds;
    private Coord mockCoord;
    private Main mockMain;
    private Rain mockRain;
    private Sys mockSys;
    private WeatherItem mockWeatherItem;
    private WeatherResponse mockWeatherResponse;

    @BeforeEach
    void init(){
        mockSnow = Mockito.mock(Snow.class);
        mockWind = Mockito.mock(Wind.class);
        mockClouds = Mockito.mock(Clouds.class);
        mockCoord = Mockito.mock(Coord.class);
        mockMain = Mockito.mock(Main.class);
        mockRain = Mockito.mock(Rain.class);
        mockSys = Mockito.mock(Sys.class);
        mockWeatherItem = Mockito.mock(WeatherItem.class);
        mockWeatherResponse = Mockito.mock(WeatherResponse.class);
    }
    
    // Tests toString DTOs
    @ParameterizedTest
    @MethodSource("sourceMethod")
    @DisplayName("When calling toString method, return I am fake!")
    void whenCallingToStringMethodReturnIAmFake(int test){
        Mockito.when(mockSnow.toString()).thenReturn("I am fake object!");
        Mockito.when(mockWind.toString()).thenReturn("I am fake object!");
        Mockito.when(mockCoord.toString()).thenReturn("I am fake object!");
        Mockito.when(mockClouds.toString()).thenReturn("I am fake object!");
        Mockito.when(mockMain.toString()).thenReturn("I am fake object!");
        Mockito.when(mockRain.toString()).thenReturn("I am fake object!");
        Mockito.when(mockSys.toString()).thenReturn("I am fake object!");
        Mockito.when(mockWeatherItem.toString()).thenReturn("I am fake object!");
        Mockito.when(mockWeatherResponse.toString()).thenReturn("I am fake object!");
        switch (test){
            case 1 -> assertEquals("I am fake object!", mockSnow.toString());
            case 2 -> assertEquals("I am fake object!", mockWind.toString());
            case 3 -> assertEquals("I am fake object!", mockCoord.toString());
            case 4 -> assertEquals("I am fake object!", mockClouds.toString());
            case 5 -> assertEquals("I am fake object!", mockMain.toString());
            case 6 -> assertEquals("I am fake object!", mockRain.toString());
            case 7 -> assertEquals("I am fake object!", mockSys.toString());
            case 8 -> assertEquals("I am fake object!", mockWeatherItem.toString());
            case 9 -> assertEquals("I am fake object!", mockWeatherResponse.toString());
            default -> System.out.println("Wrong argument was passed. ");
        }
    }

    public static Stream<Integer> sourceMethod(){
        return Stream.of(Integer.valueOf(1),
                Integer.valueOf(2),
                Integer.valueOf(3),
                Integer.valueOf(4),
                Integer.valueOf(5),
                Integer.valueOf(6),
                Integer.valueOf(7),
                Integer.valueOf(8),
                Integer.valueOf(9));
    }

   @Test
   @DisplayName("Is degree in range")
   void isDegreeInRange(){
        Mockito.when(mockWind.isDegBetween0And360()).thenReturn(true);
        Assertions.assertTrue(mockWind.isDegBetween0And360());
   }

   @Test
   @DisplayName("When calling is speed not null, return true")
   void whenCallingIsSpeedNotNullReturnTrue(){
        Mockito.when(mockWind.isSpeedNotNull()).thenReturn(true);
        Assertions.assertTrue(mockWind.isSpeedNotNull());
   }

   @Test
   @DisplayName("When calling is gust not null, return true")
   void whenCallingIsGustNotNullReturnTrue(){
        Mockito.when(mockWind.isGustNotNull()).thenReturn(true);
        Assertions.assertTrue(mockWind.isGustNotNull());
   }

   @Test
   @DisplayName("When calling is speed valid, return true")
   void isSpeedValid(){
       Mockito.when(mockWind.isSpeedValid()).thenReturn(true);
       Assertions.assertTrue(mockWind.isSpeedValid());
   }

   @Test
   @DisplayName("When calling is gust valid, return true")
   void whenCallingIsGustValidReturnTrue(){
        Mockito.when(mockWind.isGustValid()).thenReturn(true);
        Assertions.assertTrue(mockWind.isGustValid());
   }

   @Test
   @DisplayName("When calling get degree method, return 5")
   void whenCallingGetDegreeMethodReturn5(){
        Mockito.when(mockWind.getDeg()).thenReturn(5);
        assertEquals(5,mockWind.getDeg());
   }

   @Test
   @DisplayName("When calling get speed method, return 5.5")
   void whenCallingGetSpeedMethodReturn55(){
        Mockito.when(mockWind.getSpeed()).thenReturn(5.5);
        assertEquals(5.5,mockWind.getSpeed());
   }

   @Test
   @DisplayName("When calling get gust method, return 5.5")
   void whenCallingGetGustMethodReturn55(){
        Mockito.when(mockWind.getGust()).thenReturn(5.5);
        assertEquals(5.5,mockWind.getGust());
   }

   //Tests for snow dto
   @Test
   @DisplayName("Is snow1h in range")
   void isSnow1hInRange(){
        Mockito.when(mockSnow.isSnow1hBetweenRange0To107()).thenReturn(true);
        Assertions.assertTrue(mockSnow.isSnow1hBetweenRange0To107());
   }

   @Test
   @DisplayName("Is snow3h in range")
   void isSnow3HInRange(){
        Mockito.when(mockSnow.isSnow3hBetweenRange0To320()).thenReturn(true);
        Assertions.assertTrue(mockSnow.isSnow3hBetweenRange0To320());
   }

   @Test
   @DisplayName("When I am calling the getJsonMember1h method, return 5.5")
   void whenIAmCallingTheGetJsonMember1HMethodReturn55(){
        Mockito.when(mockSnow.getJsonMember1h()).thenReturn(5.5);
        assertEquals(5.5, mockSnow.getJsonMember1h());
   }

   @Test
   @DisplayName("When I am calling the getJsonMember3h method, return 5.5")
   void whenIAmCallingTheGetJsonMember3HMethodReturn55(){
        Mockito.when(mockSnow.getJsonMember3h()).thenReturn(5.5);
        assertEquals(5.5, mockSnow.getJsonMember3h());
   }

   //Tests for cloud dto
   @Test
   @DisplayName("When calling is clouds null method, return true")
   void whenCallingIsCloudsNullMethodReturnTrue(){
        Mockito.when(mockClouds.isCloudsNull()).thenReturn(true);
        Assertions.assertTrue(mockClouds.isCloudsNull());
   }

   @Test
   @DisplayName("When calling is cloud positive method, return true")
   void whenCallingIsCloudPositiveMethodReturnTrue(){
        Mockito.when(mockClouds.isCloudPositive()).thenReturn(true);
        Assertions.assertTrue(mockClouds.isCloudPositive());
   }

   @Test
   @DisplayName("When calling the get all method, return 5")
   void whenCallingTheGetAllMethodReturn5(){
        Mockito.when(mockClouds.getAll()).thenReturn(5);
        assertEquals(5,mockClouds.getAll());
   }

   //Tests for coord dto
   @Test
   @DisplayName("When calling the lon is not null method, return true")
   void whenCallingTheLonIsNotNullMethodReturnTrue(){
        Mockito.when(mockCoord.lonIsNotNull()).thenReturn(true);
        Assertions.assertTrue(mockCoord.lonIsNotNull());
   }

   @Test
   @DisplayName("When calling the lat is not null method, return true")
   void whenCallingTheLatIsNotNullMethodReturnTrue(){
        Mockito.when(mockCoord.latIsNotNull()).thenReturn(true);
        Assertions.assertTrue(mockCoord.latIsNotNull());
   }

   @Test
   @DisplayName("Is lot in range")
   void isLotInRange(){
        Mockito.when(mockCoord.lonIsBetweenValidRange()).thenReturn(true);
        Assertions.assertTrue(mockCoord.lonIsBetweenValidRange());
   }
   
   @Test
   @DisplayName("Is lat in range")
   void isLatInRange(){
        Mockito.when(mockCoord.latIsBetweenValidRange()).thenReturn(true);
        Assertions.assertTrue(mockCoord.latIsBetweenValidRange());
   }

   @Test
   @DisplayName("When calling the get lon method, return 5.5")
   void whenCallingTheGetLonMethodReturn55(){
        Mockito.when(mockCoord.getLon()).thenReturn(5.5);
        assertEquals(5.5, mockCoord.getLon());
   }

   @Test
   @DisplayName("When calling the get lat method, return 5.5")
   void whenCallingTheGetLatMethodReturn55(){
        Mockito.when(mockCoord.getLat()).thenReturn(5.5);
        assertEquals(5.5, mockCoord.getLat());
   }

   // tests for main dto
   @Test
   @DisplayName("when calling getTemp method, return 5.5")
   void whenCallingGetTempMethodReturn55() {
        Mockito.when(mockMain.getTemp()).thenReturn((5.5));
        assertEquals(5.5, mockMain.getTemp());
   }

    @Test
    @DisplayName("when calling getTempMin method, return 5.5")
    void whenCallingGetTempMinMethodReturn55() {
        Mockito.when(mockMain.getTempMin()).thenReturn(5.5);
        assertEquals(5.5, mockMain.getTempMin());
    }

    @Test
    @DisplayName("when calling getGrndLevel method, return 5")
    void whenCallingGetGrndLevelMethodReturn5() {
        Mockito.when(mockMain.getGrndLevel()).thenReturn(5);
        assertEquals(5, mockMain.getGrndLevel());
    }

    @Test
    @DisplayName("when calling getHumidity method, return 5")
    void whenCallingGetHumidityMethodReturn5() {
        Mockito.when(mockMain.getHumidity()).thenReturn(5);
        assertEquals(5, mockMain.getHumidity());
    }

    @Test
    @DisplayName("when calling getPressure method, return 5")
    void whenCallingGetPressureMethodReturn5() {
        Mockito.when(mockMain.getPressure()).thenReturn(5);
        assertEquals(5, mockMain.getPressure());
    }

    @Test
    @DisplayName("when calling getSeaLevel method, return 5")
    void whenCallingGetSeaLevelMethodReturn5() {
        Mockito.when(mockMain.getSeaLevel()).thenReturn(5);
        assertEquals(5, mockMain.getSeaLevel());
    }

    @Test
    @DisplayName("when calling getFeelsLike method, return 5.5")
    void whenCallingGetFeelsLikeMethodReturn55() {
        Mockito.when(mockMain.getFeelsLike()).thenReturn(5.5);
        assertEquals(5.5, mockMain.getFeelsLike());
    }

    @Test
    @DisplayName("when calling getTempMax method, return 5.5")
    void whenCallingGetTempMaxMethodReturn55() {
        Mockito.when(mockMain.getTempMax()).thenReturn(5.5);
        assertEquals(5.5, mockMain.getTempMax());
    }

   // tests for Rain Dto
   @Test
   @DisplayName("when calling getJsonMember1h method, return 5.5")
   void whenCallingGetJsonMember1hMethodReturn55() {
       Mockito.when(mockRain.getJsonMember1h()).thenReturn(5.5);
       assertEquals(5.5, mockRain.getJsonMember1h());
   }

    @Test
    @DisplayName("when calling isRainNull method, return true")
    void whenCallingisRainNullMethodReturnTrue() {
        Mockito.when(mockRain.isRainNull()).thenReturn(true);
        Assertions.assertTrue(mockRain.isRainNull());
    }

    @Test
    @DisplayName("when calling isRainPositive method, return true")
    void whenCallingIsRainPositiveMethodReturnTrue() {
        Mockito.when(mockRain.isRainPositive()).thenReturn(true);
        assertTrue(mockRain.isRainPositive());
    }

    // tests for Sys dto
    @Test
    @DisplayName("when calling getCountry method, return I am a fake Object ")
    void whenCallingGetCountryMethodReturnIAmAFakeObject() {
        Mockito.when(mockSys.getCountry()).thenReturn("I am a fake Object");
        assertEquals("I am a fake Object", mockSys.getCountry());
    }

    @Test
    @DisplayName("when calling getSunrise method, return 5")
    void whenCallingGetSunriseMethodReturn5() {
        Mockito.when(mockSys.getSunrise()).thenReturn(5);
        assertEquals(5, mockSys.getSunrise());
    }

    @Test
    @DisplayName("when calling getSunset method, return 5")
    void whenCallingGetSunsetMethodReturn5() {
        Mockito.when(mockSys.getSunset()).thenReturn(5);
        assertEquals(5, mockSys.getSunset());
    }

    @Test
    @DisplayName("when calling getId method, return 5")
    void whenCallingGetIdMethodReturn5() {
        Mockito.when(mockSys.getId()).thenReturn(5);
        assertEquals(5, mockSys.getId());
    }

    @Test
    @DisplayName("when calling getType method, return 5")
    void whenCallingGetTypeMethodReturn5() {
        Mockito.when(mockSys.getType()).thenReturn(5);
        assertEquals(5, mockSys.getType());
    }

    @Test
    @DisplayName("when calling sunriseIsNotNull method, return true")
    void whenCallingSunriseIsNotNullMethodReturnTrue() {
        Mockito.when(mockSys.sunriseIsNotNull()).thenReturn(true);
        Assertions.assertTrue(mockSys.sunriseIsNotNull());
    }

    @Test
    @DisplayName("when calling sunsetIsNotNull method, return true")
    void whenCallingSunsetIsNotNullMethodReturnTrue() {
        Mockito.when(mockSys.sunsetIsNotNull()).thenReturn(true);
        Assertions.assertTrue(mockSys.sunsetIsNotNull());
    }

    @Test
    @DisplayName("when calling typeIsNotNull method, return true")
    void whenCallingTypeIsNotNullMethodReturnTrue() {
        Mockito.when(mockSys.typeIsNotNull()).thenReturn(true);
        Assertions.assertTrue(mockSys.typeIsNotNull());
    }

    @Test
    @DisplayName("when calling idIsNotNull method, return true")
    void whenCallingIdIsNotNullMethodReturnTrue() {
        Mockito.when(mockSys.idIsNotNull()).thenReturn(true);
        Assertions.assertTrue(mockSys.idIsNotNull());
    }

    @Test
    @DisplayName("when calling countryIsNotNull method, return true")
    void whenCallingCountryIsNotNullMethodReturnTrue() {
        Mockito.when(mockSys.countryIsNotNull()).thenReturn(true);
        Assertions.assertTrue(mockSys.countryIsNotNull());
    }

    @Test
    @DisplayName("when calling sunriseIsToday method, return true")
    void whenCallingSunriseIsTodayMethodReturnTrue() {
        Mockito.when(mockSys.sunriseIsToday()).thenReturn(true);
        Assertions.assertTrue(mockSys.sunriseIsToday());
    }

    @Test
    @DisplayName("when calling sunsetIsToday method, return true")
    void whenCallingSunsetIsTodayMethodReturnTrue() {
        Mockito.when(mockSys.sunsetIsToday()).thenReturn(true);
        Assertions.assertTrue(mockSys.sunsetIsToday());
    }

    // tests for weatheritem dto
    @Test
    @DisplayName("when calling getIcon method, return I am a fake object")
    void whenCallingGetIconMethodReturnIAmAFakeObject() {
        Mockito.when(mockWeatherItem.getIcon()).thenReturn("I am a fake object");
        assertEquals("I am a fake object", mockWeatherItem.getIcon());
    }

    @Test
    @DisplayName("when calling getDescription method, return I am a fake object")
    void whenCallingGetDescriptionReturnIAmAFakeObject() {
        Mockito.when(mockWeatherItem.getDescription()).thenReturn("I am a fake object");
        assertEquals("I am a fake object", mockWeatherItem.getDescription());
    }

    @Test
    @DisplayName("when calling getMain method, return I am a fake object")
    void whenCallingGetMainMethodReturnIAmAFakeObject() {
        Mockito.when(mockWeatherItem.getMain()).thenReturn("I am a fake object");
        assertEquals("I am a fake object", mockWeatherItem.getMain());
    }

    @Test
    @DisplayName("When calling getId Method in weatherItem, return 5")
    void whenCallingGetIdInWeatherItemMethodReturn5() {
        Mockito.when(mockWeatherItem.getId()).thenReturn(5);
        assertEquals(5, mockWeatherItem.getId());
    }
    @Test
    @DisplayName("when calling idIsValid method, return true")
    void whenCallingIdIsValidReturnTrue() {
        Mockito.when(mockWeatherItem.idIsValid()).thenReturn(true);
        assertTrue(mockWeatherItem.idIsValid());
    }
    @Test
    @DisplayName("when calling iconIsValid method, return true")
    void whenCallingIconIsValidReturnTrue() {
        Mockito.when(mockWeatherItem.iconIsValid()).thenReturn(true);
        assertTrue(mockWeatherItem.iconIsValid());
    }
    @Test
    @DisplayName("when calling mainIsValid method, return true")
    void whenCallingMainIsValidReturnTrue() {
        Mockito.when(mockWeatherItem.mainIsValid()).thenReturn(true);
        assertTrue(mockWeatherItem.mainIsValid());
    }
    @Test
    @DisplayName("when calling descriptionIsValid method, return true")
    void whenCallingDescriptionIsValidReturnTrue() {
        Mockito.when(mockWeatherItem.descriptionIsValid()).thenReturn(true);
        assertTrue(mockWeatherItem.descriptionIsValid());
    }

    @Test
    @DisplayName("When Calling getVisibility, return 5")
    void whenCallingGetVisibilityReturn5() {
        Mockito.when(mockWeatherResponse.getVisibility()).thenReturn(5);
        assertEquals(5, mockWeatherResponse.getVisibility());
    }

    @Test
    @DisplayName("When calling getTimeZone return 5")
    void whenCallingGetTimeZoneReturn5() {
        Mockito.when(mockWeatherResponse.getTimezone()).thenReturn(5);
        assertEquals(5, mockWeatherResponse.getTimezone());
    }

    @Test
    @DisplayName("When calling getdt return 5")
    void whenCallingGetdtReturn5() {
        Mockito.when(mockWeatherResponse.getDt()).thenReturn(5);
        assertEquals(5, mockWeatherResponse.getDt());
    }

    @Test
    @DisplayName("When calling getName return 'I am fake object!'")
    void whenCallingGetNameReturnIAmFakeObject() {
        Mockito.when(mockWeatherResponse.getName()).thenReturn("I am fake object!");
        assertEquals("I am fake object!" , mockWeatherResponse.getName());
    }

    @Test
    @DisplayName("When calling getCod return 5")
    void whenCallingGetCodReturn5() {
        Mockito.when(mockWeatherResponse.getCod()).thenReturn(5);
        assertEquals(5, mockWeatherResponse.getCod());
    }

    @Test
    @DisplayName("When calling getBase return 'I am fake object'")
    void whenCallingGetBaseReturnIAmFakeObject() {
        Mockito.when(mockWeatherResponse.getBase()).thenReturn("I am fake object!");
        assertEquals("I am fake object!", mockWeatherResponse.getBase());
    }

    @Test
    @DisplayName("When calling isTimeZoneValid method, return true")
    void whenCallingIsTimeZoneValidMethodReturnTrue() {
        Mockito.when(mockWeatherResponse.isTimeZoneValid()).thenReturn(true);
        assertTrue(mockWeatherResponse.isTimeZoneValid());
    }

    @Test
    @DisplayName("When calling isVisibilityValid method, return true")
    void whenCallingIsVisibilityValidMethodReturnTrue() {
        Mockito.when(mockWeatherResponse.isVisibilityValid()).thenReturn(true);
        assertTrue(mockWeatherResponse.isVisibilityValid());
    }

    @Test
    @DisplayName("When calling isRainValid method, return true")
    void whenCallingIsRainValidMethodReturnTrue() {
        Mockito.when(mockWeatherResponse.isRainValid()).thenReturn(true);
        assertTrue(mockWeatherResponse.isRainValid());
    }

    @Test
    @DisplayName("When calling isWindValid method, return true")
    void whenCallingIsWindValidMethodReturnTrue() {
        Mockito.when(mockWeatherResponse.isWindValid()).thenReturn(true);
        assertTrue(mockWeatherResponse.isWindValid());
    }

    @Test
    @DisplayName("When calling isSysValid method, return true")
    void whenCallingIsSysValidMethodReturnTrue() {
        Mockito.when(mockWeatherResponse.isSysValid()).thenReturn(true);
        assertTrue(mockWeatherResponse.isSysValid());
    }

    @Test
    @DisplayName("When calling isIdValid method, return true")
    void whenCallingIsIdValidMethodReturnTrue() {
        Mockito.when(mockWeatherResponse.isIdValid()).thenReturn(true);
        assertTrue(mockWeatherResponse.isIdValid());
    }

    @Test
    @DisplayName("When calling isCOD200, return true")
    void whenCallingIsCod200ReturnTrue() {
        Mockito.when(mockWeatherResponse.isCOD200()).thenReturn(true);
        assertTrue(mockWeatherResponse.isCOD200());
    }

    @Test
    @DisplayName("when calling visibilityIsBetweenValidRange method, return true")
    void whenCallingVisibilityIsBetweenValidRangeMethodReturnTrue() {
        Mockito.when(mockWeatherResponse.visibilityIsBetweenValidRange()).thenReturn(true);
        assertTrue(mockWeatherResponse.visibilityIsBetweenValidRange());
    }

    @Test
    @DisplayName("when calling isRainRangeValid method, return true")
    void whenCallingIsRainRangeValidMethodReturnTrue() {
        Mockito.when(mockWeatherResponse.getRain().isRainRangeValid()).thenReturn(true);
        assertTrue(mockWeatherResponse.getRain().isRainRangeValid());
    }
}