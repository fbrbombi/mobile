Feature: Publish a product

  Background:
    Given the user has set a location
    And the user is logged in
    And the user has a picture of the product
    And the user is in the main screen

  Scenario: Publish a product
    Given the user is in sell-product's steps
    When the user wants to publish a product
    Then A new product is published