Feature: Creating address of customer

  Background:
    Given Navigate to GMI Bank website
    When Sign in as a "employee"
    Then Go to manage customers page
    And Click "Create a new Customers" button
    And Search customer by customer's SSN

  Scenario Outline:Address should be provided and cannot be left blank
    When I should provide custumer all informations as "<middle initial>" , "<phone number>" , "<zipcode>" , "<city>" , "<country>" , "<state>"
    Then I should verify address has not left blank
    Examples: Customer Extra Data
      | middle initial | phone number | zipcode | city  | country | state |
      |custy           |650-345-2345  |43054    |Dublin |USA      |OH     |

  @US_010/TC_001
  Scenario:Address should be provided and cannot be left as blank
    Given I should verify address has not left blank

  @US_010/TC_002
  Scenario:City should be provided and cannot be left as blank
    Given I should verify city has not left blank

  @US_010/TC_003
  Scenario:Country should be typed and cannot be blank
    Given I should verify country has not left blank

  @US_010/TC_004
  Scenario:State should be provided as US state and cannot be blank
    Given I should verify state has not left blank

