package com.test.stepdefs;

import org.openqa.selenium.By;
import com.darkprograms.speech.synthesiser.SynthesiserV2;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.test.baseclass.BaseClass;
import com.test.context.Context;
import com.test.pages.CommonPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeFeedbackStepDefs extends BaseClass {
	private CommonPage commonPage=new CommonPage();
	private Context context = new Context();
	static SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");

	@Given("I should see {string} response sent from chatbot")
	public void i_should_see_response_sent_from_chatbot(String text) {
		context.setContextParam("messageFromBot", text);
		Assert.assertTrue(commonPage.verifyMessageFromChatBot(text), "Message from chatbot is not displayed");
	}

	@Given("I Enter input as {string}")
	public void i_Enter_input_as(String text) {
		commonPage.enterText(text);
		context.setContextParam("inputText", text);
	}

	@Then("I should see helpline number containing {string} displayed")
	public void i_should_see_helpline_number_containing_displayed(String text) {
		Assert.assertTrue(browserFactory.getWait().until(ExpectedConditions.textToBePresentInElement(
				By.xpath("(//div[@class='webchat__row attachment']//*[contains(.,'" + text + "')])[last()]"), text)),
				"Helpline number is not displayed");
	}

	@Then("I should see chat continues")
	public void i_should_see_chat_continues() {
		Assert.assertTrue(
				browserFactory.getWait()
						.until(ExpectedConditions.numberOfElementsToBeMoreThan(
								By.xpath("//div[@class='webchat__row message']//*[contains(@aria-label,'"
										+ context.getContextParam("messageFromBot") + "')]"),1)).size()>1,
				"Chat abruptly ended when negative feedback is given");
	}

	@Then("I should below menu options displayed")
	public void i_should_below_menu_options_displayed(DataTable dataTable) {
		Assert.assertTrue(
				dataTable.asList().stream()
						.allMatch(text -> browserFactory.getWait()
								.until(ExpectedConditions.textToBePresentInElement(
										By.xpath("//button[@type='button' and contains(.,'" + text + "')]"), text))),
				"Wash Formula Menu not displayed");
	}
}
