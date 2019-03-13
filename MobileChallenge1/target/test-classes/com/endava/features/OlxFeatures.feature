Feature: Login

  Scenario: Login with an email on OLX
    Given the user has an email
    When the user wants to login
    Then The service should verificate the email
