package com.bestbuy.qa.home.test;

import static com.bestbuy.qa.utils.DataMap.Email;
import static com.bestbuy.qa.utils.DataMap.FirstName;
import static com.bestbuy.qa.utils.DataMap.LastName;
import static com.bestbuy.qa.utils.DataMap.Number;
import static com.bestbuy.qa.utils.DataMap.Password1;
import static com.bestbuy.qa.utils.DataMap.Password2;
import static com.bestbuy.qa.utils.DataMap.Text1;
import static com.bestbuy.qa.utils.DataMap.Text2;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bestbuy.qa.base.BaseClass;
import com.bestbuy.qa.utils.ExcelUtil;

public class AutoTestMapDataProvider extends BaseClass {

	@DataProvider(name = "excelMap")
	public Object[][] mapData() {
		String pathString = configuration.get("excelPath");
		String sheetNameString = configuration.get("excelSheetMap");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		int size = excelUtil.dataMap().size();
		Object[][] objects2d = new Object[size][1];
		for (int i = 0; i < size; i++) {
			objects2d[i][0] = excelUtil.dataMap().get(i);
		}
		return objects2d;
	}

	@Test(enabled = false, dataProvider = "excelMap")
	public void getAutoExelMapWithDataProvider(Map<String, String> map) {
		homePage.homepageAccountSteps();
		createAccount.createAccountSteps2(map.get("Header Title"), map.get("First Name"), map.get("Last Name"),
				map.get("Email"), map.get("Password"), map.get("Confirm Password"), map.get("Sub-Text"),
				map.get("Number"));
	}

	@Test(enabled = false, dataProvider = "excelMap")
	public void getAutoExelMapWithEnum(Map<String, String> map) {
		homePage.homepageAccountSteps();
		createAccount.createAccountSteps2(map.get(Text1.name()), map.get(FirstName.getValue()),
				map.get(LastName.getValue()), map.get(Email.getValue()), map.get(Password1.getValue()),
				map.get(Password2.getValue()), map.get(Text2.name()), map.get(Number.getValue()));
	}
	
	@Test(enabled = true, dataProvider = "excelMap")
	public void getAutoExelMapWithDataMap(Map<String, String> map) {
		homePage.homepageAccountSteps();
		createAccount.createAccountSteps(map);
	}
}
