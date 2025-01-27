package com.qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {	
	public WebDriver Tdriver;
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		System.out.println("Apllication is getting executed in "+browser+ " Browser");
		switch(browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;
		default :
			System.out.println(browser+ "Browser initialization not defined");
	
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	public static synchronized WebDriver getDriver() {
		return driver.get();
		
	}

}
