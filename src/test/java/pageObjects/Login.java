package pageObjects;

import org.openqa.selenium.By;

import reusableComponents.PropertiesOperations;
import testBase.BaseClass;
import testBase.LocalDriverFactory;

public class Login extends BaseClass {

	By loginHeader = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-xhjyaz']");
	By phoneNumberField = By.id(":r1:");
	By verifyButton = By.xpath("//button[normalize-space()='Verify']");
	By otpDigitField = By.xpath("//input[@id='otp-input-0']");
	By submitButton = By.xpath("//button[normalize-space()='Submit']");

	public void verifyLoginPageNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(loginHeader),"Login Page");
	}
	
	public void enterPhoneNumber(String phoneNumber) {
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(phoneNumberField), "Phone Number Field" , phoneNumber);
	}
	
	public void clickVerifyButton() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(verifyButton), "Verify button");
	}
	
	public void enterOtp(String otp) {
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(otpDigitField), "OTP Digit Field" , otp);
	}
	
	public void clickSubmitButton() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(submitButton), "Submit Button");
	}

}
