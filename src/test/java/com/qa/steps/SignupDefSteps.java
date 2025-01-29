package com.qa.steps;


import java.util.List;
import java.util.Map;

import com.qa.driver.Driverfactory;
import com.qa.pages.SignUpPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class SignupDefSteps {
	SignUpPage signupPage= new SignUpPage(Driverfactory.getDriver());
	@When("USer eneters the mandory details")
	public void u_ser_eneters_the_mandory_details() {
		signupPage.FillRegistartionForm();
	}
	@When("USer eneters the mandory details for sign up")
	public void u_ser_eneters_the_mandory_details_for_sign_up(DataTable table) {
		List<Map<String, String>> values = table.asMaps(String.class,String.class);
		signupPage.FillRegistartionFormDetails(values);
	}

	@When("Click on {string} button in SignUp page")
	public void click_on_button_in_sign_up_page(String string) {
		signupPage.createAccount();
	}

}
