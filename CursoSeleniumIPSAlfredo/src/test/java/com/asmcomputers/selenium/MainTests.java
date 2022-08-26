package com.asmcomputers.selenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MainTests {
  @Test
  public void f() {
	  //Step 1 - Launch browser
	  ChromeOptions chromeOpt = new ChromeOptions();
	  WebDriverManager.chromedriver().setup();	  
	  WebDriver driver = new ChromeDriver(chromeOpt);
	  driver.get("https://computer-database.gatling.io/computers");
	  driver.findElement(By.id("searchbox")); 

	  // Implicit
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  //Explicit
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.titleContains("Computers"));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchbox")));
	  
	  
	  //Step2 - Insert computer name in text box
	  driver.findElement(By.id("searchbox")).sendKeys("ACE");
	  
	  //Step3 - Click on "Filter by name"
	  driver.findElement(By.id("searchsubmit")).click();
	  
	  //Step4 - Validate computers is displayed in table
	  String actualComputerName = driver.findElement(By.xpath("//*/table/tbody/tr[1]/td[1]/a")).getText();
	  Assert.assertEquals(actualComputerName, "ACE");
	  
	  driver.close();
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
