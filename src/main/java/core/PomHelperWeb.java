package core;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PomHelperWeb {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public PomHelperWeb(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public WebElement findElement(WebElement element) throws WebExceptions {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			throw new WebExceptions(WebExceptions.ExceptionType.ELEMENT_NOT_FOUND,
					"Element not found or not visible: " + element);
		}
	}

	public List<WebElement> findElements(List<WebElement> elements) throws WebExceptions {
		try {
			return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			throw new WebExceptions(WebExceptions.ExceptionType.ELEMENT_NOT_FOUND,
					"Elements not found or not visible: " + elements);
		}
	}

	public void click(WebElement element) throws WebExceptions {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (Exception e) {
			throw new WebExceptions(WebExceptions.ExceptionType.ELEMENT_NOT_CLICKABLE,
					"Element is not clickable: " + element);
		}
	}

	public void sendKeys(WebElement element, String text) throws WebExceptions {
		try {
			WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
			ele.clear();
			ele.sendKeys(text);
		} catch (Exception e) {
			throw new WebExceptions(WebExceptions.ExceptionType.ACTION_FAILED,
					"Unable to send keys, element not found: " + element);
		}
	}

	public String getText(WebElement element) throws WebExceptions {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element)).getText();
		} catch (Exception e) {
			throw new WebExceptions(WebExceptions.ExceptionType.ACTION_FAILED,
					"Unable to get text, element not found: " + element);
		}
	}

	public boolean isElementDisplayed(WebElement element) {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
