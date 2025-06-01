@checkout
Feature: checkout

  Background:
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage
    And user clicks "Add to cart" button for Item

  @checkout-start
  Scenario: User proceeds to checkout
    Given user is on the cart page
    And user clicks the Checkout button
    Then user should be on the checkout information page
    And user enters first name "Lutfi"
    And user enters last name "Esa"
    And user enters postal code "10130"
    When user clicks the Continue button
    Then user should be on the checkout overview page
    And user clicks the Finish button
    Then user should see a confirmation message "Thank you for your order!"

  @checkout-info-invalid-firstname
  Scenario: User fills firstname blank in checkout information
    Given user is on the cart page
    When user clicks the Checkout button
    Then user should be on the checkout information page
    And user enters first name ""
    And user enters last name "Esa"
    And user enters postal code "10130"
    When user clicks the Continue button
    Then user should see a error message "Error: First Name is required"

  @checkout-info-invalid-lastname
  Scenario: User fills lastname blank in checkout information
    Given user is on the cart page
    When user clicks the Checkout button
    And user should be on the checkout information page
    And user enters first name "Lutfi"
    And user enters last name ""
    And user enters postal code "10130"
    And user clicks the Continue button
    Then user should see a error message "Error: Last Name is required"

  @checkout-info-invalid-zipcode
  Scenario: User fills zipcode blank in checkout information
    Given user is on the cart page
    When user clicks the Checkout button
    And user should be on the checkout information page
    And user enters first name "Lutfi"
    And user enters last name "Esa"
    And user enters postal code ""
    And user clicks the Continue button
    Then user should see a error message "Error: Postal Code is required"
