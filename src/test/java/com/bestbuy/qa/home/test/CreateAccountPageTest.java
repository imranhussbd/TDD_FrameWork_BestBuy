package com.bestbuy.qa.home.test;

import org.testng.annotations.Test;


import com.bestbuy.qa.base.BaseClass;

public class CreateAccountPageTest extends BaseClass {

	@Test(enabled = true)
	public void createAccountResults() {
		homePage.homepageAccountSteps();
		createAccount.createAccountSteps("Best Buy: Create an Account", "Create an Account", "Aniki",
				"Saske", "test@testng.com", "classname123", "classname123", "Your passwords match!", "2125558989");
	}
}
