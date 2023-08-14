package com.selenium.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Karthick Prasanth
 *
 */
public class GenericFunctions {

	private Properties prop;
	private WebDriver driver;
	private static GenericFunctions genericFunctions;

	private GenericFunctions() {
		prop = new Properties();
		FileInputStream fileInput;
		try {
			fileInput = new FileInputStream(System.getProperty("user.dir") + "//configuration//config.properties");
			prop.load(fileInput);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("FireFox")) {
			//System.setProperty("webdriver.gecko.driver","C://Softwares//geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}
	}

	public static GenericFunctions getInstance() {
		if (genericFunctions == null) {
			genericFunctions = new GenericFunctions();
		}
		return genericFunctions;
	}

	public String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getElement(By element) {
		WebElement webElement = null;
		try {
			webElement = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}

	public void click(By element) {
		getElement(element).click();
	}

	public void input(By element, String testData) {
		getElement(element).sendKeys(testData);
	}
	
	public void sleepInSeconds(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
