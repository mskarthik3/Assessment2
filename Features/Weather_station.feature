Feature: Weather Station API Testing

  Scenario: Verify registration without API key
    When I register a weather station without an API key
    Then I should receive an error response with code 401 and a specific error message

  Scenario: Register and verify two weather stations
    When I register two weather stations with the specified details
    Then I should receive a successful response with code 201
    And the registered stations should be retrieved correctly









