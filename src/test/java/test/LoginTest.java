package test;

import org.testng.annotations.Test;

import testBase.BaseClass;

@Test
public class LoginTest extends BaseClass {

	public void traineeLoginTest1() throws Exception {	
		login.login2("trainee","trainee");
		home.checkHomePageNavigation();
	}
	
	public void adminLoginTest1() throws Exception {	
		login.login2("admin","manager");
		home.checkHomePageNavigation();
	}
	
	public void clientLoginTest1() throws Exception {	
		login.login2("client","client");
		home.checkHomePageNavigation();
	}
}
