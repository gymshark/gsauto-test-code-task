Feature: Search
  As a user
  I want to lucky search the google
  So that results show based on this click

  @Smoke
  Scenario: Clicking lucky search to obtain results
    Given  I am on the Google UK
    When I enter "BBC" in lucky search term
    Then results to the lucky click are returned