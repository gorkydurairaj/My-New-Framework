package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.intialize_properties();
		driver = basePage.intialize_driver(prop);
		loginPage = new LoginPage(driver); 
		
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is :" +title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		
		}
	
	@Test(priority=2)
	public void verifySignUpLinkIsDisplayedTest(){
		
		Assert.assertTrue(loginPage.signUpLinkisDisplayed());
	
	}
	
	@Test(priority=3)
	public void VerifyLoginWithvalidCred(){
		
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password") );
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
