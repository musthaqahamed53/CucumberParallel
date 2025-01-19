Feature: Testing Login functionality for Ecommerce Website

  As a User of website
  I want to login with my account
  So that I can place and access orders and use the functionalities

  Background:
    Given I am on the Ecomm website

  Scenario: Login with Valid credentials
    Given I am entering valid mail and password
    When I click Login button
    Then I should be logged in successfully as a registered user

