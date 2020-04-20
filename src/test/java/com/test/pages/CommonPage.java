package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import com.test.baseclass.BaseClass;

import io.appium.java_client.AppiumDriver;

public class CommonPage extends BaseClass {

	@FindBy(xpath = "//input[@data-id='webchat-sendbox-input']")
	public WebElement inputTextBox;

	@FindBy(xpath = "//button[@type='button']")
	public WebElement menuButton;

	@FindBy(xpath = "//button[.='View Details']")
	public WebElement viewDetailsButton;
	
	@FindBy(xpath = "(//*[.='Here are your ticket'])[last()]")
	public WebElement ticketTextArea;

	@FindBy(xpath = "//p[contains(.,'Please let me know how')]")
	public WebElement welcomeMessageTextBlock;

	@FindBy(xpath = "//p[contains(.,'Doug Baker')]")
	public WebElement ceoDescriptionTextBlock;

	public CommonPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	public boolean clickMenuOption(String text) {
		try {
			((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", browserFactory.getDriver().findElement(By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]")));
			browserFactory.getWait().until(ExpectedConditions.attributeContains(By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]"),
					"aria-label", text));
			((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].click();", browserFactory.getDriver().findElement(By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]")));
			browserFactory.getWait().until(ExpectedConditions.attributeContains(By
					.xpath("(//div[@class='webchat__row message']//*[contains(@aria-label,'" + text + "')])[last()]"),
					"aria-label", text));
			return true;
		} catch (Exception e) {
			for (int i = 0; i < 2; i++) {
				try {
					if (browserFactory.getWait().until(ExpectedConditions.attributeContains(
							By.xpath("(//div[@class='webchat__row message']//*[contains(@aria-label,'" + text
									+ "')])[last()]"),
							"aria-label", text))) {
						return true;
					}
				} catch (Exception e1) {
					try {
						((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", browserFactory.getDriver().findElement(By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]")));
						((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].click();", browserFactory.getDriver().findElement(By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]")));
					} catch (Exception e2) {
					}
				}
			}
		}
		return false;
	}

	public boolean enterMenuOption(String text) {
		try {
			browserFactory.getWait().until(ExpectedConditions
					.attributeContains(By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]"), "aria-label", text));
			inputTextBox.sendKeys(text);
			inputTextBox.sendKeys(Keys.ENTER);
			browserFactory.getWait().until(ExpectedConditions.attributeContains(By
					.xpath("(//div[@class='webchat__row message']//*[contains(@aria-label,'" + text + "')])[last()]"),
					"aria-label", text));
			return true;
		} catch (Exception e) {
			try {
				browserFactory.getWait().until(ExpectedConditions.attributeContains(
						By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]"), "aria-label", text));
				inputTextBox.sendKeys(text);
				inputTextBox.sendKeys(Keys.ENTER);
				browserFactory.getWait().until(ExpectedConditions.attributeContains(By.xpath(
						"(//div[@class='webchat__row message']//*[contains(@aria-label,'" + text + "')])[last()]"),
						"aria-label", text));
				return true;
			} catch (Exception e1) {
				return false;
			}
		}
	}

	public boolean clickOption(String option) {
		try {
			browserFactory.getWait().until(ExpectedConditions
					.textToBePresentInElement(By.xpath("//button//nobr[.='" + option + "']"), option));
			((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].click();",
					browserFactory.getDriver().findElement(By.xpath("//button//nobr[.='" + option + "']")));
			browserFactory.getWait().until(ExpectedConditions.attributeContains(By
					.xpath("(//div[@class='webchat__row message']//*[contains(@aria-label,'" + option + "')])[last()]"),
					"aria-label", option));
			return true;
		} catch (Exception e) {
			for (int i = 0; i < 2; i++) {
				try {
					if (browserFactory.getWait()
							.until(ExpectedConditions.attributeContains(
									By.xpath("(//div[@class='webchat__row message']//*[contains(@aria-label,'" + option
											+ "')])[last()]"),
									"aria-label", option))) {
						return true;
					}
				} catch (Exception e1) {
					try {
						((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].click();",
								browserFactory.getDriver().findElement(By.xpath("//button//nobr[.='" + option + "']")));
					} catch (Exception e2) {
					}
				}
			}
		}
		return false;
	}
	
	public CommonPage enterText(String text) {
		inputTextBox.sendKeys(text);
		inputTextBox.sendKeys(Keys.ENTER);
		browserFactory.getWait()
				.until(ExpectedConditions.attributeContains(By.xpath(
						"(//div[@class='webchat__row message']//*[contains(@aria-label,'" + text + "')])[last()]"),
						"aria-label", text));
		return this;
	}

	public boolean verifyMessageFromChatBot(String text) {
		return browserFactory.getWait()
				.until(ExpectedConditions.attributeContains(By.xpath(
						"(//div[@class='webchat__row message']//*[contains(@aria-label,'" + text + "')])[last()]"),
						"aria-label", text));
	}

	public CommonPage enterOption(String option) {
		try {
			browserFactory.getWait().until(ExpectedConditions
					.textToBePresentInElement(By.xpath("//button//nobr[.='" + option + "']"), option));
			inputTextBox.sendKeys(option);
			inputTextBox.sendKeys(Keys.ENTER);
			browserFactory.getWait().until(ExpectedConditions.attributeContains(By
					.xpath("(//div[@class='webchat__row message']//*[contains(@aria-label,'" + option + "')])[last()]"),
					"aria-label", option));

		} catch (Exception e) {
			browserFactory.getWait().until(ExpectedConditions
					.textToBePresentInElement(By.xpath("//button//nobr[.='" + option + "']"), option));
			inputTextBox.sendKeys(option);
			inputTextBox.sendKeys(Keys.ENTER);
			browserFactory.getWait().until(ExpectedConditions.attributeContains(By
					.xpath("(//div[@class='webchat__row message']//*[contains(@aria-label,'" + option + "')])[last()]"),
					"aria-label", option));
		}
		return this;
	}

	public CommonPage clickMenuButton(String text) {
		try {
			((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					browserFactory.getDriver()
							.findElement(By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]")));
			browserFactory.getWait().until(ExpectedConditions.attributeContains(
					By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]"), "aria-label", text));
			((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].click();", browserFactory
					.getDriver().findElement(By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]")));
		} catch (Exception e) {
			for (int i = 0; i < 2; i++) {

				try {
					if (browserFactory.getWait()
							.until(ExpectedConditions.attributeContains(
									By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]"), "aria-label",
									text))) {
						((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].click();",
								browserFactory.getDriver().findElement(
										By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]")));
						break;
					}
				} catch (Exception e1) {
					try {
						((JavascriptExecutor) browserFactory.getDriver()).executeScript(
								"arguments[0].scrollIntoView(true);", browserFactory.getDriver().findElement(
										By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]")));
						((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].click();",
								browserFactory.getDriver().findElement(
										By.xpath("(//button[contains(@aria-label,'" + text + "')])[last()]")));
					} catch (Exception e2) {
					}
				}
			}
		}
		return this;
	}

	public CommonPage clickMenuButton(String buttonText, String menuText) {
		try {
			((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					browserFactory.getDriver()
							.findElement(By.xpath("(//*[contains(@class,'adaptiveCard')]//p[contains(.,'" + menuText
									+ "')]/../../../../..//button[@aria-label='" + buttonText + "'])[last()]")));
			browserFactory.getWait()
					.until(ExpectedConditions.attributeContains(
							By.xpath("(//*[contains(@class,'adaptiveCard')]//p[contains(.,'" + menuText
									+ "')]/../../../../..//button[@aria-label='" + buttonText + "'])[last()]"),
							"aria-label", buttonText));
			((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].click();",
					browserFactory.getDriver()
							.findElement(By.xpath("(//*[contains(@class,'adaptiveCard')]//p[contains(.,'" + menuText
									+ "')]/../../../../..//button[@aria-label='" + buttonText + "'])[last()]")));
		} catch (Exception e) {
			for (int i = 0; i < 2; i++) {

				try {
					if (browserFactory.getWait()
							.until(ExpectedConditions.attributeContains(
									By.xpath("(//*[contains(@class,'adaptiveCard')]//p[contains(.,'" + menuText
											+ "')]/../../../../..//button[@aria-label='" + buttonText + "'])[last()]"),
									"aria-label", buttonText))) {
						((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].click();",
								browserFactory.getDriver()
										.findElement(By.xpath("(//*[contains(@class,'adaptiveCard')]//p[contains(.,'"
												+ menuText + "')]/../../../../..//button[@aria-label='" + buttonText
												+ "'])[last()]")));
						break;
					}
				} catch (Exception e1) {
					try {
						((JavascriptExecutor) browserFactory.getDriver()).executeScript(
								"arguments[0].scrollIntoView(true);",
								browserFactory.getDriver()
										.findElement(By.xpath("(//*[contains(@class,'adaptiveCard')]//p[contains(.,'"
												+ menuText + "')]/../../../../..//button[@aria-label='" + buttonText
												+ "'])[last()]")));
						((JavascriptExecutor) browserFactory.getDriver()).executeScript("arguments[0].click();",
								browserFactory.getDriver()
										.findElement(By.xpath("(//*[contains(@class,'adaptiveCard')]//p[contains(.,'"
												+ menuText
												+ "')]/../../../../..//button[@aria-label='"+buttonText+"'])[last()]")));
					} catch (Exception e2) {
					}
				}
			}
		}
		return this;
	}
	
	public boolean verifyTextBlockIsDisplayed(String text) {
		return browserFactory.getWait().until(ExpectedConditions
				.textToBePresentInElement(By.xpath("(//p[contains(.,'" + text + "')])[last()]"), text));
	}
}
