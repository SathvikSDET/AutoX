package drivers.web;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.google.common.base.Supplier;
import core.LogManagerHelper;

public class DriverFactory implements iDriver {

    private static final Supplier<WebDriver> CHROME = () -> {
        LogManagerHelper.info("Initializing ChromeDriver...");
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> FIREFOX = () -> {
        LogManagerHelper.info("Initializing FirefoxDriver...");
        return new FirefoxDriver();
    };

    private static final Supplier<WebDriver> SAFARI = () -> {
        LogManagerHelper.info("Initializing SafariDriver...");
        return new SafariDriver();
    };

    private static final Map<String, Supplier<WebDriver>> map = new HashMap<>();

    static {
        map.put("chrome", CHROME);
        map.put("firefox", FIREFOX);
        map.put("safari", SAFARI);
    }

    @Override
    public WebDriver getdriver(String browser) {
    	LogManagerHelper.info("Requested browser: " + browser);
    	Supplier<WebDriver> browserDriver = map.get(browser.toLowerCase());
    	if(browserDriver == null) {
    		LogManagerHelper.error("Unsupported browser: "+browser);
    		throw new WebDriverException("Unsupported browser: "+browser);	
    	}
    	WebDriver driver = browserDriver.get();
    	LogManagerHelper.info("Webdriver initilized successfully");
        return driver;
    }
}
