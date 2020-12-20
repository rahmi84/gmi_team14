@US_025
Feature: US_25
  Scenario: create a country
  Given create a country with map and send to end point"https://www.gmibank.com/api/tp-countries"
    And get response and store response with JsonPath using endpoint"https://www.gmibank.com/api/tp-countries"
  Then validate the country that created before


