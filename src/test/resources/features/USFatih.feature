@registration
Feature: As a user I should be able to register


  Scenario Outline: Register with valid credentials <username>
    Given User is on the "registration" page
    When User fill out input boxes with valid info credentials
      | ssn   | firstname   | lastname   | address   | mobilephone   | username   | email   | new password    | confirmation password |
      | <ssn> | <firstname> | <lastname> | <address> | <mobilephone> | <username> | <email> | <firstPassword> | <secondPassword>      |

    Examples: registration

      | ssn         | firstname | lastname   | address                             | mobilephone  | username     | email                  | firstPassword | secondPassword |
      | 123-76-8536 | Pele      | Nascimento | 12 1th street Manhattan, NY, 10001  | 123-762-8536 | TacsizKral   | tacsizKral@gmail.com   | Tacsiz123*    | Tacsiz123*     |
      | 456-45-1982 | Yilmaz    | Guney      | 06 65th street Ankara, NY, 06000    | 123-762-8536 | CirkinKral   | cirkinKral@gmail.com   | Cirkin123*    | Cirkin123*     |
      | 840-16-2836 | Dilber    | Ay         | 16 Bursa street Istanbul,Ist, 34100 | 123-762-8536 | ZorundaMiyim | ZorundaMiyim@gmail.com | Dilber123*    | Dilber123*     |


  Scenario Outline: Register with invalid credentials <username>
    Given User is on the "registration" page
    When User fill out input boxes with invalid info credentials
      | ssn   | firstname   | lastname   | address   | mobilephone   | username   | email   | new password    | confirmation password |
      | <ssn> | <firstname> | <lastname> | <address> | <mobilephone> | <username> | <email> | <firstPassword> | <secondPassword>      |

    And Verify "default" message is displayed

    Examples: registration

      | ssn         | firstname | lastname   | address                    | mobilephone  | username     | email                | firstPassword | secondPassword |
      | x33-33-5555 | wrongName | Nascimento | NY, 10001                  | 123-72-36    | TacsizKral   | tacsizKral@gmail.com | Tacsiz        | Tacsiz*        |
      | 456-45-1982 | Yilmaz    | lastNme    | 06 65 06000                | 972-v90-6768 | CirkinKral   | cirkinKral@gmail.com | 23*           | 123*           |
      | 840-16-2836 | Dilber    | bad        | Bursa street Istanbul,Ist, | 9736807889   | ZorundaMiyim | ZorundaMiyim@gmail   | dilber        | Dilber123*     |

  Scenario Outline: see error message when invalid credentials entered
    Given User is on the "registration" page
    When Invalid "<input>" entered to "<credentials>" box user see "<error message>" displayed
    Examples:
      | input       | credentials   | error message                       |
      | ssn         | x33-33-5555   | Your SSN is invalid                 |
      | ssn         | 456-4-1982    | Your SSN is invalid                 |
      | ssn         | 840162836     | Your SSN is invalid                 |
      | mobilephone | 972-v90-6768  | Your mobile phone number is invalid |
      | mobilephone | 972-666-68    | Your mobile phone number is invalid |
      | mobilephone | 9736807889    | Your mobile phone number is invalid |
      | email       | janny         | This field is invalid               |
      | email       | janny@gmail   | This field is invalid               |
      | email       | janny@gmail.  | This field is invalid               |
      | email       | jannygmail.co | This field is invalid               |
#      | email       | janny@gmail.co | This field is invalid               |






#      | input       | info                               |
#      | ssn         | 123-76-8536                        |
#      | firstname   | Pele                               |
#      | lastname    | Nascimento                         |
#      | address     | 12 1th street Manhattan, NY, 10001 |
#      | mobilephone | 123-762-8536                       |
#      | username    | Tacsiz Kral                        |
#      | email       | tacsizKral@gmail.com               |
#      | firstPassword  | 123-76-8536 |
#      | secondPassword | 123-76-8536 |
