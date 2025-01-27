package com.qa.steps;


import org.junit.Assert;

import com.qa.driver.Driverfactory;
import com.qa.pages.SigninPage;

import io.cucumber.java.en.*;

public class LoginDefSteps {
	private SigninPage login= new SigninPage(Driverfactory.getDriver());
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
	
}

