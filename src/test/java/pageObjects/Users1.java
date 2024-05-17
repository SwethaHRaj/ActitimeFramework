package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import reusableComponents.ActionEngine;
import testBase.ExtentTestFactory;
import testBase.LocalDriverFactory;

public class Users1 extends ActionEngine {

	By logo = By.xpath("//tr/td/div/span[text()='List of Users']");
	By btn_departments = By
			.xpath("//div[@class='userList_container_managementButtonsContainer']/div/div[text()='  Departments']");
	By btn_newUser = By
			.xpath("//div[@class='userList_container_managementButtonsContainer']/div/div[text()='New User']");
	By btn_bulkInvitations = By
			.xpath("//div[@class='userList_container_managementButtonsContainer']/div/div[text()='Bulk Invitations']");

	public void verifyUsersPageNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(logo), "Users page");
	}

	public void clickOnNewUser() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(btn_newUser), "New User");
	}

	public void verifyAddedUserInListOfUsers(HashMap<String, String> data) {
		List<WebElement> wes = LocalDriverFactory.getInstance().getLocalDriver().findElements(
				By.xpath("//table[@class='userNameContainer']/tbody/tr/td/div/span[@class='userNameSpan']"));
		for (WebElement we : wes) {
				Assert.assertEquals(we.getText(), data.get("LastName")+", "+data.get("FirstName"), "Added User not found in List Of Users");
				ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS, "User has been added to Users List");
				break;
		}
		
	}
}
