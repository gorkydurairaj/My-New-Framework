package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeSuite
	public void setUp(){
		
		basePage = new BasePage();
		prop = basePage.intialize_properties();
		driver = basePage.intialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		}
	
	@Test
	public void verifyHomePageTitleTest(){
		String HomePageTitle = homePage.verifyHomePageTitle();
		System.out.println("HomePage title is : " +HomePageTitle);
		Assert.assertEquals(HomePageTitle,Constants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void verifyHomePageHeaderTitleIsDisplayedTest(){
		
		Assert.assertTrue(homePage.verifyHomePageHeaderTitleIsDisplayed());
		
	}
	
	@Test
	public void getHomePageHeaderTitleTest(){
		String HomePageHeaderTitle = homePage.getHomePageHeaderTitle();
		System.out.println("HomePage header title is : " +HomePageHeaderTitle);
		Assert.assertEquals(HomePageHeaderTitle, Constants.HOME_PAGE_HEADER_TITLE);
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
