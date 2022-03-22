package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	// Global Variable
	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By NavBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By popup = By.xpath("//button[text()='NO THANKS']");


	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
	}

	
	
	public LoginPage getSignin()
	{
		driver.findElement(signin).click();
		LoginPage login = new LoginPage(driver); 
		return login;
	}
	

	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
	
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public int getPopupSize()
	{
		return driver.findElements(popup).size();
	}
	
	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}
	
}
