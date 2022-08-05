package com.bestbuy.qa.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bestbuy.qa.common.Commons;

public class HomePage {

	Commons commons;

	public HomePage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;

	}

	@FindBy(id = "gh-search-input")
	WebElement searchElement;

	@FindBy(className = "header-search-button")
	WebElement searchButtonElement;

	@FindBy(xpath = "//a[text() = 'Shop Featured PS5']")
	WebElement shopFtP5ButtonElement;

	private void inputSearch(String value) {
		commons.inputValues(searchElement, value);
	}

	private void clickSearch() {
		commons.click(searchButtonElement);
	}

	private void clickShopFtPs5() {
		commons.click(shopFtP5ButtonElement);
	}

	public void homepageSteps(String value) {
		inputSearch(value);
		clickSearch();
		clickShopFtPs5();
	}
}
