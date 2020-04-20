package com.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.test.baseclass.BaseClass;

public class EvaHomePage extends BaseClass {

	@FindBy(xpath = "(//input[contains(@placeholder,'Search for articles')])[2]")
	public WebElement DosageTextBlock;

	public EvaHomePage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}
}
