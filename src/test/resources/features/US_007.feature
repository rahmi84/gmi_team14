@US07
Feature: System should not allow to make updates with invalid credentials

  Background:User sign-in with valid credential and navigate to the user info page
    Given I am at the user info page
  @TCUs07-1
  Scenario Outline: Email id cannot contain just digits or chars without "@" sign or ".com" extension
    When Click the current email box
    And Delete "<Current email>"
    And Send key "<New email>"
    And Click save button to see error message
    Then Verify the error message
    Examples:
      | Current email | New email |
      | abc@gmail.com | !!@gmail.com  |
      | abc@gmail.com | a@l.com  |
      | abc@gmail.com | a@l.com  |
      | abc@gmail.com | .@5.com  |
      | abc@gmail.com | b@a.c  |
      | abc@gmail.com | b@a.5  |
      | abc@gmail.com | b@a.!  |
  @TCUs07-2
  Scenario:There should not be an option of any other language other than English or Turkish
    When Click the language box
    And Select from dropdown menu Turkish and English options
    And Check if it is another option
    Then Verify  languages which is in dropdown menu

  @TCUs07-3
  Scenario Outline: Firstname should not be update with invalid credentials
    When Click on firstname box
    And Send invalid firstname for "<First name>"
    When Click on lastname box
    And Send invalid lastname for "<Last name>"
    And click save botton to see error message
    Then Verify the error message for lastname and firstname
    Examples:
      | First name | Last name |
      | 123        |123    |
      | a          |a      |
      | @!**       | @!**  |
      | null       | null  |

