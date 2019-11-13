package com.xamplify.LIVE;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class ScheduleEmail extends Emailcampaign {
	
	// @AfterMethod  [for auto responses...comment @AfterTest annotation and use @Aftermethod , extends AutoResponsesEmail]
	
	@AfterTest
	public void launch() throws InterruptedException, SQLException
	{
	
		driver.findElement(By.xpath(properties.getProperty("email_schedule_click"))).click();
		Thread.sleep(5000);
		
		
		
	        WebElement dateTable = driver.findElement(By.xpath(properties.getProperty("select_date")));
	        dateTable.click();
	        
	        		WebElement we1=driver.findElement(By.xpath(properties.getProperty("evsch_date_click")));
	        		we1.click();
			Thread.sleep(8000);
			
			/*Date gd =	Calendar.getInstance().getTime();
			
			String newString = new SimpleDateFormat("H:mm").format(gd);
			System.out.println(newString);*/
			
			Calendar calendar = Calendar.getInstance();
			
			int hours = calendar.get(Calendar.HOUR_OF_DAY);
			int minutes = calendar.get(Calendar.MINUTE);
			System.out.println(hours);
			System.out.println(minutes);
	    	
			if(hours < 12  )
				
			
			{
	    	driver.findElement(By.xpath(properties.getProperty("evsh_date_hour"))).sendKeys("1");
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("evsh_date_min"))).sendKeys("11");
			Thread.sleep(5000);
			}
			else
			{
				driver.findElement(By.xpath(properties.getProperty("evsh_date_hour"))).sendKeys("11");
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("evsh_date_min"))).sendKeys("59");
				Thread.sleep(5000);
			}
			
	    	
		WebElement country_drpdwn=driver.findElement(By.xpath(properties.getProperty("select_country")));
		Select country1=new Select(country_drpdwn);
		Thread.sleep(5000);
		country1.selectByValue("103");
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("email_schedulelast"))).click();
		Thread.sleep(8000);
	
	}

	
}


