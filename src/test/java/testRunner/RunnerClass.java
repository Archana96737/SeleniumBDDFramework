package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//@Listeners(ExtentReporterListener.class)
@CucumberOptions(
		features={"src/test/resources/Features"},
		glue={"com.qa.steps"}
//		,tags= "@SC2"
		, plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}	
		, dryRun=false
		)


public class RunnerClass extends AbstractTestNGCucumberTests {

	
}

