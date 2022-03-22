package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomepage {

	// Global Variable
	public WebDriver driver;
	
	By searchbox = By.name("query");
	
	
	
	public PortalHomepage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public WebElement getSearchBox() 
	{
		return driver.findElement(searchbox);	
	}
}
	
