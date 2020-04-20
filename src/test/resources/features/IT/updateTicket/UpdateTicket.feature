@Hooks
Feature: Update Ticket

  @TC026 @IT @UpdateTicket @Automation
  Scenario: Verifying tickets are updated from EVA using Recent Ticket feature [webchat] [Select options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'IT' option displayed in menu section
    And I choose 'Recent Ticket' option displayed in menu section
    And I choose to provide comment for the first ticket displayed
    And I should see 'Please enter your comment' response sent from chatbot
    When I Enter input as 'test comment' for the IT ticket
    And I should see 'Thank you for your comments regarding' response sent from chatbot
    Then I should see Corresponding Ticket should get updated as per the comments provided
    
  @TC027 @IT @UpdateTicket @Automation
  Scenario: Verifying tickets are updated from EVA using Recent Ticket feature  [webchat] [Enter options as input]
    Given I login to EVA Appication as "User Type 1"
    And I Enter 'IT' as input
    And I Enter 'Recent Ticket' as input
    And I choose to provide comment for the first ticket displayed
    And I should see 'Please enter your comment' response sent from chatbot
    When I Enter input as 'test comment' for the IT ticket
    And I should see 'Thank you for your comments regarding' response sent from chatbot
    Then I should see Corresponding Ticket should get updated as per the comments provided
    
  @TC030 @IT @UpdateTicket @Automation
  Scenario: Verifying tickets are updated from EVA using Update Ticket feature [webchat] [Select options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'IT' option displayed in menu section
    And I choose 'Recent Ticket' option displayed in menu section
    And I get the ticketnumber of the recent ticket from servicenow
    And I choose 'Update Ticket' option displayed in menu section
    And I should see 'Please provide your request' response sent from chatbot
    And I Enter the ticket number
    And I choose to provide comment for the ticket displayed
    And I should see 'Please enter your comment' response sent from chatbot
    When I Enter input as 'test comment' for the IT ticket
    And I should see 'Thank you for your comments regarding' response sent from chatbot
    Then I should see Corresponding Ticket should get updated as per the comments provided
    
  @TC031 @IT @UpdateTicket @Automation
  Scenario: Verifying tickets are updated from EVA using Update Ticket feature [webchat] [Enter options as input]
    Given I login to EVA Appication as "User Type 1"
    And I Enter 'IT' as input
    And I Enter 'Recent Ticket' as input
    And I get the ticketnumber of the recent ticket from servicenow
    And I Enter Update Ticket along with ticket number as input
    And I choose to provide comment for the ticket displayed
    And I should see 'Please enter your comment' response sent from chatbot
    When I Enter input as 'test comment' for the IT ticket
    And I should see 'Thank you for your comments regarding' response sent from chatbot
    Then I should see Corresponding Ticket should get updated as per the comments provided
    
  @TC032 @IT @UpdateTicket @Automation
  Scenario: Verifying invalid ticket number message is displayed
    Given I login to EVA Appication as "User Type 1"
    And I choose 'IT' option displayed in menu section
    And I choose 'Update Ticket' option displayed in menu section
    And I should see 'Please provide your request' response sent from chatbot
    When I Enter input as 'INC000000'
    Then I should see a message stating 'I was not able to find that request'