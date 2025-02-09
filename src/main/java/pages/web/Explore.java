package pages.web;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.LogManagerHelper;
import core.PomHelperWeb;
import core.WebExceptions;

public class Explore extends PomHelperWeb{
	
	//locators
	private WebElement trending;
	private List<WebElement> trendingData;

	public void initializElements() throws WebExceptions, InterruptedException {
		LogManagerHelper.info("Explore Page Element initialized");
		this.trending = getDynamicElement("Trending");
		Thread.sleep(10000);
		click(this.trending);
		Thread.sleep(10000);
		this.trendingData  = getDynamicElements("TreadingData");
	}
	
	
	public Explore(WebDriver driver) {
		super(driver);
	}
	
	public void clickTrending() throws WebExceptions {
		LogManagerHelper.info("Clicked on Treding");
		click(trending);
	}
	
	
	
	public List<String> getTrendingData() {
		LogManagerHelper.info("Fetching treanding data...");
		List<String> dataList = trendingData.stream().map(ele -> ele.getText())
													.limit(2)
														
														.collect(Collectors.toList());
		LogManagerHelper.info("Treanding Data"+dataList);
		return dataList;	
	}
	
}
