package com.qa.steps;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.driver.Driverfactory;
import com.qa.util.Configreader;

import io.cucumber.java.*;

public class HookDefSteps {
	
	Configreader config;
	Properties prop;
	Driverfactory driverFactory;
	public WebDriver driver;
	
	@Before(order=0)
	public void readProperties() {
		config= new Configreader();
		prop=config.init_prop();	
	}
	
	@Before(order=1)
	public void launchBroser() {
		String browserName=prop.getProperty("browser");
		driverFactory= new Driverfactory();
		driver=driverFactory.init_driver(browserName);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
