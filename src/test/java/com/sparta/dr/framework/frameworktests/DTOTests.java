package com.sparta.dr.framework.frameworktests;

import com.sparta.dr.framework.DTO.Snow;
import com.sparta.dr.framework.DTO.Wind;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DTOTests {

    private Snow mockSnow;
    private Wind mockWind;

    @BeforeEach
    void init(){
        mockSnow = Mockito.mock(Snow.class);
        mockWind = Mockito.mock(Wind.class);
    }

   @Test
   @DisplayName("When calling toString method on wind, return I am fake object")
   void whenCallingToStringMethodOnWindReturnIAmFakeObject(){
        Mockito.when(mockWind.toString()).thenReturn("I am fake object");
        Assertions.assertEquals("I am fake object", mockWind.toString());
   }




}
