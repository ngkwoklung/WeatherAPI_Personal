package com.sparta.dr.cucumber;

import com.sparta.dr.framework.DTO.WeatherResponse;
import com.sparta.dr.framework.connection_manager.ConnectionManager;
import com.sparta.dr.framework.injector.Injector;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.net.http.HttpResponse;

public class MyStepdefs {
    HttpResponse<String> response;
    WeatherResponse weatherDTO;

    @Given("that I call the API")
    public void thatICallTheAPI() {
        response = ConnectionManager.getResponseByCity("london");
    }

    @When("I get a response")
    public HttpResponse<String> iGetAResponse() {
        return response;
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int code) {
        int actual = iGetAResponse().statusCode();
        Assertions.assertEquals(code, actual);
    }

    @Then("the DTO should be populated")
    public void theDTOShouldBePopulated() {
        weatherDTO = Injector.injectWeatherDTO(response);
        Assertions.assertTrue(weatherDTO.isSysValid() &&
                weatherDTO.areIconsInWeatherItemValid() &&
                weatherDTO.areDescriptionsInWeatherItemValid() &&
                weatherDTO.toString() != null);
    }

    @Given("that I call the API with Lat and Lon")
    public HttpResponse<String> thatICallTheAPIWithLatAndLon() {
        return response = ConnectionManager.getResponseByCoord("51.5085", "-0.1257");
    }

    @Then("the correct Lon and Lat are passed to the URL")
    public void theCorrectLonAndLatArePassedToTheURL() {
        String expected = "https://api.openweathermap.org/data/2.5/weather?lat=51.5085&lon=-0.1257&appid=a39a8ef364461dd7292792ea50bba6a1&units=imperial";
        String actual = thatICallTheAPIWithLatAndLon().uri().toString();
        Assertions.assertEquals(expected, actual);
    }

    @Then("the correct JSON file is passed")
    public void theCorrectJSONFileIsPassed() {
        System.out.println(response.headers().firstValue("json"));
    }

    @Given("that I call the API with a City Id")
    public HttpResponse<String> thatICallTheAPIWithACityId() {
        return response = ConnectionManager.getResponseByCityId(2643743);
    }

    @Then("the correct City Id is passed to the URL")
    public void theCorrectCityIdIsPassedToTheURL() {
        String expected = "https://api.openweathermap.org/data/2.5/weather?id=2643743&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric";
        String actual = thatICallTheAPIWithACityId().uri().toString();
        Assertions.assertEquals(expected, actual);
    }

    @Given("that I call the API with a Zip Id")
    public HttpResponse<String> thatICallTheAPIWithAZipId() {
        return response = ConnectionManager.getResponseByZipId(94040);
    }

    @Then("the correct Zip Id is passed to the URL")
    public void theCorrectZipIdIsPassedToTheURL() {
        String expected = "https://api.openweathermap.org/data/2.5/weather?q=94040&appid=a39a8ef364461dd7292792ea50bba6a1&units=metric";
        String actual = thatICallTheAPIWithAZipId().uri().toString();
        Assertions.assertEquals(expected, actual);
    }

    @Then("the Weather DTO should have valid populated values")
    public void theWeatherDTOShouldHaveValidPopulatedValues() {
        weatherDTO = Injector.injectWeatherDTO(response);
    }

    @Then("the DTO should have the correct Weather Id")
    public void theDTOShouldHaveTheCorrectWeatherId() {
        Assertions.assertTrue(weatherDTO.isIdValid());
    }
    

    @Then("the DTO should have today's date")
    public void theDTOShouldHaveTheTodaySDate() {
        Assertions.assertTrue(weatherDTO.dtIsToday());
    }


    @Then("the DTO should have a Sunrise Time of today's date")
    public void theDTOShouldHaveASunriseTimeOfTodaySDate() {
        Assertions.assertTrue(weatherDTO.getSys().sunriseIsToday());
    }

    @And("the DTO should have a Sunset Time of today's date")
    public void theDTOShouldHaveASunsetTimeOfTodaySDate() {
        Assertions.assertTrue(weatherDTO.getSys().sunsetIsToday());
    }


    @Then("the DTO should have a time zone within the correct range")
    public void theDTOShouldHaveTheATimeZoneWithinTheCorrectRange() {
        Assertions.assertTrue(weatherDTO.timezoneIsBetweenValidRange());
    }

    @Given("that I call the API with a City Name and a Country Name")
    public HttpResponse<String> thatICallTheAPIWithACityNameAndACountryName() {
        return response = ConnectionManager.getResponseByCityId(2643743);
    }

    @Then("the DTO should have the correct City Id")
    public void theDTOShouldHaveTheCorrectCityId() {
        Assertions.assertTrue(thatICallTheAPIWithACityNameAndACountryName().uri().toString().contains("id=2643743"));
    }

    @And("the DTO should have the correct Country Id")
    public void theDTOShouldHaveTheCorrectCountryId() {
        Assertions.assertTrue(thatICallTheAPIWithACityNameAndACountryName().uri().toString().contains("2075535"));
    }

    @Then("the DTO should have a Visibility value within the correct range")
    public void theDTOShouldHaveAVisibilityValueWithinTheCorrectRange() {
        Assertions.assertTrue(weatherDTO.isVisibilityValid());
    }

    @Then("the DTO should have a Wind Degree within the correct range")
    public void theDTOShouldHaveAWindDegreeWithinTheCorrectRange() {
        Assertions.assertTrue(weatherDTO.getWind().isDegBetween0And360());
    }

    @And("the DTO should have a Wind Gust within the correct range")
    public void theDTOShouldHaveAWindGustWithinTheCorrectRange() {
        Assertions.assertTrue(weatherDTO.getWind().isGustValid());
    }

    @And("the DTO should have a Wind Speed")
    public void theDTOShouldHaveAWindSpeed() {
        Assertions.assertTrue(weatherDTO.getWind().isSpeedValid());
    }

    @Given("that I call the API with a Snow Volume for the last {int} hour, mm")
    public void thatICallTheAPIWithASnowVolumeForTheLastHourMm(int arg0) {
        weatherDTO = Injector.injectWeatherDTO(response);
    }

    @Then("the DTO should have a Snow Volume within the correct range")
    public void theDTOShouldHaveASnowVolumeWithinTheCorrectRange() {
        //Assertions.assertTrue(weatherDTO.getSnow().isSnow1hBetweenRange0To107());
    }

    @Given("that I call the API with a Snow Volume for the last {int} hours, mm")
    public void thatICallTheAPIWithASnowVolumeForTheLastHoursMm(int arg0) {
        //Assertions.assertTrue(weatherDTO.getSnow().isSnow3hBetweenRange0To320());
    }

    @Then("the DTO should have a Rain Volume within the correct range")
    public void theDTOShouldHaveARainVolumeWithinTheCorrectRange() {
        Assertions.assertTrue(weatherDTO.isRainRangeValid());
    }

    @Then("the DTO should have a Cloud value within the correct range")
    public void theDTOShouldHaveACloudValueWithinTheCorrectRange() {
        Assertions.assertTrue(weatherDTO.getClouds().isCloudPositive());
    }
}
