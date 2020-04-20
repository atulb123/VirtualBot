@Hooks
Feature: Resolve Ticket

  @TC028 @IT @ResolveTicket @Automation
  Scenario: Verifying tickets are resolved from EVA using Resolve Ticket feature [webchat] [Enter options as input]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'IT' option displayed in menu section
    And I choose 'Resolve Ticket' option displayed in menu section
    And I choose to resolve ticket for the last ticket displayed
    And I should see 'Kindly provide a reason' response sent from chatbot
    When I Enter input as 'ticket has been resolved' for the IT ticket
    And I should see 'Thank you. Your request' response sent from chatbot
    Then I should see Corresponding Ticket is resolved and same is updated in servicenow
    
  @TC029 @IT @ResolveTicket @Automation @Smoke
  Scenario: Verifying tickets are resolved from EVA using Resolve Ticket feature [webchat] [Enter options as input]
    Given I login to EVA Appication as "User Type 1"
    And I Enter input as 'Resolve Ticket'
    And I choose to resolve ticket for the last ticket displayed
    And I should see 'Kindly provide a reason' response sent from chatbot
    When I Enter input as 'ticket has been resolved' for the IT ticket
    And I should see 'Thank you. Your request' response sent from chatbot
    Then I should see Corresponding Ticket is resolved and same is updated in servicenow