package core;

public enum BrowserType {
	CHROME, FIREFOX, EDGE, SAFARI;

	public static BrowserType fromString(String browser) {

		try {
			return BrowserType.valueOf(browser.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Unsupported browser type: " + browser, e);
		}

	}

}
