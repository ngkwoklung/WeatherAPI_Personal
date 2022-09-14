Ability: Able to get Weather response
  Scenario: Checking that the DTO is populated
    Given that I call the API with Lat and Lon
    When I get a response
    Then the Weather DTO should have valid populated values

  Scenario: Checking the populated DTO has the correct Weather Id
    Given that I call the API with Lat and Lon
    When I get a response
    Then the DTO should have the correct Weather Id

  Scenario: Checking the populated DTO has the correct Date
    Given that I call the API with a Date
    When I get a response
    Then the DTO should have today's date

  Scenario: Checking the populated DTO has the correct Sunrise and Sunset Time
    Given that I call the API with a Sunrise Time and a Sunset Time
    When I get a response
    Then the DTO should have a Sunrise Time of today's date
    And the DTO should have a Sunset Time of today's date

  Scenario: Checking the populated DTO has the correct Time Zone
    Given that I call the API with a Time Zone
    When I get a response
    Then the DTO should have a time zone within the correct range

  Scenario: Checking the populated DTO has the correct City and Country Ids
    Given that I call the API with a City Name and a Country Name
    When I get a response
    Then the DTO should have the correct City Id
    And the DTO should have the correct Country Id

  Scenario: Checking the populated DTO has a valid Visibility
    Given that I call the API with a Visibility
    When I get a response
    Then the DTO should have a Visibility value within the correct range

  Scenario: Checking the populated DTO has valid Wind data
    Given that I call the API with a Wind
    When I get a response
    Then the DTO should have a Wind Degree within the correct range
    And the DTO should have a Wind Gust within the correct range
    And the DTO should have a Wind Speed

  Scenario: Checking the populated DTO has a valid 1h Snow Volume
    Given that I call the API with a Snow Volume for the last 1 hour, mm
    When I get a response
    Then the DTO should have a Snow Volume within the correct range

  Scenario: Checking the populated DTO has a valid 3h Snow Volume
    Given that I call the API with a Snow Volume for the last 3 hours, mm
    When I get a response
    Then the DTO should have a Snow Volume within the correct range

  Scenario: Checking the populated DTO has a valid Rain Volume
    Given that I call the API with a Rain Volume
    When I get a response
    Then the DTO should have a Rain Volume within the correct range

  Scenario: Checking the populated DTO has a valid Cloud value
    Given that I call the API with a Cloud value
    When I get a response
    Then the DTO should have a Cloud value within the correct range