package com.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.test.baseclass.BaseClass;

public class ServiceNowPage extends BaseClass {

	@FindBy(xpath = "(//input[contains(@placeholder,'Search for articles')])[2]")
	public WebElement searchBox;

	@FindBy(css = "div[role='listitem'] span[ng-bind-html]")
	public List<WebElement> searchResultsTextBlock;

	@FindBy(xpath = "//div//label[.='Number']/..//div")
	public WebElement ticketNumber;

	@FindBy(xpath = "//div//label[.='Priority']/..//div")
	public WebElement ticketPriority;

	@FindBy(xpath = "//span[.='Tickets']")
	public WebElement ticketsLink;

	@FindBy(xpath = "//table[contains(@class,'table-responsive')]//*[.='New']")
	public List<WebElement> ticketsTable;
	
	@FindBy(xpath = "(//small[@class='text-muted']//time)[1]")
	public WebElement lastUpdatedTimeStamp;
	
	@FindBy(xpath = "(//div[@class='timeline-body']//p)[1]")
	public WebElement commentTextBlock;

	@FindBy(xpath = "//div[contains(@ng-if,'resolved')]//div[@class='ng-binding']")
	public WebElement resolvedNotesTextBlock;

	@FindBy(xpath = "//label[.='State']/..//div")
	public WebElement ticketStatusTextBlock;

	public List<String> serviceNowSearchResult;

	public ServiceNowPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	public ServiceNowPage enterTextInSearchBox(String text) {
		browserFactory.getWait().until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(text);
		browserFactory.getWait().until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(Keys.ENTER);
		return this;
	}

	public ServiceNowPage getSearchResults() {
		serviceNowSearchResult = new ArrayList<String>();
		browserFactory.getWait().until(ExpectedConditions.visibilityOfAllElements(searchResultsTextBlock)).stream()
				.forEach(e -> serviceNowSearchResult.add(e.getText().replaceAll("\\W", " ")));
		return this;
	}

	public ServiceNowPage clickTicketsTab() {
		browserFactory.getWait().until(ExpectedConditions.visibilityOf(ticketsLink)).click();
		return this;
	}
}
