package TestBase;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryRule implements IRetryAnalyzer {
	int currentCount = 0;
	private final int maxCount = 2;

	@Override
	public boolean retry(ITestResult result) {
		if( currentCount < maxCount) {
			currentCount++;
			return true;
		}
		
		return false;
	}
	

}
