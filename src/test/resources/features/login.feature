@wip
Feature: login page

  Background:
    Given The user is on the main page

  Scenario Outline: TC-<No> login successfully as an already registered user account
    When The user goes to "profile" module
    And The user clicks "Log In" btn as a "<AccountType>"
    And The user navigates to "Customer Log In - TourRadar" page
    And The user fills the login form with "<Email>" and "<Password>" and clicks "Log In" btn
    Then Validate that page title should be "10 Best Europe Tours & Trips 2023/2024 - TourRadar"
    Then Validate that the "<username>" should displayed in profile account
    Then The user clicks the "My Account" link
    Then Validate that the "<username>" and "<Email>" address should be displayed
    Examples:
      | No | AccountType | Email                        | Password  | username |
      | 1  | Traveller   | tourradar8587@mailinator.com | asdfghzxc | Mike     |


  Scenario Outline: TC-<No> login with wrong credentials
    When The user goes to "profile" module
    And The user clicks "Log In" btn as a "<AccountType>"
    And The user navigates to "Customer Log In - TourRadar" page
    And The user fills the login form with "<Email>" and "<Password>" and clicks "Log In" btn
    Then Validate that "Wrong login data." message should be showed up
    Examples:
      | No | AccountType | Email                    | Password  | username |
      | 2  | Traveller   | tourradar@mailinator.com | asdfghzxc | Jake     |

  Scenario Outline: TC-<No> login Out successfully as an already registered user account
    When The user goes to "profile" module
    And The user clicks "Log In" btn as a "<AccountType>"
    And The user navigates to "Customer Log In - TourRadar" page
    And The user fills the login form with "<Email>" and "<Password>" and clicks "Log In" btn
    Then Validate that page title should be "10 Best Europe Tours & Trips 2023/2024 - TourRadar"
    Then Validate that the "<username>" should displayed in profile account
    Then The user clicks the "My Account" link
    Then Validate that the "<username>" and "<Email>" address should be displayed
    Then The user clicks the "My Account" link
    Then The user clicks the "Logout" link
    Then Validate that page title should be "TourRadar - Book Tours & Travel Packages"
    Examples:
      | No | AccountType | Email                        | Password  | username |
      | 3  | Traveller   | tourradar8587@mailinator.com | asdfghzxc | Mike     |
