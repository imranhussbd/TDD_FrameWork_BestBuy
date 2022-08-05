package com.bestbuy.qa.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bestbuy.qa.common.Commons;

public class Ps5PackagePage {

	WebDriver driver;
	Commons commons;

	public Ps5PackagePage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;

	}

	@FindBy(tagName = "h1")
	WebElement titlElement;

	@FindBy(xpath = "(//button[@class = 'c-button c-button-disabled c-button-md c-button-block add-to-cart-button'])[1]")
	WebElement ps5SoldOutElement;

	@FindBy(xpath = "(//button[@class = 'c-button c-button-disabled c-button-md c-button-block add-to-cart-button'])[2]")
	WebElement ps5DigitalSoldOutElement;

	private void getTitle(String expected) {
		assertEquals(commons.getText(titlElement), expected);
	}

	private void getCurrentUrl(String expectedUrl) {
		assertEquals(commons.getCurrentUrl(driver), expectedUrl);
	}

	private void ps5SoldOutButtonDisabled() {
		commons.buttonEnabled(ps5SoldOutElement);
	}

	private void ps5DigitalSoldOutButtonDisabled() {
		commons.buttonEnabled(ps5DigitalSoldOutElement);
	}

	public void ps5PgSteps(String expected, String expectedUrl) {
		getTitle(expected);
		getCurrentUrl(expectedUrl);
		ps5SoldOutButtonDisabled();
		ps5DigitalSoldOutButtonDisabled();
	}

}
