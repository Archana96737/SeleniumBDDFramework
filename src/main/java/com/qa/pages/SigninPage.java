package com.qa.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.Datatable;

public class SigninPage {

	private WebDriver driver;
	private String username;
	WebElement element;

	public SigninPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
	private WebElement signupLoginLink;

	@FindBy(xpath = "//h2[contains(text(),'New User Signup!')]")
	WebElement newUserSignUp;

	@FindBy(name = "name")
	WebElement name;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement email;

	@FindBy(xpath = "//button[.='Signup']")
	WebElement signUp;

	@FindBy(xpath = "//h2[.='Enter Account Information']")
	WebElement entrAccountInfo;

	@FindBy(xpath = "//h2[.='Account Created!']")
	WebElement accountCreted;
	
	@FindBy(xpath="//div[@class='pull-right']")
	WebElement continuebtn;

	@FindBy(xpath ="//li[10]//a[1]" )
	WebElement loggedinUser;

	@FindBy(xpath = "//a[.=' Delete Account']")
	WebElement deleteAccount;
	
	@FindBy(xpath = "//h2[.='Account Deleted!']")
	WebElement accountdeleted;

	public String getTitle() {
		return driver.getTitle();
	}

	public void ClickElement(String name) {

		switch (name) {
		case "Signup / Login":
			element = signupLoginLink;
			break;
		case "Signup":
			element = signUp;
			break;
		case "Continue":
			element=continuebtn;
			break;
		case "Delete Account":
			element=deleteAccount;
			break;
		default:
			System.out.println("Element not present");
		}
		element.click();
	}

	public boolean ElementVisible(String element) {
		if (element.equals("New User Signup!")) {
			if (newUserSignUp.isDisplayed()) {
				System.out.println(element + " is Visible...");
				return true;
			}

		} else if (element.equals("ENTER ACCOUNT INFORMATION")) {
			if (entrAccountInfo.isDisplayed()) {
				System.out.println(element + " is Visible...");
				return true;
			}
		} else if (element.equals("Account Created!")) {
			if(accountCreted.isDisplayed()) {
				System.out.printf("%s is visible",element);
				return true;
			}

		} else if (element.equals("Logged in User")) {
			if (loggedinUser.getText().equals("Logged in as "+username)) {
				System.out.printf("%s is visible", element);
				return true;
			}

		} else if (element.equals("Account Deleted!")) {
			if (accountdeleted.isDisplayed()) {
				System.out.printf("%s is visible", element);
				return true;
			}

		
	}
		System.out.println(element+" Not Visible");
		return false;

	}

	public void TyeText() {
		name.sendKeys("ARCHANADEVI KN");
		email.sendKeys("archanadevikn@gmail.com");

	}

	public void TypeText(Datatable element) {
		username= element.getName();
		CommonPageActions.typeKeys(name, element.getName());
		CommonPageActions.typeKeys(email, element.getEmail());
//		CommonPageActions.typeKeys(name, data.get(0).get("Name"));
//		CommonPageActions.typeKeys(email, data.get(0).get("Email"));
	}

}
