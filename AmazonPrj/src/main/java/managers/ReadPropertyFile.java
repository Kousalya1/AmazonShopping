package managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	private static Properties properties = new Properties();
	private static final String PROPERTIES_FILE = "src\\main\\resources\\envConfigs\\config.properties";

	static {
		try {
			FileInputStream ip = new FileInputStream(PROPERTIES_FILE);
			properties.load(ip);
		} catch (IOException e) {
			throw new RuntimeException("Property file is not found" + e);
		}
	}

	public static String getAmazonUrl() {
		return properties.getProperty("amazon.url");
	}

	public static String getAmazonUsername() {
		return properties.getProperty("amazon.username");
	}

	public static String getAmazonPassword() {
		try {
			return PasswordHandler.decrypt(properties.getProperty("amazon.password"));
		} catch (Exception e) {
			throw new RuntimeException("Not able to decrypt the catproductivity password : "
					+ properties.getProperty("catproductivity.password"));
		}
	}

	public static String getChromeDriver() {
		return properties.getProperty("chrome.driver");
	}

	public static String getChromeDriverPath() {
		return properties.getProperty("chrome.driverPath");
	}

	public static String getIncorrectUsername() {
		return properties.getProperty("incorrectUsername");
	}

	public static String getIncorrectPassword() {
		return properties.getProperty("incorrectPassword");
	}

	public static String getIncorrectUsernameErrorMsg() {
		return properties.getProperty("incorrectUsernameErrorMsg");
	}

	public static String getIncorrectPwdErrorMsg() {
		return properties.getProperty("incorrectPasswordErrorMsg");
	}

}
