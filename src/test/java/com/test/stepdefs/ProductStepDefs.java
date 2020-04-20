package com.test.stepdefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.test.baseclass.BaseClass;
import com.test.common.ComonActions;
import com.test.missions.ProductsMission;
import com.test.model.UserDataModel;
import com.test.pages.CommonPage;
import com.test.utility.GetUserData;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDefs extends BaseClass {
	private CommonPage commonPage = new CommonPage();
	private ComonActions comonActions=new ComonActions();
	private GetUserData getUserData=new GetUserData();
	private ProductsMission productsMission=new ProductsMission();

	@Then("I should see {string} info is displayed")
	public void i_should_see_info_is_displayed(String text) {
		Assert.assertTrue(browserFactory.getWait()
				.until(ExpectedConditions.attributeContains(By.xpath(
						"(//div[@class='webchat__row message']//*[contains(@aria-label,'" + text + "')])[last()]"),
						"aria-label", text)),
				"Information about product not displayed");
	}

	@Given("I choose {string} option displayed in menu section")
	public void i_choose_option_displayed_in_menu_section(String string) {
		Assert.assertTrue(commonPage.clickMenuOption(string), "Failed to click on " + string);
	}

	@Then("I should see menu options related to Product Wash Formula displayed")
	public void i_should_see_menu_options_related_to_Product_Wash_Formula_displayed(DataTable dataTable) {
		Assert.assertTrue(
				dataTable.asList().stream()
						.allMatch(text -> browserFactory.getWait().until(ExpectedConditions.attributeContains(
								By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]"), "aria-label", text))),
				"Wash Formula Menu not displayed");
	}

	@When("I Enter {string} as input")
	public void i_Enter_as_input(String text) {
		Assert.assertTrue(commonPage.enterMenuOption(text), "Failed to click on " + text);
	}

	@Given("I login to EVA Appication as {string}")
	public void i_login_to_EVA_Appication_as(String userType) {
		UserDataModel userData = getUserData.getTestData(userType);
		comonActions.performLogin(userData.getUserName(), userData.getPassword(),userType);
	}

	@Then("I should see Techincal Information related to Laundry detergent plus product displayed when I choose below menu options")
	public void i_should_see_Techincal_Information_related_to_Laundry_detergent_plus_product_displayed_when_I_choose_below_menu_options(
			DataTable dataTable) {
		Assert.assertTrue(
				dataTable.asList().stream().allMatch(menus -> productsMission.verifyTechincalInformation(menus)),
				"Techincal Information related to Laundry detergent plus product is not displayed");
	}

	@When("I choose {string} option in menu section when displayed under menu section {string}")
	public void i_choose_option_in_menu_section_when_displayed_under_menu_section(String buttonText, String menuText) {
		commonPage.clickMenuButton(buttonText, menuText);
	}

	@Then("I should see Switchout Information related to Laundry detergent plus product displayed when I choose below menu options")
	public void i_should_see_Switchout_Information_related_to_Laundry_detergent_plus_product_displayed_when_I_choose_below_menu_options(
			DataTable dataTable) {
		Assert.assertTrue(
				dataTable.asList().stream().allMatch(menus -> productsMission.verifyTechincalInformation(menus)),
				"Switchout Information related to Laundry detergent plus product is not displayed");
	}
	
	@When("I choose below menu then corresponding product should be recommended")
	public void i_choose_below_menu_then_corresponding_product_should_be_recommended(DataTable table) {
		for (int i = 0; i < table.asLists().size(); i++) {
			if (i != 0)
				commonPage.clickOption("Product Recommendation");
			commonPage.clickOption(table.asLists().get(i).get(0));
			commonPage.clickOption(table.asLists().get(i).get(1));
			commonPage.clickOption(table.asLists().get(i).get(2));
			Assert.assertTrue(commonPage.verifyMessageFromChatBot(table.asLists().get(i).get(3)),
					"Failed to display the Product Recommendation");
		}
	}
	
	@When("I enter below menu then corresponding product should be recommended")
	public void i_enter_below_menu_then_corresponding_product_should_be_recommended(DataTable table) {
		for (int i = 0; i < table.asLists().size(); i++) {
			if (i != 0)
			commonPage.enterOption("Product Recommendation");
			commonPage.enterOption(table.asLists().get(i).get(0));
			commonPage.enterOption(table.asLists().get(i).get(1));
			commonPage.enterOption(table.asLists().get(i).get(2));
			Assert.assertTrue(commonPage.verifyMessageFromChatBot(table.asLists().get(i).get(3)),
					"Failed to display the Product Recommendation");
		}
	}


	@Then("I should see (Adjust a Dispenser|Verify Product Dosage) related to Laundry detergent plus product displayed when I choose below menu options")
	public void i_should_see_Adjust_a_Dispenser_related_to_Laundry_detergent_plus_product_displayed_when_I_choose_below_menu_options(
			DataTable dataTable) {
		for (int i = 0; i < dataTable.asLists().size(); i++) {
			commonPage.clickMenuOption(dataTable.asLists().get(i).get(0));
			Assert.assertTrue(commonPage.verifyTextBlockIsDisplayed(dataTable.asLists().get(i).get(1)),
					"Failed to display Adjust dispnser for " + dataTable.asLists().get(i).get(0));
		}
	}
}
