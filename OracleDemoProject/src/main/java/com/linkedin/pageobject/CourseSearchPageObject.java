package com.linkedin.pageobject;

import org.openqa.selenium.By;

public class CourseSearchPageObject {
	public By searchBox_Input = By.xpath("//input[contains(@class,'input')]");
	public By search_Button = By.xpath("//button[contains(@class,nav-bar]");
	public By getHoursDuration = By.xpath("//div[contains(@class,'overview__head')]/ul/li[1]");
	public By clickFirstCourse = By.xpath("(//div[@class='lls-card-detail-card-body__main']//a/span)[1]");

	public By getResultLink(String course) {
		return By.xpath("//span[text()='" + course + "']");
	}
}
