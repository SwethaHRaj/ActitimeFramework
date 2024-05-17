package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;

import testBase.BaseClass;
import testBase.LocalDriverFactory;

public class Home1 extends BaseClass {

	By logo = By.id("logo_aT");

	public void clickOnMainMenu(HashMap<String, String> data) {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver()
				.findElement(By.xpath("//tr/td/a/div[text()='" + data.get("MainMenu") + "']")), "Main Menu");
	}

//	public void clickOnMainMenuAndSubMenu(String mainMenu, String subMenu) {
//		click_Custom(LocalDriverFactory.getInstance().getLocalDriver()
//				.findElement(By.xpath("//tr/td/a/div[text()='" + mainMenu + "']")), "Main Menu");
//		click_Custom(LocalDriverFactory.getInstance().getLocalDriver()
//				.findElement(By.xpath("//tr[@class='secondLevelRow']/td/div/a[text()='" + subMenu + "']")), "Sub Menu");
//	}

	// ------------Validation Methods---------------

	public void checkHomePageNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(logo), "Home Page");
	}

}
