package com.test.stepdefs;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.test.baseclass.BaseClass;
import com.test.pages.CommonPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class PartsStepDefs extends BaseClass {
	private CommonPage commonPage=new CommonPage();
	
	@Given("I should see list of parts related to SCLS displayed")
	public void i_should_see_list_of_parts_related_to_SCLS_displayed() {
		Assert.assertTrue(browserFactory.getWait()
				.until(ExpectedConditions
						.numberOfElementsToBeMoreThan(By.xpath("//div[@aria-label='Product Details card']"), 0))
				.size() > 0, "Parts list not displayed");
	}

	@Then("I should see specific part information along with {string} and {string} buttons")
	public void i_should_see_specific_part_information_along_with_and_buttons(String viewPart, String addToCart) {
		Assert.assertTrue(browserFactory.getWait().until(ExpectedConditions.attributeContains(
				By.xpath("(//button[contains(@aria-label,'" + viewPart + "')])[last()]"), "aria-label", viewPart)),
				"viewPart link not displayed");
		Assert.assertTrue(browserFactory.getWait().until(ExpectedConditions.attributeContains(
				By.xpath("(//button[contains(@aria-label,'" + addToCart + "')])[last()]"), "aria-label", addToCart)),
				"addToCart link not displayed");
	}

	@Given("I choose {string} as option")
	public void i_choose_as_option(String option) {
		Assert.assertTrue(commonPage.clickOption(option), "Yes or No option not displayed");
	}

	@Then("I should see a message stating {string}")
	public void i_should_see_a_message_stating(String text) {
		Assert.assertTrue(commonPage.verifyMessageFromChatBot(text),
				"Corresponding message is not displayed");
	}

	@Given("I Enter {string} as option")
	public void i_Enter_as_option(String option) {
		commonPage.enterOption(option);
	}
}
