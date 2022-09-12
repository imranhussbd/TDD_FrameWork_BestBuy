package com.bestbuy.qa.utils;

public class CreateAccountData {

	private String expectedText1;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String rePassword;
	private String expectedText2;
	private String number;

	public CreateAccountData(String expectedText1, String firstName, String lastName, String email, String password,
			String rePassword, String expectedText2, String number) {
		this.expectedText1 = expectedText1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.rePassword = rePassword;
		this.expectedText2 = expectedText2;
		this.number = number;
	}

	public String getExpectedText1() {
		return expectedText1;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public String getExpectedText2() {
		return expectedText2;
	}

	public String getNumber() {
		return number;
	}

}
