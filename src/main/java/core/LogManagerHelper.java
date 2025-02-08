package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogManagerHelper {
	
	private static Logger getLogger() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }

    public static void info(String msg) { getLogger().info(msg); }
    public static void warn(String msg) { getLogger().warn(msg); }
    public static void error(String msg) { getLogger().error(msg); }
    public static void debug(String msg) { getLogger().debug(msg); }
    public static void fatal(String msg) { getLogger().fatal(msg); }
	

}
