package com.bestbuy.qa.home.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bestbuy.qa.base.BaseClass;
import com.bestbuy.qa.utils.CreateAccountData;
import com.bestbuy.qa.utils.ExcelUtil;



public class AccountTestExcelData extends BaseClass{

	@DataProvider(name = "excelAutoData")
	public Iterator<CreateAccountData> autoData(){
		String pathString = configuration.get("excelPath");
		String sheetNameString = configuration.get("excelSheet");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		String[][] objects = excelUtil.dataObjects();
		List<CreateAccountData> list = new ArrayList<CreateAccountData>();
		for(int i = 0; i < objects.length; i++) {
			CreateAccountData autoData  = new CreateAccountData(objects[i][0],objects[i][1], objects[i][2], objects[i][3],objects[i][4],
					objects[i][5], objects[i][6],objects[i][7]);
			list.add(autoData);
		}
		return list.iterator();
	}
	
	@Test(enabled = true, dataProvider = "excelAutoData")
	public void getAutoExelMap(CreateAccountData autoData) {
		homePage.homepageAccountSteps();
		createAccount.createAccountSteps(autoData);
	}
}
