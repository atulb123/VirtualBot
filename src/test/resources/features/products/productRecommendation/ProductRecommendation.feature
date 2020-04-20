@Hooks
Feature: Product Recommendation

  @TC050 @Product @ProductRecommendation @Automation
  Scenario: Verify Product Recommendation flow [Select options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Product Recommendation' option displayed in menu section
    When I choose below menu then corresponding product should be recommended
    |Liquids|Detergent|Yes|Laundry Detergent Ultra|
    |Liquids|Detergent|No|Laundry Detergent Plus|
    |Liquids|Softener|Yes|Clearly Soft Plus|
    |Liquids|Softener|No|So Fresh|
    |Liquids|Bleach|Colored|Oxy-Brite|
    |Liquids|Bleach|White|Chlorine Destainer|
    |Liquids|Sour|Yes|Sour VII|
    |Liquids|Sour|No|Neutralizer NP|
    
     @TC051 @Product @ProductRecommendation @Automation
  Scenario: Verify Product Recommendation flow [Enter Menu Options]
    Given I login to EVA Appication as "User Type 1"
    And I Enter 'Product' as input
    And I Enter 'Product Recommendation' as input
    When I enter below menu then corresponding product should be recommended
    |Liquids|Detergent|Yes|Laundry Detergent Ultra|
    |Liquids|Detergent|No|Laundry Detergent Plus|
    |Liquids|Softener|Yes|Clearly Soft Plus|
    |Liquids|Softener|No|So Fresh|
    |Liquids|Bleach|Colored|Oxy-Brite|
    |Liquids|Bleach|White|Chlorine Destainer|
    |Liquids|Sour|Yes|Sour VII|
    |Liquids|Sour|No|Neutralizer NP|