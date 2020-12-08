
  Feature: Password segment on Homepage should be editable

    Background:User sign-in with valid credential and navigate to the password page
      Given I am at the user password page
@TC_01
      Scenario: The old password should not be used
         When Click the current password box
        Then The current password box must be editable
        When Enter the current password
        And Click the new password box
        Then The new password box must be editable
        And  Enter the one of the old password as new one
        When Click the new password confirmation box
        Then The new password box must be editable
        And  Enter the same old password you just entered
        When Click the save button
        Then you should see the error message "An error has occured.The password could not be changed"

  @TC_02
  Scenario: The new password should be confirmed
    When Enter the current password
    And Enter the new password
    And Enter the new password to the confirmation box
    And Click the save button
    Then you should see the valid message "Password changed"

    @TC_03
    Scenario: When I entered the new password with just lower-case chars between four and forty and checking the password strength
      When I entered the new password with just lower-case chars between four and forty
      Then password strength should be one bar

    @TC_04
    Scenario: When I entered the new password with just upper-case chars between four and forty and checking the password strength
      When I entered the new password with just upper-case chars between four and forty
      Then password strength should be one bar

    @TC_05
    Scenario: When I entered the new password with just digit chars between four and forty and checking the password strength
      When I entered the new password with just digit chars between four and forty
      Then password strength should be one bar

    @TC_06
    Scenario: When I entered the new password with just special character chars between four and forty and checking the password strength
      When I entered the new password with just special character chars between four and forty
      Then password strength should be one bar

    @TC_07
    Scenario: When I entered the new password with 4 type chars between four and six and checking the password strength
      When I entered the new password with 4 type chars between four and six
      Then password strength should be one bar

    @TC_08
    Scenario: When I entered the new password with 2 type of chars (lower-upper) between seven and forty and checking the password strength
      When I entered the new password with 2 type of chars (lower-upper) between seven and forty
      Then password strength should be three bar

    @TC_09
    Scenario: When I entered the new password with 2 type of chars (lower-special) between seven and forty and checking the password strength
      When I entered the new password with 2 type of chars  (lower-special) between seven and forty
      Then password strength should be three bar

    @TC_10
    Scenario: When I entered the new password with 2 type of chars  (lower-digit) between seven and forty and checking the password strength
      When I entered the new password with 2 type of chars  (lower-digit) between seven and forty
      Then password strength should be three bar

    @TC_11
    Scenario: When I entered the new password with 2 type of chars  (upper-special) between seven and forty and checking the password strength
      When I entered the new password with 2 type of chars (upper-special) between seven and forty
      Then password strength should be three bar

    @TC_12
    Scenario: When I entered the new password with 2 type of chars (upper-digit) between seven and forty and checking the password strength
      When I entered the new password with 2 type of chars (upper-digit) between seven and forty
      Then password strength should be three bar

    @TC_13
    Scenario: When I entered the new password with 2 type of chars (special-digit) between seven and forty and checking the password strength
      When I entered the new password with 2 type of chars (special-digit) between seven and forty
      Then password strength should be three bar

    @TC_14
    Scenario: When I entered the new password with 3 type of chars (lower-upper-special) between seven and forty and checking the password strength
      When I entered the new password with 3 type of chars (lower-upper-special) between seven and forty
      Then password strength should be four bar

    @TC_15
    Scenario: When I entered the new password with 3 type of chars (lower-upper-digit) between seven and forty and checking the password strength
      When I entered the new password with 3 type of chars (lower-upper-digit) between seven and forty
      Then password strength should be four bar

    @TC_16
    Scenario: When I entered the new password with 3 type of chars (digit-upper-special) between seven and forty and checking the password strength
      When I entered the new password with 3 type of chars (digit-upper-special) between seven and forty
      Then password strength should be four bar

    @TC_17
    Scenario: When I entered the new password with 4 type of chars (lower-upper-digit-special) between 7-40 and checking the password strength
      When I entered the new password w ith 4 type of chars (lower-upper-digit-special) between seven and forty
      Then password strength should be five bar


    @TC_18
    Scenario:The system should not accept the password with space
      When I used space in the new password
      Then the password should not be accepted

    @TC_19
    Scenario:
      When I left the new password empty
      And  Click new confirmation box
      Then I have to see error message "Your password is required"






