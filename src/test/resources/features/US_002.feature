@us11
Feature: US1 Any field on the registration page should not be left blank
  Background: All custumer registration tests common links
    Given user is on home page

  Scenario:  Registration page
    And user click on User button
    And user clicks Registration tab

  Scenario:  SSN Text Box Test
    And click on SSN TextBox
    Then user enters a invalid SSN number "<SSNnumber>"

  Scenario:  First Name TextBox Test
    And click on First Name TextBox
    Then user enters a invalid First Name "<First Name>"

  Scenario:  Last Name TextBox Test
    And click on Last Name TextBox
    Then user enters a invalid Last Name "<Last Name>"

  Scenario:  Address TextBox Test
    And click on Address TextBox
    Then user enters invalid Address "<Address>"

  Scenario:  Mobile Phone Number TextBox Test
    And click on Mobile Phone Number TextBox
    Then user enters a invalid Mobil Phone Number "<Mobile Phone Number>"

  Scenario:  Username TextBox Test
    And click on Username TextBox
    Then user enters invalid username "<Username>"

  Scenario:  Email TextBox Test
    And click on Email TextBox
    Then user enters invalid Email "<Email>"

  Scenario:  New password TextBox Test
    And click on New password TextBox
    Then user enters invalid New password "<New password>"

  Scenario:  Password strength level must be strong test
    And Password strength level must be strong

  Scenario:  New password confirmation TextBox Test
    And click on New password confirmation TextBox
    Then user enters invalid New password confirmation "<New password confirmation>"

  Scenario:  New password confirmation TextBox Test
    Then user clicks the Register button

  Scenario:  user must enter valid data into SSN TextBox using "-" character.
    And new click on SSN TextBox
    And the user must type the character "<Tire>" - when entering a number into the current SSN TextBox.
    Then ssn the user should not see the text "Your SSN is invalid"

  Scenario:  user must enter valid data in Mobile Phone Number TextBox using "-" character.
    And new click on Mobile Phone Number TexttBox
    And user must type the"<Tire>" character - when entering a number into the valid Mobile Phone Number TextBox
    Then mobil the user should not see the text "Your mobile phone number is invalid".

  Scenario:  user must enter valid data in Email TextBox using "@" character and ".com" expression
    And new click on Email TextBox
    And the user is entering a valid Email TextBox Email Must use"<email charecter>" @  character and .com expression in TextBox
    Then email the user should not see the text "This field is invalid".

