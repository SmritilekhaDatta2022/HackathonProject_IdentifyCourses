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
 * Description : This class is to identify the WebElements of the Coursera Home page 
 * 		 and to contain the relevant methods which perform operations on these WebElements.
 * 
 * Note : Methods can be reused. Usage of relative path has been followed.
 */

package org.coursera;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebDevelopmentSearchPOM extends Initialization {

	By searchbox = By.xpath(
			"//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/div[1]/input");
	By searchButton = By.cssSelector("button.nostyle:nth-child(3) > div:nth-child(1)");
	By result = By.xpath("//*[@id=\"main\"]/div/div[1]/div/h2/span");
	By levels = By.xpath("//*[@id=\"react-select-3--value\"]/div[1]");
	By levopt = By.xpath("//*[@value='Beginner']");
	By levtxt = By.xpath("//h6[contains(text(),'Beginner')]");

	By langs = By.xpath("//*[@id=\"react-select-2--value\"]/div[1]");
	By langopt = By.xpath("//*[@id=\"react-select-2--option-0\"]");
	By langtxt = By.xpath("//h6[contains(text(),'English')]");

	By firstcoursename = By
			.xpath("//*[@id=\"main\"]/div/div/div[1]/div/div[2]/div/div/div/div/ul/li[1]/div/div/a/div/div[2]/h2");
	By secondcoursename = By
			.xpath("//*[@id=\"main\"]/div/div/div[1]/div/div[2]/div/div/div/div/ul/li[2]/div/div/a/div/div[2]/h2");

	By firstcourserating = By.xpath("//*[@id=\"main\"]/div[3]/div/div/div/ul/li/a/div/span");
	By secondcourserating = By.xpath("//*[@id=\"main\"]/div[3]/div/div/div/ul/li/a/div/span");

	By firstcourseduration = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div/div/div[5]/div[2]/div/span");
	By secondcourseduration = By
			.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div/div[2]/div[6]/div[2]/div/span");

	public WebElement findSearchBox() {
		return driver.findElement(searchbox);
	}

	public WebElement findAutoSugg() {
		return driver.findElement(searchButton);
	}

	public WebElement findlevel() {
		return driver.findElement(levels);
	}

	public WebElement findLevelOption() {
		return driver.findElement(levopt);
	}

	public WebElement findLevelText() {
		return driver.findElement(levtxt);
	}

	public WebElement findLanguage() {
		return driver.findElement(langs);
	}

	public WebElement findLanguageOption() {
		return driver.findElement(langopt);
	}

	public WebElement findLanguageText() {
		return driver.findElement(langtxt);
	}

	public WebElement findFirstCourseName() {
		return driver.findElement(firstcoursename);
	}

	public WebElement findSecondCourseName() {
		return driver.findElement(secondcoursename);
	}

	public WebElement findFirstCourseRating() {
		return driver.findElement(firstcourserating);
	}

	public WebElement findSecondCourseRating() {
		return driver.findElement(secondcourserating);
	}

	public WebElement result() {
		return driver.findElement(result);
	}

	public WebElement findFirstCourseDuration() {
		return driver.findElement(firstcourseduration);
	}

	public WebElement findSecondCourseDuration() {
		return driver.findElement(secondcourseduration);
	}
}
