package com.xamplify.login;

	
	

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Properties;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	
	
	public class AutoResponseToEmailVisitEmailCampagin {


		 WebDriver driver = Instance.getInstance();
		 
			Properties properties = PropertiesFile.readPropertyFile("datafile.properties");

		
			@BeforeMethod
			
			public void ecampaign() throws InterruptedException, SQLException
			{
				driver.get("https://release.xamplify.io/home/dashboard/welcome");

					Thread.sleep(25000);
					Properties properties = PropertiesFile.readPropertyFile("datafile.properties");

					Thread.sleep(15000);
					WebElement campele=driver.findElement(By.xpath(properties.getProperty("campaignhover")));
																	
																			
					Actions camp_action=new Actions(driver);
					 camp_action.moveToElement(campele).perform();
					 Thread.sleep(5000);
					 WebElement create_campele= driver.findElement(By.xpath(properties.getProperty("createcampaign")));
					 camp_action.moveToElement(create_campele);
					 camp_action.click();
					 camp_action.perform();
					Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("openecampaign"))).click();		
				Thread.sleep(5000);
				
				List<String> campaignNames = new ArrayList<String>();
				String query = properties.getProperty("query.getCampaignNamesByOrganizationId").replaceAll(":emailId",properties.getProperty("user.name"));
				ResultSet resultSet = DatabaseConnection.getResultSet(query);
				while (resultSet.next()) {
					campaignNames.add(resultSet.getString("campaign_name").toLowerCase());
				}
				String campaignNameFromProp = properties.getProperty("write_campaign").toLowerCase();
				
				driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("write_campaign"));	
				Thread.sleep(5000);
				if(campaignNames.indexOf(campaignNameFromProp)>-1) {
					driver.findElement(By.id(properties.getProperty("ecampaignName"))).clear();
					driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("write_campaign")+"_"+System.currentTimeMillis());	
				}
				Thread.sleep(3000);								
			driver.findElement(By.xpath(properties.getProperty("through_partner"))).click();
				Thread.sleep(3000);																					//through partner//		
				driver.findElement(By.name(properties.getProperty("subjectline"))).sendKeys("subject line:-)...");
				driver.findElement(By.name(properties.getProperty("preheader"))).sendKeys("preHeader.:-0)");
				//driver.findElement(By.className(properties.getProperty("notifyme"))).click();									
				driver.findElement(By.id(properties.getProperty("next"))).click();								
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("partnerlist"))).click();										
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("partnerlist_preview"))).click();		
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("close_partnerpreview"))).click();	
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("next2"))).click();						
//				WebElement camp_email_temp=	driver.findElement(By.xpath("//div[@id='mix-details']//h4[@title='sda-1']"));//hover  to select template//
//				Thread.sleep(5000);
//				Actions email_temp_action=new Actions(driver);
//				email_temp_action.moveToElement(camp_email_temp).perform();
				Thread.sleep(20000);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				  js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
				driver.findElement(By.xpath(properties.getProperty("select_template"))).click();
				Thread.sleep(1000);

				/*driver.findElement(By.xpath("select_preview_temp")).click();
				Thread.sleep(15000);
				driver.findElement(By.xpath("close_preview")).click();											
				Thread.sleep(5000);*/
				driver.findElement(By.xpath(properties.getProperty("next3"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("email_visit_email"))).click();
				Thread.sleep(10000);
				driver.findElement(By.xpath(properties.getProperty("email_visit_choosetemp"))).click();
				Thread.sleep(5000);
		}
		
		

	@Test(priority=33,enabled=true)
		public void email_savetest1() throws InterruptedException {
		WebElement rdrpdwn=driver.findElement(By.xpath(properties.getProperty("eresponse_drpdwn")));
		//rdrpdwn.click();
		Select reason=new Select(rdrpdwn);
		Thread.sleep(5000);
		reason.selectByValue("13");
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("evsubject"))).sendKeys("subject line:-)");
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("evselect_temp"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("evsave_click"))).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("evsave"))).click();
		Thread.sleep(5000);
		

		}
		
		
		@Test(priority=34,enabled=true)
		public void email_now1() throws InterruptedException {
		WebElement rdrpdwn=driver.findElement(By.xpath(properties.getProperty("eresponse_drpdwn")));
		//rdrpdwn.click();
		Select reason=new Select(rdrpdwn);
		Thread.sleep(5000);
		reason.selectByValue("0");
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("evreply_xdays"))).sendKeys("2");
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath(properties.getProperty("evsubject2"))).sendKeys("email not opened in 2 days-)");
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("evselect_temp2"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("evnow_click"))).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("evnow_launch"))).click();
		Thread.sleep(5000);
		

		}
		

		@Test(priority=35,enabled=true)
		public void email_schedule1() throws InterruptedException {
		WebElement rdrpdwn=driver.findElement(By.xpath(properties.getProperty("eresponse_drpdwn")));
		//rdrpdwn.click();
		Select reason=new Select(rdrpdwn);
		Thread.sleep(5000);
		reason.selectByValue("16");
		Thread.sleep(15000);
		
		driver.findElement(By.xpath(properties.getProperty("evsubject3"))).sendKeys("added sub");
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("evselect_temp3"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("evschedule_click"))).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("evsch_date"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("evsch_date_click"))).click();
		Thread.sleep(5000);

		
		
		
		WebElement e_sch_cntry_drpdwn=driver.findElement(By.xpath(properties.getProperty("evsch_country")));
		//country_drpdwn.click();
		Select sch_country1=new Select(e_sch_cntry_drpdwn);
		Thread.sleep(5000);
		sch_country1.selectByValue("103");// india
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath(properties.getProperty("evsch_lastclick"))).click();
		Thread.sleep(5000);
		
		}
		
		

	@Test(priority=36,enabled=true)
	public void email_testmail() throws InterruptedException {
	WebElement rdrpdwn=driver.findElement(By.xpath(properties.getProperty("eresponse_drpdwn")));
	//rdrpdwn.click();
	Select reason=new Select(rdrpdwn);
	Thread.sleep(5000);
	reason.selectByValue("22");
	Thread.sleep(15000);
	driver.findElement(By.xpath(properties.getProperty("evreply_xdays1"))).sendKeys("1");
	Thread.sleep(5000);


	driver.findElement(By.xpath(properties.getProperty("evsubject4"))).sendKeys("partner not used");
	Thread.sleep(5000);
	driver.findElement(By.xpath(properties.getProperty("evselect_temp4"))).click();
	Thread.sleep(5000);
	
	driver.findElement(By.xpath(properties.getProperty("evnow"))).click();
	Thread.sleep(5000);


	driver.findElement(By.xpath(properties.getProperty("evnowlaunch"))).click();

	Thread.sleep(8000);

}
}