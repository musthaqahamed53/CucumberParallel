Feature: Testing Login functionality for Ecommerce Website

  As a User of website
  I want to login with my account
  So that I can place and access orders and use the functionalities

  Background:
    Given User is on the E-Commerce website

  @ValidUser
  Scenario Outline: #Test Case 2: Login User with correct email and password
    Given User entering valid mail and password from "<SheetName>" in "<Reference>"
    When User click Login button
    Then User should be logged in successfully as a registered user

  Examples:
    | SheetName | Reference  |
    | LoginUser | Valid_User |

  @InvalidUser
  Scenario Outline: #Test Case 3: Login User with incorrect email and password
    Given User entering valid mail and password from "<SheetName>" in "<Reference>"
    When User click Login button
    Then User should see error message

    Examples:
      | SheetName | Reference    |
      | LoginUser | Invalid_User |

  @Logout
  Scenario Outline: #Test Case 4: Logout User
    Given User logs in using mail and password from "<SheetName>" in "<Reference>"
    When User click Logout button
    Then User should be navigated to SignUpOrLogin Page

    Examples:
      | SheetName | Reference  |
      | LoginUser | Valid_User |