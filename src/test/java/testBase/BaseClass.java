package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.AddUser1;
import pageObjects.Home;
import pageObjects.Home1;
import pageObjects.Login;
import pageObjects.Login1;
import pageObjects.NavBar;
import pageObjects.Users1;
import reusableComponents.ActionEngine;
import reusableComponents.CommonMethods;
import reusableComponents.DataBaseOperations;
import reusableComponents.ExcelOperations;
import reusableComponents.PropertiesOperations;

public class BaseClass extends ActionEngine {

	DriverFactory driver = new DriverFactory();
	public CommonMethods cm = new CommonMethods();;
//	public Login1 login1;
//	public Home1 home1;
//	public Users1 users1;
//	public AddUser1 addUser1;
	public DataBaseOperations db;
	
	public Home home;
	public Login login;
	public NavBar navBar;

	@BeforeMethod
	public void setup() {
		LocalDriverFactory.getInstance()
				.setLocalDriver(driver.createDriver(PropertiesOperations.getProperty("browser")));
		WebDriver driver = LocalDriverFactory.getInstance().getLocalDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.navigate().to(PropertiesOperations.getProperty("url"));

//		login = new Login1();
//		users = new Users1();
//		addUser = new AddUser1();
		db=new DataBaseOperations();
		
		home = new Home();
		login = new Login();
		navBar = new NavBar();
	}

	@AfterMethod
	public void tearDown() {
		LocalDriverFactory.getInstance().closeLocalDriver();
	}

}
