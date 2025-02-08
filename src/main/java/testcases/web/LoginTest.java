package testcases.web;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.ConfigManager;
import core.LogManagerHelper;
import core.WebExceptions;
import drivers.web.DriverFactory;
import drivers.web.iDriver;
import pages.web.Login;


public class LoginTest {
	
	private WebDriver driver;
	private iDriver driverFactory;
	private Login loginPage;
	private ConfigManager config;
	
	
	@BeforeClass
	public void setUp() {
		config = ConfigManager.getConfig();
		LogManagerHelper.info("Initializing WebDriver...");
		driverFactory = new DriverFactory();
		driver = driverFactory.getdriver("chrome");
		driver.manage().window().maximize();
		driver.get("https://x.com/login");
		loginPage = new Login(driver);
		LogManagerHelper.info("Test Setup Completed.");
	}
	
	
	@Test
	public void testValidation() throws WebExceptions, InterruptedException {
		LogManagerHelper.info("Starting valid login test...");
		loginPage.enterPassword(config.getProperty("username"));
		
		Thread.sleep(10000);
		if(loginPage.isDisplayed()) {
			loginPage.enterPhoneOrEmailInput(config.getProperty("email"));
		}
		Thread.sleep(10000);
		loginPage.enterPassword(config.getProperty("password"));
		LogManagerHelper.info("Valid Login Completed");
	}
	
	@AfterClass
	public void tearDown() {
		LogManagerHelper.info("Closeing Webdriver");
		if(driver != null) {
			driver.quit();
		}
		LogManagerHelper.info("Test "+this.getClass().getSimpleName()+" execution completed");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
      

}
