package com.xamplify.LIVE;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;


//public class SaveEmail extends AutoResponsesEmail {

public class SaveEmail extends Emailcampaign {
	
	// @AfterMethod  [for auto responses...comment @AfterTest annotation and use @Aftermethod , extends AutoResponsesEmail]
	
	@AfterTest
	public void save() throws InterruptedException, SQLException
	{
	
		
		driver.findElement(By.xpath(properties.getProperty("e_testmail"))).click();							//click on test mail

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("e_mailid"))).sendKeys("agayatri@stratapps.com");		//send to any mail id

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("submit"))).click();								//submit
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("ok"))).click();									//ok
		Thread.sleep(5000);
	
		driver.findElement(By.xpath(properties.getProperty("spamcheck"))).click();
		Thread.sleep(3000);
		
		WebDriverWait w7 = new WebDriverWait(driver, 30);
		WebElement we7 = w7.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("insidespamcheck"))));
		we7.click();
		
		Thread.sleep(7000);
		/*
		WebDriverWait w8 = new WebDriverWait(driver, 30);
		WebElement we8 = w8.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("inside_refresh"))));
		we8.click(); //refresh
		*/
		driver.findElement(By.xpath(properties.getProperty("inside_refresh"))).click();
		Thread.sleep(7000);
		
		

			driver.findElement(By.xpath(properties.getProperty("spam_close"))).click();
			Thread.sleep(7000);
			
	
	driver.findElement(By.xpath(properties.getProperty("evsave_click"))).click();		//click SAVE
	Thread.sleep(5000);
	
	driver.findElement(By.xpath(properties.getProperty("evsave"))).click();				//click to save campaign
	Thread.sleep(8000);
	
	
	}
	
}
	
	
	
	
	
	
