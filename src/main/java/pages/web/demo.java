package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.LocatorHelper;
import core.LocatorType;

public class demo {
	private WebDriver driver;
	public static void main(String[] args) {
		
		
		LocatorType type = LocatorHelper.getLocatorType("username");
		System.out.println(type);
        String value = LocatorHelper.getLocatorValue("username");
        System.out.println(value);

		
	}

	
	
    
}
