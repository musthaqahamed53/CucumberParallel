Feature: Testing SignUp functionality for Ecommerce Website

  As a User of website
  I want to create new account
  So that I can access the websites

  Background:
    Given User is on the E-Commerce website

  @CreateUser
  Scenario Outline: Test Case 1: Register User
    Given User enters name and email and clicks signup Button
    When User navigates to Create account page
    And User enters all the necessary details from "<SheetName>"
    Then User should be logged in newly created account

    Examples:
      | SheetName |
      | NewUser   |