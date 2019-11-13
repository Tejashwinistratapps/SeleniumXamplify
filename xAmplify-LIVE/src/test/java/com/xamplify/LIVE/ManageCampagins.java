package com.xamplify.LIVE;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ManageCampagins {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile.readPropertyFile("rdata.properties");

	@Test(priority =301, enabled = true)

	public void manageCampaignClicks() throws InterruptedException {
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Wait till the element is not visible

		WebElement mng_cmpgn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("campaignhover1"))));
		mng_cmpgn.click(); 																//click on campaign
		
		
		Actions camp_action = new Actions(driver);
		camp_action.moveToElement(mng_cmpgn).perform();
		driver.findElement(By.xpath(properties.getProperty("managecampaign"))).click();  //click on manage campaigns
		Thread.sleep(8000);
		System.out.println(" click strs");
		driver.findElement(By.xpath(properties.getProperty("memail"))).click();         //click on email tab
		Thread.sleep(5000);
		System.out.println("email clicked");
		driver.findElement(By.xpath(properties.getProperty("mvideo"))).click();			//click on video tab
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("msocial"))).click();		//click on social tab
		Thread.sleep(5000);
		System.out.println("social clicked");
		driver.findElement(By.xpath(properties.getProperty("mall"))).click();			//click on all tab
		Thread.sleep(5000);
		System.out.println("all clicked");
		
		driver.findElement(By.xpath(properties.getProperty("mcalendarview"))).click();		//click on calendar
		Thread.sleep(5000);
		System.out.println("calendar clicked");
		
		
		driver.findElement(By.xpath(properties.getProperty("mcalendarview_previousclck"))).click(); //click on previous(>)in calendar
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath(properties.getProperty("mcalendar_weekview"))).click();		//click on week in calendar
		Thread.sleep(5000);
		System.out.println("calendar week clicked");
		driver.findElement(By.xpath(properties.getProperty("mcalendar_dayview"))).click();		//click on day in calendar
		Thread.sleep(5000);
		System.out.println("calendar day clicked");
		
		driver.findElement(By.xpath(properties.getProperty("mcalendarview_todayclck"))).click();		//click on today in calendar
		Thread.sleep(5000);
		
			driver.get("https://release.xamplify.io/home/campaigns");							//redirect to manage campaigns
			driver.findElement(By.xpath(properties.getProperty("mgridview"))).click();			//click on grid view
			Thread.sleep(5000);
			
		System.out.println("grid clicked");
		driver.findElement(By.xpath(properties.getProperty("mlistview"))).click();				//click on list view
		Thread.sleep(5000);
		System.out.println("list clicked");
		WebElement ele_drpdwn = driver.findElement(By.xpath(properties.getProperty("msortby")));	//click on sort by drop down
		Select sort = new Select(ele_drpdwn);														//selecting the drop down
		Thread.sleep(5000);
		sort.selectByIndex(1);											
		Thread.sleep(6000);
		sort.selectByIndex(2);
		Thread.sleep(6000);
		sort.selectByIndex(3);
		Thread.sleep(5000);
		sort.selectByIndex(4);
		Thread.sleep(5000);
	}
	@Test(priority =302, enabled = true)

	public void mngcmpgn_CamapignBasedReports() throws InterruptedException {
		
		driver.get("https://release.xamplify.io/home/campaigns/manage");								//redirect to manage campaigns page.
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("msearchdata"))).sendKeys("Automation_v");			//search field and send data
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("msearchicon"))).click();							//click on search icon
		Thread.sleep(10000);

		driver.findElement(By.xpath(properties.getProperty("cmpgnbasedreport"))).click();						//campaign based report icon
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_vdepreview"))).click();							//video info  preview
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("mc_vdeclosepreview"))).click();						//close video info preview

		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("mc_emailpreview"))).click();						//email info  preview
		Thread.sleep(6000);
		driver.findElement(By.xpath(properties.getProperty("mc_emailclose"))).click();							//close email info preview
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("mc_partnerlistpreview"))).click();				//partner list info preview
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("mc_partnerlistclosepreview"))).click();			//close partner list info
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("mc_tot_receipents"))).click();					//total recipients preview
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_tr_exporticon"))).click();					// icon click related to export to excel
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_tr_exporticon_click"))).click();				//click on export to excel
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_tr_search"))).sendKeys("gayatri");		//search in total recipients and send data
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_tr_searchclick"))).click();				//searched click for total recipients
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_tot_receipentsclose"))).click();			//close total recipients
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_act_receipents"))).click();				//active recipients preview
		Thread.sleep(6000);

		driver.findElement(By.xpath(properties.getProperty("mc_act_exporticon"))).click();				//icon click related to export to excel
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_act_exporticonclick"))).click();			//click on export to excel
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_actr_search"))).sendKeys("gayatri");		//search in active  recipients and send data
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_actr_searchclick"))).click();			//searched click for active recipients
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_act_receipentsclose"))).click();			//close active recipients
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(properties.getProperty("mc_clickedurl"))).click();			//click on clicked url
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(properties.getProperty("mc_clckd_exporticon"))).click();				//icon click related to export to excel
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_clckd_exporticonclick"))).click();			//click on export to excel
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_clckd_search"))).sendKeys("gayatri");		//search in clicked  and send data
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_clckd_searchclick"))).click();			//searched click 
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_clckdclose"))).click();			//close clicked 
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(properties.getProperty("mc_views"))).click();			//click on views
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(properties.getProperty("mc_views_exporticon"))).click();				//icon click related to export to excel
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_views_exporticonclick"))).click();			//click on export to excel
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_views_search"))).sendKeys("gayatri");		//search in views  and send data
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_views_searchclick"))).click();			//searched click 
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_viewsclose"))).click();			//close clicked 
		Thread.sleep(3000);
				
				
				
				
				
				
				
	}
	@Test(priority =303, enabled = true)

	public void mngcmpgn_copy() throws InterruptedException {
		
		driver.get("https://release.xamplify.io/home/campaigns/manage");								//redirect to manage campaigns page.
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("msearchdata"))).sendKeys("Deploy Test Email Thro");			//search for campaign for related data.
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("msearchicon"))).click();				//click on search icon
		Thread.sleep(50000);

		driver.findElement(By.xpath(properties.getProperty("mc_settingsicon1"))).click();			//click on settings icon for a campaign
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_preview"))).click();				//preview of the campaign

		Thread.sleep(7000);
		driver.findElement(By.xpath(properties.getProperty("mc_preview_close"))).click();		//close the preview of campaign
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_settingsicon1"))).click();		//click on settings icon for a campaign
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_cpycampaign"))).click();			//click on copy campaign 
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_cpy_cmpgn_save"))).click();		//save the copy campaign
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_settingsicon1"))).click();		//click on settings icon for a campaign
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_drft_delete"))).click();			//click on delete 
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("mc_s_delete"))).click();			//yes delete the campagin
		Thread.sleep(5000);

	}

}


