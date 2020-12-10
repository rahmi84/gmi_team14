@Smoke
Feature: System should allow user to manage their account

  Background: US_015 Balance populations
    Given user should signIn Customer Account
    And clicks My Operations
    Then  clicks My Accounts

  @US15_TC01
  Scenario: User should see all account types and balance populated
    Given user can see all account types and balance populated
    Then user signOut


  @US15_TC02
  Scenario: User can View Transaction
    Given user clicks View Transaction Box
    And user can see all view transaction
    Then user signOut
