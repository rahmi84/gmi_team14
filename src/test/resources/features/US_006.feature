@US06
Feature: User info segment (User Settings) should be editable on Homepage
  Background:User sign-in with valid credential and navigate to the user info page
    Given I am at the user info page
  @TCUs06-1
  Scenario: There should be user info "firstname, lastname, email and language" on the page
    When Click the current firstname box
    And Check firstname box that must be filled
    And Get the firstname from firstname box
    When Click the current lastname box
    And Check lastname box that must be filled
    And Get the lastname from lastname box
    When Click the current email box
    And Check email box that must be filled
    And Get the email from email box
    When Click the current language box
    And Check language box that must be show English or Turkish
    And Get the current language from language box

  @TCUs06-2
  Scenario:There should be 2 languages available "English and Turkish"
    When Click the language dropdown menu
    And Get the languages
    And Check if there is another language
    Then Verify the languages which is in dropdown menu

  @TCUs06-3
  Scenario:There should be an option to update firstname
    When Click on firstname box on userinfo page
    And Check if firstname is editable
    And Send valid firstname
    And Click on save button
    Then Verify the firstname changed

  @TCUs06-4
  Scenario:There should be an option to update lastname
    When Click on lastname box on userinfo page
    And Check if lastname is editable
    And Send valid lastname
    And Click on save button
    Then Verify the lastname changed

  @TCUs06-5
  Scenario: There should be an option to update email id adding "@" sign and ".com" extension
    When Click on email box on userinfo page
    And Check if email is editable
    And Send valid email which include "@" and ".com"
    And Click on save button
    Then Verify the email changed

