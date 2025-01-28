package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonPageActions {
	private WebDriver driver;

	public CommonPageActions(WebDriver driver) {
		this.driver=driver;
	}
	
	public static void clickElement(WebElement element) {
		element.click();
	}
	
	public static void typeKeys(WebElement element,String message) {
		element.sendKeys(message);
	}
	
	public static void SelectDropdown(WebElement element, String Value) {
		Select select= new Select(element);
		select.selectByValue(Value);
	}
		
}
