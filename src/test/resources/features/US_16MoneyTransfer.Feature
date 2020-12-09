Feature: Money Transfer should be available

  Scenario: TC01 Customer should see all available accounts at from dropdown

    Given user is on money transfer page
    When user clicks to from dropdown
    Then verify all the accounts appears on dropdown

    Scenario: TC02 Customer should see all available accounts at to dropdown
      Given user is on money transfer page
      When user clicks to to dropdown
      Then verify all available accounts appears on dropdown

      Scenario: TC03 Customer should be available to click to Balance box and enter the amount
        Given user is on money transfer page
        When user clicks to balance box
        And user enters an amount
        And user enters an amount on cent box
        Then verify amount appears on the balance box and cent box

        Scenario:TC04 Customer should be available to type description
          Given User is on money transfer page
          When user clicks to description box
          And user enters the description
          Then verify descriptions appears on the description box

