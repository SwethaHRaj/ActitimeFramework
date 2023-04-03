package pageObjects;

import org.openqa.selenium.By;

import testBase.BaseClass;
import testBase.LocalDriverFactory;

public class Home extends BaseClass {

	By logo = By.id("logo_aT");

	public void clickOnMainMenu(String mainMenu) {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver()
				.findElement(By.xpath("//tr/td/a/div[text()='" + mainMenu + "']")), "Main Menu");
	}
	
	public void clickOnMainMenuAndSubMenu(String mainMenu, String subMenu) {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver()
				.findElement(By.xpath("//tr/td/a/div[text()='" + mainMenu + "']")), "Main Menu");
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver()
				.findElement(By.xpath("//tr[@class='secondLevelRow']/td/div/a[text()='"+subMenu+"']")), "Sub Menu");
	}
	
	//------------Validation Methods---------------

	public void checkHomePageNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(logo), "Home Page");
	}

}
