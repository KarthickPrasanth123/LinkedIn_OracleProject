package com.linkedin.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.linkedin.pageobject.LoginPageObject;
import com.selenium.commons.GenericFunctions;

public class LoginPage {

	private LoginPageObject loginPageObj = new LoginPageObject();
	private GenericFunctions genericFunctions = GenericFunctions.getInstance();

	public void login() {
		System.out.println("------Login Page !-------");
		WebDriver driver = genericFunctions.getDriver();
		driver.get(genericFunctions.getPropertyValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		genericFunctions.click(loginPageObj.signIn_Button);
		
		WebElement emailElement = genericFunctions.getElement(loginPageObj.email_Input);
		Assert.assertTrue(emailElement != null ? emailElement.isDisplayed() : false,
				"Email text box is not displayed in sign in page !");
		genericFunctions.input(loginPageObj.email_Input, genericFunctions.getPropertyValue("username"));
		genericFunctions.click(loginPageObj.continue_Button);
		genericFunctions.sleepInSeconds(10);
		WebElement passwordElement = genericFunctions.getElement(loginPageObj.password_Input);
		Assert.assertTrue(passwordElement != null ? passwordElement.isDisplayed() : false,
				"Password text box is not displayed in sign in page !");
		genericFunctions.input(loginPageObj.password_Input, genericFunctions.getPropertyValue("password"));
		genericFunctions.click(loginPageObj.continue_submit);
		genericFunctions.sleepInSeconds(10);
		System.out.println("------Logged in Successfully-------");
	}

}
