@US_29
Feature:   user page with database validation

  Background:
    Given user connecting GMI database

  @TC_2901
  Scenario: All users info (user, employee, manager and admin) should be retrieved
  by database and validated

    And user read all  data from database
    Then user validate all  data

  @TC_2902
  Scenario:  All countries' info should be retrieved by database and validated

    And user read all countries info from database
    Then user validate all countries info

  @TC_2903
  Scenario: All states should related to USA should be  retrieved by database and validated
    And  user read all states of related  to USA from database
    Then  user validate all states of  related to USA

