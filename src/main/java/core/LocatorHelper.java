package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LocatorHelper {

    private static final String LOCATOR_FILE_PATH = "config/locators.txt"; 
    private static final Map<String, String> locators = new HashMap<>();

    static {
        loadLocators();
    }

    private static void loadLocators() {
        try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+LOCATOR_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 3);
                if (parts.length == 3) {
                    String key = parts[0];
                    locators.put(key, parts[1] + ":" + parts[2]); // Store as type:value
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading locators from file: " + e.getMessage(), e);
        }
    }

    public static String getLocator(String key) {
        return locators.get(key);
    }

    public static LocatorType getLocatorType(String key) {
        String locator = locators.get(key);
        if (locator != null) {
            return LocatorType.fromString(locator.split(":")[0]);
        }
        throw new IllegalArgumentException("Locator not found for key: " + key);
    }

    public static String getLocatorValue(String key) {
        String locator = locators.get(key);
        if (locator != null) {
            return locator.split(":", 2)[1];
        }
        throw new IllegalArgumentException("Locator value not found for key: " + key);
    }
}
