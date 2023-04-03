package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;
import testBase.LocalDriverFactory;

public class AddUser extends BaseClass {

	By logo = By.xpath("//div[text()='Add User']");
	By txt_firstName = By.xpath("//div/input[@id='createUserPanel_firstNameField']"); // executor
	By txt_lastName = By.id("createUserPanel_lastNameField");
	By txt_email = By.id("createUserPanel_emailField");
	By ddDiv_department = By.xpath("//div[text()='-- department not assigned --' and @class='title']");
	By btn_calender = By.xpath("//div[@id='editUserPanel_hireDatePlaceholder']/table");
	By btn_today = By.xpath("//button[text()='today']");
//	By chk_useCorporatesettings = By.xpath(
//			"//label[@class='components_checkboxContainer useDefaultScheduleCheckbox checked']/span[text()='Use corporate settings']"); //default
	By btn_saveAndSendInvitation = By.xpath("//div[text()='Save & Send Invitation']");
	By confirmMessagePage = By.xpath("//div[@class='inviteOneMoreButton']/span[text()='Invite one more user']");

	public void verifyAddUserPageNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(logo), "Add User Page");

	}

	public void enterAddUserPageDetails() {

		WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(),
				Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(txt_firstName));
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(txt_firstName), "First Name",
				"Ram");
		wait.until(ExpectedConditions.elementToBeClickable(txt_lastName));
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(txt_lastName), "Last Name",
				"Raj");
		wait.until(ExpectedConditions.elementToBeClickable(txt_email));
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(txt_email), "Email",
				"Ram@gmail.com");

		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(ddDiv_department), "Department");
		String dept = "Quality Control";
		click_Custom(
				LocalDriverFactory.getInstance().getLocalDriver().findElement(By
						.xpath("//div[@class='scrollView scrollableContainer']/div/div[2]/div[text()='" + dept + "']")),
				"Department");

//		wait.until(ExpectedConditions.presenceOfElementLocated(btn_calender));
//		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(btn_calender), "Calender");
//		wait.until(ExpectedConditions.presenceOfElementLocated(btn_today));
//		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(btn_today), "Today");		//today by default selected
//		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(chk_useCorporatesettings),	//already checked
//				"Use Corporate settings CheckBox");
	}

	public void clickOnSaveButton() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(btn_saveAndSendInvitation),
				"Save Button");
	}

	public void verifyAddUserConfirmationMessageAndClose() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(confirmMessagePage),
				"Confirmation Message");
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver()
				.findElement(By.xpath(("(//span[text()='Close'])[1]"))), "Close button");
	}

}
