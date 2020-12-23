Feature: Read all customers you created and validate them from your data set
         Read all customers you created and validate them 1 by 1


@US_20api
  Scenario: create a country
    Given create a customer with map and send to end point "https://www.gmibank.com/api/tp-customers"
    And   Retrive the Customer with CustomerId you created
    When  get response and store response with JsonPath using endpoint"https://www.gmibank.com/api/tp-customers" with "custId" Pathparam
#    Then validate the customers that created before