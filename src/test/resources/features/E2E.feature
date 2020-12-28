Feature: Multi-Enviroment Validation

  @TC_01api
  Scenario: UI API and Database validation with the customer created
    Given create a customer with map and send to end point "https://www.gmibank.com/api/tp-customers"
    And   Retrive the CustomerId you created
    When  get response and store response with JsonPath using endpoint"https://www.gmibank.com/api/tp-customers" with "custId" Pathparam
    Then validate the customer with UI,API and Database perspective
    And get the print out the pdf documents

