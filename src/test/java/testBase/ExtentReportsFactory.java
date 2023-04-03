package testBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reusableComponents.PropertiesOperations;

public class ExtentReportsFactory {

	static ExtentReports report;

	public static ExtentReports setupExtentReport() {

		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		Date date = new Date();
		String formatedDate = format.format(date);
		String reportPath = System.getProperty("user.dir") + "./TestReports/ExtentReports/ExtentReport_" + formatedDate
				+ ".html";

		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		report = new ExtentReports();
		report.attachReporter(sparkReport);

		report.setSystemInfo("Application", "-------------");
		report.setSystemInfo("Environment", PropertiesOperations.getProperty("url"));
		report.setSystemInfo("Browser", PropertiesOperations.getProperty("browser"));
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
		report.setSystemInfo("User Name", System.getProperty("user.name"));
		sparkReport.config().setDocumentTitle("DocumentTitle");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("ReportName");

		return report;
	}
}
