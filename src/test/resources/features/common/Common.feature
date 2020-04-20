@Hooks 
Feature: Common Flow

@TC059 @Common @Automation @Smoke
Scenario: Verifying CEO informtaion is displayed when user request for CEO information
	Given I login to EVA Appication as "User Type 1" 
	When I Enter input as 'who is the ceo?'
	Then I should see a CEO's information displayed
	
@TC060 @Common @Automation @Smoke
Scenario: Escalte Dialog flow is displayed when user enters 'human help''
	Given I login to EVA Appication as "User Type 1" 
	When I Enter input as 'human help'
	Then I should see helpline number containing '293-1471' displayed
	
@TC061 @Common @Automation @Smoke
Scenario: Verifying Product OnBoarding dialog flow is displayed when user enters input as "product onboarding help"
	Given I login to EVA Appication as "User Type 1" 
	When I Enter input as 'product onboarding help'
	Then I should see text block containing 'Product Dialog Onboarding Help' displayed
