package TestBase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	private WebDriver driver;
	
	public Listener(WebDriver driver) {
        this.driver = driver;
    }

	@Override
	public void onTestFailure(ITestResult result) {
		if (driver != null) {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(screenshot, new File("./screenshot/" + result.getName() + ".png"));
				System.out.println("Screenshot saved: " + result.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
