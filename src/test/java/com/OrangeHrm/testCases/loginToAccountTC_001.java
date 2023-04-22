package com.OrangeHrm.testCases;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.OragangeHrm.pageObjects.LoginPage;
import com.OrangeHrm.utilities.Log4jUtility;

public class loginToAccountTC_001 extends BaseClass {

	private static final Logger logger = Log4jUtility.getLogger(loginToAccountTC_001.class);
	@Test
	public void login() throws InterruptedException
	{
		logger.info("navigating to url");
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering the username");
		lp.enterUserName(usernm);
		logger.info("Entering the Password");
		lp.enterPassword(passw);
		logger.info("Click on Login button");
		lp.enterLoginbtn();
		lp.verifyUserLoginSuccessfully();
	}
}
