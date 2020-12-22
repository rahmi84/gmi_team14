@us18
Feature: System should allow Admin to manage a customer

 Scenario: US_018 customer account information populations
    Given admin should go to homepage and signIn Customer Account
   And admin clicks My Operations
   And admin clicks My Accounts

  @US18_TC01
  Scenario:admin should see all customer account information
    Then Verify admin can see all  populating the account information of the customer"First Name" " Last Name"  "Middle Initial" " Email"  "Mobile Phone Number"  "Phone Number"  "Address" " Create Date "

  @US18_TC02
  Scenario:-There should be a View option where customer can be navigated to all customer info and see
edit button there
    When Click the language view menu
    And See all customer info on that page
    Then Verify edit button there

  @US18_TC03
  Scenario:There should be an Edit button where all customer information can be populated
    When Click  edit button
    And See all customer info populated



  @US18_TC04
  Scenario:The Edit portal can allow user to create or update the user info
    When Click  edit button
    And See all customer info populated


  @US18_TC05
  Scenario:User can delete a customer, but seeing a message if the user is sure about deletion
    When Click  delete button
    And click delete on confirmation box
  Then verify customer is deleted

##  1-All customers should show up on manage customers module populating the account information of the customer
##  "First Name  Last Name  Middle Initial  Email  Mobile Phone Number  Phone Number  Address  Create Date "
#  2-There should be a View option where customer can be navigated to all customer info and see
#edit button there
#  3-There should be an Edit button where all customer information can be populated
#  4-The Edit portal can allow user to create or update the user info
#  5-User can delete a customer, but seeing a message if the user is sure about deletion