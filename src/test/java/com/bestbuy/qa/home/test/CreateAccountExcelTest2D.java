package com.bestbuy.qa.home.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bestbuy.qa.base.BaseClass;
import com.bestbuy.qa.utils.ExcelUtil;

public class CreateAccountExcelTest2D extends BaseClass {

	@DataProvider(name = "autoData2DExcel")
	public Object[][] autoData() {
		String pathString = configuration.get("excelPath");
		String sheetNameString = configuration.get("excelSheet");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		return excelUtil.dataObjects();
	}

	@Test(enabled = true, dataProvider = "autoData2DExcel")
	public void accountExcel2D(String expectedText1, String firstName, String lastName, String email, String password,
			String rePassword, String expectedText2, String number) {
		homePage.homepageAccountSteps();
		createAccount.createAccountSteps2(expectedText1, firstName, lastName, email, password, rePassword,
				expectedText2, number);
	}
}
