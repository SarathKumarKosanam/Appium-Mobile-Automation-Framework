Feature: App Search Functionality

  @Regression @Negative
  Scenario: Verify framework handles missing search history element
    Given the app is launched and user is on the main menu
    When the user navigates to "App" then "Search"
    And the user attempts to click on "Clear History" button
    Then the "History Cleared" message should be visible