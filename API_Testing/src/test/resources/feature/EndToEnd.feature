Feature: Validate complete CRUD functionalities

  Scenario: Verify post call

    Given user calls the endpoint "endpoint"
    When user sets header "Content-Type" to "application/json"
    And set request body from file "createData.json"
    Then user performs post method
    Then verify status code is 201
    Then verify response body has a field "id"
    Then store the id "id" in variable "createdID"

  Scenario: Verify get call

    Given user calls the endpoint "/endpoint"
    And retrieve the created data with id "createdID"
    When user sets header "Content-Type" to "application/json"
    Then user performs get method
    Then verify status code is 200

  Scenario: Verify put call

    Given user calls the endpoint "/api/id/"
    And retrieve the created data with id "createdID"
    When user sets header "Content-Type" to "application/json"
    Then set request body from file "updateData.json"
    Then user performs put method
    Then verify status code is 200

  Scenario: Verify delete call

    Given user calls the endpoint "/api/id/"
    And retrieve the created data with id "createdID"
    When user sets header "Content-Type" to "application/json"
    Then user performs delete method
    Then verify status code is 200
