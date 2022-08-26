package com.selenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.selenium.base.Base;
import com.selenium.base.GlobalVariables;

public class MainPage extends Base {

	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	// Objects
	//Login Screen
	By txtLoginUserName = By.xpath("//input[@name=\"username\"]");
	By txtLoginPass = By.xpath("//input[@name=\"password\"]");
	By btnLoginSubmit = By.xpath("//button[@type=\"submit\"]");
	
	//Landing Page
	By btnAdminModule = By.xpath("(//*[contains(@class, 'oxd-main-menu')]//*[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name')])[1]");
	
	//Admin Module
	By btnAdminAddUser = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
	By txtAdminUsrNameSearch = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
	By btnAdminSearch = By.xpath("//button[@type=\"submit\"]");
	By userNameRecord = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div");
	By secondaryUserNameRecord = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[2]/div/div[2]/div");
	By txtRecordsFound = By.xpath("//*[contains(@class, 'orangehrm-horizontal-padding orangehrm-vertical-padding')]//*[contains(@class, 'oxd-text oxd-text--span')]");
	By btnRemoveUser = By.xpath("(//*[contains(@class, 'oxd-table-cell oxd-padding-cell')]//*[contains(@class, 'oxd-icon-button oxd-table-cell-action-space')])[1]");
	By txtRemoveUserWarning = By.xpath("//*[contains(@class, \"orangehrm-modal-header\")]//*[contains(@class, \"oxd-text oxd-text--p oxd-text--card-title\")]");
	By btnRemoveConfirmUser = By.xpath("//*[@class=\"oxd-icon bi-trash oxd-button-icon\"]");
	
	//Add Admin User
	By sddAdminUserRole = By.xpath("(//*[contains(@class, 'orangehrm-card-container')]//*[contains(@class, 'oxd-select-text-input')])[1]");
	By sddAdminUserRoleOpt = By.xpath("(//*[contains(@class, 'oxd-select-dropdown --positon-bottom')]//*[contains(@class, 'oxd-select-option')])[2]");
	By sddAdminStatus = By.xpath("(//*[contains(@class, 'orangehrm-card-container')]//*[contains(@class, 'oxd-select-text-input')])[2]");
	By sddAdminStatusOpt = By.xpath("(//*[contains(@class, 'oxd-select-dropdown --positon-bottom')]//*[contains(@class, 'oxd-select-option')])[2]");
	By txtAdminEmployeeName = By.xpath("//input[@placeholder=\"Type for hints...\"]");
	By txtAdminEmployeeNameResult = By.xpath("//*[contains(@class, 'oxd-autocomplete-dropdown --positon-bottom')]//*[contains(@class, 'oxd-autocomplete-option')]");
	By txtAdminUserName = By.xpath("(//*[contains(@class, 'oxd-input-group oxd-input-field-bottom-space')]//input[contains(@class, 'oxd-input oxd-input--active')])[1]");
	By txtAdminUserNameError = By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]");
	By txtAdminPassword = By.xpath("(//*[contains(@class, 'orangehrm-card-container')]//*[contains(@class, 'oxd-input oxd-input--active')])[1]");
	By txtAdminConfirmPassword = By.xpath("(//*[contains(@class, 'orangehrm-card-container')]//*[contains(@type, 'password')])[2]");
	By btnAdminSave = By.xpath("//*[contains(@class, 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space')]");
	
	/*
	 * Login
	 * @author Alfredo Santoyo
	 */
	public void login(String user, String pass) {
		implicitWait();
		type(txtLoginUserName, user);
		type(txtLoginPass, pass);
		click(btnLoginSubmit);
		verifyUrlContains(GlobalVariables.viewEmployeeList_URL);
		takeScreenshot("VerifyUserLoggedIn");
	}
	
	public void enterAdminModule() {
		click(btnAdminModule);
		verifyUrlContains(GlobalVariables.viewSystemUsers_URL);
		takeScreenshot("VerifyUserInAdminPage");
	}
	
	public void AddSystemUsr() {
		click(btnAdminAddUser);
		verifyUrlContains(GlobalVariables.saveSystemUser_URL);
	}
	public void fillSystemUsrData(String employeeName, String employeeFullName, String userName, String userPassword) {
		click(sddAdminUserRole);
		click(sddAdminUserRoleOpt);
		click(sddAdminStatus);
		click(sddAdminStatusOpt);
		type(txtAdminEmployeeName, employeeName);
		verifyVisibilityElement(txtAdminEmployeeNameResult);
		verifyEmployeeName("Searching....");
		verifyInvisibilityElementTxt(txtAdminEmployeeNameResult, "Searching....");
		verifyEmployeeName(employeeFullName);
		click(txtAdminEmployeeNameResult);
		type(txtAdminUserName, userName);
		verifyVisibilityElement(txtAdminUserNameError);
		verifyErrorMessage("Should be least 5 characters");
		verifyInvisibilityElementTxt(txtAdminUserNameError, "Should be least 5 characters");
		type(txtAdminPassword, userPassword);
		type(txtAdminConfirmPassword, userPassword);
		click(btnAdminSave);
		
	}
	
	public void searchAdminUser(String userName) {
		verifyVisibilityElement(txtAdminUsrNameSearch);
		type(txtAdminUsrNameSearch, userName);
		click(btnAdminSearch);
		verifyInvisibilityElement(secondaryUserNameRecord);
		verifyVisibilityElement(userNameRecord);
		verifyUserResult(userName);
		takeScreenshot("VerifyUserInTableResult");
		
		
}
	public void deleteUser() {
		verifyRecordsFound("(1) Record Found");
		click(btnRemoveUser);
		verifyVisibilityElement(txtRemoveUserWarning);
		verifyRemoveWarningMsg("Are you Sure?");
		click(btnRemoveConfirmUser);
		
	}
	public void verifyDeletedUser() {
		verifyInvisibilityElement(btnRemoveConfirmUser);
		verifyRecordsFound("No Records Found");
		takeScreenshot("VerifyUserIsDeleted");
	}
	
	public void verifyEmployeeName(String expectedResult) {
		String searchName = getText(txtAdminEmployeeNameResult);
		Assert.assertEquals(searchName, expectedResult);
	}
	
	public void verifyErrorMessage(String expectedResult) {
		String errorMessage = getText(txtAdminUserNameError);
		Assert.assertEquals(errorMessage, expectedResult);
	}
	public  void verifyUserResult(String userName) {
		String actualUserName = getText(userNameRecord);
		Assert.assertEquals(actualUserName, userName);
	}
	public void verifyRecordsFound(String expectedRecordsFound) {
		String actualRecordsFound = getText(txtRecordsFound);
		Assert.assertEquals(actualRecordsFound, expectedRecordsFound);
	}
	public void verifyRemoveWarningMsg(String expectedWarningMsg) {
		String actualWarningMsg = getText(txtRemoveUserWarning);
		Assert.assertEquals(actualWarningMsg, expectedWarningMsg);
	}
	public void verifyUserNameInput(String expectedUserName) {
		String actualUserName = getText(txtAdminUsrNameSearch);
		Assert.assertEquals(actualUserName, expectedUserName);
	}
}
