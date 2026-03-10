Feature: Products Page
  Background:
    Given user logged as "standard_user" and "secret_sauce"

  Scenario: Verify all products are displayed
    Then all products should be visible on the page


  Scenario Outline: Verify product titles
    Then user should see product "<productName>"
    Examples:
    |productName|
    | Sauce Labs Backpack   |
    | Sauce Labs Bike Light |