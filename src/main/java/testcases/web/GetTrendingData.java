package testcases.web;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestBase.TestBase;
import core.LogManagerHelper;
import core.WebExceptions;
import drivers.web.DriverFactory;
import drivers.web.iDriver;
import pages.web.Explore;
import pages.web.SideBar;

public class GetTrendingData {
	
	
	
	private WebDriver driver;
	private iDriver driverFactory;
	private SideBar sideBar;
	private Explore explore;
	
	
	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
		LogManagerHelper.info("Initializing WebDriver...");
		driverFactory = new DriverFactory();
		driver = driverFactory.getdriver("chrome");
		driver.manage().window().maximize();
		driver.get("https://x.com/home");
		TestBase.loadCookies(driver);
		driver.navigate().refresh();
		LogManagerHelper.info("Test Setup Completed.");
	}
	
	
	
	@Test
	public void testValidation() throws WebExceptions, InterruptedException, IOException {
		LogManagerHelper.info("Starting Get Trending Data test...");
		LogManagerHelper.info("Clicking on Explore...");
		sideBar = new SideBar(driver);
		sideBar.initializElements();
		sideBar.clickExplore();
		Thread.sleep(10000);
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
			TestBase.deleteAllCookiesAndQuit(driver);
		}
		LogManagerHelper.info("Test "+this.getClass().getSimpleName()+" execution completed");
		
		
	}
	

}
