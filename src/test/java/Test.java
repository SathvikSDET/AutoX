import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		//demo92233654708
		//987654321s
	    WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://x.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Wait for username input and enter username
        WebElement entryUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='text']")));
        entryUser.sendKeys("demo92233654708");
        entryUser.sendKeys(Keys.ENTER);

        // Wait for password input to be visible
        WebElement entryPwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        entryPwd.sendKeys("987654321s");
        entryPwd.sendKeys(Keys.ENTER);

        // Wait for the 'Explore' button to be clickable
        WebElement exploreButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Explore']")));
        exploreButton.click();
        
        // Wait for the 'Explore' button to be clickable
        WebElement Trending = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Trending']")));
        Trending.click();
		
		
		
		
		
	}

}
