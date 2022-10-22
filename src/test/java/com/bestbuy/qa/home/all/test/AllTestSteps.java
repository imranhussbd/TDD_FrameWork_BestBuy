package com.bestbuy.qa.home.all.test;

import org.testng.annotations.Test;


import com.bestbuy.qa.base.BaseClass;

public class AllTestSteps  extends BaseClass{

	@Test(groups = "ps5")
	public void ps5PackageVerify() {
		homePage.homepageSteps("Best Buy | Official Online Store | Shop Now & Save", "PS5");
		ps5PackagePage.ps5PgSteps("PlayStation 5 Consoles and Accessories", "https://www.bestbuy.com/site/playstation-5/playstation-5-packages/pcmcat1588107358954.c?id=pcmcat1588107358954");

	}
	
	@Test(groups = "account")
	public void createAccVerfied() {
		homePage.homepageAccountSteps();
		createAccount.createAccountSteps("Best Buy: Create an Account", "Create an Account", "Aniki",
				"Saske", "test@testng.com", "classname123", "classname123", "Your passwords match!", "2125558989");
	}
}
