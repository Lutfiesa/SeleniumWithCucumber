@login
Feature: Login

  @valid-login
  Scenario: Login with valid Username and Password
    Given user is on login page
    When user input username with "standard_user"
    And user input password with "secret_sauce"
    And user click login button
    Then user is on homepage

  @invalid-login
  Scenario: Login with invalid Username and Password
    Given user is on login page
    When user input username with "standard"
    And user input password with "sauce"
    And user click login button
    Then user able to see error message "Epic sadface: Username and password do not match any user in this service"

  @emptypassword-login
  Scenario: Login with empty Password
    Given user is on login page
    When user input username with "standard_user"
    And user input password with ""
    And user click login button
    Then user able to see error message "Epic sadface: Password is required"

  @emptyusername-login
  Scenario: Login with empty Username
    Given user is on login page
    When user input username with ""
    And user input password with "secret_sauce"
    And user click login button
    Then user able to see error message "Epic sadface: Username is required"