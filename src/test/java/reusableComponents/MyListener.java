package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testBase.ExtentReportsFactory;
import testBase.ExtentTestFactory;
import testBase.LocalDriverFactory;

public class MyListener implements ITestListener {

	static ExtentReports report;
	static ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		extentTest = report.createTest(result.getMethod().getMethodName());
		ExtentTestFactory.getInstance().setExtentTest(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS,
				"Test Case : " + result.getMethod().getMethodName() + "--> Passed");
		ExtentTestFactory.getInstance().removeExtentTest();
	}

	public void onTestFailure(ITestResult result) {
		ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL,
				"Test Case : " + result.getMethod().getMethodName() + "--> Failed");
		ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL, result.getThrowable());
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date date = new Date();
		String formatedDate = format.format(date);

		// String random=result.getName();
		TakesScreenshot t = (TakesScreenshot) LocalDriverFactory.getInstance().getLocalDriver();
		File src = t.getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir") + "./TestReports/Screenshots/Screenshot_" + formatedDate
				+ ".png";
		File des = new File(filePath);
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
		}
		ExtentTestFactory.getInstance().getExtentTest().addScreenCaptureFromPath(filePath,
				"Test Case Failure ScreenShot");
		ExtentTestFactory.getInstance().removeExtentTest();
	}

	public void onTestSkipped(ITestResult result) {
		ExtentTestFactory.getInstance().getExtentTest().log(Status.SKIP,
				"Test Case : " + result.getMethod().getMethodName() + "--> Skipped");
		ExtentTestFactory.getInstance().removeExtentTest();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		report = ExtentReportsFactory.setupExtentReport();
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}
}
