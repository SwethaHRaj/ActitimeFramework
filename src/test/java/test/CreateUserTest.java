package test;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusableComponents.ExcelOperations;
import testBase.BaseClass;

//public class CreateUserTest extends BaseClass {
//	
//	ExcelOperations excel=new ExcelOperations("Add_User");
//
//	@Test(dataProvider = "demoTest")
//	public void createUser(Object obj) throws Exception {
//		
//		@SuppressWarnings("unchecked")
//		HashMap<String, String> data=(HashMap<String, String>) obj;
//		
//		// adding new User
//		login.login();
//		home.checkHomePageNavigation();
//		home.clickOnMainMenu(data);
//		users.verifyUsersPageNavigation();
//		users.clickOnNewUser();
//		addUser.verifyAddUserPageNavigation();
//		addUser.enterAddUserDetails(data);
//		addUser.verifyAddUserConfirmationMessageAndClose();
//		home.checkHomePageNavigation();
//		// verify user in Users List 
//		users.verifyAddedUserInListOfUsers(data);
//	}
//	
//	@DataProvider(name="demoTest")
//	public Object[][] demoTestDataProvider() throws Exception {
//		Object[][] obj=new Object[excel.getRowCount()][1];
//		HashMap<String, String> hm=null;
//		for(int i=0;i<excel.getRowCount();i++) {
//			hm=excel.getTestDataInMap(i+1);		
//			obj[i][0]=hm;
//		}
//		return obj;						
//	}
//}



