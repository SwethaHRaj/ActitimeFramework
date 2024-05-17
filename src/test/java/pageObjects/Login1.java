package pageObjects;

import org.openqa.selenium.By;

import reusableComponents.PropertiesOperations;
import testBase.BaseClass;
import testBase.LocalDriverFactory;

public class Login1 extends BaseClass {

	By txt_userName = By.id("username");
	By txt_password = By.name("pwd");
	By btn_login = By.id("loginButton");

	public void login() {
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(txt_userName), "UserId",
				PropertiesOperations.getProperty("username"));
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(txt_password), "Password",
				PropertiesOperations.getProperty("password"));
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(btn_login), "Login Button");
	}
	
	public void login2(String un, String pwd) {
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(txt_userName), "UserId",
				un);
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(txt_password), "Password",
				pwd);
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(btn_login), "Login Button");
	}

}
