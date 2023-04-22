package com.OragangeHrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@name=\"username\"]")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//input[@name=\"password\"]")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement enterLoginBtn;

	@FindBy(xpath = "//div[@class='orangehrm-login-branding']")
	@CacheLookup
	WebElement companyBrandLogo;

	@FindBy(xpath = "//div[@class='orangehrm-login-forgot']")
	@CacheLookup
	WebElement forgetPasswordLink;

	@FindBy(xpath = "//li[@class='oxd-userdropdown']")
	@CacheLookup
	WebElement userProfile;

	public void companyBrandName() {
		companyBrandLogo.isDisplayed();
	}

	public void enterUserName(String uname) {
		userName.sendKeys(uname);
	}

	public void enterPassword(String pword) {
		password.sendKeys(pword);
	}

	public void enterLoginbtn() {
		enterLoginBtn.click();
	}

	public void verifyUserLoginSuccessfully() {
		boolean cond = userProfile.isDisplayed();
		if (cond) {
			Assert.assertTrue(true);
			System.out.println("pass");
		} else {
			try {
				Assert.assertTrue(false, "user may enter wrong credetials");
			} catch (Exception e) {

			}
		}
	}
}
