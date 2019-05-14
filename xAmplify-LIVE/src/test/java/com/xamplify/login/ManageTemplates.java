package com.xamplify.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
public class ManageTemplates {

	Properties properties = PropertiesFile.readPropertyFile("datafile.properties");
	WebDriver driver = Instance.getInstance();
	
	@Test(priority=91,enabled=true)
	public void manage_templateedit() throws InterruptedException {
		
		Thread.sleep(5000);
		WebElement element=driver.findElement(By.xpath(properties.getProperty("email-hover-2")));
		 Actions action = new Actions(driver);
		 action.moveToElement(element).perform();
		 WebElement mnge_ele= driver.findElement(By.xpath(properties.getProperty("mnge_template")));
			action.moveToElement(mnge_ele);
			action.click();
			action.perform();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("mnge_temp_preview"))).click();
				Thread.sleep(5000);
			
				driver.findElement(By.xpath(properties.getProperty("mnge_temp_preview_close"))).click();
				Thread.sleep(5000);
				
	/*	WebElement w1=driver.findElement(By.xpath("e_temp_cndtn"));
		
		if(w1.getText().equalsIgnoreCase("video-cobranding")||w1.getText().equalsIgnoreCase("video-cobranding"))
		{	
				*/
				
				
				
				driver.findElement(By.xpath(properties.getProperty("e_search_temp"))).sendKeys("upload-automation");
				Thread.sleep(15000);
				driver.findElement(By.xpath(properties.getProperty("mnge_temp_search"))).click();
				Thread.sleep(10000);
			
					driver.findElement(By.xpath(properties.getProperty("mnge_edit_temp"))).click();
					Thread.sleep(5000);
					
			
			driver.findElement(By.xpath(properties.getProperty("tmpname_updte"))).sendKeys("-1");
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("e_temp_update_button"))).click();
			Thread.sleep(8000);
			driver.findElement(By.xpath(properties.getProperty("e_temp_delete"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("e_temp_delete_s"))).click();
			Thread.sleep(5000);
		/*	
		}
		else
		{
			driver.findElement(By.xpath(properties.getProperty("mnge_edit_temp"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("e_temp_esave"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("e_temp_esaveupdte"))).click();
			Thread.sleep(5000);
			
			
		}*/
	}
	@Test(priority=92,enabled=true)
	public void mt_gsortby() throws InterruptedException {
			
			driver.findElement(By.xpath(properties.getProperty("e_gridview"))).click();

			WebElement ele_drpdwn_sort=driver.findElement(By.xpath(properties.getProperty("e_sort_drpdwn")));
			ele_drpdwn_sort.click();
			Select namea_z=new Select(ele_drpdwn_sort);
			Thread.sleep(8000);
			namea_z.selectByIndex(1);
			Thread.sleep(15000);
			namea_z.selectByIndex(2);
			Thread.sleep(15000);
			namea_z.selectByIndex(3);
			Thread.sleep(18000);
			namea_z.selectByIndex(4);
			Thread.sleep(20000);
	}
	
	@Test(priority=93,enabled=true)
	public void mt_allclicks() throws InterruptedException {
	
			driver.findElement(By.xpath(properties.getProperty("e_search_temp"))).sendKeys("basic");
			Thread.sleep(15000);
			driver.findElement(By.xpath(properties.getProperty("e_clear"))).click();
			Thread.sleep(10000);	
			driver.findElement(By.xpath(properties.getProperty("e_search"))).click();
			Thread.sleep(10000);
		
		driver.findElement(By.xpath(properties.getProperty("e_m_basic"))).click();
		Thread.sleep(15000);
		
		driver.findElement(By.xpath(properties.getProperty("e_m_video"))).click();
		Thread.sleep(15000);
		
		driver.findElement(By.xpath(properties.getProperty("e_m_uploaded"))).click();
		Thread.sleep(15000);
		
	
		driver.findElement(By.xpath(properties.getProperty("e_m_emailcobranding"))).click();
		Thread.sleep(15000);
		
		driver.findElement(By.xpath(properties.getProperty("e_m_videocobranding"))).click();
		
		Thread.sleep(15000);
		/*driver.findElement(By.xpath(properties.getProperty("e_m_event"))).click();
		Thread.sleep(8000);
	*/

		
	}

}
