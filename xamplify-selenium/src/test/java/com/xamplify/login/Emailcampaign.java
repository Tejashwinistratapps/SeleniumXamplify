package com.xamplify.login;

import java.io.IOException;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Emailcampaign {
	
	

	  static WebDriver driver = Instance.getInstance();
	 static Properties properties = PropertiesFile.readPropertyFile("C:\\Users\\dtejashwini\\eclipse-workspace\\xamplify-selenium\\datafile.properties");
		//Properties properties = PropertiesFile.readPropertyFile("datafile.properties");
		public  static Logger logger = LoggerFactory.getLogger(UploadVideo.class);
		public static void main(String[] args) throws InterruptedException, IOException, SQLException {


			driver.get("https://xamplify.io/home/dashboard/welcome");

			
			driver.manage().window().maximize();
			logger.debug("Entering the URL");

			driver.get("https://xamplify.io/");
			driver.findElement(By.xpath("//a[@class='loginTF']")).click();
			logger.debug("login with credentials");

			Thread.sleep(10000);
			WebElement usernameElement = driver.findElement(By.xpath("//input[@id='username']")); 
			WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
			usernameElement.sendKeys("dtejashwini@stratapps.com");
			passwordElement.sendKeys("Xamplify@11");
			Thread.sleep(3000);

			driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();

		
			
			

				Thread.sleep(10000);
				WebElement campele=driver.findElement(By.xpath(properties.getProperty("e_campaignhover")));
																
																		
				Actions camp_action=new Actions(driver);
				 camp_action.moveToElement(campele).perform();
				 Thread.sleep(5000);
				 WebElement create_campele= driver.findElement(By.xpath(properties.getProperty("e_createcampaign")));
				 camp_action.moveToElement(create_campele);
				 camp_action.click();
				 camp_action.perform();
				Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("e_openecampaign"))).click();		
			Thread.sleep(5000);
			
			List<String> campaignNames = new ArrayList<String>();
			String query = properties.getProperty("query.getCampaignNamesByOrganizationIds").replaceAll(":emailId",properties.getProperty("user.name"));
			ResultSet resultSet = DatabaseConnection.getResultSet(query);
			while (resultSet.next()) {
				campaignNames.add(resultSet.getString("campaign_name").toLowerCase());
			}
			String campaignNameFromProp = properties.getProperty("ewrite_campaign").toLowerCase();
			Thread.sleep(5000);

			driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("ewrite_campaign"));	
			Thread.sleep(5000);
			//if(campaignNames.indexOf(campaignNameFromProp)>-1) {
				driver.findElement(By.id(properties.getProperty("ecampaignName"))).clear();
				driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("ewrite_campaign")+"_"+System.currentTimeMillis());	
			//}
			Thread.sleep(3000);								
		//driver.findElement(By.xpath(properties.getProperty("through_partner"))).click();
			Thread.sleep(3000);																					//through partner//		
			driver.findElement(By.name(properties.getProperty("subjectline"))).sendKeys("subject line:-)...");
			driver.findElement(By.name(properties.getProperty("preheader"))).sendKeys("preHeader.:-0)");
			//driver.findElement(By.className(properties.getProperty("notifyme"))).click();									
			driver.findElement(By.id(properties.getProperty("next"))).click();								
			Thread.sleep(5000);
			
			driver.findElement(By.xpath(properties.getProperty("e_prtnrlst_srch"))).sendKeys("TGA");
			Thread.sleep(5000);
			
			
			driver.findElement(By.xpath(properties.getProperty("esrch_slct_prtnrlst_clck"))).click();										
			Thread.sleep(5000);
			
			
			driver.findElement(By.xpath(properties.getProperty("eslct_prtnrlst"))).click();		
			Thread.sleep(8000);
			
			
			driver.findElement(By.xpath(properties.getProperty("epartnerlist_preview"))).click();		
			Thread.sleep(5000);
			
				
			 
			 
			 WebElement eg = driver.findElement(By.xpath(properties.getProperty("eplist")));
					 List<WebElement> links = eg.findElements(By.tagName("li"));
					 for (int i = 0; i <= links.size()+2; i++)
					 {
						 System.out.println(i);
						// System.out.println(links.size());
					   //  System.out.println(links.get(i).getText());
					  

						 WebElement  c1=driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation")));
						 c1.click();
						 Thread.sleep(3000);
						 System.out.println(i +"clicked");
								 	
					 
					 } 
			
			
			

			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("eclose_partnerpreview"))).click();	
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("enext2"))).click();						
		Thread.sleep(10000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			  
			 Thread.sleep(8000);
			 
			 for(int g=0;g<=5;g++) {
		driver.findElement(By.xpath(properties.getProperty("epagenation"))).click();
		Thread.sleep(8000);
			 }
			
			
			 Thread.sleep(15000);
			driver.findElement(By.xpath(properties.getProperty("egoto_top"))).click();
			Thread.sleep(3000);
		
			
			driver.findElement(By.xpath(properties.getProperty("ebasic_tmplt"))).click();
			Thread.sleep(8000);
			
			driver.findElement(By.xpath(properties.getProperty("eupld_tmplt"))).click();
			Thread.sleep(8000);

			driver.findElement(By.xpath(properties.getProperty("erglr_tmplt"))).click();
			Thread.sleep(8000);
			driver.findElement(By.xpath(properties.getProperty("eall_tmplt"))).click();
			Thread.sleep(8000);
			
		driver.findElement(By.xpath(properties.getProperty("esrch_tmplt"))).sendKeys("basicEcomTemp ");			
		Thread.sleep(5000);
		

		driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_clck"))).click();
		Thread.sleep(5000);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		  js1.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		  Thread.sleep(5000);

			JavascriptExecutor js11 = (JavascriptExecutor) driver;
			  js11.executeScript("window.scrollTo(document.body.scrollHeight,0)");
			  Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_slct_last"))).click();
		Thread.sleep(8000);
		
		//driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_clck_clr_srch"))).click();
		//Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("eselect_template"))).click();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath(properties.getProperty("etemplate_prvw"))).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("etemplate_prvw_cls"))).click();
		Thread.sleep(5000);
		
		
		
			driver.findElement(By.xpath(properties.getProperty("next31"))).click();
			Thread.sleep(5000);
	
			
			driver.findElement(By.xpath(properties.getProperty("autorespone1"))).click();
			Thread.sleep(5000);
		WebElement ele_drpdwn=driver.findElement(By.xpath(properties.getProperty("drp_dwn_click")));
		//rdrpdwn.click();
		Select when_to_send_email=new Select(ele_drpdwn);
		Thread.sleep(5000);
		when_to_send_email.selectByValue("20");
		Thread.sleep(15000);
		
driver.findElement(By.name("subject")).sendKeys("subject line:send immediately after clicked");
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:send immediately after clicked,thanku for clicking immediately");

		driver.switchTo().defaultContent();
		
		
		driver.findElement(By.xpath(properties.getProperty("save"))).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("testmail"))).click();
		
		Thread.sleep(5000);
driver.findElement(By.xpath(properties.getProperty("mailid"))).sendKeys("agayatri@stratapps.com");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("submit"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("ok"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("save2"))).click();
		Thread.sleep(8000);

	
			WebElement campele1=driver.findElement(By.xpath(properties.getProperty("e_campaignhover")));
			
			
			Actions camp_action1=new Actions(driver);
			 camp_action1.moveToElement(campele1).perform();
			 Thread.sleep(5000);
			 WebElement create_campele1= driver.findElement(By.xpath(properties.getProperty("e_createcampaign")));
			 camp_action1.moveToElement(create_campele1);
			 camp_action1.click();
			 camp_action1.perform();
			Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("e_openecampaign"))).click();		
		Thread.sleep(5000);
		
		List<String> campaignNames1 = new ArrayList<String>();
		String query1 = properties.getProperty("query.getCampaignNamesByOrganizationIds").replaceAll(":emailId",properties.getProperty("user.name"));
		ResultSet resultSet1 = DatabaseConnection.getResultSet(query1);
		while (resultSet1.next()) {
			campaignNames1.add(resultSet1.getString("campaign_name").toLowerCase());
		}
		String campaignNameFromProp1 = properties.getProperty("ewrite_campaign").toLowerCase();
		Thread.sleep(5000);

		driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("ewrite_campaign"));	
		Thread.sleep(5000);
		//if(campaignNames.indexOf(campaignNameFromProp)>-1) {
			driver.findElement(By.id(properties.getProperty("ecampaignName"))).clear();
			driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("ewrite_campaign")+"_"+System.currentTimeMillis());	
		//}
		Thread.sleep(3000);								
	//driver.findElement(By.xpath(properties.getProperty("through_partner"))).click();
		Thread.sleep(3000);																					//through partner//		
		driver.findElement(By.name(properties.getProperty("subjectline"))).sendKeys("subject line:-)...");
		driver.findElement(By.name(properties.getProperty("preheader"))).sendKeys("preHeader.:-0)");
		//driver.findElement(By.className(properties.getProperty("notifyme"))).click();									
		driver.findElement(By.id(properties.getProperty("next"))).click();								
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("e_prtnrlst_srch"))).sendKeys("TGA");
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath(properties.getProperty("esrch_slct_prtnrlst_clck"))).click();										
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath(properties.getProperty("eslct_prtnrlst"))).click();										
		Thread.sleep(8000);
		
		
		driver.findElement(By.xpath(properties.getProperty("epartnerlist_preview"))).click();		
		Thread.sleep(5000);
		
			
		 
		 
		 
		 WebElement eg1 = driver.findElement(By.xpath(properties.getProperty("eplist")));
				 List<WebElement> links1 = eg1.findElements(By.tagName("li"));
				 for (int i = 0; i <= links1.size()+2; i++)
				 {
					 System.out.println(i);
					// System.out.println(links.size());
				   //  System.out.println(links.get(i).getText());
				  
					 WebElement  c1=driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation")));
					 c1.click();
					
					 Thread.sleep(3000);
					 System.out.println(i +"clicked");
							 	
				 
				 } 
	
		
		
		
		
		
		

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("eclose_partnerpreview"))).click();	
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("enext2"))).click();						
	Thread.sleep(10000);

	JavascriptExecutor js2 = (JavascriptExecutor) driver;
		  js2.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		  
		 Thread.sleep(8000);
		 
		 for(int g=0;g<=5;g++) {
	driver.findElement(By.xpath(properties.getProperty("epagenation"))).click();
	Thread.sleep(8000);
		 }
		
		
		 Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("egoto_top"))).click();
		Thread.sleep(3000);
	
		
		driver.findElement(By.xpath(properties.getProperty("ebasic_tmplt"))).click();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath(properties.getProperty("eupld_tmplt"))).click();
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("erglr_tmplt"))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("eall_tmplt"))).click();
		Thread.sleep(8000);
		
	driver.findElement(By.xpath(properties.getProperty("esrch_tmplt"))).sendKeys("basicEcomTemp ");			
	Thread.sleep(5000);
	

	driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_clck"))).click();
	Thread.sleep(5000);
	
	JavascriptExecutor js12 = (JavascriptExecutor) driver;
	  js12.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	  Thread.sleep(5000);

		JavascriptExecutor js112 = (JavascriptExecutor) driver;
		  js112.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		  Thread.sleep(5000);
	driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_slct_last"))).click();
	Thread.sleep(8000);
	
/*	driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_clck_clr_srch"))).click();
	Thread.sleep(5000);*/
	
	driver.findElement(By.xpath(properties.getProperty("eselect_template"))).click();
	Thread.sleep(8000);
	
	driver.findElement(By.xpath(properties.getProperty("etemplate_prvw"))).click();
	Thread.sleep(5000);

	driver.findElement(By.xpath(properties.getProperty("etemplate_prvw_cls"))).click();
	Thread.sleep(5000);
	
	
	
		driver.findElement(By.xpath(properties.getProperty("next31"))).click();
		Thread.sleep(5000);
		

			
			driver.findElement(By.xpath(properties.getProperty("autorespone1"))).click();
			Thread.sleep(5000);
		WebElement ele_drpdwn2=driver.findElement(By.xpath(properties.getProperty("drp_dwn_click")));
		
		driver.findElement(By.xpath(properties.getProperty("subject2"))).sendKeys("subject line2:send if not clicked");
		Thread.sleep(5000);
	
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello,send if not clicked:please click the mail");

		driver.switchTo().defaultContent();
		
		
		driver.findElement(By.xpath(properties.getProperty("now_campaign"))).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("now_launch"))).click();
		
		Thread.sleep(5000);

		WebElement campele2=driver.findElement(By.xpath(properties.getProperty("e_campaignhover")));
		
		
		Actions camp_action2=new Actions(driver);
		 camp_action2.moveToElement(campele2).perform();
		 Thread.sleep(5000);
		 WebElement create_campele2= driver.findElement(By.xpath(properties.getProperty("e_createcampaign")));
		 camp_action2.moveToElement(create_campele2);
		 camp_action2.click();
		 camp_action2.perform();
		Thread.sleep(5000);
	driver.findElement(By.xpath(properties.getProperty("e_openecampaign"))).click();		
	Thread.sleep(5000);
	
	List<String> campaignNames2 = new ArrayList<String>();
	String query2= properties.getProperty("query.getCampaignNamesByOrganizationIds").replaceAll(":emailId",properties.getProperty("user.name"));
	ResultSet resultSet2 = DatabaseConnection.getResultSet(query2);
	while (resultSet2.next()) {
		campaignNames2.add(resultSet2.getString("campaign_name").toLowerCase());
	}
	String campaignNameFromProp2 = properties.getProperty("ewrite_campaign").toLowerCase();
	Thread.sleep(5000);

	driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("ewrite_campaign"));	
	Thread.sleep(5000);
	//if(campaignNames.indexOf(campaignNameFromProp)>-1) {
		driver.findElement(By.id(properties.getProperty("ecampaignName"))).clear();
		driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("ewrite_campaign")+"_"+System.currentTimeMillis());	
	//}
	Thread.sleep(3000);								
/*driver.findElement(By.xpath(properties.getProperty("through_partner"))).click();
	Thread.sleep(3000);	*/																				//through partner//		
	driver.findElement(By.name(properties.getProperty("subjectline"))).sendKeys("subject line:-)...");
	driver.findElement(By.name(properties.getProperty("preheader"))).sendKeys("preHeader.:-0)");
	//driver.findElement(By.className(properties.getProperty("notifyme"))).click();									
	driver.findElement(By.id(properties.getProperty("next"))).click();								
	Thread.sleep(5000);
	
	driver.findElement(By.xpath(properties.getProperty("e_prtnrlst_srch"))).sendKeys("TGA");
	Thread.sleep(5000);
	
	
	driver.findElement(By.xpath(properties.getProperty("esrch_slct_prtnrlst_clck"))).click();										
	Thread.sleep(5000);
	
	
	driver.findElement(By.xpath(properties.getProperty("eslct_prtnrlst"))).click();										
	Thread.sleep(8000);
	
	
	driver.findElement(By.xpath(properties.getProperty("epartnerlist_preview"))).click();		
	Thread.sleep(5000);
	
	
	 
	 
	 WebElement eg2 = driver.findElement(By.xpath(properties.getProperty("eplist")));
			 List<WebElement> links2= eg2.findElements(By.tagName("li"));
			 for (int i = 0; i <= links2.size()+2; i++)
			 {
				 System.out.println(i);
				 System.out.println(links2.size());
			   //  System.out.println(links.get(i).getText());
			  

				 WebElement  c1=driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation")));
				 c1.click();
				 Thread.sleep(3000);
				 System.out.println(i +"clicked");
						 	
			 
			 } 
	

	
	
	
	
	


	Thread.sleep(5000);
	driver.findElement(By.xpath(properties.getProperty("eclose_partnerpreview"))).click();	
	Thread.sleep(5000);
	driver.findElement(By.xpath(properties.getProperty("enext2"))).click();						
Thread.sleep(10000);

JavascriptExecutor js3= (JavascriptExecutor) driver;
	  js3.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	  
	 Thread.sleep(8000);
	 
	 for(int g=0;g<=5;g++) {
driver.findElement(By.xpath(properties.getProperty("epagenation"))).click();
Thread.sleep(8000);
	 }
	
	
	 Thread.sleep(10000);
	driver.findElement(By.xpath(properties.getProperty("egoto_top"))).click();
	
	 
	Thread.sleep(3000);
	

	
	driver.findElement(By.xpath(properties.getProperty("ebasic_tmplt"))).click();
	Thread.sleep(8000);
	
	driver.findElement(By.xpath(properties.getProperty("eupld_tmplt"))).click();
	Thread.sleep(8000);

	driver.findElement(By.xpath(properties.getProperty("erglr_tmplt"))).click();
	Thread.sleep(8000);
	driver.findElement(By.xpath(properties.getProperty("eall_tmplt"))).click();
	Thread.sleep(8000);
	
driver.findElement(By.xpath(properties.getProperty("esrch_tmplt"))).sendKeys("basicEcomTemp ");			
Thread.sleep(5000);


driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_clck"))).click();
Thread.sleep(5000);

JavascriptExecutor js13 = (JavascriptExecutor) driver;
  js13.executeScript("window.scrollTo(document.body.scrollHeight,0)");
  Thread.sleep(5000);

	JavascriptExecutor js113 = (JavascriptExecutor) driver;
	  js113.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	  Thread.sleep(5000);
driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_slct_last"))).click();
Thread.sleep(8000);

/*driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_clck_clr_srch"))).click();
Thread.sleep(5000);
*/
driver.findElement(By.xpath(properties.getProperty("eselect_template"))).click();
Thread.sleep(8000);

driver.findElement(By.xpath(properties.getProperty("etemplate_prvw"))).click();
Thread.sleep(5000);

driver.findElement(By.xpath(properties.getProperty("etemplate_prvw_cls"))).click();
Thread.sleep(5000);



	driver.findElement(By.xpath(properties.getProperty("next31"))).click();
	Thread.sleep(5000);
	

			
			driver.findElement(By.xpath(properties.getProperty("autorespone1"))).click();
			Thread.sleep(5000);
		WebElement ele_drpdwn3=driver.findElement(By.xpath(properties.getProperty("drp_dwn_click")));
		//rdrpdwn.click();
		Select when_to_send_email3=new Select(ele_drpdwn3);
		Thread.sleep(5000);
		when_to_send_email3.selectByValue("21");
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("email_xdays"))).sendKeys("1");
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("subject3"))).sendKeys("subject3:schedule");
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:campgin is scheduled for 1 day...");

		driver.switchTo().defaultContent();
		
		
		
		/*driver.findElement(By.xpath(properties.getProperty("evselect_temp"))).click();
		Thread.sleep(5000);*/
		driver.findElement(By.xpath(properties.getProperty("email_schedule_click"))).click();
		Thread.sleep(5000);
		
	
		
		
		driver.findElement(By.xpath(properties.getProperty("select_date"))).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath(properties.getProperty("nxt_mnth_clck"))).click();
		Thread.sleep(10000);

		

		driver.findElement(By.xpath(properties.getProperty("date_click"))).click();
		Thread.sleep(5000);
		
		WebElement country_drpdwn=driver.findElement(By.xpath(properties.getProperty("select_country")));
		Select country1=new Select(country_drpdwn);
		Thread.sleep(5000);
		country1.selectByValue("238");
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("email_schedulelast"))).click();
		Thread.sleep(5000);

		WebElement campele3=driver.findElement(By.xpath(properties.getProperty("e_campaignhover")));
		
		
		Actions camp_action3=new Actions(driver);
		 camp_action3.moveToElement(campele3).perform();
		 Thread.sleep(5000);
		 WebElement create_campele3= driver.findElement(By.xpath(properties.getProperty("e_createcampaign")));
		 camp_action3.moveToElement(create_campele3);
		 camp_action3.click();
		 camp_action3.perform();
		Thread.sleep(5000);
	driver.findElement(By.xpath(properties.getProperty("e_openecampaign"))).click();		
	Thread.sleep(5000);
	
	List<String> campaignNames3 = new ArrayList<String>();
	String query3 = properties.getProperty("query.getCampaignNamesByOrganizationIds").replaceAll(":emailId",properties.getProperty("user.name"));
	ResultSet resultSet3 = DatabaseConnection.getResultSet(query3);
	while (resultSet3.next()) {
		campaignNames3.add(resultSet3.getString("campaign_name").toLowerCase());
	}
	String campaignNameFromProp3 = properties.getProperty("ewrite_campaign").toLowerCase();
	Thread.sleep(5000);
	driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("ewrite_campaign"));	
	Thread.sleep(5000);
	//if(campaignNames.indexOf(campaignNameFromProp)>-1) {
		driver.findElement(By.id(properties.getProperty("ecampaignName"))).clear();
		driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("ewrite_campaign")+"_"+System.currentTimeMillis());	
	//}
	Thread.sleep(3000);								
/*driver.findElement(By.xpath(properties.getProperty("through_partner"))).click();
	Thread.sleep(3000);	*/																				//through partner//		
	driver.findElement(By.name(properties.getProperty("subjectline"))).sendKeys("subject line:-)...");
	driver.findElement(By.name(properties.getProperty("preheader"))).sendKeys("preHeader.:-0)");
	//driver.findElement(By.className(properties.getProperty("notifyme"))).click();									
	driver.findElement(By.id(properties.getProperty("next"))).click();								
	Thread.sleep(5000);
	
	driver.findElement(By.xpath(properties.getProperty("e_prtnrlst_srch"))).sendKeys("TGA");
	Thread.sleep(5000);
	
	
	driver.findElement(By.xpath(properties.getProperty("esrch_slct_prtnrlst_clck"))).click();										
	Thread.sleep(5000);
	
	
	driver.findElement(By.xpath(properties.getProperty("eslct_prtnrlst"))).click();										
	Thread.sleep(8000);
	
	
	driver.findElement(By.xpath(properties.getProperty("epartnerlist_preview"))).click();		
	Thread.sleep(5000);
	
	
	 
	 
	 
	 WebElement eg4 = driver.findElement(By.xpath(properties.getProperty("eplist")));
			 List<WebElement> links4 = eg4.findElements(By.tagName("li"));
			 for (int i = 0; i <= links4.size()+2; i++)
			 {
				 System.out.println(i);
				// System.out.println(links.size());
			   //  System.out.println(links.get(i).getText());
			  
				 WebElement  c1=driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation")));
				 c1.click();
				
				 Thread.sleep(3000);
				 System.out.println(i +"clicked");
						 	
			 
			 } 
	

	
	
	
	
	
	Thread.sleep(5000);
	driver.findElement(By.xpath(properties.getProperty("eclose_partnerpreview"))).click();	
	Thread.sleep(5000);
	driver.findElement(By.xpath(properties.getProperty("enext2"))).click();						
Thread.sleep(10000);

JavascriptExecutor js5 = (JavascriptExecutor) driver;
	  js5.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	  
	 Thread.sleep(8000);
	 
	 for(int g=0;g<=5;g++) {
driver.findElement(By.xpath(properties.getProperty("epagenation"))).click();
Thread.sleep(8000);
	 }
	
	
	 Thread.sleep(10000);
	driver.findElement(By.xpath(properties.getProperty("egoto_top"))).click();
	Thread.sleep(3000);

	
	driver.findElement(By.xpath(properties.getProperty("ebasic_tmplt"))).click();
	Thread.sleep(8000);
	
	driver.findElement(By.xpath(properties.getProperty("eupld_tmplt"))).click();
	Thread.sleep(8000);

	driver.findElement(By.xpath(properties.getProperty("erglr_tmplt"))).click();
	Thread.sleep(8000);
	driver.findElement(By.xpath(properties.getProperty("eall_tmplt"))).click();
	Thread.sleep(8000);
	
driver.findElement(By.xpath(properties.getProperty("esrch_tmplt"))).sendKeys("basicEcomTemp ");			
Thread.sleep(5000);


driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_clck"))).click();
Thread.sleep(5000);

JavascriptExecutor js15 = (JavascriptExecutor) driver;
  js15.executeScript("window.scrollTo(document.body.scrollHeight,0)");
  Thread.sleep(5000);

	JavascriptExecutor js115 = (JavascriptExecutor) driver;
	  js115.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	  Thread.sleep(5000);
driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_slct_last"))).click();
Thread.sleep(8000);

/*driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_clck_clr_srch"))).click();
Thread.sleep(5000);
*/
driver.findElement(By.xpath(properties.getProperty("eselect_template"))).click();
Thread.sleep(8000);

driver.findElement(By.xpath(properties.getProperty("etemplate_prvw"))).click();
Thread.sleep(5000);

driver.findElement(By.xpath(properties.getProperty("etemplate_prvw_cls"))).click();
Thread.sleep(5000);



	driver.findElement(By.xpath(properties.getProperty("next31"))).click();
	Thread.sleep(5000);
	


			driver.findElement(By.xpath(properties.getProperty("email_visit_email"))).click();
			Thread.sleep(5000);
			WebElement rdrpdwn=driver.findElement(By.xpath(properties.getProperty("eresponse_drpdwn")));
			//rdrpdwn.click();
			Select reason=new Select(rdrpdwn);
			Thread.sleep(5000);
			reason.selectByValue("13");
			Thread.sleep(15000);
			driver.findElement(By.xpath(properties.getProperty("evsubject"))).sendKeys("subject:email is opened");
			Thread.sleep(5000);
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
			driver.findElement(By.xpath("html/body")).click();
			driver.switchTo().activeElement().sendKeys("Hello:email is opened,thanku for opening email");

			driver.switchTo().defaultContent();
			
			/*driver.findElement(By.xpath(properties.getProperty("evselect_temp"))).click();
			Thread.sleep(5000);*/
			driver.findElement(By.xpath(properties.getProperty("evsave_click"))).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath(properties.getProperty("evsave"))).click();
			Thread.sleep(5000);
			
			WebElement campele5=driver.findElement(By.xpath(properties.getProperty("e_campaignhover")));
			
			
			Actions camp_action5=new Actions(driver);
			 camp_action5.moveToElement(campele5).perform();
			 Thread.sleep(5000);
			 WebElement create_campele5= driver.findElement(By.xpath(properties.getProperty("e_createcampaign")));
			 camp_action5.moveToElement(create_campele5);
			 camp_action5.click();
			 camp_action5.perform();
			Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("e_openecampaign"))).click();		
		Thread.sleep(5000);
		
		List<String> campaignNames5 = new ArrayList<String>();
		String query5 = properties.getProperty("query.getCampaignNamesByOrganizationIds").replaceAll(":emailId",properties.getProperty("user.name"));
		ResultSet resultSet5 = DatabaseConnection.getResultSet(query5);
		while (resultSet5.next()) {
			campaignNames5.add(resultSet5.getString("campaign_name").toLowerCase());
		}
		String campaignNameFromProp5 = properties.getProperty("ewrite_campaign").toLowerCase();
		Thread.sleep(5000);
		driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("ewrite_campaign"));	
		Thread.sleep(5000);
		//if(campaignNames.indexOf(campaignNameFromProp)>-1) {
			driver.findElement(By.id(properties.getProperty("ecampaignName"))).clear();
			driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("ewrite_campaign")+"_"+System.currentTimeMillis());	
		//}
		Thread.sleep(3000);								
	/*driver.findElement(By.xpath(properties.getProperty("through_partner"))).click();
		Thread.sleep(3000);	*/																				//through partner//		
		driver.findElement(By.name(properties.getProperty("subjectline"))).sendKeys("subject line:-)...");
		driver.findElement(By.name(properties.getProperty("preheader"))).sendKeys("preHeader.:-0)");
		//driver.findElement(By.className(properties.getProperty("notifyme"))).click();									
		driver.findElement(By.id(properties.getProperty("next"))).click();								
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("e_prtnrlst_srch"))).sendKeys("TGA");
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath(properties.getProperty("esrch_slct_prtnrlst_clck"))).click();										
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath(properties.getProperty("eslct_prtnrlst"))).click();										
		Thread.sleep(8000);
		
		
		driver.findElement(By.xpath(properties.getProperty("epartnerlist_preview"))).click();		
		Thread.sleep(5000);
		
		/*	WebElement  c1=driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation")));

	 for(int a=0;a<=6;a++) {
			  driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation"))).click();
				Thread.sleep(3000);
			 }
		*/
		 
		 
		 
		 
		 WebElement eg6 = driver.findElement(By.xpath(properties.getProperty("eplist")));
				 List<WebElement> links6 = eg6.findElements(By.tagName("li"));
				 for (int i = 0; i <= links6.size()+2; i++)
				 {
					 System.out.println(i);
					// System.out.println(links.size());
				   //  System.out.println(links.get(i).getText());
				  
					 WebElement  c1=driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation")));
					 c1.click();
					 
					 Thread.sleep(3000);
					 System.out.println(i +"clicked");
							 	
				 
				 } 
		

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("eclose_partnerpreview"))).click();	
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("enext2"))).click();						
	Thread.sleep(10000);

	JavascriptExecutor js6 = (JavascriptExecutor) driver;
		  js6.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		  
		 Thread.sleep(8000);
		 
		 for(int g=0;g<=5;g++) {
	driver.findElement(By.xpath(properties.getProperty("epagenation"))).click();
	Thread.sleep(8000);
		 }
		
		
		 Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("egoto_top"))).click();
		Thread.sleep(3000);
	
		
		driver.findElement(By.xpath(properties.getProperty("ebasic_tmplt"))).click();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath(properties.getProperty("eupld_tmplt"))).click();
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("erglr_tmplt"))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("eall_tmplt"))).click();
		Thread.sleep(8000);
		
	driver.findElement(By.xpath(properties.getProperty("esrch_tmplt"))).sendKeys("basicEcomTemp ");			
	Thread.sleep(5000);
	

	driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_clck"))).click();
	Thread.sleep(5000);
	
	JavascriptExecutor js16 = (JavascriptExecutor) driver;
	  js16.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	  Thread.sleep(5000);

		JavascriptExecutor js116 = (JavascriptExecutor) driver;
		  js116.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		  Thread.sleep(5000);
	driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_slct_last"))).click();
	Thread.sleep(8000);
	
	/*driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_clck_clr_srch"))).click();
	Thread.sleep(5000);
	*/
	driver.findElement(By.xpath(properties.getProperty("eselect_template"))).click();
	Thread.sleep(8000);
	
	driver.findElement(By.xpath(properties.getProperty("etemplate_prvw"))).click();
	Thread.sleep(5000);

	driver.findElement(By.xpath(properties.getProperty("etemplate_prvw_cls"))).click();
	Thread.sleep(5000);
	
	
	
		driver.findElement(By.xpath(properties.getProperty("next31"))).click();
		Thread.sleep(5000);
		


				driver.findElement(By.xpath(properties.getProperty("email_visit_email"))).click();
				Thread.sleep(5000);
			WebElement rdrpdwn6=driver.findElement(By.xpath(properties.getProperty("eresponse_drpdwn")));
			//rdrpdwn.click();
			Select reason6=new Select(rdrpdwn6);
			Thread.sleep(5000);
			reason6.selectByValue("0");
			Thread.sleep(15000);
			driver.findElement(By.xpath(properties.getProperty("evreply_xdays"))).sendKeys("2");
			Thread.sleep(5000);
			
			
			driver.findElement(By.xpath(properties.getProperty("evsubject2"))).sendKeys("email not opened in 2 days-)");
			Thread.sleep(5000);
			/*driver.findElement(By.xpath(properties.getProperty("evselect_temp2"))).click();
			Thread.sleep(5000);*/
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
			driver.findElement(By.xpath("html/body")).click();
			driver.switchTo().activeElement().sendKeys("Hello:email is not opened for 2 days;please open the email");

			driver.switchTo().defaultContent();
			
			driver.findElement(By.xpath(properties.getProperty("evnow_click"))).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath(properties.getProperty("evnow_launch"))).click();
			Thread.sleep(5000);
			
			WebElement campele6=driver.findElement(By.xpath(properties.getProperty("e_campaignhover")));
			
			
			Actions camp_action6=new Actions(driver);
			 camp_action6.moveToElement(campele6).perform();
			 Thread.sleep(5000);
			 WebElement create_campele6= driver.findElement(By.xpath(properties.getProperty("e_createcampaign")));
			 camp_action6.moveToElement(create_campele6);
			 camp_action6.click();
			 camp_action6.perform();
			Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("e_openecampaign"))).click();		
		Thread.sleep(5000);
		
		List<String> campaignNames6 = new ArrayList<String>();
		String query6 = properties.getProperty("query.getCampaignNamesByOrganizationIds").replaceAll(":emailId",properties.getProperty("user.name"));
		ResultSet resultSet6 = DatabaseConnection.getResultSet(query6);
		while (resultSet6.next()) {
			campaignNames6.add(resultSet6.getString("campaign_name").toLowerCase());
		}
		String campaignNameFromProp6 = properties.getProperty("ewrite_campaign").toLowerCase();
		Thread.sleep(5000);
		driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("ewrite_campaign"));	
		Thread.sleep(5000);
		//if(campaignNames.indexOf(campaignNameFromProp)>-1) {
			driver.findElement(By.id(properties.getProperty("ecampaignName"))).clear();
			driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("ewrite_campaign")+"_"+System.currentTimeMillis());	
		//}
		Thread.sleep(3000);								
	/*driver.findElement(By.xpath(properties.getProperty("through_partner"))).click();
		Thread.sleep(3000);	*/																				//through partner//		
		driver.findElement(By.name(properties.getProperty("subjectline"))).sendKeys("subject line:-)...");
		driver.findElement(By.name(properties.getProperty("preheader"))).sendKeys("preHeader.:-0)");
		//driver.findElement(By.className(properties.getProperty("notifyme"))).click();									
		driver.findElement(By.id(properties.getProperty("next"))).click();								
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("e_prtnrlst_srch"))).sendKeys("TGA");
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath(properties.getProperty("esrch_slct_prtnrlst_clck"))).click();										
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath(properties.getProperty("eslct_prtnrlst"))).click();										
		Thread.sleep(8000);
		
		
		driver.findElement(By.xpath(properties.getProperty("epartnerlist_preview"))).click();		
		Thread.sleep(5000);
		
		/*	WebElement  c1=driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation")));

	 for(int a=0;a<=6;a++) {
			  driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation"))).click();
				Thread.sleep(3000);
			 }
		*/
		 
		 
		 
		 
		 WebElement eg7 = driver.findElement(By.xpath(properties.getProperty("eplist")));
				 List<WebElement> links7 = eg7.findElements(By.tagName("li"));
				 for (int i = 0; i <= links7.size()+2; i++)
				 {
					 System.out.println(i);
					// System.out.println(links.size());
				   //  System.out.println(links.get(i).getText());
					 WebElement  c1=driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation")));
					 c1.click();

					 Thread.sleep(3000);
					 System.out.println(i +"clicked");
							 	
				 
				 } 
	
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("eclose_partnerpreview"))).click();	
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("enext2"))).click();						
	Thread.sleep(10000);

	JavascriptExecutor js7 = (JavascriptExecutor) driver;
		  js7.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		  
		 Thread.sleep(8000);
		 
		 for(int g=0;g<=5;g++) {
	driver.findElement(By.xpath(properties.getProperty("epagenation"))).click();
	Thread.sleep(8000);
		 }
		
		
		 Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("egoto_top"))).click();
		Thread.sleep(3000);
	
		
		driver.findElement(By.xpath(properties.getProperty("ebasic_tmplt"))).click();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath(properties.getProperty("eupld_tmplt"))).click();
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("erglr_tmplt"))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("eall_tmplt"))).click();
		Thread.sleep(8000);
		
	driver.findElement(By.xpath(properties.getProperty("esrch_tmplt"))).sendKeys("basicEcomTemp ");			
	Thread.sleep(5000);
	

	driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_clck"))).click();
	Thread.sleep(5000);
	
	JavascriptExecutor js17 = (JavascriptExecutor) driver;
	  js17.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	  Thread.sleep(5000);

		JavascriptExecutor js117 = (JavascriptExecutor) driver;
		  js117.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		  Thread.sleep(5000);
	driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_slct_last"))).click();
	Thread.sleep(8000);
	
	/*driver.findElement(By.xpath(properties.getProperty("esrch_tmplt_clck_clr_srch"))).click();
	Thread.sleep(5000);
	*/
	driver.findElement(By.xpath(properties.getProperty("eselect_template"))).click();
	Thread.sleep(8000);
	
	driver.findElement(By.xpath(properties.getProperty("etemplate_prvw"))).click();
	Thread.sleep(5000);

	driver.findElement(By.xpath(properties.getProperty("etemplate_prvw_cls"))).click();
	Thread.sleep(5000);
	
	
	
		driver.findElement(By.xpath(properties.getProperty("next31"))).click();
		Thread.sleep(5000);
		

				

				driver.findElement(By.xpath(properties.getProperty("email_visit_email"))).click();
				Thread.sleep(5000);
				
			WebElement rdrpdwn7=driver.findElement(By.xpath(properties.getProperty("eresponse_drpdwn")));
			//rdrpdwn.click();
			Select reason7=new Select(rdrpdwn7);
			Thread.sleep(5000);
			reason7.selectByValue("16");
			Thread.sleep(15000);
			
			driver.findElement(By.xpath(properties.getProperty("evsubject3"))).sendKeys("send immeditely after email is opnd");
			Thread.sleep(5000);
			/*driver.findElement(By.xpath(properties.getProperty("evselect_temp3"))).click();
			Thread.sleep(5000);*/
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
			driver.findElement(By.xpath("html/body")).click();
			driver.switchTo().activeElement().sendKeys("Hello:send immeditely after email is opnd,thnku for opening");

			driver.switchTo().defaultContent();
			
			driver.findElement(By.xpath(properties.getProperty("evschedule_click"))).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath(properties.getProperty("evsch_date"))).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[2]")).click();
			Thread.sleep(10000);

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
	
	
	
	
	
}