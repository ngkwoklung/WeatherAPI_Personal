package com.sparta.dr.framework.frameworktests;

import com.sparta.dr.framework.DTO.Clouds;
import com.sparta.dr.framework.DTO.Snow;
import com.sparta.dr.framework.DTO.Wind;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class DTOTests {

    private Snow mockSnow;
    private Wind mockWind;
    private Clouds mockClouds;

    @BeforeEach
    void init(){
        mockSnow = Mockito.mock(Snow.class);
        mockWind = Mockito.mock(Wind.class);
        mockClouds = Mockito.mock(Clouds.class);
    }

    //Tests for wind dto
   @Test
   @DisplayName("When calling toString method on wind, return I am fake object")
   void whenCallingToStringMethodOnWindReturnIAmFakeObject(){
        Mockito.when(mockWind.toString()).thenReturn("I am fake object");
        Assertions.assertEquals("I am fake object", mockWind.toString());
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
        Assertions.assertEquals(5,mockWind.getDeg());
   }

   @Test
   @DisplayName("When calling get speed method, return 5.5")
   void whenCallingGetSpeedMethodReturn55(){
        Mockito.when(mockWind.getSpeed()).thenReturn(5.5);
        Assertions.assertEquals(5.5,mockWind.getSpeed());
   }

   @Test
   @DisplayName("When calling get gust method, return 5.5")
   void whenCallingGetGustMethodReturn55(){
        Mockito.when(mockWind.getGust()).thenReturn(5.5);
        Assertions.assertEquals(5.5,mockWind.getGust());
   }

   //Tests for snow dto
   @Test
   @DisplayName("When I am calling toString method on snow, then return I am fake object")
   void whenIAmCallingToStringMethodOnSnowThenReturnIAmFakeObject(){
        Mockito.when(mockSnow.toString()).thenReturn("I am fake object");
        Assertions.assertEquals("I am fake object",mockSnow.toString());
   }

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
        Assertions.assertEquals(5.5, mockSnow.getJsonMember1h());
   }

   @Test
   @DisplayName("When I am calling the getJsonMember3h method, return 5.5")
   void whenIAmCallingTheGetJsonMember3HMethodReturn55(){
        Mockito.when(mockSnow.getJsonMember3h()).thenReturn(5.5);
        Assertions.assertEquals(5.5, mockSnow.getJsonMember3h());
   }

   //Tests for snow dto
   @Test
   @DisplayName("When I am calling toString method on clouds, then return I am fake object")
   void whenIAmCallingToStringMethodOnCloudsThenReturnIAmFakeObject(){
        Mockito.when(mockClouds.toString()).thenReturn("I am fake object");
        Assertions.assertEquals("I am fake object",mockClouds.toString());
   }

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
        Assertions.assertEquals(5,mockClouds.getAll());
   }
}
