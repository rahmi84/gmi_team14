@US16
Feature: Money Transfer should be available

  Background: Customer logins with valid credentials and clicks to money transfer button
    Given user is on customer page
    And user clicks to My Operations
    And user clicks to transfer money
    Then verify the user is on Transfer money page


  Scenario: TC01 Customer should see all available accounts at from dropdown
    When user clicks to From dropdown
    Then verify all the accounts appears on dropdown

  Scenario: TC02 Customer should see all available accounts at to dropdown
      When user clicks to To dropdown
      Then verify all available accounts appears on dropdown

      Scenario: TC03 Customer should be available to click to Balance box and enter the amount
        When user clicks to balance box
        And user enters an amount
        And user enters an amount on cent box
        Then verify amount appears on the balance box and cent box

        Scenario:TC04 Customer should be available to type description
          When user clicks to description box
          And user enters the descriptions
          Then verify descriptions appears on the description box

