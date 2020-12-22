@US_23
Feature:System should allow to read all Applicants using api end point

  Background: US_023 background
    Given Use API end point for applicants "https://www.gmibank.com/api/tp-account-registrations"
    And get all applicants' information as Deserialization
  @TCUs23-1
  Scenario: Read all applicants you created and validate them from your data set
    And find out how many applicants are here and verify it
    And create a new country
    And get all the information of the fifth applicant
    And verify fifth applicant's ssn is "123-45-2345" and address is "Gallows road 8765"
  @TCUs23-2
  Scenario: Read all customers you created and validate them 1 by 1
    And verify first customer's firstName "example" (us23)
    And verify second customer's lastName "firstuser" (us23)
    And verify third customer's phoneNumber "345-344-4357" (us23)
    And verify last customer's user email "jovita.green@hotmail.com" (us23)
