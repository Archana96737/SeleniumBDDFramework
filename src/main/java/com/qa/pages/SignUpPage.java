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
	
	private void selectTitle(String title) {
		if(title.toUpperCase().equals("MR")) {
			CommonPageActions.clickElement(titleMr);
		}
		else {
			CommonPageActions.clickElement(titleMrs);	
		}
	}
	public void FillRegistartionForm() {
		CommonPageActions.clickElement(titleMr);
		CommonPageActions.typeKeys(password, "Krish@123");
		CommonPageActions.SelectDropdown(days, "20");
		CommonPageActions.SelectDropdown(month, "4");
		CommonPageActions.SelectDropdown(year, "1906");
		CommonPageActions.clickElement(newsletterchbox);
		CommonPageActions.clickElement(splOfferChbox);

		CommonPageActions.typeKeys(first_name, "Krish");
		CommonPageActions.typeKeys(last_name, "Dev");
		CommonPageActions.typeKeys(company, "Luxsoft");
		CommonPageActions.typeKeys(address, "Gemini HOUSE");
		CommonPageActions.typeKeys(country, "India");
		CommonPageActions.typeKeys(state, "Kerala");
		CommonPageActions.typeKeys(city, "Wayanad");
		CommonPageActions.typeKeys(zipcode, "680581");
		CommonPageActions.typeKeys(mobile_number, "6389422502");
	}
	
	public void createAccount() {
		CommonPageActions.clickElement(CreateAccount);
	}

	public void FillRegistartionFormDetails(List<Map<String, String>> data,int row_num) {
		selectTitle(data.get(row_num).get("title"));
		CommonPageActions.typeKeys(password,data.get(row_num).get("password"));
		CommonPageActions.SelectDropdown(days, data.get(row_num).get("days"));
		CommonPageActions.SelectDropdown(month, data.get(row_num).get("month"));
		CommonPageActions.SelectDropdown(year, data.get(row_num).get("year"));
		CommonPageActions.clickElement(newsletterchbox);
		CommonPageActions.clickElement(splOfferChbox);

		CommonPageActions.typeKeys(first_name, data.get(row_num).get("first_name"));
		CommonPageActions.typeKeys(last_name, data.get(row_num).get("last_name"));
		CommonPageActions.typeKeys(company, data.get(row_num).get("company"));
		CommonPageActions.typeKeys(address, data.get(row_num).get("address"));
		CommonPageActions.typeKeys(country, data.get(row_num).get("country"));
		CommonPageActions.typeKeys(state, data.get(row_num).get("state"));
		CommonPageActions.typeKeys(city, data.get(row_num).get("city"));
		CommonPageActions.typeKeys(zipcode,data.get(row_num).get("zipcode"));
		CommonPageActions.typeKeys(mobile_number, data.get(row_num).get("mobile_number"));
	}

	

	

}
