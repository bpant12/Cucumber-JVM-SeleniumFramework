Feature: Smoke Tests
@Smoke
  Scenario: Login
    Given I access google search page
    When I search "ThoughtWorks"
    And I submit search
    Then I see link 1 as "ThoughtWorks: Agile Development and Experience Design1"