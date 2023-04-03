package test;

import org.testng.annotations.Test;

import testBase.BaseClass;

public class DemoTest extends BaseClass {

	@Test
	public void testCase1() throws Exception {
		login.login();
		home.checkHomePageNavigation();
		home.clickOnMainMenu("Users");
		users.verifyUsersPageNavigation();
		users.clickOnNewUser();
		addUser.verifyAddUserPageNavigation();
		addUser.enterAddUserPageDetails();
		addUser.clickOnSaveButton();
		addUser.verifyAddUserConfirmationMessageAndClose();
		home.checkHomePageNavigation();
	}
}
