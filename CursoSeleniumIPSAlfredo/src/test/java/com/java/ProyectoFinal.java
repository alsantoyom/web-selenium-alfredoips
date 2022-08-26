package com.java;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ProyectoFinal {
  @Test
  public void f() {
	  //Step 1 - Launch browser
	  ChromeOptions chromeOpt = new ChromeOptions();
	  WebDriverManager.chromedriver().setup();	  
	  WebDriver driver = new ChromeDriver(chromeOpt);
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  
	  //Step 2 - Enter Username and Password
	  driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");

	  //Step 3 - Click login
	  driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	  
	  //Step 4 - Validate user is logged successfully
	  wait.until(ExpectedConditions.urlContains("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList"));

	  //Step 5 - Click Admin module
	  driver.findElement(By.xpath("(//*[contains(@class, 'oxd-main-menu')]//*[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name')])[1]")).click();

	  //Step 6 - Validate user is able to see Admin page
	  wait.until(ExpectedConditions.urlContains("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

	  //Step 7 - Click Add button
	  driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")).click();
	  wait.until(ExpectedConditions.urlContains("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"));
	  
	  //Step 8 - Fill out the form to create the user
	  //User Role
	  driver.findElement(By.xpath("(//*[contains(@class, 'orangehrm-card-container')]//*[contains(@class, 'oxd-select-text-input')])[1]")).click();
	  //Admin Option
	  driver.findElement(By.xpath("(//*[contains(@class, 'oxd-select-dropdown --positon-bottom')]//*[contains(@class, 'oxd-select-option')])[2]")).click();
	  //Status
	  driver.findElement(By.xpath("(//*[contains(@class, 'orangehrm-card-container')]//*[contains(@class, 'oxd-select-text-input')])[2]")).click();
	  //Enabled Option
	  driver.findElement(By.xpath("(//*[contains(@class, 'oxd-select-dropdown --positon-bottom')]//*[contains(@class, 'oxd-select-option')])[2]")).click();
	  //EmployeeName
	  driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys("Jasmine");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'oxd-autocomplete-dropdown --positon-bottom')]//*[contains(@class, 'oxd-autocomplete-option')]")));
		  String searchName = driver.findElement(By.xpath("//*[contains(@class, 'oxd-autocomplete-dropdown --positon-bottom')]//*[contains(@class, 'oxd-autocomplete-option')]")).getText();
		  Assert.assertEquals(searchName, "Searching....");
	  wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class, 'oxd-autocomplete-dropdown --positon-bottom')]//*[contains(@class, 'oxd-autocomplete-option')]"), searchName));
	  String newSearchName = driver.findElement(By.xpath("//*[contains(@class, 'oxd-autocomplete-dropdown --positon-bottom')]//*[contains(@class, 'oxd-autocomplete-option')]")).getText();
	  Assert.assertEquals(newSearchName, "Jasmine Morgan");
	  driver.findElement(By.xpath("//*[contains(@class, 'oxd-autocomplete-dropdown --positon-bottom')]//*[contains(@class, 'oxd-autocomplete-option')]")).click();
	  
	  //UserName
	  driver.findElement(By.xpath("(//*[contains(@class, 'oxd-input-group oxd-input-field-bottom-space')]//input[contains(@class, 'oxd-input oxd-input--active')])[1]")).sendKeys("asmNewUser8");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")));
	  String actualErrorMessage = driver.findElement(By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")).getText();
	  Assert.assertEquals(actualErrorMessage, "Should be least 5 characters");
	  wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class, 'oxd-autocomplete-dropdown --positon-bottom')]//*[contains(@class, 'oxd-autocomplete-option')]"), actualErrorMessage));
	  
	  //Password
	  driver.findElement(By.xpath("(//*[contains(@class, 'orangehrm-card-container')]//*[contains(@class, 'oxd-input oxd-input--active')])[1]")).sendKeys("asmUser123!");

	  //ConfirmPassword
	  driver.findElement(By.xpath("(//*[contains(@class, 'orangehrm-card-container')]//*[contains(@type, 'password')])[2]")).sendKeys("asmUser123!");

	  //Step 9 - Click on Save button.	  
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message")));
	  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space')]"))).click();
	
	  //Step 10 - Insert user recently created into Username textbox
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")));
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("asmNewUser8");

	  //Step 11 - Click search
	  driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	  
	  //Step 12 - Validate user exist in the table result after click search
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, \"oxd-table-cell oxd-padding-cell\")]//*[contains(text(), \"asmNewUser8\")]")));
	  String actualUserName = driver.findElement(By.xpath("//*[contains(@class, \"oxd-table-cell oxd-padding-cell\")]//*[contains(text(), \"asmNewUser8\")]")).getText();
	  Assert.assertEquals(actualUserName, "asmNewUser8");

	  //Step 13 - Select user in the table result and click Delete
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class=\\\"oxd-icon bi-trash oxd-button-icon\\\"]")));
	  String actualSearchResults = driver.findElement(By.xpath("//*[contains(@class, 'orangehrm-horizontal-padding orangehrm-vertical-padding')]//*[contains(@class, 'oxd-text oxd-text--span')]")).getText();
	  Assert.assertEquals(actualSearchResults, "(1) Record Found");
	  driver.findElement(By.xpath("(//*[contains(@class, 'oxd-table-cell oxd-padding-cell')]//*[contains(@class, 'oxd-icon-button oxd-table-cell-action-space')])[1]")).click();
	  
	  //Step 14 - Click on OK button in modal window (Delete records?)
	  driver.findElement(By.xpath("//*[@class=\"oxd-icon bi-trash oxd-button-icon\"]")).click();
	
	  //Step 15 - Validate user was deleted successfully
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class=\\\"oxd-icon bi-trash oxd-button-icon\\\"]")));
	  String actualDeletedUser = driver.findElement(By.xpath("//*[contains(@class, 'orangehrm-horizontal-padding orangehrm-vertical-padding')]//*[contains(@class, 'oxd-text oxd-text--span')]")).getText();
	  Assert.assertEquals(actualDeletedUser, "No Records Found");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")));
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("asmNewUser8");
	  driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class=\\\"oxd-icon bi-trash oxd-button-icon\\\"]")));
	  String actualNewDeletedUser = driver.findElement(By.xpath("//*[contains(@class, 'orangehrm-horizontal-padding orangehrm-vertical-padding')]//*[contains(@class, 'oxd-text oxd-text--span')]")).getText();
	  Assert.assertEquals(actualNewDeletedUser, "No Records Found");

  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
