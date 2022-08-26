package com.finalProject;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.base.Base;
import com.selenium.base.GlobalVariables;
import com.selenium.poc.MainPage;

public class orangeHrm {
	
	WebDriver driver;
	Base base;
	MainPage mainPage;
	String adminUserName;
	String adminPassword;
	String employeeName;
	String userName;
	String userPassword;
	String employeeFullName;
	ExtentReports extent;
	ExtentTest logger;
	private String className = this.getClass().getSimpleName();
	
  @BeforeTest
  public void beforeTest() {
	  base = new Base(driver);
	  driver = base.chromeDriverCon();
	  mainPage = new MainPage(driver);
	  adminUserName = base.getJSONValue("tc001", "adminUserName");
	  adminPassword = base.getJSONValue("tc001", "adminPassword");
	  employeeName = base.getJSONValue("tc001", "employeeName");
	  userName = base.getJSONValue("tc001", "userName");
	  userPassword = base.getJSONValue("tc001", "userPassword");
	  employeeFullName = base.getJSONValue("tc001", "employeeFullName");
	  
	  // Set up Extend reports
	  extent = new ExtentReports(System.getProperty(GlobalVariables.USER_DIR) + GlobalVariables.REPORT_PATH, true);
	  extent.addSystemInfo(GlobalVariables.EXTENT_QA_URL, GlobalVariables.QA_URL);
	  extent.loadConfig(new File(System.getProperty(GlobalVariables.USER_DIR) + GlobalVariables.CONFIG_EXTENT));
  }
  
  @Test
  public void tc001() {
	  
	 // Extent report start test
	 logger = extent.startTest(className + " - " + new Object() {
	 }.getClass().getEnclosingMethod().getName());
		
  	/*
  	 * TC001 -  Add & Delete User	  	
  	 * Step 1 Open browser "OrangeHRM" web page
  	 * Step 2 Enter Username and Password
  	 * Step 3 Click login
  	 * Step 4 Validate user is logged successfully
  	 * Step 5 Click Admin module
  	 * Step 6 Validate user is able to see Admin page 
  	 * Step 7 Click Add button
  	 * Step 8 Fill out the form to create the user
  	 * Step 9 Click on Save button.
  	 * Step 10 Insert user recently created into Username textbox
  	 * Step 11 Click search
  	 * Step 12 Validate user exist in the table result after click search
  	 * Step 13	Select user in the table result and click Delete
  	 * Step 14	Click on OK button in modal window (Delete records?)
  	 * Step 15	Validate user was deleted successfully
  	 */

	  base.LunchBrowser(GlobalVariables.QA_URL); 
	  mainPage.login(adminUserName, adminPassword);
	  mainPage.enterAdminModule();
	  mainPage.AddSystemUsr();
	  mainPage.fillSystemUsrData(employeeName, employeeFullName, userName, userPassword);
	  mainPage.searchAdminUser(userName);
	  mainPage.deleteUser();
	  mainPage.verifyDeletedUser();
	  
	  // Log Extent Report
	  logger.log(LogStatus.PASS, "Validation " + className + " - " + new Object() {
	  }.getClass().getEnclosingMethod().getName() + " was successfully");
	
  }
	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, logger.addScreenCapture(base.takeScreenshot("fail")));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);

	}
	
  @AfterTest
  public void afterTest() {
	  // Close Extend report
	  extent.flush();
	  extent.close();
	  base.closeBrowser();
  }
 }
