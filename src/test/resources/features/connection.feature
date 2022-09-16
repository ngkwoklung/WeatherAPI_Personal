Ability: Able to get connection response

  @SmokeTest @RegressionTest
  Scenario: Checking the connection works
    Given that I call the API
    When I get a response
    Then the status code should be 200

  @SmokeTest @RegressionTest
  Scenario: Checking that I get all the responses
    Given that I call the API
    When I get a response
    Then the DTO should be populated

  @SmokeTest @RegressionTest
  Scenario: Checking that the URL is correct
    Given that I call the API
    When I get a response
    Then the URL is correct

  @CoordTest
  Scenario: Checking that the URL passes the correct Lon and Lat
    Given that I call the API with Lat and Lon
    When I get a response
    Then the correct Lon and Lat are passed to the URL

  @SmokeTest @RegressionTest
  Scenario: Checking that the response has the correct JSON file
    Given that I call the API
    When I get a response
    Then the correct JSON file is passed

  @CoordTest
  Scenario: Checking that the URL passes the correct the correct City Id
    Given that I call the API
    When I get a response
    Then the correct City Id is passed to the URL

  @CoordTest
  Scenario: Checking that the URL passes the correct the correct Zip Id
    Given that I call the API with a Zip Id
    When I get a response
    Then the correct Zip Id is passed to the URL