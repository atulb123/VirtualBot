@Hooks
Feature: Specification

  @TC062 @Product @Specification @Automation
  Scenario: Verify Specification Information related to Laundry detergent plus product is displayed [Select options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Specification' option displayed in menu section
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see a message stating 'Here is the Specification information'
    
  @TC063 @Product @Specification @Automation
  Scenario: Verify Specification Information related to Laundry detergent plus product is displayed [Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I Enter 'Product' as input
    And I Enter 'Specification' as input
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see a message stating 'Here is the Specification information'
    
   @TC064 @Product @Specification @Automation @Smoke
  Scenario: Verify Specification Information is displayed when product name is given as input directly 
    Given I login to EVA Appication as "User Type 1"
    When I Enter input as 'Specification for laundry detergent plus'
    Then I should see a message stating 'Here is the Specification information'
    
   @TC065 @Product @Specification @Automation
  Scenario: Verify Specification Information related to Laundry detergent plus product displayed via Product Lookup[Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Products Lookup' option displayed in menu section
    And I should see 'For which product' response sent from chatbot
    And I Enter input as 'laundry detergent plus'
    When I choose 'Specification' option in menu section when displayed under menu section 'Liquid built detergent'
    Then I should see a message stating 'Here is the Specification information'