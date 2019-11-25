package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.util.ElementActions;

public class LoginPageNPF extends BasePage {
	ElementActions elementActions;
	
	By email = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	public LoginPageNPF(WebDriver driver){
		
		this.driver =driver;
		elementActions = new ElementActions(driver);
		
	}
	public void getLoginpageTitle(){
		driver.getTitle();
	}
	
	public boolean VerifySignUpLink(){
		return elementActions.elementIsDisplayed(signUpLink);
		
	}
	public void doLogin(String username,String pwd){
		elementActions.elementSendKeys(email, username);
		elementActions.elementSendKeys(password, pwd);
		elementActions.elementClick(loginButton);
	}

}
