@Hooks
Feature: Verify Product Dosage

  @TC070 @Product @VerifyProductDosage @Automation
  Scenario: Verify Product Dosage related to Laundry detergent plus product displayed [Select options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Verify Product Dosage' option displayed in menu section
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see Verify Product Dosage related to Laundry detergent plus product displayed when I choose below menu options
    |TriStar|Advanced laundry Control System|
    |EcoStar|EcoStar I/O Manual|
    |LCLS|Liquid Central Laundry Dispenser Programming|
    
  @TC071 @Product @VerifyProductDosage @Automation
  Scenario: Verify Product Dosage related to Laundry detergent plus product displayed [Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I Enter 'Product' as input
    And I Enter 'Verify Product Dosage' as input
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see Adjust a Dispenser related to Laundry detergent plus product displayed when I choose below menu options
    |TriStar|Advanced laundry Control System|
    |EcoStar|EcoStar I/O Manual|
    |LCLS|Liquid Central Laundry Dispenser Programming|
    
   @TC072 @Product @VerifyProductDosage @Automation
  Scenario: Verify Product Dosage is displayed when product name is given as input directly 
    Given I login to EVA Appication as "User Type 1"
    When I Enter input as 'Verify Product Dosage for laundry detergent plus'
    Then I should see Adjust a Dispenser related to Laundry detergent plus product displayed when I choose below menu options
    |TriStar|Advanced laundry Control System|
    |EcoStar|EcoStar I/O Manual|
    |LCLS|Liquid Central Laundry Dispenser Programming|

   @TC073 @Product @VerifyProductDosage @Automation
  Scenario: Verify Product Dosage related to Laundry detergent plus product displayed via Product Lookup[Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Products Lookup' option displayed in menu section
    And I should see 'For which product' response sent from chatbot
    And I Enter input as 'laundry detergent plus'
    When I choose 'Verify Product Dosage' option in menu section when displayed under menu section 'Liquid built detergent'
    Then I should see Adjust a Dispenser related to Laundry detergent plus product displayed when I choose below menu options
    |TriStar|Advanced laundry Control System|
    |EcoStar|EcoStar I/O Manual|
    |LCLS|Liquid Central Laundry Dispenser Programming|