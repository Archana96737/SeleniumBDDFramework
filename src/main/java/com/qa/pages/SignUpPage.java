package com.qa.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	private WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='uniform-id_gender1']")
	WebElement titleMr;
	
	@FindBy(xpath="//div[@id='uniform-id_gender2']")
	WebElement titleMrs;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="days")
	WebElement days;
	
	@FindBy(name="months")
	WebElement month;
	
	@FindBy(name="years")
	WebElement year;
	
	@FindBy(name="newsletter")
	WebElement newsletterchbox;
	
	@FindBy(name="optin")
	WebElement splOfferChbox;
	

	@FindBy(xpath="//input[@id='first_name']")
	WebElement first_name;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement last_name;
	
	@FindBy(xpath="//input[@id='company']")
	WebElement company;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement address;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement country;
			
	@FindBy(xpath="//input[@id='state']")
	WebElement state;
			
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement zipcode;
			
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement mobile_number;
	
	@FindBy(xpath="//button[contains(text(),\"Create Account\")]")
	WebElement CreateAccount;
	
	public void FillRegistartionForm() {
		CommonPageActions.clickElement(titleMrs);
		CommonPageActions.typeKeys(password, "Archana@123");
		CommonPageActions.SelectDropdown(days, "29");
		CommonPageActions.SelectDropdown(month, "4");
		CommonPageActions.SelectDropdown(year, "1996");
		CommonPageActions.clickElement(newsletterchbox);
		CommonPageActions.clickElement(splOfferChbox);

		CommonPageActions.typeKeys(first_name, "Archanadevi");
		CommonPageActions.typeKeys(last_name, "KN");
		CommonPageActions.typeKeys(company, "TCS");
		CommonPageActions.typeKeys(address, "KANARA HOUSE");
		CommonPageActions.typeKeys(country, "India");
		CommonPageActions.typeKeys(state, "Kerala");
		CommonPageActions.typeKeys(city, "Thrissur");
		CommonPageActions.typeKeys(zipcode, "680581");
		CommonPageActions.typeKeys(mobile_number, "8281805256");
	}
	
	public void createAccount() {
		CommonPageActions.clickElement(CreateAccount);
	}

	public void FillRegistartionFormDetails(List<Map<String, String>> data) {
		
		CommonPageActions.clickElement(titleMr);
		CommonPageActions.typeKeys(password,data.get(0).get("password"));
		CommonPageActions.SelectDropdown(days, data.get(0).get("days"));
		CommonPageActions.SelectDropdown(month, data.get(0).get("month"));
		CommonPageActions.SelectDropdown(year, data.get(0).get("year"));
		CommonPageActions.clickElement(newsletterchbox);
		CommonPageActions.clickElement(splOfferChbox);

		CommonPageActions.typeKeys(first_name, data.get(0).get("first_name"));
		CommonPageActions.typeKeys(last_name, data.get(0).get("last_name"));
		CommonPageActions.typeKeys(company, data.get(0).get("company"));
		CommonPageActions.typeKeys(address, data.get(0).get("address"));
		CommonPageActions.typeKeys(country, data.get(0).get("country"));
		CommonPageActions.typeKeys(state, data.get(0).get("state"));
		CommonPageActions.typeKeys(city, data.get(0).get("city"));
		CommonPageActions.typeKeys(zipcode,data.get(0).get("zipcode"));
		CommonPageActions.typeKeys(mobile_number, data.get(0).get("mobile_number"));
	}
	

}
