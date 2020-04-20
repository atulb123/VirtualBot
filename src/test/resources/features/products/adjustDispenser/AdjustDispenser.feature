@Hooks
Feature: Adjust a Dispenser

  @TC066 @Product @AdjustDispenser @Automation
  Scenario: Verify Adjust a Dispenser related to Laundry detergent plus product displayed [Select options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Adjust a Dispenser' option displayed in menu section
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see Adjust a Dispenser related to Laundry detergent plus product displayed when I choose below menu options
    |TriStar|Advanced laundry Control System|
    |EcoStar|EcoStar I/O Manual|
    |LCLS|Liquid Central Laundry Dispenser Programming|
    
  @TC067 @Product @AdjustDispenser @Automation
  Scenario: Verify Adjust a Dispenser related to Laundry detergent plus product displayed [Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I Enter 'Product' as input
    And I Enter 'Adjust a Dispenser' as input
    And I should see 'For which product' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should see Adjust a Dispenser related to Laundry detergent plus product displayed when I choose below menu options
    |TriStar|Advanced laundry Control System|
    |EcoStar|EcoStar I/O Manual|
    |LCLS|Liquid Central Laundry Dispenser Programming|
    
   @TC068 @Product @AdjustDispenser @Automation
  Scenario: Verify Adjust a Dispenser is displayed when product name is given as input directly 
    Given I login to EVA Appication as "User Type 1"
    When I Enter input as 'Adjust a Dispenser for laundry detergent plus'
    Then I should see Adjust a Dispenser related to Laundry detergent plus product displayed when I choose below menu options
    |TriStar|Advanced laundry Control System|
    |EcoStar|EcoStar I/O Manual|
    |LCLS|Liquid Central Laundry Dispenser Programming|

   @TC069 @Product @AdjustDispenser @Automation
  Scenario: Verify Adjust a Dispenser related to Laundry detergent plus product displayed via Product Lookup[Enter options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Products Lookup' option displayed in menu section
    And I should see 'For which product' response sent from chatbot
    And I Enter input as 'laundry detergent plus'
    When I choose 'Adjust a Dispenser' option in menu section when displayed under menu section 'Liquid built detergent'
    Then I should see Adjust a Dispenser related to Laundry detergent plus product displayed when I choose below menu options
    |TriStar|Advanced laundry Control System|
    |EcoStar|EcoStar I/O Manual|
    |LCLS|Liquid Central Laundry Dispenser Programming|