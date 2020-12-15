@employee
  Feature: new employee account create functionality


Scenario: : User sign-in with valid credential and navigate to the application home page
    Given login  as employee
    Then user click  create a new account








  @TC01-employee
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
      | TEST9       | 900     | CREDIT_CARD  | CLOSED         |
      | TEST10      | 400     | INVESTING    | CLOSED         |
      | TEST11      | 300     | INVESTING    | SUESPENDED     |
      | TEST12      | 200     | INVESTING    | CLOSED         |



    @TC-02employee
  Scenario Outline:  employee creates new  account with different balance -Negative path
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
      | TEST13      | 0       | CHECKING     | ACTIVE         |
      | TEST14      | -0      | CHECKING     | ACTIVE         |
      | TEST15      | +0      | CHECKING     | ACTIVE         |
      | TEST16      | -1      | CHECKING     | ACTIVE         |
#      | TEST17      | 10.23   | CHECKING     | ACTIVE         |
#      | TEST18      | -10.23  | CHECKING     | ACTIVE         |



  @TC-03employee
  Scenario: employee creates new account with blank description or/and balance
    Given user click  create a new account
    And save form
    But error box content












