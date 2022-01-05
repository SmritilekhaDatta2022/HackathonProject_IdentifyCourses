/**********************************************************************************************
 * Author : Group 1

 * 			Smritilekha Datta (Emp.Id : 2063369)
 * 			Praveen J (Emp.Id : 2063438)
 * 			George Franklin P (Emp.Id : 2063339)
 * 			Dona Mariya Joseph (Emp.Id : 2063490)
 * 			Anjali Kumari Mishra (Emp.Id : 2063519)
 * 
 * Date : 04th January 2022
 * 
 * Description : This class is to implement the Extent Report for the Coursera Idendify Courses Automation 
 * 
 * Note : Methods can be reused.
 *********************************************************************************************/
package org.coursera;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	public static ExtentReports report;

	public static ExtentReports reporter() {
		if (report == null) {
			ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "./HTMLreport/report.html");
			report = new ExtentReports();
			report.attachReporter(htmlreporter);
			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Browser", "edge");

			htmlreporter.config().setDocumentTitle("Coursera website automation");
			htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlreporter.config().setTheme(Theme.DARK);
			htmlreporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		}
		return report;
	}
}
