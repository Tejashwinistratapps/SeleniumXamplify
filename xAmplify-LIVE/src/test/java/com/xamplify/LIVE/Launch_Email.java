package com.xamplify.LIVE;

import java.sql.SQLException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

//public class Launch_Email extends AutoResponsesEmail {

public class Launch_Email extends Emailcampaign {
	
	// @AfterMethod  [for auto responses...comment @AfterTest annotation and use @Aftermethod , extends AutoResponsesEmail]
	
	@AfterTest
			
	public void launch() throws InterruptedException, SQLException
	{
	driver.findElement(By.xpath(properties.getProperty("now_campaign"))).click();			//click NOW
	Thread.sleep(5000);
	
	driver.findElement(By.xpath(properties.getProperty("now_launch"))).click();				//click LAUNCH
	
	Thread.sleep(8000);
}
}