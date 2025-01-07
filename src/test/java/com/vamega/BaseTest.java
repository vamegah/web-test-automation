package com.vamega;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.vamega.pages.LoginPageObject;

import resources.commonLibs.implementations.CommonDriver;
import resources.commonLibs.utils.ConfigUtils;
import resources.commonLibs.utils.ReportUtils;
import resources.commonLibs.utils.ScreenshotUtils;

public class BaseTest {
	
	CommonDriver commonDriver;
	
	WebDriver driver;
	
	LoginPageObject loginPageObject;
	
	Properties configProperty;
	
	String configFilename;
	
	String currentWorkingDir;
	
	String reportFilename;
	
	ReportUtils reportUtils;
	
	ScreenshotUtils screenshot;
	
	@BeforeSuite
	public void preSetup() throws Exception {
		
		currentWorkingDir = System.getProperty("user.dir");
		
		configFilename = currentWorkingDir + "/config/sit.properties";
		
		reportFilename = currentWorkingDir + "/reports/testReport.html";
		
		configProperty = ConfigUtils.readProperties(configFilename);
		
		reportUtils = new ReportUtils(reportFilename);
		
	}
	
	@BeforeClass
	public void setup() throws Exception {
		
		commonDriver = new CommonDriver(configProperty.getProperty("browser"));
		
		driver = commonDriver.getDriver();
		
		loginPageObject = new LoginPageObject(driver);
		
		screenshot = new ScreenshotUtils(driver);
		
		commonDriver.navigateToURL(configProperty.getProperty("appUrl"));
		
	}
	
	@AfterMethod
	public void postTestAction(ITestResult result) throws Exception {
		
		String testCaseName = result.getName();
		
		long executionTime = System.currentTimeMillis();
		
		String screenshotFilename = currentWorkingDir + "/screenshots/" + testCaseName + executionTime + ".png";
		
		if (result.getStatus() == ITestResult.FAILURE) {
			
			reportUtils.addTestLog(Status.FAIL, "One or more steps Failed");
			
			screenshot.captureAndSaveScreenshot(screenshotFilename);
			
			reportUtils.attachScreenshotToReport(screenshotFilename);
			
		}
	}
	
	@AfterClass
	public void tearDowm() {
		
		commonDriver.closeAllBrowser();
		
	}
	
	@AfterSuite
	public void postTearDown() {
		
		reportUtils.flushReport();
	}

}
