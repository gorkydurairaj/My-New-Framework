package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.pages.LoginPageNPF;

public class LoginPageNPFTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPageNPF loginPageNpf;

@BeforeMethod
public void setUp(){
	basePage = new BasePage();
	prop = basePage.intialize_properties();
	driver = basePage.intialize_driver(prop);
	loginPageNpf = new LoginPageNPF(driver); 
	
}

@Test
public void verifySignUpLinkTest(){
	Assert.assertTrue(loginPageNpf.VerifySignUpLink());
}

@AfterMethod
public void tearDown(){
	driver.quit();
}
}
