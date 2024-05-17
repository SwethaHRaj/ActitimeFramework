package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;

import testBase.BaseClass;
import testBase.LocalDriverFactory;

public class Home extends BaseClass {

	By logo = By.xpath("//a[normalize-space()='']//img[@alt='kgen_logo']");

	public void verifyHomePageNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(logo), "Home Page");
	}
	
}
