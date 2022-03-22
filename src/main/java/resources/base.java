package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	// Global Variables 
	public  WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initializeDriver(String browserName) throws IOException
	{
		if(browserName.equals("chrome")){
			//System.setProperty("webdriver.chrome.driver", "/Users/svc/Documents/SEL/chromedriver");
	        WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless");
			
			driver = new ChromeDriver(options);
		}
		else if (browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			//options.addArguments("--headless");
			
			driver = new FirefoxDriver(options);
		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
}


	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		
		return destinationFile;
	}
	

}
