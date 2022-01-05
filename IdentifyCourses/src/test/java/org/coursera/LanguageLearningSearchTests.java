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
 * Description : This class is to check if the Language Learning course search functionality is working.
 * 				  
 * Note : Methods can be reused. Usage of relative path has been followed.
 */

package org.coursera;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LanguageLearningSearchTests extends Initialization {

	LanguageLearningSearchPOM llspom;
	String search, searchButton, filter, showAll, show, closing, level, lvl;
	String courseinput;

	/***************** Load the Home Page *****************/
	@Test(priority = 15)
	public void returnHomePage() throws IOException {
		ExtentTest logger = report.createTest("TC016");
		try {
			driver.navigate().to(readConfigProperties("URL"));
			String title = driver.getTitle();
			assertEquals(title, readConfigProperties("hptitle"));
			Reporter.log("Page Loaded Successfully");
			logger.log(Status.PASS, "Rached HomePage Successfully");
		} catch (Exception e) {
			Reporter.log("Page Load unsuccessful");
			logger.log(Status.FAIL, "Unable to load HomePage");
		}
	}

	/***************** Search for Language Learning courses *****************/
	@Test(priority = 16)
	public void searchLangLearn() throws Exception {
		ExtentTest logger = report.createTest("TC017");
		try {
			String[] input = ReadExcelData.readExcelData("LanLearn");
			llspom = new LanguageLearningSearchPOM();
			llspom.search().clear();
			llspom.search().sendKeys(input[0]);
			llspom.searchButton().click();
			if (llspom.result().getText().contains(input[0])) {
				Reporter.log("Result page loaded correctly");
				logger.log(Status.PASS, "Result page loaded correctly");
				takeSreenshot("search2");
			}
		} catch (Exception e) {
			Reporter.log("Page Load unsuccessful");
			logger.log(Status.FAIL, "Unable to load HomePage");
		}
	}

	/*****************
	 * Extract all the languages with the total counts
	 *****************/
	@Test(priority = 17)
	public void langFilter() {
		ExtentTest logger = report.createTest("TC018");
		try {
			llspom.filter().click();
			llspom.showAll().click();
			Reporter.log(llspom.show().getText());
			logger.log(Status.PASS, llspom.show().getText());
			takeSreenshot("languages");
			llspom.closing().click();
		} catch (Exception e) {
			Reporter.log("Page Load unsuccessful");
			logger.log(Status.FAIL, "Unable to fetch languages");
		}

	}

	/*****************
	 * Extract all the different levels with the total counts
	 *****************/
	@Test(priority = 18)
	public void levelFilter() {
		ExtentTest logger = report.createTest("TC019");
		try {
			llspom.level().click();
			Reporter.log(llspom.lvl().getText());
			logger.log(Status.PASS, llspom.lvl().getText());
			takeSreenshot("levels");
		} catch (Exception e) {
			Reporter.log("Page Load unsuccessful");
			logger.log(Status.FAIL, "Unable to fetch levels");
		}
	}
}
