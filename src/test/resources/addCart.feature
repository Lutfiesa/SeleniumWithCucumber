@addcart
Feature: AddCart

  Background:
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage

  @addChart
  Scenario: Add Item To Cart
    Given user is on homepage
    When user clicks "Add to cart" button for Item
    Then the button should change to "Remove"
    And cart count should increase by 1