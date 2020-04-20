package com.test.stepdefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.test.baseclass.BaseClass;
import com.test.pages.CommonPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonStepdefs extends BaseClass{
	
	private CommonPage commonPage=new CommonPage();

	@Then("I should see a CEO's information displayed")
	public void i_should_see_a_CEO_s_information_displayed() {
		Assert.assertTrue(browserFactory.getWait()
				.until(ExpectedConditions.visibilityOf(commonPage.ceoDescriptionTextBlock)).isDisplayed(),
				"CEO information is not displayed");
	}
	
	@Then("I should see text block containing {string} displayed")
	public void i_should_see_text_block_containing_displayed(String text) {
		Assert.assertTrue(commonPage.verifyTextBlockIsDisplayed(text),
				"Text Block containing " + text + " is not displayed");
	}

	@When("I provide {string} then I should see same question being displayed")
	public void i_provide_then_I_should_see_same_question_being_displayed(String text) {
		commonPage.enterText(text);
		Assert.assertTrue(browserFactory.getWait()
				.until(ExpectedConditions.textToBePresentInElementLocated(
						By.xpath("//p[contains(.,'How would you rate your experience')]"),
						"How would you rate your experience")),
				"Mismatch in Feedback flow");
	}
}
