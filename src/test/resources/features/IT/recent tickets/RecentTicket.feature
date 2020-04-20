@Hooks
Feature: Recent Ticket

  @TC024 @IT @RecentTicket @Automation
  Scenario: Verifying only FIVE recent tickets are getting displayed when recent tickets option is chosen
    Given I login to EVA Appication as "User Type 1"
    And I choose 'IT' option displayed in menu section
    When I choose 'Recent Ticket' option displayed in menu section
    Then Application should display recent tickets with all the details
    
  @TC025 @IT @RecentTicket @Automation @Smoke
  Scenario: Verifying only FIVE recent tickets are getting displayed when recent tickets option is chosen [Enter options as input]
    Given I login to EVA Appication as "User Type 1"
    When I Enter input as 'Recent Ticket'
    Then Application should display recent tickets with all the details