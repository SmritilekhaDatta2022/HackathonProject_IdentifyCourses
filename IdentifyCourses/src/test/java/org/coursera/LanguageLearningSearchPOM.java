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

public class LanguageLearningSearchPOM extends Initialization {

	By homepage = By.xpath(
			"//*[@id=\"rendered-content\"]/div/div/span/div[1]/header/div[2]/div/div[1]/div/div/div[2]/div/div/div/a");
	By search = By.xpath("//input[@class='react-autosuggest__input']");
	By searchButton = By.cssSelector("button.nostyle:nth-child(3) > div:nth-child(1)");
	By filter = By.xpath("//div[@class='Select-placeholder' and contains(text(),'Language')]");
	By showAll = By.xpath("//*[@id=\"react-select-2--option-9\"]/div/button[2]");
	By show = By.xpath("//div[@class='c-modal-content']/div[@class='filters-modal-content horizontal-box']");
	By closing = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/div/div[3]/div/div[3]/div[3]/a");

	By level = By.xpath("//div[@class='Select-placeholder' and contains(text(),'Level')]");
	By lvl = By.xpath("//div[@class='Select-menu-outer']/div[@class='Select-menu']");
	By searchbox = By.xpath(
			"//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/div[1]/input");
	By result = By.xpath("//*[@id=\"main\"]/div/div[1]/div/h2/span");

	public WebElement search() {
		return driver.findElement(search);
	}

	public WebElement searchButton() {
		return driver.findElement(searchButton);
	}

	public WebElement filter() {
		return driver.findElement(filter);
	}

	public WebElement showAll() {
		return driver.findElement(showAll);
	}

	public WebElement show() {
		return driver.findElement(show);
	}

	public WebElement closing() {
		return driver.findElement(closing);
	}

	public WebElement level() {
		return driver.findElement(level);
	}

	public WebElement lvl() {
		return driver.findElement(lvl);
	}

	public WebElement homepage() {
		return driver.findElement(homepage);
	}

	public WebElement findSearchBox() {
		return driver.findElement(searchbox);
	}

	public WebElement result() {
		return driver.findElement(result);
	}

}
