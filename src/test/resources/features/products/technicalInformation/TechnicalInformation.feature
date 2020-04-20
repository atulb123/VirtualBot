@Hooks
Feature: Technical Information

  @TC033 @Product @TechnicalInformation @Automation
  Scenario: Verify Techincal Information related to Laundry detergent plus product displayed [Select options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Technical Information' option displayed in menu section
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see Techincal Information related to Laundry detergent plus product displayed when I choose below menu options
    |Guide|Eco-Star|Tri-Star|
    
  @TC034 @Product @TechnicalInformation @Automation
  Scenario: Verify Techincal Information related to Laundry detergent plus product displayed [Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I Enter 'Product' as input
    And I Enter 'Technical Information' as input
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see Techincal Information related to Laundry detergent plus product displayed when I choose below menu options
    |Guide|Eco-Star|Tri-Star|
    
   @TC035 @Product @TechnicalInformation @Automation @Smoke
  Scenario: Verify Techincal Information is displayed when product name is given as input directly 
    Given I login to EVA Appication as "User Type 1"
    When I Enter input as 'Technical Information for laundry detergent plus'
    Then I should see Techincal Information related to Laundry detergent plus product displayed when I choose below menu options
    |Guide|Eco-Star|Tri-Star|
    
   @TC036 @Product @TechnicalInformation @Automation
  Scenario: Verify Techincal Information related to Laundry detergent plus product displayed via Product Lookup[Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Products Lookup' option displayed in menu section
    And I should see 'For which product' response sent from chatbot
    And I Enter input as 'laundry detergent plus'
    When I choose 'Technical Information' option in menu section when displayed under menu section 'Liquid built detergent'
    Then I should see Techincal Information related to Laundry detergent plus product displayed when I choose below menu options
    |Guide|Eco-Star|Tri-Star|