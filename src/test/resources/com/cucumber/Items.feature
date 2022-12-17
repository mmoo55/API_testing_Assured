Feature: Item

  Scenario: I want to create an item
    Given I had authentication to todo.ly
    When I send 'POST' request 'items.json' and the name of item is 'BootcampItem'
    Then I will expect the response code 200

  Scenario: I want to get an item by its' id
    Given I had authentication to todo.ly
    When I send 'GET' request 'items/11093072.json'
    Then I will expect the response code 200
    And I will expect the 'Id' is equal to 11093072

  Scenario: I want to update an item by its' id
    Given I had authentication to todo.ly
    When I send 'POST' request 'items/11093072.json' and the name of item is 'BootcampItemUpdated'
    Then I will expect the response code 200

  Scenario: I want to delete an item by its' id
    Given I had authentication to todo.ly
    When I send 'DELETE' request 'items/11093072.json' and the name of item is 'BootcampItemUpdated'
    Then I will expect the response code 200
    And I will expect the item was deleted is equal 'true'
