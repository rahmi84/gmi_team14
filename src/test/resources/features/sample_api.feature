@api
  Feature: get the data from end point
    Scenario: Get data from end point
    Given user goes to end point "https://www.gmibank.com/api/tp-customers"
      And recieve all the data