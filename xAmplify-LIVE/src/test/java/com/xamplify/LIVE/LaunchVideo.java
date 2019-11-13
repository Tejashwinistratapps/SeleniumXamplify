package com.xamplify.LIVE;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class LaunchVideo extends VideoCampaign {
	// @AfterMethod  [for auto responses...comment @AfterTest annotation and use @Aftermethod , extends  AutoResponsesVideo]
	@AfterTest
	public void vlaunch() throws InterruptedException, SQLException
	{
	driver.findElement(By.xpath(properties.getProperty("video_now"))).click();			//click NOW
	Thread.sleep(5000);
	
	driver.findElement(By.xpath(properties.getProperty("video_launch"))).click();				//click LAUNCH
	
	Thread.sleep(7000);

	
}
}
