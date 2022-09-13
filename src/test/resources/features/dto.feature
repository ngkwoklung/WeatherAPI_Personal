Ability: Able to get Weather response
  Scenario: Checking that the DTO is populated
    Given that I call the API with Lat and Lon
    When I get a response
    Then the Weather DTO should have populated values

  Scenario: Checking the populated DTO has the correct Weather Id
    Given that I call the API with Lat and Lon
    When I get a response
    Then the DTO should have the correct Weather Id


