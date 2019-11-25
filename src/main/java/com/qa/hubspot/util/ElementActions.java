package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.basepage.BasePage;

public class ElementActions extends BasePage{
	


public ElementActions(WebDriver driver){
	this.driver = driver;
}

public WebElement getElement(By locator){
	
	WebElement element = null;
	try{
		 element = driver.findElement(locator);
	}
	catch(Exception e){
		
		System.out.println("some exception happened while locating the element : " +element );
	}
	
	return element;
}

public void waitForElementPresence(By locator){
	
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
}

public boolean elementIsDisplayed(By locator){
	
	return getElement(locator).isDisplayed();
	
}
public void  elementClick(By locator){
	getElement(locator).click();
	
}

public void elementSendKeys(By locator,String value){
	
	getElement(locator).sendKeys(value);
	
	
}




}
