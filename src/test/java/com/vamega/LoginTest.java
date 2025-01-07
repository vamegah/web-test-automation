package com.vamega;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTest extends BaseTest {
	
	@Parameters({"username", "password"})
	@Test
	public void verifyUserLoginWithCorrectCredentials(String username, String password) {
		
		reportUtils.createATestCase("verify User Login With Correct Credentials");
		
		reportUtils.addTestLog(Status.INFO, "Performing Login");
		
		loginPageObject.loginToApplication(username, password);
		
		String expectedTitle = "GTPL Bank Manager HomePage";
		
		String actualTitle = commonDriver.getPageTitle();
		
		reportUtils.addTestLog(Status.INFO, "Comparing expected and actual Title");
		
		Assert.assertEquals(actualTitle, expectedTitle);

		
		
	}

}
