package com.xamplify.LIVE;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class SaveVideo extends VideoCampaign {
				// @AfterMethod  [for auto responses...comment @AfterTest annotation and use @Aftermethod , extends  AutoResponsesVideo]
	@AfterTest
	public void vsave() throws InterruptedException, SQLException
	{
		driver.findElement(By.xpath(properties.getProperty("v_testmail"))).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("v_mailid"))).sendKeys("gayatrialla11@gmail.com");
		driver.findElement(By.xpath(properties.getProperty("vsubmit"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("vok"))).click();
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath(properties.getProperty("vsave1"))).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("vsave_spamcheck"))).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("vsave_insidespamcheck"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("vsave_inside_refresh"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("vsave_spam_close"))).click();
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath(properties.getProperty("vsaved"))).click();
		Thread.sleep(5000);
	}

	
}
