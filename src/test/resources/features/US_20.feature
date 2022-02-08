
Feature: Read all customers you created and validate them from your data set
         Read all customers you created and validate them 1 by 1

Background:
  Given create a customer with map and send to end point "https://www.gmibank.com/api/tp-customers"
  And   Retrive the CustomerId you created

  @TC_01
  Scenario: create a customer and checking the payload
    When   Retrive the All Customers
    Then   Verify the customer you created is in the payload

  @TC_02
  Scenario: create a costumer and validating all properties are matching
    When  get response and store response with JsonPath using endpoint"https://www.gmibank.com/api/tp-customers" with "custId" Pathparam
   Then validate the customers that created before

  @TC_03
  Scenario: UI API and Database validation with the customer created
    When  get response and store response with JsonPath using endpoint"https://www.gmibank.com/api/tp-customers" with "custId" Pathparam
    Then validate the customer with UI,API and Database perspective


