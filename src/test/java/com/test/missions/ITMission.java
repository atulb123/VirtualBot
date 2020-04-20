package com.test.missions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.test.baseclass.BaseClass;
import com.test.baseclass.BrowserFactory;
import com.test.context.Context;
import com.test.pages.CommonPage;
import com.test.pages.ServiceNowPage;
import com.test.utility.GetPropertiesData;

public class ITMission extends BaseClass {

	ServiceNowPage serviceNowPage = new ServiceNowPage();
	CommonPage commonPage = new CommonPage();
	Context context = new Context();

	public boolean getSearchResults(String searchText) {
		List<String> EvaKBSearchResults = new ArrayList<String>();
		browserFactory.getWait().until(ExpectedConditions.numberOfElementsToBeMoreThan(
				By.xpath("//div[@class='content']//li//div[contains(@style,'17')]//p"), 1));
		browserFactory.getDriver().findElements(By.xpath("//div[@class='content']//li//div[contains(@style,'17')]//p"))
				.stream().forEach(e -> EvaKBSearchResults.add(e.getText()));
		browserFactory.getDriver().get(GetPropertiesData.getPropertyValue("devservicenow"));
		serviceNowPage.enterTextInSearchBox(searchText).getSearchResults();
		return EvaKBSearchResults.stream().allMatch(result -> serviceNowPage.serviceNowSearchResult.contains(result.replaceAll("[\\W]", " ")));
	}

	public ITMission enterTicketDescription() {
		String descriptionText = "";
		for (int i = 0; i < 5; i++)
			descriptionText = descriptionText + RandomStringUtils.randomAlphabetic(4) + " ";
		descriptionText = descriptionText.trim();
		commonPage.enterText(descriptionText);
		context.setContextParam("descriptionText", descriptionText);
		return this;
	}

	public boolean verifyTicketCreationInServiceNow() {
		String parentWindow = browserFactory.getDriver().getWindowHandle();
		commonPage.clickMenuButton("View Details");
		for (String window : browserFactory.getDriver().getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				browserFactory.getDriver().switchTo().window(window);
				break;
			}
		}
		context.setContextParam("priority", browserFactory.getWait()
				.until(ExpectedConditions.visibilityOf(serviceNowPage.ticketPriority)).getText());
		context.setContextParam("ticketNumber",
				browserFactory.getWait().until(ExpectedConditions.visibilityOf(serviceNowPage.ticketNumber)).getText());
		serviceNowPage.clickTicketsTab();
		return browserFactory.getWait()
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//tr//td[.='" + context.getContextParam("ticketNumber")
								+ "']//..//td[.='" + context.getContextParam("descriptionText") + "']")))
				.isDisplayed()
				&& browserFactory.getWait()
						.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//td[.='" + context.getContextParam("ticketNumber") + "']")))
						.isDisplayed()
				&& context.getContextParam("priority").contains("Medium");
	}

	public boolean verifyRecentTickets() {
		String parentWindow = browserFactory.getDriver().getWindowHandle();
		commonPage.clickMenuButton("View All Your Requests");
		for (String window : browserFactory.getDriver().getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				browserFactory.getDriver().switchTo().window(window);
				break;
			}
		}
		browserFactory.getWait().until(ExpectedConditions.visibilityOfAllElements(serviceNowPage.ticketsTable));
		for (int i = 1; i <= serviceNowPage.ticketsTable.size(); i++)
		{
			context.setContextParam(
					browserFactory.getWait()
							.until(ExpectedConditions.visibilityOf(browserFactory.getDriver()
									.findElement(By.xpath("(//tr[contains(@ng-repeat,'data.list track')])[" + i
											+ "]//td[@data-field='sys_created_on']"))))
							.getText(),
					browserFactory.getWait()
							.until(ExpectedConditions.visibilityOf(browserFactory.getDriver()
									.findElement(By.xpath("(//tr[contains(@ng-repeat,'data.list track')])[" + i
											+ "]//td[@data-field='short_description']"))))
							.getText());
		}
		browserFactory.getDriver().switchTo().window(parentWindow);
		int i = 1;
		for (Entry<String, String> entry : context.tempValues.entrySet()) {
			if (!entry.getKey().equals("inputText")) {
				Assert.assertTrue(browserFactory.getWait()
						.until(ExpectedConditions.textToBePresentInElement(
								By.xpath("//div[@class='content']//li[" + i + "]//div[@class='ac-textBlock'][2]"),
								entry.getKey())));
				Assert.assertTrue(browserFactory.getWait()
						.until(ExpectedConditions.textToBePresentInElement(
								By.xpath("//div[@class='content']//li[" + i + "]//div[@class='ac-textBlock'][1]"),
								entry.getValue())));
				i++;
			}
		}
		return true;
	}
	
	public boolean verifyTicketIsUpdated() {
		String parentWindow = browserFactory.getDriver().getWindowHandle();
		commonPage.clickMenuButton("View Details");
		for (String window : browserFactory.getDriver().getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				browserFactory.getDriver().switchTo().window(window);
				break;
			}
		}
		return browserFactory.getWait().until(ExpectedConditions.visibilityOf(serviceNowPage.lastUpdatedTimeStamp))
				.getText().contains("just now")
				&& browserFactory.getWait().until(ExpectedConditions.visibilityOf(serviceNowPage.commentTextBlock))
						.getText().equals(context.getContextParam("inputText"));

	}

	public boolean verifyTicketIsResolved() {
		String parentWindow = browserFactory.getDriver().getWindowHandle();
		commonPage.clickMenuButton("View Details");
		for (String window : browserFactory.getDriver().getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				browserFactory.getDriver().switchTo().window(window);
				break;
			}
		}
		Assert.assertTrue(browserFactory.getWait()
				.until(ExpectedConditions.visibilityOf(serviceNowPage.resolvedNotesTextBlock)).getText()
				.equals(context.getContextParam("inputText"))
				&& browserFactory.getWait().until(ExpectedConditions.visibilityOf(serviceNowPage.ticketStatusTextBlock))
						.getText().equals("Resolved"),
				"Ticket not resolved");
		context.setContextParam("ticketNumber",
				browserFactory.getWait().until(ExpectedConditions.visibilityOf(serviceNowPage.ticketNumber)).getText());
		serviceNowPage.clickTicketsTab();
		browserFactory.getWait().until(ExpectedConditions.visibilityOfAllElements(serviceNowPage.ticketsTable));
		return browserFactory.getWait()
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//tr//td[.='" + context.getContextParam("ticketNumber")
								+ "']//..//td[.='" + context.getContextParam("inputText") + "']")))
				.isDisplayed()
				&& browserFactory.getWait()
						.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//td[.='" + context.getContextParam("ticketNumber") + "']//..//td[7]")))
						.getText().equals("Resolved");

	}
	
	public ITMission getTicketNumberFromServiceNow() {
		String parentWindow = browserFactory.getDriver().getWindowHandle();
		commonPage.clickMenuButton("View Details");
		for (String window : browserFactory.getDriver().getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				browserFactory.getDriver().switchTo().window(window);
				break;
			}
		}
		context.setContextParam("ticketNumber",
				browserFactory.getWait().until(ExpectedConditions.visibilityOf(serviceNowPage.ticketNumber)).getText());
		browserFactory.getDriver().close();
		browserFactory.getDriver().switchTo().window(parentWindow);
		return this;
	}
	
	public ITMission clickCommentButtonofSpecificTicket() {
		browserFactory.getWait().until(ExpectedConditions.visibilityOf(commonPage.ticketTextArea));
		commonPage.clickMenuButton("Comment");
		return this;
	}
}
