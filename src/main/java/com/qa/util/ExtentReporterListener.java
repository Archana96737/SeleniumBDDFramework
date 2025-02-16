package com.qa.util;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.driver.Driverfactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReporterListener implements ITestListener {
	private static ExtentReports extent;
	private static ExtentTest test;

	@Override
	public void onStart(org.testng.ITestContext context) {
		// Initialize the ExtentReports object at the start of the tests
		ExtentSparkReporter reporter = new ExtentSparkReporter("target/extent-reports/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", System.getProperty("user.name"));
	}

	@Override
	public void onFinish(org.testng.ITestContext context) {
		// Flush the reports after all tests are completed
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// Create a new test in ExtentReports for each test case
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Log success information in the report
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Log failure information in the report and include the exception message
//		test.log(Status.FAIL, "Test failed: " + result.getThrowable());
		String screenshotName = result.getName();
		try {
			//This takes a screenshot from the driver at save it to the specified location
			File sourcePath = ((TakesScreenshot) Driverfactory.getDriver()).getScreenshotAs(OutputType.FILE);
			
			//Building up the destination path for the screenshot to save
			//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
			String destinationPath = System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png";
		
			//Copy taken screenshot from source location to destination location
			Files.copy(sourcePath.toPath(), Paths.get(destinationPath));   

			//This attach the specified screenshot to the test
			test.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(destinationPath).build());
            
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// Log skipped test information
		test.log(Status.SKIP, "Test skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
}


