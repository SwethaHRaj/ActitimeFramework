package testBase;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestFactory {

	// Singleton Design Pattern
	private static ExtentTestFactory instance = new ExtentTestFactory();

	private ExtentTestFactory() {
	}

	public static ExtentTestFactory getInstance() {
		return instance;
	}

	// Factory Design Pattern
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void setExtentTest(ExtentTest extentTest) {
		this.extentTest.set(extentTest);
	}

	public ExtentTest getExtentTest() {
		return extentTest.get();
	}

	public void removeExtentTest() {
		extentTest.remove();
	}
}
