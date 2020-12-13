@US15_SmokeTest
Feature: System should allow user to manage their account

  Background: US_015 Balance populations
    Given user should go to homepage and signIn Customer Account
    And clicks My Operations
    And  clicks My Accounts

  @US15_TC01
  Scenario: User should see all account types and balance populated
    Then Verify user can see all account types and balance populated
    And user signOut


  @US15_TC02
  Scenario: User can View Transaction
    Given user clicks View Transaction Buttons
    Then Verify user can see all view transaction
    And user signOut
