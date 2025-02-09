package pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.LogManagerHelper;
import core.PomHelperWeb;
import core.WebExceptions;

public class SideBar extends PomHelperWeb {

	private WebElement explore ;
	
	public void initializElements() throws WebExceptions {
		this.explore = getDynamicElement("Explore");
	}


	public SideBar(WebDriver driver) {
		super(driver);
	}

	public String getTextExplore() throws WebExceptions {
		String text = getText(explore);
		LogManagerHelper.info("Explore text: " + text);
		return text;
	}
	
	public void clickExplore() throws WebExceptions {
		LogManagerHelper.info("SideBar Explore clicked");
		click(explore);
	}

}
