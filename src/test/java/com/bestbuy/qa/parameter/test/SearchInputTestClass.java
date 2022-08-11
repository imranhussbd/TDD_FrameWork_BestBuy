package com.bestbuy.qa.parameter.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bestbuy.qa.base.BaseClass;

public class SearchInputTestClass extends BaseClass {
	
	@Parameters("searchValue")
	@Test
	public void inputSearch(String searchValue) {
		homePage.homepageSteps(searchValue);
		ps5PackagePage.ps5PgSteps("PlayStation 5 Consoles and Accessories", "https://www.bestbuy.com/site/playstation-5/playstation-5-packages/pcmcat1588107358954.c?id=pcmcat1588107358954");
	}
}
