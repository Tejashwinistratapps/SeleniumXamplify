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

	public class VideoCampaign {
		
		
		
		 WebDriver driver = Instance.getInstance();
		 
			Properties properties = PropertiesFile.readPropertyFile("datafile.properties");

		 
		@BeforeMethod
		public void vdecampaign() throws InterruptedException, SQLException
		{
				driver.get("https://release.xamplify.io/home/dashboard/welcome");
				Thread.sleep(25000);
				//Properties properties = PropertyFile.readPropertyFile("datafile.properties");

				
				WebElement campele=driver.findElement(By.xpath(properties.getProperty("campaignhover")));
																
																		
				Actions camp_action=new Actions(driver);
				 camp_action.moveToElement(campele).perform();
				 Thread.sleep(5000);
				 WebElement create_campele= driver.findElement(By.xpath(properties.getProperty("createcampaign")));
				 camp_action.moveToElement(create_campele);
				 camp_action.click();
				 camp_action.perform();
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-select-campaign[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]/i[1]")).click();
				Thread.sleep(3000);
				WebElement cam_name=driver.findElement(By.name("campaignName"));
						
				DatabaseQueries data = new DatabaseQueries();
				String query7 = properties.getProperty("query.getCampaignNamesByOrganizationId").replaceAll(":emailId",properties.getProperty("user.name"));
				List<String> campaignNames = data.listNames(query7, "campaign_name");
				String campaignNameFromProp = properties.getProperty("write_campaign").toLowerCase();
				
				driver.findElement(By.name(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("write_campaign"));	
				
				Thread.sleep(5000);
				if(campaignNames.indexOf(campaignNameFromProp)>-1) {
				driver.findElement(By.name(properties.getProperty("ecampaignName"))).clear();
				driver.findElement(By.name(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("write_campaign")+"_"+System.currentTimeMillis());
				Thread.sleep(25000);
				}
				
				
						
						driver.findElement(By.name("subjectLine")).sendKeys("subjectLine***");
						driver.findElement(By.name("preHeader")).sendKeys("preHeader***");
						Thread.sleep(3000);
						
						driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/switch[1]/div[1]/div[1]/span[3]")).click();
						driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[2]/div[1]/switch[1]/div[1]/div[1]/span[3]")).click();
						driver.findElement(By.xpath("//button[@id='campaign-detail-next-button']")).click();
						WebElement vdrpdwn=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[2]/span[1]/select[1]"));
						Thread.sleep(3000);

						
						
					
						
						//WebElement vdrpdwn=driver.findElement(By.xpath(properties.getProperty("")));
						Select vd=new Select(vdrpdwn);
						Thread.sleep(5000);
						vd.selectByValue("108");
						Thread.sleep(15000);
						driver.findElement(By.xpath("//input[@id='campaign_video_id_2102']")).click();

					
						driver.findElement(By.xpath("//button[@title='Please Select Video']")).click();
						Thread.sleep(5000);
						driver.findElement(By.xpath("//input[@id='2617']")).click();
						
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@title='Please Select Contact List']")).click();
						Thread.sleep(10000);
						
						JavascriptExecutor js = (JavascriptExecutor) driver;
						   js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

						driver.findElement(By.xpath("//div[@class='mix-grid']//ul[1]//li[1]//div[1]//div[1]//span[1]//label[1]")).click();

						
						Thread.sleep(5000);

						
						
						
						driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[2]/li[1]/div[1]/div[1]/span[1]/label[1]")).click();
						driver.findElement(By.xpath("//button[@title='Please Select Email Template']")).click();
						Thread.sleep(5000);
		}
		
		@Test(priority=33,enabled=true)
		
		
		
		public void vde_autovistit1() throws InterruptedException {
			
			driver.findElement(By.xpath("//*[@id=\"step-6\"]/form/div[2]/div/div/div[1]/a")).click();
			//driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[1]/switch[1]/div[1]/div[1]/span[2]")).click();
			Thread.sleep(5000);
		
						driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("subject*sub");
						
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
						driver.findElement(By.xpath("html/body")).click();
						driver.switchTo().activeElement().sendKeys("Hello Test1");

						driver.switchTo().defaultContent();
						
						
						
						/*driver.findElement(By.xpath("//input[@id='url-0-3586']")).click();
						Thread.sleep(5000);*/
						driver.findElement(By.xpath("//*[@id=\"step-6\"]/form/div[3]/div/div[1]/div[1]/label[1]")).click();
						
						Thread.sleep(5000);

						driver.findElement(By.xpath("//button[contains(text(),'Launch')]")).click();
						Thread.sleep(5000);

						
						}
					




		@Test(priority=34,enabled=true)
	public void vde_autovistit2() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"step-6\"]/form/div[2]/div/div/div[1]/a")).click();
		Thread.sleep(5000);

		WebElement drpdwnv1=driver.findElement(By.xpath("//*[@id=\"url-schedule-type\"]"));
		
		Select arv_vde=new Select(drpdwnv1);
		Thread.sleep(5000);
		arv_vde.selectByValue("20");
		Thread.sleep(15000);
		
					driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("subject2..");
					Thread.sleep(5000);
					
					
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
					driver.findElement(By.xpath("html/body")).click();
					driver.switchTo().activeElement().sendKeys("Hello Test! to tempalte");

					driver.switchTo().defaultContent();
					
					
					
					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[1]/label[1]/input[1]")).click();
					
					Thread.sleep(5000);

					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[2]/div[1]/button[2]")).click();
	Thread.sleep(5000);

					
					driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/input[1]")).sendKeys("gayatrialla11@gmail.com");
					
					
					driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/button[1]")).click();
					Thread.sleep(5000);

					driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/button[1]")).click();
					
					
					}


		@Test(priority=35,enabled=true)
	public void vde_autovistit3() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"step-6\"]/form/div[2]/div/div/div[1]/a")).click();
		//driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[1]/switch[1]/div[1]/div[1]/span[2]")).click();
		Thread.sleep(5000);

		WebElement drpdwnv1=driver.findElement(By.xpath("//*[@id=\"url-schedule-type\"]"));
		//rdrpdwn.click();
		Select arv_vde=new Select(drpdwnv1);
		Thread.sleep(5000);
		arv_vde.selectByValue("21");
		Thread.sleep(15000);
		
					driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("subject3..");
					Thread.sleep(5000);
					
					
					
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
					driver.findElement(By.xpath("html/body")).click();
					driver.switchTo().activeElement().sendKeys("Hello Test!...");

					driver.switchTo().defaultContent();
					
					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[1]/label[2]/input[1]")).click();
					
					Thread.sleep(5000);

					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[2]/div[1]/input[1]")).click();
	Thread.sleep(5000);



					driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/span[27]")).click();
					
				WebElement	v_sch_cntry_drpdwn1=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[2]/div[2]/select[1]"));
					Select vde_sch_country1=new Select(v_sch_cntry_drpdwn1);
					Thread.sleep(5000);
					vde_sch_country1.selectByValue("237");
					Thread.sleep(5000);
					
					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[2]/div[1]/button[3]")).click();
					Thread.sleep(5000);

					
					}
		
		
		
		
		

	@Test(priority=36,enabled=true)
	public void vde_autovistitemail1() throws InterruptedException {
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[2]/a[1]/i[1]")).click();
		Thread.sleep(5000);

		
		
		
		WebElement rdrpdwnv1=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/select[1]"));
		//rdrpdwn.click();
		Select arve_vde=new Select(rdrpdwnv1);
		Thread.sleep(5000);
		arve_vde.selectByValue("13");
		Thread.sleep(15000);
		
					driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("eamil opened..");
					Thread.sleep(5000);
					
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
					driver.findElement(By.xpath("html/body")).click();
					driver.switchTo().activeElement().sendKeys("Hello Test!");

					driver.switchTo().defaultContent();
					
					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[1]/label[3]/input[1]")).click();
					
					Thread.sleep(5000);

					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[2]/div[1]/button[3]")).click();
						Thread.sleep(5000);

				
					}



	@Test(priority=37,enabled=true)
	public void vde_autovistitemail2() throws InterruptedException {
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[2]/a[1]/i[1]")).click();
		Thread.sleep(5000);

		
		
		
		WebElement rdrpdwnv1=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/select[1]"));
		//rdrpdwn.click();
		Select arve_vde=new Select(rdrpdwnv1);
		Thread.sleep(5000);
		arve_vde.selectByValue("16");
		Thread.sleep(15000);
		
					driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("after email opened..");
					Thread.sleep(5000);
					
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
					driver.findElement(By.xpath("html/body")).click();
					driver.switchTo().activeElement().sendKeys("Hello Test after email is opened");

					driver.switchTo().defaultContent();
					
					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[1]/label[2]")).click();
					
					Thread.sleep(5000);

					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[2]/div[1]/input[1]")).click();
						Thread.sleep(5000);
						
						driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/span[27]")).click();
						Thread.sleep(5000);
						
						
						driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[2]/div[2]/select[1]")).click();
						Thread.sleep(5000);
						
						
						WebElement vde_sch_cntry_drpdwn=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[2]/div[2]/select[1]"));
						//country_drpdwn.click();
						Select v_sch_country=new Select(vde_sch_cntry_drpdwn);
						Thread.sleep(5000);
						v_sch_country.selectByValue("14");
						Thread.sleep(5000);
						
						
						WebElement vde_time_drpdwn=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[2]/div[3]/select[1]"));
						//country_drpdwn.click();
						Select v_sch_time=new Select(vde_time_drpdwn);
						Thread.sleep(5000);
						v_sch_time.selectByValue("Australia/Sydney");
						Thread.sleep(5000);
						
						driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[2]/div[1]/button[3]")).click();
						Thread.sleep(5000);
						
				
					}



	@Test(priority=38,enabled=true)
	public void vde_autovistitemail3() throws InterruptedException {
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[2]/a[1]/i[1]")).click();
		Thread.sleep(5000);

		WebElement rdrpdwnv1=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/select[1]"));
		Select arve_vde=new Select(rdrpdwnv1);
		Thread.sleep(5000);
		arve_vde.selectByValue("1");
		Thread.sleep(15000);
		
					driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("video played..");
					Thread.sleep(5000);
					
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
					driver.findElement(By.xpath("html/body")).click();
					driver.switchTo().activeElement().sendKeys("Hello Test after video played");

					driver.switchTo().defaultContent();
					
					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[1]/label[3]")).click();
					
					Thread.sleep(5000);

					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[2]/div[1]/button[3]")).click();
						Thread.sleep(5000);	
						
						
				
					}


	@Test(priority=39,enabled=true)
	public void vde_autovistitemail4() throws InterruptedException {
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[2]/a[1]/i[1]")).click();
		Thread.sleep(5000);

		WebElement rdrpdwnv1=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/select[1]"));
		Select arve_vde=new Select(rdrpdwnv1);
		Thread.sleep(5000);
		arve_vde.selectByValue("17");
		Thread.sleep(15000);
		
					driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("immediately after video played..");
					Thread.sleep(5000);
					
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
					driver.findElement(By.xpath("html/body")).click();
					driver.switchTo().activeElement().sendKeys("Hello Test immediately after video played");

					driver.switchTo().defaultContent();
					
					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[1]/label[3]/input[1]")).click();
					
					Thread.sleep(5000);

					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[2]/div[1]/button[3]")).click();
					Thread.sleep(5000);	
							
						
				
					}


	@Test(priority=40,enabled=true)
	public void vde_autovistitemail5() throws InterruptedException {
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[2]/a[1]/i[1]")).click();
		Thread.sleep(5000);

		WebElement rdrpdwnv1=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/select[1]"));
		Select arve_vde=new Select(rdrpdwnv1);
		Thread.sleep(5000);
		arve_vde.selectByValue("18");
		Thread.sleep(15000);
		
					driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("video not  played..");
					Thread.sleep(5000);
					
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
					driver.findElement(By.xpath("html/body")).click();
					driver.switchTo().activeElement().sendKeys("Hello Test!  video  is not played");

					driver.switchTo().defaultContent();
					
					
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[1]/div[1]/label[1]")).click();
					
					Thread.sleep(5000);

					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[2]/div[1]/button[3]")).click();
					Thread.sleep(5000);	
				
					}





	}




