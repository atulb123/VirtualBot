@Hooks
Feature: Product Wash Formula

  @TC001 @Product @Automation @ProductWashFormula
  Scenario: Verify menus displayed on selecting Product Wash Formula [Select options from menu]
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    When I choose 'Product Wash Formula' option displayed in menu section
    Then I should see menu options related to Product Wash Formula displayed
    |Lodging|Restaurant Linen|Long Term Care|Specialty|

   @TC002 @Product @Automation @ProductWashFormula @Smoke
  Scenario: Verify menus displayed on selecting Product Wash Formula [Enter options as input]
    Given I login to EVA Appication as "User Type 1"
    When I Enter input as 'Product Wash Formula'
    Then I should see menu options related to Product Wash Formula displayed
    |Lodging|Restaurant Linen|Long Term Care|Specialty|
    