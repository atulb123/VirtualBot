@Hooks 
Feature: OnBase Flow

@TC058 @OnBase @Automation @Smoke
Scenario: Verifying cost center dialog flow is displayed when user asks for Cost Centre directly
	Given I login to EVA Appication as "User Type 1" 
	When I Enter input as 'What is my Cost Centre?'
	Then I should see a message stating 'Our cost center can be found in Workday'

@TC077 @OnBase @Automation
Scenario: Verifying GL account flow when user chooses "YES" for all the options
	Given I login to EVA Appication as "User Type 1" 
	And I choose 'OnBase' option displayed in menu section
	And I choose 'What is my GL Account?' option displayed in menu section
	And I should see text block containing 'description of the GL' displayed
	And I choose 'Yes' as option 
	And I should see text block containing 'search by description in OnBase' displayed
	And I choose 'Yes' as option 
	And I should see text block containing 'need assistance finding and opening' displayed
	And I choose 'Yes' as option 
	And I should see text block containing 'MyBuy + Invoice Approver' displayed
	And I should see text block containing 'Begin typing the description' displayed
	And I should see text block containing 'Did that resolve your issue' displayed
	And I choose 'Yes' as option 
	Then I should below menu options displayed
     |Main Menu|Feedback|Sign Out|

@TC078 @OnBase @Automation
Scenario: Verifying GL account flow when user enters "YES" for all the options
	Given I login to EVA Appication as "User Type 1" 
	And I Enter input as 'What is my GL Account?'
	And I should see text block containing 'description of the GL' displayed
	And I Enter 'Yes' as option 
	And I should see text block containing 'search by description in OnBase' displayed
	And I Enter 'Yes' as option  
	And I should see text block containing 'need assistance finding and opening' displayed
	And I Enter 'Yes' as option 
	And I should see text block containing 'MyBuy + Invoice Approver' displayed
	And I should see text block containing 'Begin typing the description' displayed
	And I should see text block containing 'Did that resolve your issue' displayed
	And I Enter 'Yes' as option 
	Then I should below menu options displayed
     |Main Menu|Feedback|Sign Out|

@TC079 @OnBase @Automation
Scenario: Verifying GL account flow when user enters "No" for Description of GL account
	Given I login to EVA Appication as "User Type 1" 
	And I Enter input as 'What is my GL Account?'
	And I should see text block containing 'description of the GL' displayed
	When I Enter 'No' as option 
	Then I should see text block containing 'please contact your local Help Desk' displayed
	
@TC080 @OnBase @Automation
Scenario: Verifying GL account flow when user enters "No" for GL account assistance
	Given I login to EVA Appication as "User Type 1" 
	And I Enter input as 'What is my GL Account?'
	And I should see text block containing 'description of the GL' displayed
	When I Enter 'Yes' as option 
	And I should see text block containing 'search by description in OnBase' displayed
	And I Enter 'No' as option  
	Then I should see text block containing 'please contact your local Help Desk' displayed
	
@TC081 @OnBase @Automation
Scenario: Verifying GL account flow when user chooses "No" when EVA asks "Did it resolve the issue" at the end of GL account flow
	Given I login to EVA Appication as "User Type 1" 
	And I Enter input as 'What is my GL Account?'
	And I should see text block containing 'description of the GL' displayed
	And I Enter 'Yes' as option 
	And I should see text block containing 'search by description in OnBase' displayed
	And I Enter 'Yes' as option  
	And I should see text block containing 'need assistance finding and opening' displayed
	And I Enter 'Yes' as option 
	And I should see text block containing 'MyBuy + Invoice Approver' displayed
	And I should see text block containing 'Begin typing the description' displayed
	And I should see text block containing 'Did that resolve your issue' displayed
	And I Enter 'No' as option 
	Then I should see text block containing 'please contact your local Help Desk' displayed
	
@TC082 @OnBase @Automation
Scenario: Verifying GL account flow when user chooses "No" when EVA asks "need assistance finding and opening AP invoice coding form" and user enters "No" when EVA asks "Did it resolve the issue" at the end of GL account flow
	Given I login to EVA Appication as "User Type 1" 
	And I Enter input as 'What is my GL Account?'
	And I should see text block containing 'description of the GL' displayed
	And I Enter 'Yes' as option 
	And I should see text block containing 'search by description in OnBase' displayed
	And I Enter 'Yes' as option  
	And I should see text block containing 'need assistance finding and opening' displayed
	And I Enter 'No' as option 
	And I should see text block containing 'Begin typing the description' displayed
	And I should see text block containing 'Did that resolve your issue' displayed
	And I Enter 'No' as option 
	Then I should see text block containing 'please contact your local Help Desk' displayed

@TC083 @OnBase @Automation
Scenario: Verifying GL account flow when user chooses "No" when EVA asks "need assistance finding and opening AP invoice coding form" and user enters "Yes" when EVA asks "Did it resolve the issue" at the end of GL account flow
	Given I login to EVA Appication as "User Type 1" 
	And I Enter input as 'What is my GL Account?'
	And I should see text block containing 'description of the GL' displayed
	And I Enter 'Yes' as option 
	And I should see text block containing 'search by description in OnBase' displayed
	And I Enter 'Yes' as option  
	And I should see text block containing 'need assistance finding and opening' displayed
	And I Enter 'No' as option 
	And I should see text block containing 'Begin typing the description' displayed
	And I should see text block containing 'Did that resolve your issue' displayed
	And I Enter 'Yes' as option 
	Then I should below menu options displayed
     |Main Menu|Feedback|Sign Out|
	
