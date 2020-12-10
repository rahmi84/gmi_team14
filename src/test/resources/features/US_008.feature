
  Feature: Password segment on Homepage should be editable

    Background:User sign-in with valid credential and navigate to the password page
      Given I am at the user password page
@TC_01
      Scenario: The old password should not be used
         When Click the current password box
        Then The current password box must be editable
        When Enter the current password "Team14_new_user"
        And Click the new password box
        Then The new password box must be editable
        And  Enter the one of the old password as new one "fgffjk"
        When Click the new password confirmation box
        Then The new password confirmation box must be editable
        And  Enter the one of the old password as new one "fgffjk"
        When Click the save button
        Then you should see the error message "An error has occured.The password could not be changed"

  @TC_02
  Scenario: The new password should be confirmed
    When Enter the current password "Team14_new_user"
    And Enter the new password "hkhklkl"
    And Enter the new password to the confirmation box "hkhklkl"
    And Click the save button
    Then you should see the valid message "Password changed"

    @TC_03
    Scenario: When I entered the new password with just lower-case chars between four and six and checking the password strength
      When I entered the new password with just lower-case chars between four and six
      Then password strength should be one bar

    @TC_04
    Scenario: When I entered the new password with just upper-case chars between four and six and checking the password strength
      When I entered the new password with just upper-case chars between four and six
      Then password strength should be one bar

    @TC_05
    Scenario: When I entered the new password with just digit chars between four and six and checking the password strength
      When I entered the new password with just digit chars between four and six
      Then password strength should be one bar

    @TC_06
    Scenario: When I entered the new password with just special character chars between four and six and checking the password strength
      When I entered the new password with just special character chars between four and six
      Then password strength should be one bar

    @TC_07
    Scenario: When I entered the new password with four type chars between four and six and checking the password strength
      When I entered the new password with four type chars between four and six
      Then password strength should be one bar

    @TC_08
    Scenario: When I entered the new password with just lower-case chars between seven and forty and checking the password strength
      When I entered the new password with just lower-case chars between seven and forty
      Then password strength should be two bar

    @TC_09
    Scenario: When I entered the new password with just upper-case chars between seven and forty and checking the password strength
      When I entered the new password with just upper-case chars between seven and forty
      Then password strength should be two bar

    @TC_10
    Scenario: When I entered the new password with just digit chars between seven and forty and checking the password strength
      When I entered the new password with just digit chars between seven and forty
      Then password strength should be two bar

    @TC_011
    Scenario: When I entered the new password with just special character chars between seven and forty and checking the password strength
      When I entered the new password with just special character chars between seven and forty
      Then password strength should be two bar



    @TC_12
    Scenario: When I entered the new password with two type of chars (lower-upper) between seven and forty and checking the password strength
      When I entered the new password with two type of chars (lower-upper) between seven and forty
      Then password strength should be three bar

    @TC_13
    Scenario: When I entered the new password with two type of chars (lower-special) between seven and forty and checking the password strength
      When I entered the new password with two type of chars  (lower-special) between seven and forty
      Then password strength should be three bar

    @TC_14
    Scenario: When I entered the new password with two type of chars  (lower-digit) between seven and forty and checking the password strength
      When I entered the new password with two type of chars  (lower-digit) between seven and forty
      Then password strength should be three bar

    @TC_15
    Scenario: When I entered the new password with two type of chars  (upper-special) between seven and forty and checking the password strength
      When I entered the new password with two type of chars (upper-special) between seven and forty
      Then password strength should be three bar

    @TC_16
    Scenario: When I entered the new password with two type of chars (upper-digit) between seven and forty and checking the password strength
      When I entered the new password with two type of chars (upper-digit) between seven and forty
      Then password strength should be three bar

    @TC_17
    Scenario: When I entered the new password with two type of chars (special-digit) between seven and forty and checking the password strength
      When I entered the new password with two type of chars (special-digit) between seven and forty
      Then password strength should be three bar

    @TC_18
    Scenario: When I entered the new password with three type of chars (lower-upper-special) between seven and forty and checking the password strength
      When I entered the new password with three type of chars (lower-upper-special) between seven and forty
      Then password strength should be four bar

    @TC_19
    Scenario: When I entered the new password with three type of chars (lower-upper-digit) between seven and forty and checking the password strength
      When I entered the new password with three type of chars (lower-upper-digit) between seven and forty
      Then password strength should be four bar

    @TC_20
    Scenario: When I entered the new password with three type of chars (digit-upper-special) between seven and forty and checking the password strength
      When I entered the new password with three type of chars (digit-upper-special) between seven and forty
      Then password strength should be four bar

    @TC_21
    Scenario: When I entered the new password with four type of chars (lower-upper-digit-special) between 7-40 and checking the password strength
      When I entered the new password with four type of chars (lower-upper-digit-special) between seven and forty
      Then password strength should be five bar


    @TC_18
    Scenario:The system should not accept the password with space
      When I used space in the new password
      And Click the new password confirmation box
      Then the password should not be accepted

    @TC_19
    Scenario:The password should not be empty
      When I left the new password empty
      And  Click the new password confirmation box
      Then I have to see error message "Your password is required."






