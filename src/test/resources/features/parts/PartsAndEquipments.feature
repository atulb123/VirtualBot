@Hooks 
Feature: Parts and Equipments 

@TC009 @Parts @Automation 
Scenario: Verifying specific part info is displayed when searched for a specific part without knowing the category [webchat] [Select options from menu] 
	Given I login to EVA Appication as "User Type 1" 
	And I choose 'Parts and Equipment' option displayed in menu section 
	And I choose 'Parts Lookup' option displayed in menu section 
	And I choose 'No' as option 
	And I should see 'What part are you looking for' response sent from chatbot 
	And I Enter input as 'SCLS' 
	And I should see list of parts related to SCLS displayed 
	And I choose 'more details' option displayed in menu section 
	Then I should see specific part information along with 'View parts' and 'Add To Cart' buttons 
	
@TC010 @Parts @Automation 
Scenario: Verifying cannot find part information message is displayed when invalid input is given [webchat] [Enter options as input] 
	Given I login to EVA Appication as "User Type 1" 
	And I choose 'Parts and Equipment' option displayed in menu section 
	And I choose 'Parts Lookup' option displayed in menu section 
	And I choose 'No' as option 
	And I should see 'What part are you looking for' response sent from chatbot 
	And I Enter input as 'test@123' 
	Then I should see a message stating 'cannot find information on your selection' 
	
@TC011 @Parts @Automation 
Scenario: Verifying Part info is displayed when parts is searched based on the category defined [webchat] [Select options from menu]
	Given I login to EVA Appication as "User Type 1" 
	And I choose 'Parts and Equipment' option displayed in menu section 
	And I choose 'Parts Lookup' option displayed in menu section 
	And I choose 'Yes' as option 
	And I choose 'Dispenser' option displayed in menu section 
	And I choose 'Laundry' option displayed in menu section 
	And I choose 'Solids' option displayed in menu section 
	And I choose 'SCLS' option displayed in menu section 
	And I should see list of parts related to SCLS displayed 
	And I choose 'more details' option displayed in menu section 
	Then I should see specific part information along with 'View parts' and 'Add To Cart' buttons 
	
@TC012 @Product @Automation 
Scenario: Verifying Part info is displayed when parts is searched based on the category defined [webchat] [Enter options as input]
	Given I login to EVA Appication as "User Type 1" 
	And I Enter 'Parts and Equipment' as input 
	And I Enter 'Parts Lookup' as input 
	And I Enter 'Yes' as option 
	And I Enter 'Dispenser' as input 
	And I Enter 'Laundry' as input 
	And I Enter 'Solids' as input 
	When I Enter 'SCLS' as input 
	Then I should see list of parts related to SCLS displayed
	
	@TC055 @Product @Automation @Smoke
Scenario: Verifying Part info is displayed when partname is entered directly [webchat] [Enter options as input]
	Given I login to EVA Appication as "User Type 1"
	When I Enter input as 'Parts Lookup SCLS'
	Then I should see list of parts related to SCLS displayed
