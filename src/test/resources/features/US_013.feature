@employee
Feature: new employee account create functionality


Scenario: : User sign-in with valid credential and navigate to the application home page
    Given login  as employee




  Scenario Outline: employee creates new  account with  Account Type and Account Status combinations
   Then user click  create a new account
    And enter a <Description>
    When enter balance as <Balance>
    When select <Account Type> account type
    When select account status <Account Status>
    And save form
    Then  Success message is displayed




    Examples:
      | Description | Balance | Account Type | Account Status |
      | TEST1       | 1000    | CHECKING     | ACTIVE         |
      | TEST2       | 2000    | CHECKING     | SUESPENDED     |
      | TEST3       | 3000    | CHECKING     | CLOSED         |
      | TEST4       | 4000    | SAVING       | ACTIVE         |
      | TEST5       | 5000    | SAVING       | SUESPENDED     |
      | TEST6       | 600     | SAVING       | CLOSED         |
      | TEST7       | 700     | CREDIT_CARD  | ACTIVE         |
      | TEST8       | 800     | CREDIT_CARD  | SUESPENDED     |
      | TEST9       | +1      | CREDIT_CARD  | CLOSED         |
      | TEST10      | +1      | INVESTING    | CLOSED         |
      | TEST11      | -0      | INVESTING    | SUESPENDED     |
      | TEST12      | -0      | INVESTING    | CLOSED         |



  Scenario Outline:  employee creates new  account with different balance -Unhappy path
   Then user click  create a new account
    When enter a <Description>
    When enter balance as <Balance>
    When select <Account Type> account type
    When select account status <Account Status>
    When click employee dropdown menu
    And save form
    Then  Success message is displayed



    Examples:

      | Description | Balance | Account Type | Account Status |
      | TEST13     | 10.23   | CHECKING     | ACTIVE         |
      | TEST14     | -10.23  | CHECKING     | ACTIVE         |




  Scenario: employee creates new account with blank description or/and balance
   Given user click  create a new account
    And save form
    But error box content












