import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		//demo92233654708
		//987654321s
		WebDriver driver = new ChromeDriver();
		driver.get("https://x.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement entryUser = driver.findElement(By.xpath("//input[@name='text']"));
		entryUser.sendKeys("demo92233654708");
		Thread.sleep(5000);
		entryUser.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		WebElement entrypwd= driver.findElement(By.xpath("//input[@name='password']"));
		entrypwd.sendKeys("987654321s");
		
		entrypwd.sendKeys(Keys.ENTER);
		driver.quit();
		
		
	}

}
