@Hooks
Feature: Ordering

  @TC045 @Product @Ordering @Automation
  Scenario: Verify Ordering Information related to Laundry detergent plus product is displayed [Select options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Ordering' option displayed in menu section
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see a message stating 'Below is the Ordering information you requested'
    
  @TC046 @Product @Ordering @Automation
  Scenario: Verify Ordering Information related to Laundry detergent plus product is displayed [Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I Enter 'Product' as input
    And I Enter 'Ordering' as input
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see a message stating 'Below is the Ordering information you requested'
    
   @TC047 @Product @Ordering @Automation @Smoke
  Scenario: Verify Ordering Information is displayed when product name is given as input directly 
    Given I login to EVA Appication as "User Type 1"
    When I Enter input as 'Ordering for laundry detergent plus'
    Then I should see a message stating 'Ordering information you requested'
    
   @TC048 @Product @Ordering @Automation
  Scenario: Verify Ordering Information related to Laundry detergent plus product displayed via Product Lookup[Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Products Lookup' option displayed in menu section
    And I should see 'For which product' response sent from chatbot
    And I Enter input as 'laundry detergent plus'
    When I choose 'Ordering' option in menu section when displayed under menu section 'Liquid built detergent'
    Then I should see a message stating 'Below is the Ordering information you requested'