


Feature: Date should be created ont he time of account creation


  Background: user signs in in as employee and goes to account creation
      When employee goes to endpoint
    When signs in as employee
    When clicks on myOperations
    When selects Manage Accounts
    And clicks on create a new account
Scenario Outline: Creation time of an account cant be earlier or later

  When user fills description
  When user fills balance
  When user fills account Type
  When user fills status type
  When user fills "<create date>"
  When user fills "<description>"
  And user clicks on save




