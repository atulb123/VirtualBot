package com.test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.test.baseclass.BaseClass;

public class PasswordPage extends BaseClass {
	@FindBy(id = "i0118")
	public WebElement passwordTextBox;

	@FindBy(css = "input[value='Sign in']")
	public WebElement signinButton;

	@FindBy(css = "input[value='Accept']")
	public WebElement acceptButton;

	public PasswordPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	public PasswordPage enterPassword(String password) {
		try {
		browserFactory.getWait().until(ExpectedConditions.visibilityOf(passwordTextBox)).sendKeys(password);
		}
		catch(Exception e)
		{
			browserFactory.getWait().until(ExpectedConditions.visibilityOf(passwordTextBox)).sendKeys(password);
		}
		return this;
	}

	public PasswordPage clickNextButton() {
		try {
		browserFactory.getWait().until(ExpectedConditions.visibilityOf(signinButton)).click();
		}
		catch(Exception e)
		{
			browserFactory.getWait().until(ExpectedConditions.visibilityOf(signinButton)).click();
		}
		return this;
	}

	public PasswordPage clickAcceptButton() {
		try {
		browserFactory.getWait().until(ExpectedConditions.visibilityOf(acceptButton)).sendKeys(Keys.ENTER);
		}
		catch(Exception e)
		{
			browserFactory.getWait().until(ExpectedConditions.visibilityOf(acceptButton)).sendKeys(Keys.ENTER);
		}
		return this;
	}
}
