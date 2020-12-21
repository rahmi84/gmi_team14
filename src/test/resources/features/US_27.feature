@US_027
Feature: US_27

  Scenario Outline: Create a state
    Given user sets the response using api end point "https://www.gmibank.com/api/tp-countries" and creates a state using "<idJson>" and "<nameJson>"
    Examples: create a state
      |idJson |nameJson|
      |name   |California|

  Scenario Outline: Delete a state
    Given user deletes a state using endpoint "<endPoint>" and its extension "<id>"
    Examples: delete a state
      |endPoint                                  |id    |
      |https://www.gmibank.com/api/tp-states/1803|/57080|