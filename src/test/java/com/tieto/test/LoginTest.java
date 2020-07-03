package com.tieto.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tieto.base.WebDriverWrapper;
import com.tieto.pages.DashboardPage;
import com.tieto.pages.LoginPage;
import com.tieto.utilities.ExcelUtils;

public class LoginTest extends WebDriverWrapper{
	
	@DataProvider
	public Object[][] invalidCredentialData()
	{
		Object[][] main  = new Object[2][4];
		//Object[i][j]
		//i-> number of test case
		//j-> number of parameter
		
		main[0][0] = "john";
		main[0][1] = "john123";
		main[0][2] = "English (Indian)";
		main[0][3] = "Invalid username or password";
		
		main[1][0] = "peter";
		main[1][1] = "peter123";
		main[1][2] = "Armenian";
		main[1][3] = "Invalid username or password";
		
		return main;
	}

	
	@Test(dataProvider="invalidCredentialData")
	public void invalidCredentialTest(String username, String password, String dropdown, String invalidMessage) {
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);	
		login.enterPassword(password);
		login.selectDropDown(dropdown);
		login.login();
		
		String errorMsg = login.getErorMessage();
		
		Assert.assertEquals(errorMsg.trim(), invalidMessage);
		//True is expected. Use contains when we need to check some string in page or element.
		//Assert.assertTrue(errorMsg.contains("Invalid username or password"));
		
	}
	
	@DataProvider
	public Object[][] validCredentialData() throws IOException{
		Object[][] data = ExcelUtils.getSheetIntoObject("testdata/OpenEMRData.xlsx", "validCredentialData");
		return data;
	}

	@Test (priority=1, dataProvider ="validCredentialData" )
	public void validCredentialTest(String username,String password,String language,String expectedValue){
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsername(username);	
		login.enterPassword(password);
		login.selectDropDown(language);
		login.login();
		
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.waitPresenceOfMessageCentre(driver);
		
		String actualValue = driver.getTitle();
		
		Assert.assertEquals(actualValue, expectedValue);
		//log in report
		Reporter.log(actualValue);
	}
}
