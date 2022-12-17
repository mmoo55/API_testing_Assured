Feature: Authentication

  Scenario: I want to get the token of authentication
    Given I had authentication to todo.ly
    When I send 'GET' request 'authentication/token.json'
    Then I will expect the response code 200
    And I will expect the 'UserEmail' is equal to my email