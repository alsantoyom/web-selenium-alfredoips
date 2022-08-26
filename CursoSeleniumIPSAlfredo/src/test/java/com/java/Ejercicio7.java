package com.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ejercicio7 {
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
	  
	  //Step#2 - Go to Add a Computer
	  driver.findElement(By.id("add")).click();
	  wait.until(ExpectedConditions.urlContains("https://computer-database.gatling.io/computers/new"));
	  
	  //Step#3 - Add all required fields
	  driver.findElement(By.id("name")).sendKeys("asmComputer");
	  driver.findElement(By.id("introduced")).sendKeys("20-Aug-1985");
	  driver.findElement(By.id("discontinued")).sendKeys("20-Aug-1985");
	  Select se = new Select(driver.findElement(By.id("company")));
	  se.selectByIndex(3);
	  
	  driver.close();
  }
}
