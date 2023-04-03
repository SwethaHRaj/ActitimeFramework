package pageObjects;

import org.openqa.selenium.By;

import reusableComponents.ActionEngine;
import testBase.LocalDriverFactory;

public class Users extends ActionEngine {

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

}
