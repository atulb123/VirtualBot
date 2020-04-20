package com.test.missions;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.test.baseclass.BaseClass;
import com.test.context.Context;
import com.test.pages.CommonPage;

public class ProductsMission extends BaseClass {

	private CommonPage commonPage = new CommonPage();
	private Context context = new Context();

	public boolean verifyTechincalInformation(String menuText) {
		String parentWindow = browserFactory.getDriver().getWindowHandle();
		commonPage.clickMenuButton(menuText);
		for (String window : browserFactory.getDriver().getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				browserFactory.getDriver().switchTo().window(window);
				break;
			}
		}
		browserFactory.getWait().until(ExpectedConditions.urlContains(menuText));
		context.setContextParam("url", browserFactory.getDriver().getCurrentUrl());
		browserFactory.getDriver().close();
		browserFactory.getDriver().switchTo().window(parentWindow);
		return context.getContextParam("url").contains(menuText);
	}
}
