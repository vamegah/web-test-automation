package resources.commonLibs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {
	
	ExtentSparkReporter htmlReport;
	
	ExtentReports extentReports;
	
	ExtentTest extentTest;
	
	public ReportUtils(String htmlReportFilename) {
		
		htmlReportFilename = htmlReportFilename.trim();
		
		htmlReport = new ExtentSparkReporter(htmlReportFilename);
		
		extentReports = new ExtentReports();
		
		extentReports.attachReporter(htmlReport);
		
	}
	
	public void createATestCase(String testCaseName) {
		
		extentTest = extentReports.createTest(testCaseName);
	}
	
	public void addTestLog(Status status, String comment) {
		
		extentTest.log(status, comment);
	}
	
	public void flushReport() {
		
		extentReports.flush();
		
	}

}
