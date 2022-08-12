package com.bestbuy.qa.home.test;

import org.testng.annotations.Test;


import com.bestbuy.qa.base.BaseClass;

public class HomeTestClass extends BaseClass {
	
	@Test
	public void getResults() {
		homePage.homepageSteps("Best Buy | Official Online Store | Shop Now & Save", "PS5");
		ps5PackagePage.ps5PgSteps("PlayStation 5 Consoles and Accessories", "https://www.bestbuy.com/site/playstation-5/playstation-5-packages/pcmcat1588107358954.c?id=pcmcat1588107358954");

	}
}
