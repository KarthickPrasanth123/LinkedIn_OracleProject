package com.linkedin.pageobject;

import org.openqa.selenium.By;

public class LogoutPageObject {
	public By profile_dropdown=By.xpath("//div[@class='init__header']//div[text()='Me']");
	public By signout_Button=By.xpath("//button[contains(@class,'menu__dropdown')]//div[text()='Sign out']");
		
}
