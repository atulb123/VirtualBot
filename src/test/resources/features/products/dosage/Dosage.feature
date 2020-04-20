@Hooks
Feature: Dosage

  @TC037 @Product @Dosage @Automation
  Scenario: Verify Dosage Information related to Laundry detergent plus product is displayed [Select options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Dosage' option in menu section when displayed under menu section 'let me know'
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see a message stating 'Below is the Dosage information'
    
  @TC038 @Product @Dosage @Automation
  Scenario: Verify Dosage Information related to Laundry detergent plus product is displayed [Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I Enter 'Product' as input
    And I Enter 'Dosage' as input
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see a message stating 'Below is the Dosage information'
    
   @TC039 @Product @Dosage @Automation @Smoke
  Scenario: Verify Dosage Information is displayed when product name is given as input directly 
    Given I login to EVA Appication as "User Type 1"
    When I Enter input as 'dosage for laundry detergent plus'
    Then I should see a message stating 'the Dosage information'
    
   @TC040 @Product @Dosage @Automation
  Scenario: Verify Dosage Information related to Laundry detergent plus product displayed via Product Lookup[Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I Enter 'Product' as input
    And I Enter 'Products Lookup' as input
    And I should see 'For which product' response sent from chatbot
    And I Enter input as 'laundry detergent plus'
    When I choose 'Dosage' option in menu section when displayed under menu section 'Liquid built detergent'
    Then I should see a message stating 'Below is the Dosage information'