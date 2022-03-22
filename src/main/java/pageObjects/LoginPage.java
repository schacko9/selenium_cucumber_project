package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	// Global Variable
	public WebDriver driver;
	
	By email = By.cssSelector("[id='user_email']");
	By password = By.cssSelector("[type='password']");
	By login = By.cssSelector("[value='Log In']");
	By forgotPassword = By.cssSelector("[href*='password/new/index.php']");
	
	
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	

	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement forgotPassword()
	{
		return driver.findElement(forgotPassword);
	}
	
	
	
}
