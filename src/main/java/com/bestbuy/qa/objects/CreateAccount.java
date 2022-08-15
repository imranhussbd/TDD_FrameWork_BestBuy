package com.bestbuy.qa.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bestbuy.qa.common.Commons;
import com.bestbuy.qa.utils.AutoData;

public class CreateAccount {

	WebDriver driver;
	Commons commons;

	public CreateAccount(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

	@FindBy(tagName = "h1")
	WebElement createAccTextElement;

	@FindBy(className = "mini-header__logo")
	WebElement logoElement;

	@FindBy(name = "firstName")
	WebElement firstNamElement;

	@FindBy(name = "lastName")
	WebElement lastNamElement;

	@FindBy(name = "email")
	WebElement emailElement;

	@FindBy(name = "fld-p1")
	WebElement passwordElement;

	@FindBy(name = "reenterPassword")
	WebElement redoPasswordElement;

	@FindBy(css = "span.c-input-error-message.cdi-input-success-message")
	WebElement matchPassword;

	@FindBy(name = "phone")
	WebElement phoneNumElement;

	@FindBy(xpath = "//button[text()='Create an Account']")
	WebElement createAccButtonElement;

	// @FindBy(linkText = "Sorry, something went wrong. Please try
	// again.")WebElement errorElement;

	private void getTitle(String expectedTitle) {
		assertEquals(commons.getTitle(driver), expectedTitle);
	}

	private void getHeadingText(String expectedText1) {
		assertEquals(commons.getText(createAccTextElement), expectedText1);
	}

	private void logoDisplayed() {
		commons.isDisplayed(logoElement);
	}

	private void inputFirstName(String firstName) {
		commons.inputValues(firstNamElement, firstName);
	}

	private void inputLastName(String lastName) {
		commons.inputValues(lastNamElement, lastName);
	}

	private void inputEmail(String email) {
		commons.inputValues(emailElement, email);
	}

	private void inputPassword(String password) {
		commons.inputValues(passwordElement, password);
	}

	private void reputPassword(String rePassword) {
		commons.inputValues(redoPasswordElement, rePassword);
	}

	private void getPasswordMatchText(String expectedText2) {
		assertEquals(commons.getText(matchPassword), expectedText2);
	}

	private void inputPhoneNum(String number) {
		commons.inputValues(phoneNumElement, number);
	}

	private void createAccButtonIsEnabled() {
		commons.buttonEnabled(createAccButtonElement);
	}

	private void clickCreateAccount() {
		commons.click(createAccButtonElement);
	}

	/*
	 * private void getErrorText(String expectedError) {
	 * assertEquals(commons.getText(errorElement), expectedError); }
	 */

	public void createAccountSteps(String expectedTitle, String expectedText1, String firstName, String lastName,
			String email, String password, String rePassword, String expectedText2, String number) {
		getTitle(expectedTitle);
		getHeadingText(expectedText1);
		logoDisplayed();
		inputFirstName(firstName);
		inputLastName(lastName);
		inputEmail(email);
		inputPassword(password);
		reputPassword(rePassword);
		getPasswordMatchText(expectedText2);
		inputPhoneNum(number);
		createAccButtonIsEnabled();
		clickCreateAccount();
		// getErrorText(expectedError);
	}

	public void createAccountSteps(AutoData autoData) {
		getHeadingText(autoData.getExpectedText1());
		logoDisplayed();
		inputFirstName(autoData.getFirstName());
		inputLastName(autoData.getLastName());
		inputEmail(autoData.getEmail());
		inputPassword(autoData.getPassword());
		reputPassword(autoData.getRePassword());
		getPasswordMatchText(autoData.getExpectedText2());
		inputPhoneNum(autoData.getNumber());
		createAccButtonIsEnabled();
		//clickCreateAccount();
		// getErrorText(expectedError);
	}
	
	public void createAccountSteps2(String expectedText1, String firstName, String lastName,
			String email, String password, String rePassword, String expectedText2, String number) {
		getHeadingText(expectedText1);
		logoDisplayed();
		inputFirstName(firstName);
		inputLastName(lastName);
		inputEmail(email);
		inputPassword(password);
		reputPassword(rePassword);
		getPasswordMatchText(expectedText2);
		inputPhoneNum(number);
		createAccButtonIsEnabled();
		clickCreateAccount();
		// getErrorText(expectedError);
	}

}
