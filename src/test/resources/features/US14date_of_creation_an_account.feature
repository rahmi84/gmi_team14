@db
Feature: Accounts of customer
  Background: Employee gets to page he will work
    Given User signs in as employee to system
    And user clicks on My Operations
    And user clicks on Manage Accounts


  Scenario: The date cannot be typed earlier, in the past, at the time of creation an account
    And user clicks on the Create a new Account
    And user enter the "Team14 account" as Description
    And user enter the 9999999 as Balance
    When user enter the the creation date as "01/01/2019" and creation time as "01:01 AM"
    And user clickc on account Save button
    Then user sees green success message on the screen


  Scenario:The date should be created as month, day, year, hour and minute
    When user enter the the creation date as "21/32/2019" and creation time as "22:29 AM"

    Scenario: There user can choose an account created on manage accounts
      When user goes manage accounts page
      And clicks on user id



