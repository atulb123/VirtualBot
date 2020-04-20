@Hooks
Feature: Create Ticket

  @TC023 @IT @CreateTicket @Automation
  Scenario: Verifying new ticket is created from EVA in ServiceNow [webchat] [Select options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'IT' option displayed in menu section
    And I Enter 'Create Ticket' as option
    And I should see 'description of your request' response sent from chatbot
    And I Enter description of the ticket
    And I should see 'Is it urgent' response sent from chatbot
    And I choose 'Yes' as option
    And I should see 'Describe why this is urgent' response sent from chatbot
    When I Enter input as 'test urgency' for the IT ticket
    Then Application should display Successful ticket creation message with created date and description
    
   @TC052 @IT @CreateTicket @Automation @Smoke
  Scenario: Create Ticket Dialog flow should be displayed when user gives input as "create ticket"
    Given I login to EVA Appication as "User Type 1"
    When I Enter input as 'create ticket'
    Then I should see a message stating 'provide a detailed description'
    
    