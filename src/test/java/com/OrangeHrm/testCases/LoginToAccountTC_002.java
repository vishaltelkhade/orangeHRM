package com.OrangeHrm.testCases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OragangeHrm.pageObjects.HomePage;
import com.OragangeHrm.pageObjects.LoginPage;
import com.OrangeHrm.utilities.ReadExcelUtils;

public class LoginToAccountTC_002 extends BaseClass {

	@Test(dataProvider = "lData")
	public void loginWithDDT(String userName, String passWord, String result) throws InterruptedException {
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.enterUserName(userName);
		lp.enterPassword(passWord);
		lp.enterLoginbtn();
		String expectedCurrentUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actualurl = driver.getCurrentUrl();
		if (result.equals("Valid")) {
			if (expectedCurrentUrl.equals(actualurl)) {
				hp.clickonLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} else {
			if (result.equals("Invalid")) {
				if (expectedCurrentUrl.equals(actualurl)) {
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		}
	}

	@DataProvider(name = "lData")
	public String[][] loginData() throws FileNotFoundException {
		String excelpath = "./Testdata/LoginData.xlsx";
		ReadExcelUtils utils = new ReadExcelUtils(excelpath);
		int totalrows = utils.getRowCount("Sheet1");
		int totalcells = utils.getCellCount("Sheet1", 1);
		String[][] logData = new String[totalrows][totalcells];
		for (int r = 1; r <= totalrows; r++) {
			for (int c = 0; c < totalcells; c++) {
				logData[r - 1][c] = utils.getCellData("Sheet1", r, c);
			}
		}
		return logData;
	}
}
