@Hooks 
Feature: PEST Flow

@TC015 @Pest @Automation 
Scenario: Verifying Specification file is getting downloaded for Insect flow (Choose from menu)
	Given I login to EVA Appication as "User Type 1" 
	And I choose 'Pest' option displayed in menu section 
	And I choose 'QRG' option displayed in menu section 
	And I choose 'Insects' option displayed in menu section 
	Then I should see corresponding QRG document when I click on below menu
     |Small|Large|Ants|Bed Bugs|Cockroaches|Mosquitos|
     
@TC016 @Pest @Automation 
Scenario: Verifying Specification file is getting downloaded for Insect flow (Enter menu)
	Given I login to EVA Appication as "User Type 1" 
	And I Enter 'Pest' as input 
	And I Enter 'QRG' as input 
	And I Enter 'Insects' as input 
	Then I should see corresponding QRG document when I enter below menu
     |Small|Large|Ants|Bed Bugs|Cockroaches|Mosquitos|
     
@TC017 @Pest @Automation 
Scenario: Verifying Specification file is getting downloaded for (Rodent|Hotel Protection|SPP|Thermal Enclosure) (Choose from menu)
	Given I login to EVA Appication as "User Type 1" 
	And I Enter 'Pest' as input 
	And I Enter 'QRG' as input 
	Then I should see corresponding QRG document when I click on below menu
     |Rodent|Hotel Protection|SPP|Thermal Enclosure|
     
@TC018 @Pest @Automation 
Scenario: Verifying Specification file is getting downloaded for (Rodent|Hotel Protection|SPP|Thermal Enclosure) (Enter menu)
	Given I login to EVA Appication as "User Type 1" 
	And I Enter 'Pest' as input 
	And I Enter 'QRG' as input 
	Then I should see corresponding QRG document when I enter below menu
     |Rodent|Hotel Protection|SPP|Thermal Enclosure|
     
@TC019 @Pest @Automation 
Scenario: Verifying Specification file is getting downloaded for Fumigation flow (Choose from menu)
	Given I login to EVA Appication as "User Type 1" 
	And I choose 'Pest' option displayed in menu section 
	And I choose 'QRG' option displayed in menu section 
	And I choose 'Fumigation' option displayed in menu section 
	Then I should see corresponding QRG document when I click on below menu
     |Container Fumigation|Ship Barge|Stored Commodity|
     
@TC020 @Pest @Automation 
Scenario: Verifying Specification file is getting downloaded for Fumigation flow (Enter menu)
	Given I login to EVA Appication as "User Type 1" 
	And I Enter 'Pest' as input 
	And I Enter 'QRG' as input 
	And I Enter 'Fumigation' as input 
	Then I should see corresponding QRG document when I enter below menu
     |Container Fumigation|Ship Barge|Stored Commodity|
  
 @TC056 @Pest @Automation @Smoke
Scenario: Verifying Specification file is getting downloaded when PEST name is entered directly
	Given I login to EVA Appication as "User Type 1" 
	Then I should see QRG document download link when I enter below menu
     |QRG ants|Quick Reference Guide Ants|QRG Structural Fumigation|qrg for Rodent|
