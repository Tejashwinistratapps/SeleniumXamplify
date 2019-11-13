package com.xamplify.LIVE;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ScheduleVideo extends VideoCampaign {
	// @AfterMethod  [for auto responses...comment @AfterTest annotation and use @Aftermethod , extends  AutoResponsesVideo]
	@AfterTest
	public void vschedule() throws InterruptedException, SQLException
	{
	driver.findElement(By.xpath(properties.getProperty("v_schedule_click"))).click();
	Thread.sleep(5000);
	WebElement dateTable = driver.findElement(By.xpath(properties.getProperty("v_schdule_date")));
    dateTable.click();
    
  
    
    		WebElement we1=driver.findElement(By.xpath(properties.getProperty("v_schdule_selectdate")));
    		we1.click();
	Thread.sleep(8000);
	
	
	driver.findElement(By.xpath(properties.getProperty("vschdule_date_hour"))).sendKeys("11");
	Thread.sleep(5000);
	driver.findElement(By.xpath(properties.getProperty("vschdule_date_min"))).sendKeys("59");
	Thread.sleep(5000);
	
	
WebElement country_drpdwn=driver.findElement(By.xpath(properties.getProperty("v_schedule_cntrydrpdwn")));
Select country1=new Select(country_drpdwn);
Thread.sleep(5000);
country1.selectByValue("103");
Thread.sleep(15000);
driver.findElement(By.xpath(properties.getProperty("v_schedule"))).click();
Thread.sleep(8000);

}

}
