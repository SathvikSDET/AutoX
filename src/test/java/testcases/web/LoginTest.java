package testcases.web;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import TestBase.TestBase;

import org.testng.annotations.BeforeMethod;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.ConfigManager;
import core.LogManagerHelper;
import core.WebExceptions;
import drivers.web.DriverFactory;
import drivers.web.iDriver;
import pages.web.Explore;
import pages.web.Login;
import pages.web.SideBar;


public class LoginTest extends TestBase{
	
	private WebDriver driver;
	private Login loginPage;
	private ConfigManager config;
	private SideBar sideBar;
	private Explore explore;
	
	
	@BeforeClass
	public void setUp() {
		config = ConfigManager.getConfig();
		LogManagerHelper.info("Initializing WebDriver...");
		driver =setUpBrowser();
		driver.manage().window().maximize();
		driver.get("https://x.com/login");
		loginPage = new Login(driver);
		LogManagerHelper.info("Test Setup Completed.");
	}
	
	
	@Test
	public void testValidation() throws WebExceptions, InterruptedException {
		LogManagerHelper.info("Starting valid login test...");
		loginPage.enterUsername(config.getProperty("username"));
		
		//Thread.sleep(10000);
	/*	if(loginPage.isDisplayed()) {
			loginPage.enterPhoneOrEmailInput(config.getProperty("email"));
		}
		Thread.sleep(10000);*/
		loginPage.enterPassword(config.getProperty("password"));
		LogManagerHelper.info("Valid Login Completed");
		
		
		LogManagerHelper.info("Clicking on Explore...");
		sideBar = new SideBar(driver);
		sideBar.initializElements();
		sideBar.clickExplore();
		Thread.sleep(5000);
		explore = new Explore(driver);
		explore.initializElements();
		List<String> trendingData= explore.getTrendingData();
		for (String string : trendingData) {
			System.out.println(string);
		}
		
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