Feature: Validate login functionalities

  Scenario Outline: Verify login scenarios

    Given user opens the application
    Then verify home page is displayed
    When user clicks on login button
    And selects customer login button
    Then verify popup asking for mobile number is displayed
    When user enters "<mobileNumber>"
    And click on continue button
    Then verify otp is generated

    Examples:
    |mobileNumber|
    |6382190286  |
    |1234        |
    |000234      |
    |8903440458  |