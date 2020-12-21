@US_22DenemeSmokeTest
Feature: System should allow to read states using api end point

  Scenario Outline: Get data from api end point and create the states
    Given Get data from states end point "https://www.gmibank.com/api/tp-states" and create the states using "<Type>" and "<States>"

    Examples: Create states
      | Type | States |
      | name | Maine  |
      | name | Lowa   |

  @TC_22Api
  Scenario: Read all states you created and validate them from your data set
    Given user sets the states to response using "https://www.gmibank.com/api/tp-states"
    And user deserialization all states to pojo
#    And user saves the states to correspondent files
#    Then user validates the all states 1 by 1


  @TC_22Api
  Scenario: Read all customers you created and validate them 1 by 1
    Then Verify state id "59949" is "Maine"
#    Then Verify state id "59805" is "Lowa"