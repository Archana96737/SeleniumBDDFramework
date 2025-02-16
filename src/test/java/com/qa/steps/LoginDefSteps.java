package com.qa.steps;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.qa.driver.Driverfactory;
import com.qa.pages.LoginPage;
import com.qa.util.Configreader;
import com.qa.util.DatatablePOJO;
import com.qa.util.ExcelReader;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;

public class LoginDefSteps {
	Configreader configreader=new Configreader();
	private LoginPage login= new LoginPage(Driverfactory.getDriver());
	@Given("User is logged into automation Excercise portal")
	public void user_is_logged_into_automation_excercise_portal() {
//		DriverFactory.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Driverfactory.getDriver().get("https://automationexercise.com");
	}
	
	@Then("Verify that home page is visible successfully")
	public void verify_that_home_page_is_visible_successfully() {
	    String homePageTitle="Automation Exercise";
	    System.out.println("Page title is: " + login.getTitle());
	    Assert.assertEquals(login.getTitle(), homePageTitle);;
	}
	
	@When("Click on {string} button")
	public void click_on_button(String webElement) {
		login.ClickElement(webElement);
	}
	
	@Then("Verify {string} is visible")
	public void verify_is_visible(String element) {
		boolean elePresent=login.ElementVisible(element);
		Assert.assertTrue(elePresent);
		
	}
	@When("Enter name and email address")
	public void enter_name_and_email_address() {
		login.TyeText();	
	}
	
	@DataTableType(replaceWithEmptyString = "[anonymous]")
	public DatatablePOJO readDetails(Map<String,String> values) {
		return new DatatablePOJO(
				values.get("name"),
				values.get("email")
				);
		
	}
	@When("Enter name and email address details")
	public void When_Enter_name_and_email_address_details(List<DatatablePOJO> elements) {
		for(DatatablePOJO element : elements) {
			login.TypeText(element);
		}
		
	}
	@When("Enter name and email address details of {int} from {string}")
	public void enter_name_and_email_address_details_of_from(int row_num, String sheetname) throws InvalidFormatException, IOException {
		ExcelReader xslreader = new ExcelReader();
		String filepath=configreader.getPropertyValue("filebasePath")+sheetname+".xlsx";
		List<Map<String,String>> data=xslreader.getData(filepath, sheetname);
		login.TypeText(data,row_num-1);
	}
	
	}
	


