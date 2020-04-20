package com.test.common;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.test.baseclass.BaseClass;
import com.test.model.UserDataModel;
import com.test.pages.CommonPage;
import com.test.pages.LoginPage;
import com.test.pages.PasswordPage;
import com.test.utility.GetUserData;

public class ComonActions extends BaseClass {
	private LoginPage loginPage = new LoginPage();
	private PasswordPage passwordPage = new PasswordPage();
	private CommonPage commonPage = new CommonPage();

	public ComonActions performLogin(String userName, String password, String userType) {
		loginPage.enterUserName(userName).clickNextButton();
		passwordPage.enterPassword(password).clickNextButton();
		if (System.getProperty("env").equals("dev")) {
			try {
				passwordPage.clickAcceptButton();
			} catch (Exception e) {

			}
		}
		browserFactory.getWait().until(ExpectedConditions.visibilityOf(commonPage.welcomeMessageTextBlock));
		return this;
	}
}