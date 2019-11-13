package com.xamplify.LIVE;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;


	public class VideoCampaign {
	    private static String z = "";

		
		 WebDriver driver = Instance.getInstance();
		 
			Properties properties = PropertiesFile.readPropertyFile("rdata.properties");

		//@BeforeMethod   [for auto responses...comment @test annotation ,use @Beforemethod  ]
			@Test
			public void vdecampaign() throws InterruptedException, SQLException {
				driver.get("https://release.xamplify.io/home/dashboard/welcome");
				
				Thread.sleep(5000);
				
				WebDriverWait waitv = new WebDriverWait(driver, 30);

				// Wait till the element is not visible

				WebElement vcampele = waitv.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("campaign_hover_v"))));
				vcampele.click();
				
				
				
				
				Actions camp_action = new Actions(driver);
				camp_action.moveToElement(vcampele).perform();
				Thread.sleep(5000);
				WebElement create_campele = driver.findElement(By.xpath(properties.getProperty("vcreatecampaign")));
				camp_action.moveToElement(create_campele);
				camp_action.click();
				camp_action.perform();
				Thread.sleep(5000);

				driver.findElement(By.xpath(properties.getProperty("openvideocampaign"))).click();
				Thread.sleep(3000);
				
			
				
						List<String> campaignNames = new ArrayList<String>();
				String query = properties.getProperty("query.getCampaignNamesByOrganizationId").replaceAll(":emailId",properties.getProperty("user.name"));
				ResultSet resultSet = DatabaseConnection.getResultSet(query);
				while (resultSet.next()) {
				campaignNames.add(resultSet.getString("campaign_name").toLowerCase());
				}
				String campaignNameFromProp = properties.getProperty("ewrite_campaign").toLowerCase();

				driver.findElement(By.id(properties.getProperty("vcampaignName"))).sendKeys(properties.getProperty("vwrite_campaign"));	
				Thread.sleep(5000);
				//if(campaignNames.indexOf(campaignNameFromProp)>-1) {
				driver.findElement(By.id(properties.getProperty("vcampaignName"))).clear();
				
				WebElement vcampaignName=driver.findElement(By.id(properties.getProperty("vcampaignName")));
				vcampaignName.sendKeys(properties.getProperty("vwrite_campaign")+"_"+System.currentTimeMillis());
				System.out.println(vcampaignName.getAttribute("value"));
				  
//				driver.findElement(By.id(properties.getProperty("vcampaignName"))).sendKeys(properties.getProperty("vwrite_campaign")+"_"+System.currentTimeMillis());
				Thread.sleep(2000);
				  

				
				String getcampaignname = vcampaignName.getAttribute("value");

		        z = getcampaignname;

				//}
				
				
			
			
				Thread.sleep(1000);
				driver.findElement(By.xpath(
						"//*[@id=\"campaignDetailsForm\"]/div/div/div/div/div[2]/div/div/div/div[1]/switch/div/div/span[3]"))
						.click();
				Thread.sleep(3000);
				
				
			driver.findElement(By.xpath(properties.getProperty("vsubjectline"))).sendKeys("subjectLine***");
			
				
			Thread.sleep(3000);

				driver.findElement(By.name(properties.getProperty("vpreheader"))).sendKeys("preHeader***");
				Thread.sleep(3000);

				driver.findElement(By.xpath(properties.getProperty("vnotifyme_email"))).click();
				driver.findElement(By.xpath(properties.getProperty("vnotifyme_video"))).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(properties.getProperty("vpushleads2marketo"))).click();
				Thread.sleep(5000);
				
				
				
				
				
				
				WebDriverWait waitv2 = new WebDriverWait(driver, 30);

				// Wait till the element is not visible

				WebElement wvnext1 = waitv2.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("vcampaign_next_button1"))));
				wvnext1.click();
				
				

				/*for (int i = 0; i <= 8; i++) {
					driver.findElement(By.xpath(properties.getProperty("v_pagenation_nxt"))).click();

					Thread.sleep(5000);
				}*/
				
				
				
				
/*
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				Thread.sleep(5000);

WebElement eg1 = driver.findElement(By.xpath(properties.getProperty("vpagintionlist")));
				 List<WebElement> links1 = eg1.findElements(By.tagName("li"));
				 for (int j = 1; j <= links1.size()-5; j++)
				 {
					 System.out.println(j);
					 System.out.println(links1.size());
				    System.out.println(links1.get(j).getText());
				  

					 WebElement  c2=driver.findElement(By.xpath(properties.getProperty("v_pagenation_nxt")));
					 Thread.sleep(10000);
					 c2.click();
					 Thread.sleep(9000);
					 System.out.println(j +"clicked");
							 	
				 
				 } 
				
				*/
				
				
				Thread.sleep(5000);
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(document.body.scrollHeight,500)");
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("v_search_video"))).sendKeys("10");
				Thread.sleep(3000);
				driver.findElement(By.xpath(properties.getProperty("v_search_video_click"))).click();

				WebElement vdropdown = driver.findElement(By.xpath(properties.getProperty("video_category")));
				Thread.sleep(3000);

				Select vd = new Select(vdropdown);
				Thread.sleep(5000);
				vd.selectByValue("1");
				WebDriverWait wait=new WebDriverWait(driver,40);

				WebElement AccountingTextFind = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Accounting')]")));
				System.out.println(AccountingTextFind.getAttribute("value"));

				driver.findElement(By.xpath(properties.getProperty("select_video1"))).click();
				WebDriverWait wait4=new WebDriverWait(driver,50);

				WebElement categoryVideosLoading = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='my-videos']//tr[3]//td[2]")));
				System.out.println(categoryVideosLoading.getAttribute("value"));
				Thread.sleep(5000);
				
				driver.findElement(By.xpath(properties.getProperty("goto_top"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("video_next2"))).click();
				Thread.sleep(5000);

				/*
				 * driver.findElement(By.xpath(properties.getProperty("vd_nxt"))).click();
				 * Thread.sleep(5000);
				 */
				driver.findElement(By.xpath(properties.getProperty("search_select_partnerlist")))
						.sendKeys("gayatri test mails");
				Thread.sleep(5000);

				driver.findElement(By.xpath(properties.getProperty("search_select_partnerlist_click"))).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath(properties.getProperty("select_partner_preview"))).click();
				Thread.sleep(5000);
				
				
				
				

				/*for (int j = 0; j <= 6; j++) {
					driver.findElement(By.xpath(properties.getProperty("slct_prtnr_prvw_pgntn"))).click();
					Thread.sleep(5000);
				}*/

				driver.findElement(By.xpath(properties.getProperty("close_partner_preview"))).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath(properties.getProperty("select_partnerlist"))).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath(properties.getProperty("select_next3"))).click();
				Thread.sleep(5000);

				/*
				 * driver.findElement(By.xpath(properties.getProperty("clck_tmplt2"))).click();
				 * Thread.sleep(7000);
				 * driver.findElement(By.xpath(properties.getProperty("clck_tmplt3"))).click();
				 * Thread.sleep(5000);
				 * driver.findElement(By.xpath(properties.getProperty("clck_tmplt4"))).click();
				 * Thread.sleep(5000);
				 */

				/*driver.findElement(By.xpath("//*[@id=\"myBtn\"]")).click();
				Thread.sleep(5000);*/

				/*WebDriverWait waitv6 = new WebDriverWait(driver, 30);
				WebElement v6 = waitv6
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("srch_tmplt"))));			//click on search
				v6.sendKeys("cobranding");
				*/
				
				
				driver.findElement(By.xpath(properties.getProperty("search_template"))).sendKeys("cobranding");

			
				
				
				WebDriverWait waitv7 = new WebDriverWait(driver, 50);
				WebElement v7 = waitv7
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search_template_click"))));			//click on search
				v7.click();
				
				

				
				driver.findElement(By.xpath(properties.getProperty("search_template_click_clear"))).click();
			
				
				WebDriverWait waitv9 = new WebDriverWait(driver, 50);
				WebElement v9 = waitv9
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search_template_click_clear_search"))));			
				v9.click();
				

				WebDriverWait waitv10 = new WebDriverWait(driver, 50);
				WebElement v10 = waitv10
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("select_template"))));			
				v10.click();
				Thread.sleep(5000);
				
			
				driver.findElement(By.xpath(properties.getProperty("email_template_next"))).click();
				Thread.sleep(5000);
				
			}
		  
			
			public static String getcurrentcampaignname()
			{
				return z;
			}
			
		}

	