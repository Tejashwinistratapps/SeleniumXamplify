package com.xamplify.login;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Login {
	 WebDriver driver = Instance.getInstance();

		Properties prop = PropertiesFile.readPropertyFile("datafile.properties");
	@Test(priority=1)
	public void start() throws InterruptedException {
		
	driver.get(prop.getProperty("baseUrl"));
	
	driver.manage().window().maximize();
	
	Thread.sleep(3000);
	}

	@Test(priority=2,enabled=true)
	public void login() throws InterruptedException, SQLException {

		driver.findElement(By.xpath(prop.getProperty("loginclick"))).click();
		Thread.sleep(5000);
		driver.findElement(By.id(prop.getProperty("email"))).sendKeys(prop.getProperty("user.name"));
		driver.findElement(By.id(prop.getProperty("password"))).sendKeys(prop.getProperty("user.password"));
		driver.findElement(By.id(prop.getProperty("signin"))).click();
		Thread.sleep(15000);
		
	}
			
		
			
	
}
