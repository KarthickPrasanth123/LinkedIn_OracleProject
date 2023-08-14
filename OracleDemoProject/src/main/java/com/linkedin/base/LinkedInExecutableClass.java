package com.linkedin.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.linkedin.pages.CourseSearchPage;
import com.linkedin.pages.LoginPage;
import com.linkedin.pages.LogoutPage;
import com.selenium.commons.GenericFunctions;

/**
 * @author Karthick Prasanth
 *
 */
public class LinkedInExecutableClass {

	private GenericFunctions genericFunctions;
	private LoginPage loginPage;
	private CourseSearchPage courseSearch;
	private LogoutPage logoutPage;

	@BeforeTest
	public void loadConfig() {
		loginPage = new LoginPage();
		genericFunctions = GenericFunctions.getInstance();
		courseSearch = new CourseSearchPage();
		logoutPage =new LogoutPage();
	}

	@Test(priority = 1)
	public void launchBrowserAndSearchCourse() {
		loginPage.login();
		courseSearch.searchForCourse("course");
	}

	@Test(priority = 2)
	public void searchCourseUsingKeyword() {
		courseSearch.searchForCourse("courseKeyWord");
	}

	@AfterTest
	public void logoutAndCloseBrowser() {
		logoutPage.logout();
		genericFunctions.getDriver().close();
	}

}
