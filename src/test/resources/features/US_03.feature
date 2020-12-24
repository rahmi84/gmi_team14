@US_03
Feature: US_03

    Scenario Outline:US_03 Registration page should restrict password usage to a secure and high level password
    Given user at the home page
    And user clicks menu
    And user at the registration page and clicks ssn box and sends the ssnnumber "<ssnNumber>"
    And user clicks firstName box and sends the firstname "<firstName>"
    And user clicks lastName box and sends the  lastName "<lastName>"
    And user clicks address box and sends the  address "<address>"
    And user clicks phoneNumber box and sends the phoneNumber "<phoneNumber>"
    And user clicks userName box and sends the  userName "<userName>"
    And user clicks email box and sends the  email "<email>"
    And user clicks the password box and sends the  password "<password>"
    And user clicks the password box and sends the secondPassword "<secondPassword>"
    Then user clicks the RegisterButton
      Examples:
        | ssnNumber   | firstName | lastName   | address                          | phoneNumber  | userName     | email                | password         | secondPassword  |
        | 885-58-4578 | Deniz     | Ocean      | 350 Edgewood Dr.Oxford, MS 38655 | 365-485-2578 | DenizOcean   | DenizOcean@gmail.com | password*        | password*       |
        | 515-58-4887 | Deniz     | Ocean      | 350 Edgewood Dr.Oxford, MS 38655 | 365-485-2578 | DenizOcean   | DenizOcean@gmail.com |password1a*       | password1a*     |
        | 856-78-4587 | Deniz     | Ocean      | 350 Edgewood Dr.Oxford, MS 38655 | 365-485-2578 | DenizOcean   | DenizOcean@gmail.com | 00000000*        | 00000000*       |
        | 7124-58-4587 | Deniz     | Ocean      | 350 Edgewood Dr.Oxford, MS 38655 | 365-485-2578 | DenizOcean   | DenizOcean@gmail.com | Password1a*      | Password1a*     |
        | 365-58-4587 | Deniz     | Ocean      | 350 Edgewood Dr.Oxford, MS 38655 | 365-485-2578 | DenizOcean   | DenizOcean@gmail.com | F@rd1co          | F@rd1co         |
        | 951-58-4587 | Deniz     | Ocean      | 350 Edgewood Dr.Oxford, MS 38655 | 365-485-2578 | DenizOcean   | DenizOcean@gmail.com | HelloWorld@001!  | HelloWorld@001! |
        | 158-54-4587 | Deniz     | Ocean      | 350 Edgewood Dr.Oxford, MS 38655 | 365-485-2578 | DenizOcean   | DenizOcean@gmail.com | myDream1@$$      | myDream1@$$     |
        | 785-58-4597 | Deniz     | Ocean      | 350 Edgewood Dr.Oxford, MS 38655 | 365-485-2578 | DenizOcean   | DenizOcean@gmail.com | !@#$%^&*Aa1      |!@#$%^&*Aa1      |
        | 635-58-4587 | Deniz     | Ocean      | 350 Edgewood Dr.Oxford, MS 38655 | 365-485-2578 | DenizOcean   | DenizOcean@gmail.com | P@ssword01       | P@ssword01      |
        | 693-58-4587 | Deniz     | Ocean      | 350 Edgewood Dr.Oxford, MS 38655 | 365-485-2578 | DenizOcean   | DenizOcean@gmail.com | Suzuki@lpha2016  | Suzuki@lpha2016 |


