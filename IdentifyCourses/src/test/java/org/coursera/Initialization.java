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
 * Description : This class is to invoke the browser, load the Coursera page and to close the browser.
 * 				 
 * 
 * Note : Methods can be reused. Usage of relative path has been followed.
 */

package org.coursera;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.google.common.io.Files;

public class Initialization {
	static WebDriver driver;
	ExtentReports report = ExtentReport.reporter();

	
	/****************** Reading the content from config.properties file *****************/
	 
	public String readConfigProperties(String key) throws IOException {
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

	/***************** Invoking cross browser for execution *****************/
	@BeforeSuite
	public void invokeBrowser() {
		ExtentTest logger = report.createTest("TC001");
		try {
			String browser = readConfigProperties("browser");
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
			}

			else if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "src\\test\\resources\\msedgedriver.exe");
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
			} else {
				String Nodeurl = "http://192.168.1.5:4444/wd/hub";
				DesiredCapabilities capability = new DesiredCapabilities();	  //Implementation of Selenium Grid
				capability.setBrowserName("chrome");							
				capability.setPlatform(Platform.ANY);
				driver = new RemoteWebDriver(new URL(Nodeurl), capability);
			}

			logger.log(Status.PASS, "Browser opened Successfully");
		} catch (Exception e) {
			logger.log(Status.FAIL, "Browser not opening");
		}

		try {
			driver.manage().window().maximize();
			driver.get(readConfigProperties("URL")); 				// Load the base URL
			logger.log(Status.PASS, "URL load succesfully");
		} catch (Exception e) {
			logger.log(Status.FAIL, "URL not loaded");
		}
	}

	@AfterSuite
	public void closeBrowser() {
		report.flush();
		driver.quit();
	}

	/********************* To capture Screenshots ***********************/
	public void takeSreenshot(String name) {
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(ss, new File("./screenshot/" + name + ".png"));
			Reporter.log("Screenshot captured successfully");
		} catch (Exception e) {
			Reporter.log("error");
		}
	}
}
