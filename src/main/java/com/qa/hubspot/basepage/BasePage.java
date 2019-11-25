package com.qa.hubspot.basepage;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.util.TimeUtil;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver intialize_driver(Properties prop){
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
		else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else{
			System.out.println(browserName+"defined is not correct.Please give the correct browsername in config");
		}
		
		driver.get(prop.getProperty("url"));
		TimeUtil.mediumWait();
		return driver;
		
		
		
	}
	public Properties intialize_properties(){
		prop = new Properties();
		try { 
			FileInputStream ip = new FileInputStream("E:\\Eclipse workspace\\MyFrameWork\\src\\main\\java\\com\\qa\\hubspot"
					+ "\\configuration\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	
	
	

}
