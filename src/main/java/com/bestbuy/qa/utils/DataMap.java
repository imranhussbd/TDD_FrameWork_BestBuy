package com.bestbuy.qa.utils;

public enum DataMap {

	Text1("Header Title"), FirstName("First Name"), LastName("Last Name"), Email("Email"), Password1("Password"),
	Password2("Confirm Password"), Text2("Sub-Text"), Number("Number");

	private String value;

	private DataMap(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}