package com.test.hooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.google.common.io.Files;
import com.test.baseclass.BaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BaseClass {

	@Before("@Hooks")
	public void browserInitialization(Scenario scenario) throws Throwable {
		scenario.write(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser"));
		launchBrowser();
	}

	@After("@Hooks")
	public void closeBrowser(Scenario scenario) throws Exception {
		try {
			if (scenario.isFailed()) {
				final byte[] screenshot = ((TakesScreenshot) BaseClass.browserFactory.getDriver())
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				//takeScreenShot(scenario);
			}
		} catch (Exception e) {
		}
		browserFactory.removeDriver();
	}
	
	public void takeScreenShot(Scenario scenario) throws IOException
	{
		Calendar calendar = Calendar.getInstance();
	    SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File srcFile=((TakesScreenshot) BaseClass.browserFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		File destFile = new File("./target/surefire-reports/"+Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser")+"_"+scenario.getName()+"_"+formater.format(calendar.getTime())+".png");
		Files.copy(srcFile, destFile);
		Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='400' width='400'/> </a>");
	}
}
