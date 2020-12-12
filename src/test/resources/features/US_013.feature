@employee

Feature: new employee account create functionality


 Background: User sign-in with valid credential and navigate to the application home page
    Given login  as employee
    Then user click  create a new account




#==============AC3=  User can select an account type as CHECKING, SAVING, CREDIT_CARD or INVESTING==================
#==========AC4=Account status should be defined as ACTIVE, SUSPENDED or CLOSED================
# =======AC5 User can select an employee from the drop-down=================================

     #    there is a bug ,just there is 1 option to choose from dropdown and it is automatically chosen.

  @HappyPath
  Scenario Outline: employee creates new  account with  Account Type and Account Status combinations
   Given enter a <Description>
    When enter balance as <Balance>
    When select <Account Type> account type
    When select account status <Account Status>
    When click employee dropdown menu
    And save form
    Then success massage display



     #    there is a bug.SUSPENDED is typed wrong at the Account Status dropdown menu (SUESPENDED)

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



#AC2=============== User should provide a balance for the first time account creation as Dollar=========================
  @unhappyPath
  Scenario Outline:  employee creates new  account with different balance -Negative path
    When enter a <Description>
    When enter balance as <Balance>
    When select <Account Type> account type
    When select account status <Account Status>
    When click employee dropdown menu
    And save form
    Then success massage display


    Examples:

      | Description | Balance | Account Type | Account Status |
      | TEST13      | 0       | CHECKING     | ACTIVE         |
      | TEST14      | -0      | CHECKING     | ACTIVE         |
      | TEST15      | +0      | CHECKING     | ACTIVE         |
      | TEST16      | -1      | CHECKING     | ACTIVE         |

#    there is a bug ..Balance  does not allow to enter double and negative double datas (10.23  and -10.23)
      | TEST17      | 10.23   | CHECKING     | ACTIVE         |
      | TEST18      | -10.23  | CHECKING     | ACTIVE         |


#AC1========================User should create a description for the new account and it cannot be blank======================

  @someBlankData
  Scenario: employee creates new account with blank description or/and balance
    And save form
    But error box content




















