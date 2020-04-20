package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.test.baseclass.BaseClass;

public class LoginPage extends BaseClass {
	@FindBy(id = "i0116")
	public WebElement userNameTextBox;

	@FindBy(css = "input[value='Next']")
	public WebElement nextButton;

	public LoginPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	public LoginPage enterUserName(String email) {
		try {
			browserFactory.getWait().until(ExpectedConditions.visibilityOf(userNameTextBox))
					.sendKeys(email);
		} catch (Exception e) {
			browserFactory.getWait().until(ExpectedConditions.visibilityOf(userNameTextBox))
					.sendKeys(email);
		}
		return this;
	}

	public LoginPage clickNextButton() {
		try {
			browserFactory.getWait().until(ExpectedConditions.visibilityOf(nextButton))
					.click();
		} catch (Exception e) {
			browserFactory.getWait().until(ExpectedConditions.visibilityOf(nextButton))
					.click();
		}
		return this;
	}
}
