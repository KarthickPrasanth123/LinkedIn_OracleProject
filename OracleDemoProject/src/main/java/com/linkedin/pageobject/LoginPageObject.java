package com.linkedin.pageobject;

import org.openqa.selenium.By;

public class LoginPageObject {
	public By signIn_Button=By.xpath("//a[@class='nav__button-secondary btn-md btn-secondary-emphasis']");
	public By email_Input=By.name("email");
	public By continue_Button=By.className("signin__button");
	public By password_Input=By.id("password");
	public By continue_submit=By.xpath("//button[@type='submit']");
	
}
