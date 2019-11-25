package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.basepage.BasePage;

public class HomePage extends BasePage {
	
	@FindBy(xpath ="//h1[@class='private-page__title']")
	WebElement homePageHeader;
	
	@FindBy(xpath="//span[@class='visibility-label']")
	WebElement visibilityChecked;
	
   public  HomePage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
   
   
   public String verifyHomePageTitle(){
	   
	   return driver.getTitle();
	   
   }
   
   public String getHomePageHeaderTitle(){
	   
	   return homePageHeader.getText();
   }
   
   public boolean verifyHomePageHeaderTitleIsDisplayed(){
	  return homePageHeader.isDisplayed();
	   
   }
   
   public String getVisiblityCheckedTitle(){
	   
	   return visibilityChecked.getText();
   }
   
   
	
	
	}

	
	


