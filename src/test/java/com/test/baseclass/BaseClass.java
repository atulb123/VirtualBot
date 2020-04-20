package com.test.baseclass;

import java.util.concurrent.TimeUnit;

import org.testng.Reporter;

import com.test.utility.GetPropertiesData;

public class BaseClass {
	public static BrowserFactory browserFactory = BrowserFactory.getInstance();
	public void launchBrowser() throws Exception {
		browserFactory.setDriver(
				Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser"));
		browserFactory.setWait(browserFactory.getDriver(), 20);
		if(!(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser").equalsIgnoreCase("android")||Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser").equalsIgnoreCase("iphone")))
		browserFactory.getDriver().manage().window().maximize();
		if(System.getProperty("env").equals("dev"))
		browserFactory.getDriver().get(GetPropertiesData.getPropertyValue("devurl"));
		else if (System.getProperty("env").equals("stage"))
		browserFactory.getDriver().get(GetPropertiesData.getPropertyValue("stageurl"));	
		browserFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}