package com.bestbuy.qa.home.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bestbuy.qa.base.BaseClass;
import com.bestbuy.qa.utils.AutoData;

public class AccountAutoDataTest extends BaseClass {

	@DataProvider(name = "autoDataIterator")
	public Iterator<AutoData> autoDataIterator() {
		List<AutoData> list = new ArrayList<AutoData>();
		AutoData autoData1 = new AutoData("Create an Account", "Aniki", "Saske", "test@testng.com", "classname123",
				"classname123", "Your passwords match!", "2125558989");
		AutoData autoData2 = new AutoData("Create an Account", "Bankai", "Ichigo", "test1@testng.com", "bleachname123",
				"bleachname123", "Your passwords match!", "2125553423");
		list.add(autoData1);
		list.add(autoData2);
		return list.iterator();
	}

	@DataProvider(name = "autoDataObject")
	public Object[][] autoDataObject() {
		AutoData autoData1 = new AutoData("Create an Account", "Aniki", "Saske", "test@testng.com", "classname123",
				"classname123", "Your passwords match!", "2125558989");
		AutoData autoData2 = new AutoData("Create an Account", "Bankai", "Ichigo", "test1@testng.com", "bleachname123",
				"bleachname123", "Your passwords match!", "2125553423");
		return new Object[][] { { autoData1 }, { autoData2 } };
	}

	@Test(enabled = true, dataProvider = "autoDataObject")
	public void autoCreateData(AutoData autoData) {
		homePage.homepageAccountSteps();
		createAccount.createAccountSteps(autoData);

	}
}
