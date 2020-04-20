@Hooks
Feature: KB Search

  @TC021 @IT @KBSearch @Automation
  Scenario: Verifying Same Search Results are displayed as that of ServiceNow when searched from EVA
    Given I login to EVA Appication as "User Type 1"
    And I choose 'IT' option displayed in menu section
    And I choose 'Knowledge Base Search' option displayed in menu section
    And I should see 'what is your search text?' response sent from chatbot
    When I Enter input as 'get list of tickets opne'
    Then I should see same search results displayed as that of service now
    
  @TC022 @IT @KBSearch @Automation
  Scenario: Verifying "No Article Found" message is displayed when invalid search input is given in EVA
    Given I login to EVA Appication as "User Type 1"
    And I choose 'IT' option displayed in menu section
    And I choose 'Knowledge Base Search' option displayed in menu section
    And I should see 'what is your search text?' response sent from chatbot
    When I Enter input as 'test@123' for the IT ticket
    Then I should see a message 'no knowledge base article found' displayed in the application 
    
     @TC057 @IT @KBSearch @Automation @Smoke
  Scenario: Verifying Same Search Results are displayed as that of ServiceNow when searched directly
    Given I login to EVA Appication as "User Type 1"
    And I Enter input as 'KB Search'
    And I should see 'what is your search text?' response sent from chatbot
    When I Enter input as 'reset password'
    Then I should see same search results displayed as that of service now
    