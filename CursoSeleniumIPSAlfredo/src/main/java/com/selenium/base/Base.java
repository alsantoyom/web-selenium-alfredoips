package com.selenium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Base {
	
	private WebDriver driver;
	
	/*
	 * Constructor
	 * @author Alfredo Santoyo
	 */

	public Base(WebDriver driver) {
		this.driver=driver;
	}
	
	/*
	 * Chrome Driver Con
	 */
	public WebDriver chromeDriverCon() {
		  ChromeOptions chromeOpt = new ChromeOptions();
		  WebDriverManager.chromedriver().setup();	  
		  driver = new ChromeDriver(chromeOpt);
		  return driver;

	}
	
	/*
	 * Launch Browser
	 * @author Alfredo Santoyo
	 */
	
	public void LunchBrowser(String url) {
		  driver.get(url);
		  driver.manage().window().maximize();
	}
	
	/*
	 * Implicit wait con 5 segundos y con N segundos
	 * @author Alfredo Santoyo
	 */
	public void implicitWait() {
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void implicitWait(int seconds) {
		  driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	/*
	 * Explicit Wait
	 * @author Alfredo Santoyo
	 */
	public void verifyUrlContains(String urlExpected) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlContains(urlExpected));
	}
	
	public void verifyVisibilityElement(By objExpected) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(objExpected));
	}
	
	public void verifyInvisibilityElement(By objExpected) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(objExpected));
	
	}
	
	public void verifyInvisibilityElementTxt (By locator, String Text) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, Text));
	}
	
	/*
	 * Type
	 * @author Alfredo Santoyo
	 */
	public void type(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	/*
	 * Type
	 * @author Alfredo Santoyo
	 */
	public void click(By locator) {
		try {
			driver.findElement(locator).click();
			} catch(NoSuchElementException e) {
				e.printStackTrace();
		}
	}
	
	/*
	 * Get Text
	 * @author Alfredo Santoyo
	 */
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	/*
	 * Close Browser
	 * @author Alfredo Santoyo
	 */
	public void closeBrowser() {
		driver.close();
	}
	
	/**
	 * Get Data from JSON file (Directly)
	 * 
	 * @author Ricardo Avalos
	 * @param jsonFile, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	
	public String getJSONValue(String jsonFileObj, String jsonKey){
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonFileObj).get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}
	
	/*
	 * Take screenshot
	 * 
	 * @author Ricardo Avalos
	 * @throws IOException
	 */
	public String takeScreenshot(String fileName){
		try {
			String pathFileName= GlobalVariables.PATH_SCREENSHOTS + fileName + ".png";
			Screenshot screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
			return pathFileName;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
}
