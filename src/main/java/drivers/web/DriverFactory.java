package drivers.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.google.common.base.Supplier;
import core.LogManagerHelper;

public class DriverFactory implements iDriver {

    private static final String GRID_URL = System.getProperty("gridURL", "http://localhost:4444/wd/hub");

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
    public WebDriver getLocalDriver(String browser) {
        LogManagerHelper.info("Requested browser: " + browser);
        Supplier<WebDriver> browserDriver = map.get(browser.toLowerCase());
        if (browserDriver == null) {
            LogManagerHelper.error("Unsupported browser: " + browser);
            throw new WebDriverException("Unsupported browser: " + browser);
        }
        WebDriver driver = browserDriver.get();
        LogManagerHelper.info("WebDriver initialized successfully");
        return driver;
    }

    @Override
    public WebDriver getRemoteBrowser(ChromeOptions options) {
        return createRemoteWebDriver(options);
    }

    @Override
    public WebDriver getRemoteBrowser(FirefoxOptions options) {
        return createRemoteWebDriver(options);
    }

    private WebDriver createRemoteWebDriver(MutableCapabilities options) {
        try {
            LogManagerHelper.info("Initializing RemoteWebDriver with options: " + options.toString());
            URL gridUrl = new URL(GRID_URL);
            return new RemoteWebDriver(gridUrl, options);
        } catch (MalformedURLException e) {
            LogManagerHelper.error("Invalid Selenium Grid URL: " + GRID_URL);
            throw new WebDriverException("Invalid Selenium Grid URL", e);
        }
    }
}
