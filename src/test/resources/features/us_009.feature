Feature:Create a customer feature

  @US_009/TC_001
  Scenario Outline:Successful customer creating in GMI Bank Application
    Given Navigate to GMI Bank Application
    When A new customer click register button
    Then Customer provide all informations as as "<ssn>" , "<first name>" , "<last name>" , "<address>" , "<mobile phone>" , "<username>" , "<email>" , "<new password>" , "<confirm password>" and register
    Given Navigate to GMI Bank Application
    When Sign in as a "employee"
    Then Go to manage customers page
    And Click "Create a new Customers" button
    And Search customer by customer's SSN
    Then I should see custumer informations

    Examples:Customer Data
      | ssn       | first name | last name | address  | mobile phone | username| email        | new password| confirm password |
      |123-45-7654|Customerx   |Gates      |123 X Ave.|650-443-5675  |custx    |custxgmail.com|custx123     |custx123          |

