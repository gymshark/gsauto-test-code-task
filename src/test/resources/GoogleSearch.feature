Feature: Search
  As a user
  I want to search the internet
  So that results appropriate to my interests are returned

  Scenario: Relevant search results are returned to the user
    Given I am on the Google UK homepage
    When I enter "BBC" search term
    Then results relevant to the search term are returned