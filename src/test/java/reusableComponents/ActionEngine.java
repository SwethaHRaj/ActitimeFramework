package reusableComponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import testBase.ExtentTestFactory;
import testBase.LocalDriverFactory;

public class ActionEngine {

	public void sendKeys_Custom(WebElement element, String fieldName, String value) {
		try {
			element.sendKeys(value);
			ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS,
					fieldName + "--> " + value + " entered successfully");
		} catch (Exception e) {
			ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL,
					fieldName + "--> " + value + " not entered due to exception" + e);
		}
	}

	public void click_Custom(WebElement element, String fieldName) {
		try {
			element.click();
			ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS, fieldName + "--> Clicked successfully");
		} catch (Exception e) {
			ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL,
					fieldName + "--> not Clicked due to exception" + e);
		}
	}

	public void clear_Custom(WebElement element, String fieldName) {
		try {
			element.clear();
			ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS, fieldName + "--> Cleared successfully");
		} catch (Exception e) {
			ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL,
					fieldName + "--> not Cleared due to exception" + e);
		}
	}

	public void isDisplayed_Custom(WebElement element, String fieldName) {
		try {
			element.isDisplayed();
			ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS, fieldName + "--> Displayed");
		} catch (Exception e) {
			ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL, fieldName + "--> Not Displayed" + e);
		}
	}

	public void isEnabled_Custom(WebElement element, String fieldName) {
		try {
			element.isEnabled();
			ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS, fieldName + "--> Enabled");
		} catch (Exception e) {
			ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL, fieldName + "--> Not Enabled" + e);
		}
	}

	public void moveToElement_Custom(WebElement element, String fieldName) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) LocalDriverFactory.getInstance().getLocalDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			Actions a = new Actions(LocalDriverFactory.getInstance().getLocalDriver());
			a.moveToElement(element).build().perform();
			ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS,
					fieldName + "--> mouse hovered successfully");
		} catch (Exception e) {
			ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL,
					fieldName + "--> mouse not hovered due to exception" + e);
		}
	}

	public void selectDropdownByValue_Custom(WebElement element, String fieldName, String value) {
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS,
					fieldName + "--> " + value + " selected successfully");
		} catch (Exception e) {
			ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL,
					fieldName + "--> " + value + " not selected due to exception" + e);
		}
	}

	public void selectDropdownByVisibleText_Custom(WebElement element, String fieldName, String visibleText) {
		try {
			Select s = new Select(element);
			s.selectByVisibleText(visibleText);
			ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS,
					fieldName + "--> " + visibleText + " selected successfully");
		} catch (Exception e) {
			ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL,
					fieldName + "--> " + visibleText + " not selected due to exception" + e);
		}
	}

	public void assertEqualsString_Custom(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
			ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS,
					actual + " and " + expected + " Matched successfully");
		} catch (Exception e) {
			ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL,
					actual + " and " + expected + " not Matched due to exception" + e);
		}
	}

	public String getText_Custom(WebElement element, String fieldName) {
		String text = "";
		try {
			text = element.getText();
			ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS,
					text + " retreived successfully from " + fieldName);
		} catch (Exception e) {
			ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL, "Text not retreived due to exception" + e);
		}
		return text;
	}

	public void verify_PageNavigation(WebElement we, String pageName) {
		try {
			if (we.isDisplayed())
				ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS,
						pageName + "--> Navigated successfully");
		} catch (Exception e) {
			ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL, pageName + "--> Navigation Failed");
		}
	}
}
