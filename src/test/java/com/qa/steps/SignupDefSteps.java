package com.qa.steps;


import com.qa.driver.Driverfactory;
import com.qa.pages.SignUpPage;

import io.cucumber.java.en.*;

public class SignupDefSteps {
	SignUpPage signupPage= new SignUpPage(Driverfactory.getDriver());
	@When("USer eneters the mandory details")
	public void u_ser_eneters_the_mandory_details() {
		signupPage.FillRegistartionForm();
	}

	@Then("Click on {string} button in SignUp page")
	public void click_on_button_in_sign_up_page(String string) {
		signupPage.createAccount();
	}

}
