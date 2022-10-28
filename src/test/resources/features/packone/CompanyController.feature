Feature: BFF - Company Controller - CRUD Tests
  This feature includes tests that test the user RESTFul services

  @smokeTest @sanity
  Scenario: Create a valid user
    Given a valid user with the following details
      | firstName | lastName | type  |
      | dummy     | dummy    | dummy |
    When I make a POS call to create the user
    Then the response is successful

    


