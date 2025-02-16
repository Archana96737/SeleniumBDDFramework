package com.qa.steps;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.hpsf.Property;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.qa.driver.Driverfactory;
import com.qa.pages.SignUpPage;
import com.qa.util.Configreader;
import com.qa.util.ExcelReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class SignupDefSteps {
	Configreader configreader=  new Configreader();
	SignUpPage signupPage= new SignUpPage(Driverfactory.getDriver());
	ExcelReader xslReader= new ExcelReader();
	@When("User eneters the mandory details")
	public void u_ser_eneters_the_mandory_details() {
		signupPage.FillRegistartionForm();
	}
	

	@When("User eneters the mandory details for sign up")
	public void u_ser_eneters_the_mandory_details_for_sign_up(DataTable table) {
		List<Map<String, String>> values = table.asMaps(String.class,String.class);
		signupPage.FillRegistartionFormDetails(values,0);
	}

	@When("User eneters the mandory details for sign up of {int} from {string}")
	public void user_eneters_the_mandory_details_for_sign_up_of_from(int Row_num, String sheetname) throws InvalidFormatException, IOException {
		String filepath=configreader.getPropertyValue("filebasePath")+sheetname+".xlsx";
		List<Map<String,String>> data=xslReader.getData(filepath, sheetname);
		signupPage.FillRegistartionFormDetails(data,Row_num-1);
	}
	@When("Click on {string} button in SignUp page")
	public void click_on_button_in_sign_up_page(String string) {
		signupPage.createAccount();
	}

}
