@Hooks
Feature: Negative Feedback

  @TC003 @Negativefeedback @Product @Automation
  Scenario: Verifying helpline number is displayed when negative input is given in PRODUCT flow
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Dosage' option displayed in menu section
    And I should see 'For which product do you need information' response sent from chatbot
    When I Enter input as 'you are dumb'
    Then I should see helpline number containing '293-1471' displayed
    And I should see chat continues
    
  @TC004 @Negativefeedback @Parts @Automation
  Scenario: Verifying helpline number is displayed when negative input is given in Parts & Equipment flow
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Parts and Equipment' option displayed in menu section
    And I choose 'Parts Lookup' option displayed in menu section
    And I should see 'category of the part' response sent from chatbot
    When I Enter input as 'you are dumb'
    Then I should see helpline number containing '293-1471' displayed
    And I should see chat continues
    
  @TC005 @Negativefeedback @IT @Automation
  Scenario: Verifying helpline number is displayed when negative input is given in IT flow
    Given I login to EVA Appication as "User Type 1"
    And I choose 'IT' option displayed in menu section
    And I choose 'Create Ticket' option displayed in menu section
    And I should see 'provide a detailed description' response sent from chatbot
    When I Enter input as 'you are dumb'
    Then I should see helpline number containing '795-4357' displayed
    And I should see chat continues
    
  @TC006 @Negativefeedback @Pest @Automation
  Scenario: Verifying helpline number is displayed when negative input is given in Pest flow
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Pest' option displayed in menu section
    And I choose 'Quick Reference Guides (QRG)' option displayed in menu section
    When I Enter input as 'you are dumb'
    Then I should see helpline number containing '293-1471' displayed

  @TC007 @Negativefeedback @Feedback @Automation
  Scenario: Verifying helpline number is displayed when negative input is given in Feedback flow
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Feedback' option displayed in menu section
    And I should see 'rate your experience' response sent from chatbot
    When I Enter input as 'you are dumb'
    Then I should see helpline number containing '293-1471' displayed
    And I should see chat continues
    
  @TC008 @Negativefeedback @OnBase @Automation @Smoke
  Scenario: Verifying helpline number is displayed when negative input is given in OnBase flow
    Given I login to EVA Appication as "User Type 1"
    And I choose 'OnBase' option displayed in menu section
    And I choose 'I cannot setup delegate' option displayed in menu section
    And I should see 'Are you using Internet Explorer' response sent from chatbot
    When I Enter input as 'you are dumb'
    Then I should see helpline number containing '795-4357' displayed
    And I should see chat continues
