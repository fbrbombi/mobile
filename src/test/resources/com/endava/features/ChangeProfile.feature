Feature: Change Profile

  Background:
    Given the user has set a location

  Scenario: Change profile info
    Given the user is logged in with long password
    And the user is in the main screen
    When the user wants to change the profile info
    Then The service should change the info

  Scenario: Change profile info with short password
    Given the user is logged in with short password
    And the user is in the main screen
    When the user wants to change the profile info
    Then The service should change the info
