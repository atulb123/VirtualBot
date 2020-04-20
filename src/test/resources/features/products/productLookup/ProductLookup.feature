@Hooks 
Feature: Product Lookup Flow

@TC049 @ProductLookup @Automation @Smoke
Scenario: Verifying Product Lookup Dialog flow is displayed (Choose from menu)
	Given I login to EVA Appication as "User Type 1" 
	When I Enter input as 'product lookup laundry detergent plus'
	Then I should see a message stating 'Products List:'

@TC053 @ProductLookup @Automation @Smoke
Scenario: Verifying Product Lookup Dialog flow is displayed (Enter question as input)
	Given I login to EVA Appication as "User Type 1" 
	When I Enter input as 'What is laundry detergent plus'
	Then I should see a message stating 'Products List:'

@TC054 @ProductLookup @Automation @Smoke
Scenario: Verifying Product Lookup Dialog flow is displayed (Enter question as input)
	Given I login to EVA Appication as "User Type 1" 
	When I Enter input as 'Laundry detergent plus'
	Then I should see a message stating 'Products List:'
     
