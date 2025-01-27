package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {

	private WebDriver driver;
	WebElement element;
	public SigninPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Signup / Login')]")
	private WebElement signupLoginLink;
	
	@FindBy(xpath="//h2[contains(text(),'New User Signup!')]")
	WebElement newUserSignUp;
	
	@FindBy(name="name")
	WebElement name;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement email;
	
	@FindBy(xpath="//button[.='Signup']")
	WebElement signUp;
	
	@FindBy (xpath="//h2[.='Enter Account Information']")
	WebElement entrAccountInfo;
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void ClickElement(String name) {
		
		switch(name) {
			case "Signup / Login":
				element=signupLoginLink;
				break;
			case "Signup":
				element=signUp;
				break;
			default:
				System.out.println("Element not present");
		}
		element.click();	
	}	
	
	public boolean ElementVisible(String element) {
		if (element.equals("New User Signup!")){
			if(newUserSignUp.isDisplayed()) {
				System.out.println(element+" is Visible...");
				return true;
			}
			
		}
		else if (element.equals("ENTER ACCOUNT INFORMATION")){
			if(entrAccountInfo.isDisplayed()) {
				System.out.println(element+" is Visible...");
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
	
}
