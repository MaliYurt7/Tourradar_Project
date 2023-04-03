@wip
Feature: Whistlist page

  Background:
    Given The user is on the main page

  Scenario Outline: TC-<No> User remove already saved all tours from wishlist

    When The user goes to "profile" module
    And The user clicks "Log In" btn as a "<AccountType>"
    And The user navigates to "Customer Log In - TourRadar" page
    And The user fills the login form with "<Email>" and "<Password>" and clicks "Log In" btn
    Then Validate that page title should be "10 Best Europe Tours & Trips 2023/2024 - TourRadar"
    Then Validate that the "<username>" should displayed in profile account
    Then The user clicks the "My Account" link
    Then Validate that the "<username>" and "<Email>" address should be displayed
    And The user clicks  the "<nth>" heart icon in Recomended Tours to save
    Then the user remove  already saved all tours from wishlist
    Examples:
      | No | AccountType | Email                        | Password  | username | nth   |
      | 1  | Traveller   | tourradar8587@mailinator.com | asdfghzxc | Mike     | 2     |
      | 2  | Traveller   | tourradar8587@mailinator.com | asdfghzxc | Mike     | 1;4   |
      | 3  | Traveller   | tourradar8587@mailinator.com | asdfghzxc | Mike     | 1;2;4 |