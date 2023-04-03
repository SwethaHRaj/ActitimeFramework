package testBase;

import org.openqa.selenium.WebDriver;

public class LocalDriverFactory {

	// Singleton Design Pattern
	private static LocalDriverFactory instance = new LocalDriverFactory();

	private LocalDriverFactory() {
	}

	public static LocalDriverFactory getInstance() {
		return instance;
	}

	// Factory Design Pattern
	ThreadLocal<WebDriver> localDriver = new ThreadLocal<WebDriver>();

	public void setLocalDriver(WebDriver driver) {
		localDriver.set(driver);
	}

	public WebDriver getLocalDriver() {
		return localDriver.get();
	}

	public void closeLocalDriver() {
		localDriver.get().close();
		localDriver.remove();
	}

}
