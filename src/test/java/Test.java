import java.io.*;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Login and Save Cookies
        loginAndSaveCookies(driver, wait);
        driver.quit(); // Close the browser after saving cookies

        // Step 2: Open a new session and load cookies
        WebDriver driver2 = new ChromeDriver();
        WebDriverWait wait2 = new WebDriverWait(driver2, Duration.ofSeconds(10));

        driver2.get("https://x.com"); // Open the website
        loadCookies(driver2); // Load cookies
        driver2.navigate().refresh(); // Refresh to apply cookies
        
        // Now perform actions without logging in again
        System.out.println("Logged in successfully using cookies!");
    }

    public static void loginAndSaveCookies(WebDriver driver, WebDriverWait wait) throws IOException {
        driver.get("https://x.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Enter username
        WebElement entryUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='text']")));
        entryUser.sendKeys("demo92233654708");
        entryUser.sendKeys(Keys.ENTER);

        // Enter password
        WebElement entryPwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        entryPwd.sendKeys("987654321s");
        entryPwd.sendKeys(Keys.ENTER);

        // Wait until login is successful (Check if 'Explore' is visible)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Explore']")));
        
        // Save cookies
        saveCookies(driver);
    }

    public static void saveCookies(WebDriver driver) throws IOException {
        File file = new File("cookies.data");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        for (Cookie cookie : driver.manage().getCookies()) {
            writer.write(cookie.getName() + ";" + cookie.getValue() + ";" + 
                         cookie.getDomain() + ";" + cookie.getPath() + ";" + 
                         cookie.getExpiry() + ";" + cookie.isSecure());
            writer.newLine();
        }

        writer.close();
        System.out.println("Cookies saved successfully!");
    }

    public static void loadCookies(WebDriver driver) throws IOException {
        File file = new File("cookies.data");
        if (!file.exists()) {
            System.out.println("No cookies file found.");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            Cookie cookie = new Cookie(parts[0], parts[1], parts[2], parts[3], 
                                       null, Boolean.parseBoolean(parts[5]));
            driver.manage().addCookie(cookie);
        }

        reader.close();
        System.out.println("Cookies loaded successfully!");
    }
}
