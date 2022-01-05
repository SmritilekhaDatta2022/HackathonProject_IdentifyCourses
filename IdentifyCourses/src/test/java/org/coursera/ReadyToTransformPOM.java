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
 * Description : This class is to identify the WebElements of the Coursera Ready to Transform form
 * 		 and to contain the relevant methods which perform operations on these WebElements.
 * 
 * Note : Methods can be reused. Usage of relative path has been followed.
 */

package org.coursera;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReadyToTransformPOM extends Initialization {

	By forenterprise = By.id("enterprise-link");
	By products = By.id("menu-item-9140");
	By forcampus = By.id("menu-item-4901");
	By rttform = By.xpath("//a[@href='#form']");
	By firstname = By.id("FirstName");
	By lastname = By.id("LastName");
	By title = By.id("Title");
	By email = By.id("Email");
	By phone = By.id("Phone");
	By company = By.id("Company");
	By jobtitle = By.id("C4C_Job_Title__c");
	By insttype = By.id("Institution_Type__c");
	By pridisp = By.id("Primary_Discipline__c");
	By country = By.id("Country");
	By state = By.id("State");
	By submit = By.xpath("//button[@class='mktoButton']");
	By errormsg = By.id("ValidMsgEmail");

	public WebElement forEnterprise() {
		return driver.findElement(forenterprise);
	}

	public WebElement products() {
		return driver.findElement(products);
	}

	public WebElement forCampus() {
		return driver.findElement(forcampus);
	}

	public WebElement rttForm() {
		return driver.findElement(rttform);
	}

	public WebElement firstName() {
		return driver.findElement(firstname);
	}

	public WebElement lastName() {
		return driver.findElement(lastname);
	}

	public WebElement title() {
		return driver.findElement(title);
	}

	public WebElement email() {
		return driver.findElement(email);
	}

	public WebElement phone() {
		return driver.findElement(phone);
	}

	public WebElement company() {
		return driver.findElement(company);
	}

	public WebElement jobTitle() {
		return driver.findElement(jobtitle);
	}

	public WebElement instType() {
		return driver.findElement(insttype);
	}

	public WebElement priDisp() {
		return driver.findElement(pridisp);
	}

	public WebElement country() {
		return driver.findElement(country);
	}

	public WebElement state() {
		return driver.findElement(state);
	}

	public WebElement submit() {
		return driver.findElement(submit);
	}

	public WebElement errorMsg() {
		return driver.findElement(errormsg);
	}
}
