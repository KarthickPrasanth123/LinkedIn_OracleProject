/**
 * 
 */
package com.linkedin.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.linkedin.pageobject.CourseSearchPageObject;
import com.selenium.commons.GenericFunctions;

/**
 * @author Karthick Prasanth
 *
 */
public class CourseSearchPage {
	private GenericFunctions genericFunctions = GenericFunctions.getInstance();
	private CourseSearchPageObject courseSearchPageObj = new CourseSearchPageObject();

	public void searchForCourse(String courseValue) {
		String course = null;
		String courses[] = null;
		System.out.println("------Course Search Page is displayed !-------");
		if (courseValue.equals("course")) {
			course = genericFunctions.getPropertyValue(courseValue);
			courses = course.split(",");
			for (int i = 0; i < courses.length; i++) {
				getCourseDuration(courses[i]);
			}
		} else if (courseValue.equals("courseKeyWord")) {
			course = genericFunctions.getPropertyValue(courseValue);
			courses = course.split(",");
			for (int i = 0; i < courses.length; i++) {
				getCourseDurationForKeywordSearch(courses[i]);
			}
		}

	}

	public void searchForCourseUsingKeyword() {
		System.out.println("------Course Search Page is displayed !-------");
		String course = genericFunctions.getPropertyValue("courseKeyWord");
		String courses[] = course.split(",");
		for (int i = 0; i < courses.length; i++) {
			getCourseDurationForKeywordSearch(courses[i]);
		}
	}

	private void getCourseDuration(String course) {
		genericFunctions.getElement(courseSearchPageObj.searchBox_Input).clear();
		genericFunctions.input(courseSearchPageObj.searchBox_Input, course);
		genericFunctions.getElement(courseSearchPageObj.searchBox_Input).sendKeys(Keys.ENTER);

		WebElement element = genericFunctions.getElement(courseSearchPageObj.getResultLink(course));
		Assert.assertTrue(element != null ? element.isDisplayed() : false, "Result is not displayed !");
		genericFunctions.click(courseSearchPageObj.getResultLink(course));
		System.out.println("------Course listed Successfully !-------");
		String duration = genericFunctions.getElement(courseSearchPageObj.getHoursDuration).getText();
		String hr[] = duration.split("h ");
		String min[] = hr[1].split("m");
		int time = Integer.parseInt(hr[0]) * 60 + Integer.parseInt(min[0]);
		System.out.println(String.format("Total course duration for the course \"%s\" :-> %s(%s minutes)", course,
				duration, time));
	}

	private void getCourseDurationForKeywordSearch(String course) {
		genericFunctions.getElement(courseSearchPageObj.searchBox_Input).clear();
		genericFunctions.input(courseSearchPageObj.searchBox_Input, course);
		genericFunctions.getElement(courseSearchPageObj.searchBox_Input).sendKeys(Keys.ENTER);

		WebElement element = genericFunctions.getElement(courseSearchPageObj.clickFirstCourse);
		Assert.assertTrue(element != null ? element.isDisplayed() : false, "Result is not displayed !");
		genericFunctions.click(courseSearchPageObj.clickFirstCourse);
		System.out.println("------Course listed Successfully !-------");
		String duration = genericFunctions.getElement(courseSearchPageObj.getHoursDuration).getText();
		String hr[] = duration.split("h ");
		String min[] = hr[1].split("m");
		int time = Integer.parseInt(hr[0]) * 60 + Integer.parseInt(min[0]);
		System.out.println(String.format("Total course duration for the course \"%s\" :-> %s(%s minutes)", course,
				duration, time));
	}

}
