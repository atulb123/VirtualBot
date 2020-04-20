@Hooks 
Feature: Feedback

@TC074 @Feedback @Automation
Scenario: Verifying Feedback flow when a rating of '4' is given
	Given I login to EVA Appication as "User Type 1" 
	And I choose 'Parts and Equipment' option displayed in menu section
	And I choose 'Feedback' as option
	And I should see 'How would you rate your experience' response sent from chatbot
	When I Enter input as '4'
	Then I should see a message stating 'Thank you for your feedback!'

@TC075 @Feedback @Automation
Scenario: Verifying Feedback flow when a rating of '3' is given
	Given I login to EVA Appication as "User Type 1" 
	And I choose 'Product' option displayed in menu section
	And I Enter 'Feedback' as option
	And I should see 'How would you rate your experience' response sent from chatbot
	When I Enter input as '3'
	And I should see 'Kindly provide a reason' response sent from chatbot
	And I Enter input as 'Test Comment'
	Then I should see a message stating 'Thank you for your feedback!'

@TC076 @Feedback @Automation
Scenario Outline: Verifying Feedback flow when invalid rating is given
	Given I login to EVA Appication as "User Type 1" 
	And I choose 'IT' option displayed in menu section
	And I choose 'Feedback' as option
	And I should see 'How would you rate your experience' response sent from chatbot
	When I provide "<invalidrating>" then I should see same question being displayed
	Examples:
	|invalidrating|
	|six|
	|Zero|
	|Twenty|