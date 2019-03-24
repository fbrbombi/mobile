Feature: Products

  Background:
    Given the user has set a location
    And the user is logged in
    And the user is in the main screen


  Scenario: The user wants to see a product per category from the homepage
    Given the user selects a category
    And   the user selects a subcategory
    When  the user wants to choose a product
    Then  The product is displayed

  Scenario: The user wants to add a product to the favourite list
    Given the user selects a product from the main page
    When  the user add the product to the favourite list
    Then  The product is displayed on the favourite list