@US_22SmokeTest
Feature: System should allow to read states using api end point

  Scenario Outline: Get data from api end point and create the states
    Given Get data from states end point "https://www.gmibank.com/api/tp-states" and create the states using "<Type>" and "<States>"

    Examples: Create states
      | Type | States |
      | name | Maine  |
      | name | Lowa   |


  @TC_22Api1
  Scenario: Read your created all states and validate them one by one
    Given user sets the states to response using "https://www.gmibank.com/api/tp-states"
    And user deserialization all states Json to Java
    Then Validate your created all states one by one
