package com.bestbuy.qa.common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.bestbuy.qa.reporting.Loggers;



public class Commons {
	
	WebDriver driver;
	CommonWaits waits;

	public void inputValues(WebElement element, String value) {
		try {
			element.sendKeys(value);
			Loggers.getLog(value + " : This values has been passed into ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
	}
	
	public void click(WebElement element) {
		try {
			waits.waitUntilClickable(element);
			element.click();
			Loggers.getLog(element + " ---> This element has been clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
	}
	
	public String getText(WebElement element) {
		String valueString = null;
		try {
			valueString = element.getText();
			Loggers.getLog(element + " ---> This element has text : " + valueString);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
		return valueString;
	}
	
	public String getCurrentUrl(WebDriver driver) {
		Loggers.getLog("Current URL is : " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
	
	public String getTitle(WebDriver driver) {
		Loggers.getLog("The Title of the page is : " + driver.getTitle());
		return driver.getTitle();
	}
	
	public boolean buttonEnabled(WebElement element) {
		boolean button = false;
		try {
			button = element.isEnabled();
			Loggers.getLog(element + " ---> This element is enabled : " + button);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
		return button;
		
		
	}
}
