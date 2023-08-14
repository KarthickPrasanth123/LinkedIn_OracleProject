package com.linkedin.pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.linkedin.pageobject.LogoutPageObject;
import com.selenium.commons.GenericFunctions;

public class LogoutPage {

	private LogoutPageObject logoutPageObj = new LogoutPageObject();
	private GenericFunctions genericFunctions = GenericFunctions.getInstance();

	public void logout() {
		System.out.println("------Logout from Linked Page !-------");
		genericFunctions.click(logoutPageObj.profile_dropdown);
		
		WebElement emailElement = genericFunctions.getElement(logoutPageObj.signout_Button);
		Assert.assertTrue(emailElement != null ? emailElement.isDisplayed() : false,
				"Signout button is not displayed !");
	
		genericFunctions.click(logoutPageObj.signout_Button);
		
		System.out.println("------Logged Out Successfully-------");
		genericFunctions.getDriver().close();
	}

}
