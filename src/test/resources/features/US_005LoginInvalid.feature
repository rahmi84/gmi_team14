@US_05_Smoke
Feature: US_05 Login page should not be accessible with invalid credentials

  Background:User go to login page
    Given User go to  home page "http://www.gmibank.com/"  page
    And  User Should click on Loginmenu
    And ThenUser click  sign in

  @tc05_01
  Scenario Outline: User cannot login with invalid username validating the error message

    Given User enters invalid username "<userName>"
    When User enters  valid password "Team14_new_customer"
    And User clicks signIn button
    Then Validate error message
    And click cancel button
    Examples:
      |userName|
      |denizmavi |
      |zeynep |

  @tc05_02
  Scenario Outline: User cannot login with invalid password validating the error message
    Given user enters  valid username "team14_new_customer"
    When user enters  invalid password "<password>"
    And User clicks signIn button
    Then Validate error message
    And click cancel button
    Examples:
      |password|
      |ayse123 |
      |denizmavi567 |


  @tc05_03
  Scenario Outline: User cannot login with invalid username and password validating the error message
    Given User enters invalid username "<userName>"
    When user enters  invalid password "<password>"
    And User clicks signIn button
    Then Validate error message
    And click cancel button
    Examples:
      |userName|password|
      |aaataaa27|adkssla41 |
      |ist194578|istanbul7 |

  @tc05_04
  Scenario Outline: User with invalid credentials should be given an option to reset their password

    Given User enters invalid username "<userName>"
    When user enters  invalid password "<password>"
    And User clicks signIn button
    Then Validate error message
    And user click cancel button
    And user write invalid mail
    And user click submit button

    Examples:
      |userName|password|
      |aaataaa29|adkssla41 |
      |ist194578|istanbul7 |

  @tc05_05
  Scenario Outline: User should be given the option to navigate to registration page if they did not register yet
    Given User enters invalid username "<userName>"
    When user enters  invalid password "<password>"
    And User clicks signIn button
    And User click Register a new account
    Then User validate  navigate to registration page
    Examples:
      |userName|password|
      |ist194578|istanbul7 |
      |bezdum23|bezdum123 |