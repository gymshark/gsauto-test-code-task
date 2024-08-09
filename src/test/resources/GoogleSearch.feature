Feature: Search
  As a user
  I want to search the internet
  So that results appropriate to my interests are returned

@SmokeTest
  Scenario: Relevant search results are returned to the user
    Given I am on the Google UK homepage
    When I enter a search term eg 'BBC'
    Then results relevant to the search term are returned

@SmokeTest
    Scenario: Selecting I'm Feeling Luck reflects in the url
      Given I am on the Google UK homepage
      When I click on I'm Feeling Lucky
      Then the url will reflect the search term