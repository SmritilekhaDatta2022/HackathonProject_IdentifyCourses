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
 * Description : This class is to check if the submit button functionality under the Ready to Transform form is working.
 * 				  
 * Note : Methods can be reused. Usage of relative path has been followed.
 */

package org.coursera;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ReadyToTransformTests extends Initialization {
	String errorMsg;
	ReadyToTransformPOM rttpom = new ReadyToTransformPOM();

	/***************** Load the Home Page *****************/
	@Test(priority = 19)
	public void return2HomePage() throws IOException {
		ExtentTest logger = report.createTest("TC020");
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

	/***************** Load the Campus Page *****************/
	@Test(priority = 20)
	public void reachForCampusPage() {
		ExtentTest logger = report.createTest("TC021");
		try {
			String parentWindow = driver.getWindowHandle();
			rttpom.forEnterprise().click();
			Actions action = new Actions(driver);
			action.moveToElement(rttpom.products()).build().perform();
			rttpom.forCampus().click();
			Set<String> handles1 = driver.getWindowHandles();
			for (String childWindow1 : handles1)
				if (!childWindow1.equals(parentWindow))
					driver.switchTo().window(childWindow1);
			assertEquals(driver.getTitle(), readConfigProperties("r2ttitle"));
			Reporter.log("Reached Coursera for Campus");
			logger.log(Status.PASS, "Reached Coursera for Campus");
		} catch (Exception e) {
			Reporter.log("Failed to reach Coursera for Campus");
			logger.log(Status.FAIL, "Failed to reach Coursera for Campus");
		}
	}

	/***************** Reach the Ready to Transform form *****************/
	@Test(priority = 21)
	public void getR2TForm() throws Exception {
		ExtentTest logger = report.createTest("TC022");
		try {
			rttpom.rttForm().click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			assertEquals(driver.findElement(By.id("FirstName")).isDisplayed(), true);
			Reporter.log("Ready To Transform form is available");
			logger.log(Status.PASS, "Ready To Transform form is available");
		} catch (Exception e) {
			Reporter.log("Ready To Transform form is unavailable");
			logger.log(Status.FAIL, "Ready To Transform form is unavailable");
		}
	}

	/****************** Fill the Ready to Transform form with an invalid email id *****************/
	 
	@Test(priority = 22)
	public void fillR2TForm() throws Exception {
		ExtentTest logger = report.createTest("TC023");
		try {
			String[] input = ReadExcelData.readExcelData("Form");
			rttpom.firstName().sendKeys(input[0]);
			rttpom.lastName().sendKeys(input[1]);
			rttpom.title().sendKeys(input[2]);
			rttpom.email().sendKeys(input[3]);
			rttpom.phone().sendKeys(input[4]);
			rttpom.company().sendKeys(input[5]);
			Select select1 = new Select(rttpom.jobTitle());
			select1.selectByVisibleText(input[6]);
			Select select2 = new Select(rttpom.instType());
			select2.selectByVisibleText(input[7]);
			Select select3 = new Select(rttpom.priDisp());
			select3.selectByVisibleText(input[8]);
			Select select4 = new Select(rttpom.country());
			select4.selectByVisibleText(input[9]);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Select select5 = new Select(rttpom.state());
			select5.selectByVisibleText(input[10]);

			Reporter.log("Ready To Transform form filled successfully");
			logger.log(Status.PASS, "Ready To Transform form filled successfully");
		} catch (Exception e) {
			Reporter.log("Ready To Transform form filling unsuccessfull");
			logger.log(Status.FAIL, "Ready To Transform form filling unsuccessfull");
		}
	}

	/***************** Capture the error message *****************/
	@Test(priority = 23)
	public void getErrorMsg() {
		ExtentTest logger = report.createTest("TC024");
		try {
			rttpom.submit().click();
			errorMsg = rttpom.errorMsg().getText();
			Reporter.log("Error Message : " + errorMsg);
			logger.log(Status.PASS, "Error Message : " + errorMsg);
			takeSreenshot("errormessage");
		} catch (Exception e) {
			Reporter.log("Error Message unavailable");
			logger.log(Status.FAIL, "Error Message unavailable");
		}
	}

	
/*********** Check if the actual error message and the expected error message are same*************/ 
	@Test(priority = 24)
	public void verifyErrorMsg() {
		ExtentTest logger = report.createTest("TC025");
		try {
			assertEquals(errorMsg, readConfigProperties("errormsg"));
			Reporter.log("Error Message is correct");
			logger.log(Status.PASS, "Error Message is correct");
		} catch (Exception e) {
			Reporter.log("Error Message is incorrect");
			logger.log(Status.FAIL, "Error Message is incorrect");
		}
	}
}
