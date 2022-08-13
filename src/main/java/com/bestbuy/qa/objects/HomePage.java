package com.bestbuy.qa.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bestbuy.qa.common.Commons;

public class HomePage {
	WebDriver driver;
	Commons commons;

	public HomePage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;

	}

	@FindBy(id = "gh-search-input")
	WebElement searchElement;

	@FindBy(className ="header-search-button")
	WebElement searchButtonElement;

	@FindBy(xpath = "//a[text() = 'Shop Featured PS5']")
	WebElement shopFtP5ButtonElement;
	
	@FindBy(xpath = "//span[text()='Account']")
	WebElement accountElement;
	
	@FindBy(xpath = "//a[text()='Create Account']")
	WebElement createAccElement;
	
	private void getTitle(String expectedTitle) {
		assertEquals(commons.getTitle(driver), expectedTitle);
	}

	private void inputSearch(String value) {
		commons.inputValues(searchElement, value);
	}

	private void clickSearch() {
	commons.click(searchButtonElement);
	}

	private void clickShopFtPs5() {
		commons.click(shopFtP5ButtonElement);
	}
	
	private void clickAccount() {
		commons.click(accountElement);
	}
	
	private void clickCreateAcc() {
		commons.click(createAccElement);
	}

	public void homepageSteps(String expectedTitle, String value) {
		getTitle(expectedTitle);
		inputSearch(value);
		clickSearch();
		clickShopFtPs5();
	}
	
	public void homepageSteps(String value) {
		inputSearch(value);
		clickSearch();
		clickShopFtPs5();
	}
	
	public void homepageAccountSteps() {
		clickAccount();
		clickCreateAcc();
		
	}
}
