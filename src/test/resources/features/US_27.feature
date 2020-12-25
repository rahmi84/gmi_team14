@US_027
Feature: System should allow to create new states

  Scenario: post request to create new state one by one
    Given user post  a new state to end point
    When  user deserialization state data  json to java pojo


  Scenario Outline:  delete states
    Given user deletes a state using endpoint "<endPoint>" and its extension "<id>"
    Examples: multiple states
      | endPoint                              | id     |
      | https://www.gmibank.com/api/tp-states | /60898 |