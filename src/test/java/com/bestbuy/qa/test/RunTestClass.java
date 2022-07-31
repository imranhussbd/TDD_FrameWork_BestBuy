package com.bestbuy.qa.test;

import org.testng.annotations.Test;

import com.bestbuy.qa.base.BaseClass;

public class RunTestClass extends BaseClass {

	@Test
	public void getResults() {
		homePage.homepageSteps("PS5");

	}
}
