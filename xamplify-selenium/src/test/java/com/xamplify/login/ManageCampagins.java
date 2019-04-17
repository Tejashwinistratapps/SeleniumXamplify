package com.xamplify.login;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ManageCampagins {
	
	WebDriver driver = Instance.getInstance();
	  Properties properties = PropertiesFile.readPropertyFile("datafile.properties");
	  

		@Test(priority=41,enabled=true)
	
		public void manage_campaign() throws InterruptedException {
			Thread.sleep(5000);
			//driver.get("https://release.xamplify.io/home/dashboard/welcome");
			Thread.sleep(15000);
			WebElement mng_cmpgn=driver.findElement(By.xpath(properties.getProperty("campaignhover1")));
			Thread.sleep(5000);
			Actions camp_action=new Actions(driver);
			 camp_action.moveToElement(mng_cmpgn).perform();
			 driver.findElement(By.xpath(properties.getProperty("managecampaign"))).click();
			 Thread.sleep(15000);
			 driver.findElement(By.xpath(properties.getProperty("memail"))).click();
			 Thread.sleep(15000);
			 driver.findElement(By.xpath(properties.getProperty("mvideo"))).click();
			 Thread.sleep(15000);
			 driver.findElement(By.xpath(properties.getProperty("msocial"))).click();
			 Thread.sleep(15000);
			 driver.findElement(By.xpath(properties.getProperty("mall"))).click();
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(properties.getProperty("mgridview"))).click();
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(properties.getProperty("mlistview"))).click();
			 Thread.sleep(5000);
			 
			WebElement ele_drpdwn=driver.findElement(By.xpath(properties.getProperty("msortby")));
			Select sort=new Select(ele_drpdwn);
			Thread.sleep(5000);
			sort.selectByIndex(1);
			Thread.sleep(6000);
			sort.selectByIndex(2);
			Thread.sleep(6000);
			sort.selectByIndex(3);
			Thread.sleep(5000);
			sort.selectByIndex(4);
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("msearchdata"))).sendKeys("camp1");
			Thread.sleep(15000);
			driver.findElement(By.xpath(properties.getProperty("msearchicon"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("cmpgnbasedreport"))).click();
			Thread.sleep(5000);
			
		
			driver.findElement(By.xpath(properties.getProperty("mc_vdepreview"))).click();
			Thread.sleep(15000);
			driver.findElement(By.xpath(properties.getProperty("mc_vdeclosepreview"))).click();	//preview vde//
			
			
			Thread.sleep(15000);
			
			driver.findElement(By.xpath(properties.getProperty("mc_emailpreview"))).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath(properties.getProperty("mc_emailclose"))).click();
			Thread.sleep(25000);
			
			
			
			
		/*driver.findElement(By.xpath(properties.getProperty("mc_cntctpreview"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("mc_cntclosepreview"))).click();
		Thread.sleep(8000);*/
			
		
			

			driver.findElement(By.xpath(properties.getProperty("mc_tot_receipents"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("mc_tot_receipentsclose"))).click();
			Thread.sleep(5000);
			
			

			driver.findElement(By.xpath(properties.getProperty("mc_act_receipents"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("mc_act_receipentsclose"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/app-topnavbar[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/app-topnavbar[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/ul[1]/li[7]/a[1]")).click();
			Thread.sleep(5000);
			driver.close();
			
			
			
		 
			 
			
			 
					
							 
					 
		}
		
		
		
	
	
	
	


}
