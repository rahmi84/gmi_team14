@US_23
Feature: GMI Bank All Users info
  Scenario: Read all applicants  and validate them
    Given  user read all Applicants using api end point "https://www.gmibank.com/api/tp-account-registrations"
    And  user deserialization applicant data json to java pojo
    Then user validates all data

