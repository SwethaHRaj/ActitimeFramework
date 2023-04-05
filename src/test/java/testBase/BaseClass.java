package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.AddUser;
import pageObjects.Home;
import pageObjects.Login;
import pageObjects.Users;
import reusableComponents.ActionEngine;
import reusableComponents.CommonMethods;
import reusableComponents.DataBaseOperations;
import reusableComponents.ExcelOperations;
import reusableComponents.PropertiesOperations;

public class BaseClass extends ActionEngine {

	DriverFactory driver = new DriverFactory();
	public CommonMethods cm = new CommonMethods();;
	public Login login;
	public Home home;
	public Users users;
	public AddUser addUser;
	public DataBaseOperations db;

	@BeforeMethod
	public void setup() {
		LocalDriverFactory.getInstance()
				.setLocalDriver(driver.createDriver(PropertiesOperations.getProperty("browser")));
		WebDriver driver = LocalDriverFactory.getInstance().getLocalDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.navigate().to(PropertiesOperations.getProperty("url"));

		login = new Login();
		home = new Home();
		users = new Users();
		addUser = new AddUser();
		db=new DataBaseOperations();
	}

	@AfterMethod
	public void tearDown() {
		LocalDriverFactory.getInstance().closeLocalDriver();
	}

}
