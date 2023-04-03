@wip
Feature: Sort&Filter dropdown

  Background:
    Given The user is on the main page

  Scenario Outline: TC-<No> select one option from dropdown by "<value>"
    When The user clicks the Sort by filter dropdown
    And the user should able to see the following list
      | Total price: Lowest first      |
      | Total price: Highest first     |
      | Duration: Shortest first       |
      | Duration: Longest first        |
      | Reviews: Most reviewed         |
      | Biggest Deals: Highest savings |
      | Popularity: Most popular first |
      | Price/day: Lowest first        |
      | Price/day: Highest first       |
    And The user selects one option from dropdown by "<value>" standing for "<abbreviation of value>"
    Examples:
      | No | value      | abbreviation of value          |
      | 1  | prasc      | Total price: Lowest first      |
      | 2  | prdesc     | Total price: Highest first     |
      | 3  | lenasc     | Duration: Shortest first       |
      | 4  | lendesc    | Duration: Longest first        |
      | 5  | rec        | Reviews: Most reviewed         |
      | 6  | deals      | Biggest Deals: Highest savings |
      | 7  | popularity | Popularity: Most popular first |
      | 8  | ppdasc     | Price/day: Lowest first        |
      | 9  | ppddesc    | Price/day: Highest first       |

