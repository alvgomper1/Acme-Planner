/*
 * SignUpTest.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.authenticated.userAccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AuthenticatedUpdateUserTest extends AcmePlannerTest {

	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/userAccount/update-negative-empty.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeUpdatePasswordEmpty(final String password, final String confirmation, final String name, final String surname, final String email) {
		
		super.signIn("manager1", "manager1");
		super.clickOnMenu("Account", "General data");
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmitButton("Update");
		super.checkErrorsExist();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/userAccount/passwords.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeUpdatePasswordWrongLenght(final String password) {
		super.signIn("manager1", "manager1");
		super.clickOnMenu("Account", "General data");
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", password);
		super.clickOnSubmitButton("Update");
		super.checkErrorsExist();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/userAccount/update-negative-passConfirmNotMatch.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(40)
	public void negativeUpdatePasswordAndConfirmationNotMatch(final String password, final String confirmation, final String name, final String surname, final String email) {
		
		super.signIn("manager1", "manager1");
		super.clickOnMenu("Account", "General data");
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmitButton("Update");
		super.checkErrorsExist();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/userAccount/update-negative-empty.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(50)
	public void negativeUpdateNameSurnameEmpty(final String password, final String confirmation, final String name, final String surname, final String email) {
		
		super.signIn("manager1", "manager1");
		super.clickOnMenu("Account", "General data");
		super.fillInputBoxIn("identity.name", name);
		super.fillInputBoxIn("identity.surname", surname);
		super.clickOnSubmitButton("Update");
		super.checkErrorsExist();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/userAccount/update-negative-wrongEmail.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(60)
	public void negativeUpdateEmailWrongFormat(final String password, final String confirmation, final String name, final String surname, final String email) {
		
		super.signIn("manager1", "manager1");
		super.clickOnMenu("Account", "General data");
		super.fillInputBoxIn("identity.email", email);
		super.clickOnSubmitButton("Update");
		super.checkErrorsExist();
	}

	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/userAccount/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(70)
	public void positiveUpdate(final String password, final String confirmation, final String name, final String surname, final String email) {
		
		super.signIn("manager1", "manager1");
		super.clickOnMenu("Account", "General data");
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", confirmation);
		super.fillInputBoxIn("identity.name", name);
		super.fillInputBoxIn("identity.surname", surname);
		super.fillInputBoxIn("identity.email", email);
		super.clickOnSubmitButton("Update");
		

	}
}
	