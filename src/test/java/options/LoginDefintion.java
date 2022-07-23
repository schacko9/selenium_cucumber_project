package options;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.testng.Assert;

import io.cucumber.junit.Cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


@RunWith(Cucumber.class)
public class LoginDefintion extends base{
	
	public static Logger log = LogManager.getLogger(LoginDefintion.class.getName());

	
	@Given("Intitilize the browser with {string}")
	public void intitilize_the_browser_with(String string) throws IOException {
		driver = initializeDriver(string);	
		log.info("Driver is Initialized");
	}
	
	
	@Given("Navigate to {string} site")
	public void navigate_to_site(String string) {
		driver.get(string);
		log.info("Navigated to Home Page");
	}
	
	
	@Given("Click on Login link in home page to land on Sign in Page")
	public void click_on_login_link_in_home_page_to_land_on_sign_in_page() throws Throwable {
		
		LandingPage land = new LandingPage(driver);
		if(land.getPopupSize()>0){
			land.getPopup();
		}
		
		land.getSignin();
		log.info("Landed on Sign-in Page");
	}
	
	
	@When("User enters {string} and {string} and logs in")
	public void user_enters_username_and_password_and_logs_in(String Username, String Password) throws Throwable {
		
		LoginPage login = new LoginPage(driver); 										// Get Login Page from Landing Page Page Object
		login.getEmail(Username)					 									// Using Login Page Object to give email
			 .getPassword(Password)			     										// Using Login Page Object to give password
			 .getLogin();
		
		log.info("Logged In");
	}
	
	@When("Verify that {string} is successfully reset password")
	public void verify_that_username_is_successfully_reset_password(String Username) throws Throwable {
		
		LoginPage login = new LoginPage(driver); 
		ForgotPassword forgot = new ForgotPassword(driver);	
		
		login.forgotPassword();
		forgot.getEmail(Username);
		forgot.sendMeInstructions();
		
		log.info("Forgot Password");
	}

	
	@When("Title is Validated")
    public void title_is_validated() throws Throwable {
		LandingPage land = new LandingPage(driver);
		if(land.getPopupSize()>0){
			land.getPopup();
		}
		
		try {
			String title = land.getTitle();
			Assert.assertEquals(title, "FEATURED COURSES");     						// Correct Assertion				
			
			log.info("AppTitle: Test Complete");
		}
		catch(Exception e){
			log.info("AppTitle: Test Failed");
		}
		
		
    }


    @When("Navigaton Bar is Validated")
    public void navigaton_bar_is_validated() throws Throwable {
    	LandingPage land = new LandingPage(driver);
		if(land.getPopupSize()>0){
			land.getPopup();
		}
		
	    Assert.assertTrue(land.getNavigationBar().isDisplayed());						// Compare the text from the browser with actual text.
	    	log.info("AppNavBar: Test completed");
    }
    

    @Then("Close browsers")
    public void close_browsers() throws Throwable {
		driver.quit();	
		log.info("Driver Closed");
	}
    
}
