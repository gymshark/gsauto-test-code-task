Feature: Search
  As a user
  I want to search the internet
  So that results appropriate to my interests are returned

  @Smoke
  Scenario Outline: Relevant search results are returned to the user
    Given I am on the Google UK homepage
    When I enter a "<search_term>"
    Then results relevant to the search term are returned
    Examples:
      | search_term |
      | BBC news    |
      | GymShark    |
      | QA process  |

  @Smoke
  Scenario: User is Navigated to the relevant URL
    Given I am on the Google UK homepage
    When entered a search term and clicked on I am Feeling Lucky
    Then navigated to the relavant URL to the search entered