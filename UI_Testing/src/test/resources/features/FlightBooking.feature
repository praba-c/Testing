Feature: Validate The Functionalities of Flight Booking

  Scenario: Verify user can book a flight

    Given user opens the application
    Then verify home page is displayed
    When user clicks on flights tab
    And selects "fromCity", "destinationCity" and "date", "adultCount"
    And clicks on search button
    Then verify flights page is displayed
    When user select "flightName" from the filters tab
    Then verify flights are displayed based on the applied filter "flightName"
    When user selects a flight
    Then verify flight detail page is displayed
    And print the price details
    When user enters the "emailId"
    And fills the "title", "firstName", "lastName", "mobileNumber" and clicks on continue booking button
    Then verify payment page is displayed

