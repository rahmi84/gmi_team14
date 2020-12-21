@api
  Feature:  System should allow to update countries using api end point
    "https://www.gmibank.com/api/tp-countries"
    Scenario: Get the countries from end point and change them
    Given user goes to end point and change any user's country
      Then verifies if actual one is updated

