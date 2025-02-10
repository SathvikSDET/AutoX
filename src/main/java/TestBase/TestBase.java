package TestBase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import core.LogManagerHelper;

public class TestBase {

	public static void saveCookies(WebDriver driver) throws IOException {
		File file = new File("cookies.data");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Cookie cookie : driver.manage().getCookies()) {
	        String expiry = (cookie.getExpiry() != null) ? cookie.getExpiry().toString() : "null";
	        writer.write(cookie.getName() + ";" + cookie.getValue() + ";" +
	                     cookie.getDomain() + ";" + cookie.getPath() + ";" + 
	                     expiry + ";" + cookie.isSecure());
	        writer.newLine();
	    }

	        writer.close();
		LogManagerHelper.info("Cookies saved");

	}

	public static void loadCookies(WebDriver driver) throws IOException {
	    File file = new File("cookies.data");
	    if (!file.exists()) {
	        LogManagerHelper.warn("No cookies file found. Login may be required.");
	        return;
	    }

	    BufferedReader reader = new BufferedReader(new FileReader(file));
	    String line;

	    while ((line = reader.readLine()) != null) {
	        String[] parts = line.split(";");
	        Cookie cookie = new Cookie(parts[0], parts[1], parts[2], parts[3], 
	                                   parts[4].equals("null") ? null : new Date(parts[4]), 
	                                   Boolean.parseBoolean(parts[5]));
	        driver.manage().addCookie(cookie);
	        LogManagerHelper.info("Loaded cookie: " + parts[0]);
	    }

	    reader.close();
	    LogManagerHelper.info("Cookies loaded successfully!");
	}
	public static void deleteAllCookiesAndQuit(WebDriver driver) {
		driver.manage().deleteAllCookies();
		driver.quit();

		File file = new File("cookies.data");
		if (!file.exists() && file.delete()) {
			LogManagerHelper.info("Deleted cookies.data");
		} else {
			LogManagerHelper.warn("No Cookies.data to delete");
		}

		LogManagerHelper.info("All cookies deleted!");
	}

}
