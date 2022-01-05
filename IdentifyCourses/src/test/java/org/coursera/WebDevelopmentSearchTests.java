/*
 * Author : Group 1
 * 			Smritilekha Datta (Emp.Id : 2063369)
 * 			Praveen J (Emp.Id : 2063438)
 * 			George Franklin P (Emp.Id : 2063339)
 * 			Dona Mariya Joseph (Emp.Id : 2063490)
 * 			Anjali Kumari Mishra (Emp.Id : 2063519)
 * 
 * Date : 04th January 2022
 * 
 * Description : This class is to check if the Web Development course search
 * 				 with Beginner level and English language functionality is working.
 * 				  
 * Note : Methods can be reused. Usage of relative path has been followed.
 */

package org.coursera;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WebDevelopmentSearchTests extends Initialization {

	WebDevelopmentSearchPOM webpom = new WebDevelopmentSearchPOM();
	WebDriverWait wait;
	String parentWindow;
	String search_course1, firstCourseName, secondCourseName;

	/***************** Check if the URL page is loaded *****************/
	@Test(priority = 1)
	public void verifyHomepageTitle() {
		ExtentTest logger = report.createTest("TC002");
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			String title = driver.getTitle();
			Reporter.log(title);
			assertEquals(title, readConfigProperties("hptitle"));
			Reporter.log("Page Loaded Successfully");
			logger.log(Status.PASS, "Page Loaded Successfully");
			takeSreenshot("homepage");
		} catch (Exception e) {
			Reporter.log("Page Load unsuccessful");
			logger.log(Status.FAIL, "Page Load unsuccessfull");
		}
	}

	/***************** Search for Web Development courses *****************/
	@Test(priority = 2)
	public void searchWebDevelopment() throws IOException, InterruptedException {
		ExtentTest logger = report.createTest("TC003");
		try {
			String[] input = ReadExcelData.readExcelData("WebDev");
			wait.until(ExpectedConditions.presenceOfElementLocated(webpom.searchbox));
			webpom.findSearchBox().click();
			webpom.findSearchBox().sendKeys(input[0]);
			webpom.findAutoSugg().click();
			if (webpom.result().getText().contains(input[0])) {
				Reporter.log("Result page loaded correctly");
				logger.log(Status.PASS, "Result page loaded correctly");
				takeSreenshot("search1");
			}
		} catch (Exception e) {
			Reporter.log("Result page loaded incorrectly");
			logger.log(Status.FAIL, "Result page loaded incorrectly");
		}
	}

	/***************** Check if the Beginners level is selected *****************/
	@Test(priority = 3)
	public void selectLevel() {
		ExtentTest logger = report.createTest("TC004");
		try {
			webpom.findlevel().click();
			wait.until(ExpectedConditions.presenceOfElementLocated(webpom.levopt));
			webpom.findLevelOption().click();
			String level = webpom.findLevelText().getText();
			assertEquals(level, readConfigProperties("level"));
			Reporter.log(level + " selected successfully");
			logger.log(Status.PASS, level + " selected successfully");
		} catch (Exception e) {
			Reporter.log("Level selection unsuccessfull");
			logger.log(Status.FAIL, "Level selection unsuccessfull");
		}
	}

	/***************** Check if the English language is selected *****************/
	@Test(priority = 4)
	public void selectLanguage() {
		ExtentTest logger = report.createTest("TC005");
		try {
			webpom.findLanguage().click();
			wait.until(ExpectedConditions.presenceOfElementLocated(webpom.langopt));
			webpom.findLanguageOption().click();
			String language = webpom.findLanguageText().getText();
			assertEquals(language, readConfigProperties("lang"));
			Reporter.log(language + " selected successfully");
			logger.log(Status.PASS, language + " selected successfully");
		} catch (Exception e) {
			Reporter.log("Language selection unsuccessfull");
			logger.log(Status.FAIL, "Language selection unsuccessfull");
		}
	}

	/***************** Extract the first course name *****************/
	@Test(priority = 5)
	public void getFirstCourseName() {
		ExtentTest logger = report.createTest("TC006");
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(webpom.firstcoursename));
			firstCourseName = webpom.findFirstCourseName().getText();
			Reporter.log("First course name is - " + firstCourseName);
			logger.log(Status.PASS, "First course name is - " + firstCourseName);
		} catch (Exception e) {
			Reporter.log("Unable to fetch Course Name");
			logger.log(Status.FAIL, "Unable to fetch Course Name");
		}
	}

	/***************** Extract the second course name *****************/
	@Test(priority = 6)
	public void getSecondCourseName() {
		ExtentTest logger = report.createTest("TC007");
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(webpom.secondcoursename));
			secondCourseName = webpom.findSecondCourseName().getText();
			Reporter.log("Second course name is - " + secondCourseName);
			logger.log(Status.PASS, "Second course name is - " + secondCourseName);
		} catch (Exception e) {
			Reporter.log("Unable to fetch Course Name");
			logger.log(Status.FAIL, "Unable to fetch Course Name");
		}
	}

	/***************** Load the first course page *****************/
	@Test(priority = 7)
	public void getCourse1Page() {
		ExtentTest logger = report.createTest("TC008");
		try {
			parentWindow = driver.getWindowHandle();
			webpom.findFirstCourseName().click();
			Set<String> handles1 = driver.getWindowHandles();
			for (String childWindow1 : handles1)
				if (!childWindow1.equals(parentWindow))
					driver.switchTo().window(childWindow1);
			assertEquals(driver.getTitle(), firstCourseName + " | Coursera");
			Reporter.log("Reached Course 1 Page");
			logger.log(Status.PASS, "Reached Course 1 Page");
			takeSreenshot("course1");
		} catch (Exception e) {
			Reporter.log("Failed to reach Course 1 Page");
			logger.log(Status.FAIL, "Failed to reach Course 1 Page");
		}
	}

	/***************** Extract the first course rating *****************/
	@Test(priority = 8)
	public void getFirstCourseRating() {
		ExtentTest logger = report.createTest("TC009");
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(webpom.firstcourserating));
			String firstCourseRating = webpom.findFirstCourseRating().getText();
			Reporter.log("First course rating is - " + firstCourseRating);
			logger.log(Status.PASS, "First course rating is - " + firstCourseRating);
		} catch (Exception e) {
			Reporter.log("Unable to fetch Course Rating");
			logger.log(Status.FAIL, "Unable to fetch Course Rating");
		}
	}

	/*****************
	 * Extract the first course total learning hours
	 *****************/
	@Test(priority = 9)
	public void getCourse1Duration() {
		ExtentTest logger = report.createTest("TC0010");
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.presenceOfElementLocated(webpom.firstcourserating));
			String firstCourseDuration = webpom.findFirstCourseDuration().getText();
			Reporter.log("First course rating is - " + firstCourseDuration);
			logger.log(Status.PASS, "First course Duration is - " + firstCourseDuration);
		} catch (Exception e) {
			Reporter.log("Unable to fetch Course Duration");
			logger.log(Status.FAIL, "Unable to fetch Course Duration");
		}
	}

	/***************** Back to the Results Page *****************/
	@Test(priority = 10)
	public void backToResultPage() {
		ExtentTest logger = report.createTest("TC0011");
		try {
			driver.close();
			driver.switchTo().window(parentWindow);
			assertEquals(driver.getTitle(),
					"Top Web Development Courses Courses - Learn Web Development Courses Online | Coursera");
			Reporter.log("Reached Result Page Successfully");
			logger.log(Status.PASS, "Reached Result Page Successfully");
		} catch (Exception e) {
			Reporter.log("Unable to reach Result Page");
			logger.log(Status.FAIL, "Unable to reach Result Page");
		}
	}

	/***************** Load the second course page *****************/
	@Test(priority = 11)
	public void getCourse2Page() {
		ExtentTest logger = report.createTest("TC0012");
		try {
			webpom.findSecondCourseName().click();
			Set<String> handles2 = driver.getWindowHandles();
			for (String childWindow2 : handles2)
				if (!childWindow2.equals(parentWindow))
					driver.switchTo().window(childWindow2);
			assertEquals(driver.getTitle(), secondCourseName + " | Coursera");
			Reporter.log("Reached Course 2 Page");
			logger.log(Status.PASS, "Reached Course 2 Page");
			takeSreenshot("course2");
		} catch (Exception e) {
			Reporter.log("Failed to reach Course 2 Page");
			logger.log(Status.FAIL, "Failed to reach Course 2 Page");
		}
	}

	/***************** Extract the second course rating *****************/
	@Test(priority = 12)
	public void getSecondCourseRating() {
		ExtentTest logger = report.createTest("TC0013");
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.presenceOfElementLocated(webpom.secondcourserating));
			String secondCourseRating = webpom.findSecondCourseRating().getText();
			Reporter.log("Second course rating is - " + secondCourseRating);
			logger.log(Status.PASS, "Second course rating is - " + secondCourseRating);
		} catch (Exception e) {
			Reporter.log("Unable to fetch Course Rating");
			logger.log(Status.FAIL, "Unable to fetch Course Rating");
		}
	}

	/*****************
	 * Extract the second course total learning hours
	 *****************/
	@Test(priority = 13)
	public void getCourse2Duration() {
		ExtentTest logger = report.createTest("TC0014");
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.presenceOfElementLocated(webpom.firstcourserating));
			String secondCourseDuration = webpom.findSecondCourseDuration().getText();
			Reporter.log("Second course rating is - " + secondCourseDuration);
			logger.log(Status.PASS, "Second course Duration is - " + secondCourseDuration);
		} catch (Exception e) {
			Reporter.log("Unable to fetch Course Duration");
			logger.log(Status.FAIL, "Unable to fetch Course Duration");
		}
	}

	/***************** Back to the Results Page *****************/
	@Test(priority = 14)
	public void backToResultPage2() {
		ExtentTest logger = report.createTest("TC0015");
		try {
			driver.close();
			driver.switchTo().window(parentWindow);
			assertEquals(driver.getTitle(),
					"Top Web Development Courses Courses - Learn Web Development Courses Online | Coursera");
			Reporter.log("Reached Result Page Successfully");
			logger.log(Status.PASS, "Reached Result Page Successfully");
		} catch (Exception e) {
			Reporter.log("Unable to reach Result Page");
			logger.log(Status.FAIL, "Unable to reach Result Page");
		}
	}
}
