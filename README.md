# Weather API Project


## Overview

This project is a framework for testing the Open Weather API. The framework is only focused on the Current Weather section (https://openweathermap.org/current).

The framework itself -including the Connection Manager, the DTOs and the Injector- is internally tested using unit testing and mocking.

## Main Components

Since the API has a number of different responses, we are using a Service Object Model. This model represents the various API requests using the following components:

1. DTO: Classes that represent the different types of responses that can be called (including Clouds, Coord, Main, Rain Snow, Sys, WeatherItem and Wind). The DTOs provide access to all the data that testers could find useful.
2. ConnectionManager: A class which handles the connection to the live system and collects the response.
3. Injector: A class responsible for injecting the JSON response into the weather DTO.
4. WeatherResponseTests: A class to be used by the tester. This is where testing methods can be created in line with the available helper methods in this framework.

## BDD

The framework also has a BDD layer for both the Connection Manager and the DTO. This BDD layer allows non-technical users to access/run tests.
The BDD user stories are made in line with the helper methods created under the DTOs and the ConnectionManagerTest.

## Instructions to Run the Programme
Before using this programme, please consider the below notes:

In order to handle the connection to the live system and to inject the JSON response into the DTO, the tester has to create a @BeforeAll method in the WeatherResponseTests class prior to using the framework. See the below line for your reference:

dto = Injector.injectWeatherDTO(ConnectionManager.getResponseByCity("London"));

*Common Commands:*

Commands of the different types of tests that can be performed include the following:

- countryIsNotNull
- isTimeZoneValid
- timezoneIsBetweenValidRange

- isRainNull
- isRainPositive
- isRainValid
- isRainRangeValid

- isSnow1hBetweenRange0To107
- isSnow3hBetweenRange0To320

- isWindValid
- isDegBetween0And360
- isSpeedNotNull
- isSpeedValid
- isGustNotNull
- isGustValid

- isCloudsNull
- isCloudPositive

- isVisibilityValid
- visibilityIsBetweenValidRange

- lonIsNotNull
- latIsNotNull
- lonIsBetweenValidRange
- latIsBetweenValidRange

- dtIsToday
- sunriseIsNotNull
- sunsetIsNotNull
- sunriseIsToday
- sunsetIsToday
- typeIsNotNull

- idIsNotNull
- idISValid
- isIdValid
- areIdsInWeatherItemValid

- areMainsInWeatherItemValid
- mainStartsWithCapitalLetter
- mainIsValid
- iconIsValid

- isCOD200
- isSysValid
