package com.qa.steps;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.driver.Driverfactory;
import com.qa.util.Configreader;

import io.cucumber.java.*;

public class HookDefSteps {

	Configreader configreader;
	Driverfactory driverFactory;
	public WebDriver driver;

	@Before(order = 0)
	public void readProperties() {
		configreader = new Configreader();
		//prop = config.init_prop();
	}

	@Before(order = 1)
	public void launchBroser() {
		String browserName = configreader.getPropertyValue("browser");
		driverFactory = new Driverfactory();
		driver = driverFactory.init_driver(browserName);
	}
	@AfterStep
	public void takeScreenshot(Scenario scenario) {

		// validate if scenario has failed
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) Driverfactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

	@After
	public void tearDown(Scenario scenario) {

		driver.quit();
	}
}
