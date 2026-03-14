Feature: ApiDemos Navigation

  @Smoke
  Scenario: Verify user can navigate to Buttons screen under Views
    Given the app is launched and user is on the main menu
    When the user clicks on the "Views" option
    And the user clicks on the "Buttons" option
    Then the "Normal" button should be visible on the screen