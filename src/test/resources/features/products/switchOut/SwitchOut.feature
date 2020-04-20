@Hooks
Feature: Switch Out

  @TC041 @Product @SwitchOut @Automation
  Scenario: Verify Switch-out Information related to Laundry detergent plus product is displayed [Select options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Switch-Out' option displayed in menu section
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see Switchout Information related to Laundry detergent plus product displayed when I choose below menu options
    |Laundry|
    
  @TC042 @Product @SwitchOut @Automation
  Scenario: Verify Switch-out Information related to Laundry detergent plus product is displayed [Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I Enter 'Product' as input
    And I Enter 'Switch-Out' as input
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see Switchout Information related to Laundry detergent plus product displayed when I choose below menu options
    |Laundry|
    
   @TC043 @Product @SwitchOut @Automation @Smoke
  Scenario: Verify Switch-out Information is displayed when product name is given as input directly 
    Given I login to EVA Appication as "User Type 1"
    When I Enter input as 'Switch-Out for laundry detergent plus'
    Then I should see Switchout Information related to Laundry detergent plus product displayed when I choose below menu options
    |Laundry|
    
   @TC044 @Product @SwitchOut @Automation
  Scenario: Verify Switch-out Information related to Laundry detergent plus product displayed via Product Lookup[Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Products Lookup' option displayed in menu section
    And I should see 'For which product' response sent from chatbot
    And I Enter input as 'laundry detergent plus'
    When I choose 'Switch-Out' option in menu section when displayed under menu section 'Liquid built detergent'
    Then I should see Switchout Information related to Laundry detergent plus product displayed when I choose below menu options
    |Laundry|