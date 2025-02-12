package drivers.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public interface iDriver {
    WebDriver getLocalDriver(String browser);
    WebDriver getRemoteBrowser(ChromeOptions options);
    WebDriver getRemoteBrowser(FirefoxOptions options);
}
