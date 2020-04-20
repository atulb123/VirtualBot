package com.test.missions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.test.baseclass.BaseClass;
import com.test.baseclass.BrowserFactory;
import com.test.pages.CommonPage;

public class PestMission extends BaseClass {
	private CommonPage commonPage = new CommonPage();

	public boolean verifyQRGLinkisDisplayedWhenMenuSelected(String menu) {
		commonPage.clickMenuOption(menu);
		try {
			return browserFactory.getWait().until(ExpectedConditions.textToBePresentInElement(By.xpath(
					"//div[@class='webchat__row attachment']//button[@aria-label='Quick Reference Guide']/../../../..//p[contains(.,'"
							+ menu + "')]"),
					menu));
		} catch (Exception e) {
			System.out.println(1.3);
			return false;
		}
	}

	public boolean verifyQRGLinkisDisplayedWhenEntered(String menu) {
		commonPage.enterMenuOption(menu);
		try {
			return browserFactory.getWait().until(ExpectedConditions.textToBePresentInElement(
					By.xpath("//div[@class='webchat__row attachment']//button[@aria-label='Quick Reference Guide']/../../../..//p[contains(.,'"+menu+"')]"), menu));
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyQRGLinkisDisplayedWhenPestNameEnteredDirectly(String menu) {
		commonPage.enterText(menu);
		try {
			return browserFactory.getWait().until(ExpectedConditions.textToBePresentInElement(
					By.xpath("//div[@class='webchat__row attachment']//button[@aria-label='Quick Reference Guide']/../../../..//p[contains(.,'"+menu+"')]"), menu));
		} catch (Exception e) {
			return false;
		}
	}
}
