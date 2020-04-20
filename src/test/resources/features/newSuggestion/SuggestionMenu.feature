 @Hooks
 Feature: Suggestion Menu

  @TC013 @SuggestedMenu @Product @Automation
  Scenario: Verifying new Suggested Prompts is displayed after completing Product flow
    Given I login to EVA Appication as "User Type 1"
    And I choose 'Product' option displayed in menu section
    And I choose 'Dosage' option displayed in menu section
    And I should see 'For which product do you need information' response sent from chatbot
    When I Enter input as 'laundry detergent plus'
    Then I should below menu options displayed
     |Main Menu|Feedback|Sign Out|
    
  @TC014 @SuggestedMenu @Parts @Automation
  Scenario: Verifying new Suggested Prompts is displayed after completing Parts and Equipments flow
    Given I login to EVA Appication as "User Type 1"
	And I choose 'Parts and Equipment' option displayed in menu section 
	And I choose 'Parts Lookup' option displayed in menu section 
	And I choose 'No' as option 
	And I should see 'What part are you looking for' response sent from chatbot 
	And I Enter input as 'SCLS'
	Then I should below menu options displayed
    |Main Menu|Feedback|Sign Out| 