package options;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)																							//JUnit
@CucumberOptions(
		features = "src/test/java/options/Login.feature",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		//tags = "@Login",
		//tags = "@Title",
		//tags = "@NavBar",
		//tags = "@Validate",
		//tags = "@Regression",
		monochrome = true,
		dryRun = false
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
