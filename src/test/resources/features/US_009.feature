Feature:Create a customer feature

  Scenario:Successful customer creating in GMI Bank Application
    Given Navigate to "https://gmibank.com/"
    When A new customer click register button
    Then Customer provide all information and register
    Given Navigate to "https://gmibank.com/"
    When Sign in as a "employee"
    Then Go to manage customers page
    And Click "Create a new Customers" button
    And Search customer by customer's SSN
    Then I should see custumer informations

