import core.LogManagerHelper;

public class demo {
public static void main(String[] args) {
	
	/*System.out.println((System.getProperty("user.dir")+File.separator+"config"+File.separator+"config.properties"));
	ConfigManager c = ConfigManager.getConfig();
	System.out.println(c.getProperty("username"));
	*/
	
	
	
	

	 LogManagerHelper.info("Test execution started.");
     LogManagerHelper.debug("Debugging mode enabled.");
     LogManagerHelper.warn("This is a warning message.");
     LogManagerHelper.error("An error occurred.");
     LogManagerHelper.fatal("Fatal issue detected.");
	
}
}
