package com.test.acceptancetest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "com.test" }, tags = {
		"@TC001" }, plugin = {"json:target/cucumber-reports/CucumberTestReportIphone.json"})

@Test
public class RunTestIphone extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
