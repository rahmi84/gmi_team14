@US_21
Feature: "System should allow to read all countries info using api end point
  ""https://www.gmibank.com/api/tp-countries"" "


Scenario: Create a new country
  Given user create a new country and sets response using api end point "https://www.gmibank.com/api/tp-countries"
  And user deserialization countries data json to pojo


  Scenario: Read and validate all countries info
  Given user read all countries and sets response using api end point "https://www.gmibank.com/api/tp-countries"
  Then user validates all countries data