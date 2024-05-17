package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;

import testBase.BaseClass;
import testBase.LocalDriverFactory;

public class NavBar extends BaseClass {

	By logo = By.xpath("//a[normalize-space()='']//img[@alt='kgen_logo']");
	By hometab = By.xpath("//a[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary active css-f00zqy']");
	By gamesTab = By.xpath("//a[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary css-x40fzr'][normalize-space()='Games']");
	By questsTab = By.xpath("//a[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary css-x40fzr'][normalize-space()='Quests']");
	By loginButton = By.id("signin-button");
	By profileIcon = By.xpath("//div[@class='MuiStack-root css-toud47']//img[@alt='avatar']");

	public void verifyHomePageNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(logo), "Home Page");
	}
	
	public void clickLoginButton() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(loginButton), "Login button");
	}
	
	public void clickHomeTab() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(hometab), "Home tab");
	}
	
	public void clickQuestsTab() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(questsTab), "Quests tab");
	}

	public void clickGamesTab() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(gamesTab), "Games tab");
	}
	
	public void verifyLogin() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(profileIcon), "login");
	}
	
	
}
