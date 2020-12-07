Feature: Creating address of customer

  Background:
    Given Navigate to https://gmibank.com/
    When A new customer click register button
    Then Customer provide all information and register
    Given Navigate to https://gmibank.com/
    When Sign in as a "employee"
    Then Go to manage customers page
    And Click "Create a new Customers" button
    And Search customer by customer's SSN

  Scenario:Address should be provided and cannot be left blank
    When I should provide custumer address and zipcode
    Then I should verify address has not left blank

  Scenario:City should be provided and cannot be left as blank
    When I should provide custumer city
    Then I should verify city has not left blank

  Scenario:Country should be typed and cannot be blank
    When I should provide custumer country
    Then I should verify country has not left blank

  Scenario:State should be provided as US state and cannot be blank
    When I should provide custumer state
    Then I should verify state has not left blank