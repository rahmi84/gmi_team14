
@US_04Smoke
Feature:US_04 Login page should accessible with valid credentials

  Background:User go to login page
    Given User go to  home page "http://www.gmibank.com/"  page
    And  User Should click on Loginmenu
    And ThenUser click  sign in

  @TC_0401
  Scenario:Success login
  Given User send text usernamebox
  When User send text passwordbox
  And User click sign in button
  Then User validates name on page
    And click Sign out menu

  @TC_0402
  Scenario:Option cancel button
  Then There should be an option to cancel button
