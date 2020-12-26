@US_010
Feature: Creating address of customer


    Scenario Outline:Address should be provided and cannot be left blank
    When Sign in as a "employee"
    Then Go to manage customers page
    And Click Create a new Customers button
    And Search customer by customer's SSN
    When I should provide customer all informations as "<middle initial>" , "<phone number>" , "<zipcode>" , "<city>" , "<country>" , "<state>"
    Examples: Customer Extra Data
      | middle initial | phone number | zipcode | city      | country | state |
      |A               |650-345-2345  |95090    |Los Angeles|USA      |CA     |


    Scenario Outline:Address, State, Country and City should be provided and cannot be left as blank
    Given I should verify address as "<address>" has not left blank
    When I should verify city as "<city>" has not left blank
    Then I should verify country as "<country>" has not left blank
    And I should verify state as "<state>" has not left blank
    Examples:
      |address    |city        |country  |state |
      |Gates Ct.  |Los Angeles |USA      |CA    |




