Feature: Search
  As a user of Google UK,
  I want to use the "I'm Feeling Lucky" button
  So that I can be redirected to the first search result immediately.

  @Smoke
  Scenario: Search for "BBC" and click "I'm Feeling Lucky"
    Given I am on the Google UK homepage
    When I type "BBC" into the search bar
    And I click on the "I'm Feeling Lucky" button
    Then I should be redirected to a URL containing "bbc"