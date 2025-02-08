package pages.web;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.LogManagerHelper;
import core.PomHelperWeb;
import core.WebExceptions;

public class Login extends PomHelperWeb {

    @FindBy(xpath = "//input[@name='text']") 
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']") 
    private WebElement password;

    @FindBy(xpath = "//input[@name='text']") 
    private WebElement phoneOrEmailInput;

    public Login(WebDriver driver) {
        super(driver);
    }
    public boolean isDisplayed() {
    	return phoneOrEmailInput.isDisplayed();
    }

    public void enterUsername(String user) throws WebExceptions {
        LogManagerHelper.info("Entering username: " + user);
        findElement(username).clear();
        findElement(username).sendKeys(user);
        findElement(username).sendKeys(Keys.ENTER);
    }

    public void enterPassword(String pass) throws WebExceptions {
        LogManagerHelper.info("Entering password: ********"); // Masking password for security
        findElement(password).clear();
        findElement(password).sendKeys(pass);
        findElement(password).sendKeys(Keys.ENTER);
    }

    public void enterPhoneOrEmailInput(String pass) throws WebExceptions {
        LogManagerHelper.info("Entering phone Or Email: ");
        findElement(phoneOrEmailInput).clear();
        findElement(phoneOrEmailInput).sendKeys(pass);
        findElement(phoneOrEmailInput).sendKeys(Keys.ENTER);
    }

    public void login(String user, String pass) throws WebExceptions {
        LogManagerHelper.info("Performing login with username: " + user);
        enterUsername(user);
        enterPassword(pass);
        LogManagerHelper.info("Login attempt completed.");
    }
}
