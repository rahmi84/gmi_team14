@US_024_API
Feature: US_24
  Scenario: create a state
    Given create a state with map and send to end point"https://www.gmibank.com/api/tp-states"
    And get response and store response with JsonPath using endpoint "https://www.gmibank.com/api/tp-states"
    Then validate the state that created before
