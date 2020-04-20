package com.test.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.test.baseclass.BaseClass;
import com.test.common.ComonActions;
import com.test.context.Context;
import com.test.model.UserDataModel;
import com.test.pages.CommonPage;
import com.test.pages.ServiceNowPage;
import com.test.utility.GetUserData;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.test.missions.ITMission;

public class ITStepDefs extends BaseClass {
	private ITMission iTMission=new ITMission();
	private Context context=new Context();
	private CommonPage commonPage=new CommonPage();
	private ServiceNowPage serviceNowPage=new ServiceNowPage();

	@Then("I should see same search results displayed as that of service now")
	public void i_should_see_same_search_results_displayed_as_that_of_service_now() {
		Assert.assertTrue(iTMission.getSearchResults(context.getContextParam("inputText")),"EVA KB serach result is not matching with service now search result");
	}

	@Then("I should see a message {string} displayed in the application")
	public void i_should_see_a_message_displayed_in_the_application(String text) {
		Assert.assertTrue(browserFactory.getWait()
				.until(ExpectedConditions.attributeContains(By.xpath(
						"(//div[@class='webchat__row message']//*[contains(@aria-label,'" + text + "')])[last()]"),
						"aria-label", text)),
				"Article not found message is not displayed");
	}

	@Given("I Enter description of the ticket")
	public void i_Enter_description_of_the_ticket() {
		iTMission.enterTicketDescription();
	}

	@Then("Application should display Successful ticket creation message with created date and description")
	public void application_should_display_Successful_ticket_creation_message_with_created_date_and_description() {
		Assert.assertTrue(browserFactory.getWait()
				.until(ExpectedConditions.textToBePresentInElement(
						By.xpath("(//div[@class='webchat__row attachment']//*[contains(.,'"
								+ context.getContextParam("descriptionText") + "')])[last()]"),
						context.getContextParam("descriptionText"))),
				"Helpline number is not displayed");
		Assert.assertTrue(iTMission.verifyTicketCreationInServiceNow(), "Ticket not created in service now");
	}

	@Then("Application should display recent tickets with all the details")
	public void application_should_display_recent_tickets_with_all_the_details() {
		Assert.assertTrue(iTMission.verifyRecentTickets(),
				"Recent ticket list is not matching with service now");
	}

	@Given("I choose to provide comment for the first ticket displayed")
	public void i_choose_to_provide_comment_for_the_first_ticket_displayed() {
		commonPage.clickMenuButton("Comment");
	}

	@Then("I should see Corresponding Ticket should get updated as per the comments provided")
	public void i_should_see_Corresponding_Ticket_should_get_updated_as_per_the_comments_provided() {
		Assert.assertTrue(iTMission.verifyTicketIsUpdated(), "Ticket is not updated successfully");
	}

	@Given("I choose to resolve ticket for the last ticket displayed")
	public void i_choose_to_resolve_ticket_for_the_last_ticket_displayed() {
		commonPage.clickMenuButton("Resolve Request");
	}

	@Then("I should see Corresponding Ticket is resolved and same is updated in servicenow")
	public void i_should_see_Corresponding_Ticket_is_resolved_and_same_is_updated_in_servicenow() {
		Assert.assertTrue(iTMission.verifyTicketIsResolved(), "Ticket is not resolved successfully");
	}

	@When("I Enter input as {string} for the IT ticket")
	public void i_Enter_input_as_for_the_IT_ticket(String text) {
		text = text + (int) (Math.random() * 1000);
		commonPage.enterText(text);
		context.setContextParam("inputText", text);
	}

	@Given("I get the ticketnumber of the recent ticket from servicenow")
	public void i_get_the_ticketnumber_of_the_recent_ticket_from_servicenow() {
		iTMission.getTicketNumberFromServiceNow();
	}

	@Given("I Enter the ticket number")
	public void i_Enter_the_ticket_number() {
		commonPage.enterText(context.getContextParam("ticketNumber"));
	}

	@Given("I choose to provide comment for the ticket displayed")
	public void i_choose_to_provide_comment_for_the_ticket_displayed() {
		iTMission.clickCommentButtonofSpecificTicket();
	}

	@Given("I Enter Update Ticket along with ticket number as input")
	public void i_Enter_Update_Ticket_along_with_ticket_number_as_input() {
		commonPage.enterText("update ticket " + context.getContextParam("ticketNumber"));
	}
}
