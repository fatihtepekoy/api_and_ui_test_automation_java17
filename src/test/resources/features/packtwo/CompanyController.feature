Feature: Company Management - CRUD Tests
  This feature includes tests that test the user RESTFul services

  @smokeTest @sanity
  Scenario: Create a valid company
    Given a valid company with the following details
      | name  | firstName | lastName | industryCode |
      | dummy | dummy     | dummy    | 990          |
    When I make a POS call to create the company
    Then the response is successful


