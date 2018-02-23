package helper;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationFactory.BrowserFactory;
import applicationFactory.DataProviderFactory;

public class BaseClassCloud {
	
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger =null;
	
	@BeforeSuite
	public void setUpReports() {
		
		System.out.println("INFO: Setting up the report");
		report = new ExtentReports(System.getProperty("user.dir")+"/Reports/"+Utility.getCurrentDateAndTime()+".html");
			
	}
	
	@Parameters({"Browser", "OSName", "version"})
	@BeforeClass
	public void startUpSession(String browser, String os, String version) {
		
	driver =BrowserFactory.startApllicationOnCloud(browser, DataProviderFactory.getConfig().getTestApplicationUrl(), os, version);
	}
	
	
	@AfterClass
	public void terminateSession() {
		
		driver.close();
		System.out.println("Closing the active browser session");
	}
	
	@AfterSuite
	public void tearDownReports() {
		report.close();
		System.out.println("INFO: report generated and can be checked in report folder");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
				if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test passed successfully");
			logger.log(LogStatus.INFO, logger.addScreenCapture(Utility.captureScreenShot(driver)));
			
			
		}else if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "test failed");
			logger.log(LogStatus.INFO, logger.addScreenCapture(Utility.captureScreenShot(driver)));
			logger.log(LogStatus.ERROR, result.getThrowable().getMessage());
		}
		report.endTest(logger);
	}
	


}
