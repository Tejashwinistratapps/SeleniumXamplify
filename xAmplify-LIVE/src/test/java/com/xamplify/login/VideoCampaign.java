package com.xamplify.login;

	import java.sql.SQLException;
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
			public void vdecampaign() throws InterruptedException, SQLException {

				driver.get("https://xamplify.io/home/dashboard/welcome");
				Thread.sleep(10000);

				WebElement campele = driver.findElement(By.xpath(properties.getProperty("campaign_hover")));

				Actions camp_action = new Actions(driver);
				camp_action.moveToElement(campele).perform();
				Thread.sleep(5000);
				WebElement create_campele = driver.findElement(By.xpath(properties.getProperty("createcampaign")));
				camp_action.moveToElement(create_campele);
				camp_action.click();
				camp_action.perform();
				Thread.sleep(5000);

				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-select-campaign[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]/i[1]\r\n"))
						.click();
				Thread.sleep(3000);
				WebElement cam_name = driver.findElement(By.name("campaignName"));

				DatabaseQueries data = new DatabaseQueries();
				String query7 = properties.getProperty("query.getCampaignNamesByOrganizationId").replaceAll(":emailId",
						properties.getProperty("user.name"));
				List<String> campaignNames = data.listNames(query7, "campaign_name");
				String campaignNameFromProp = properties.getProperty("write_campaign").toLowerCase();

				driver.findElement(By.name(properties.getProperty("ecampaignName")))
						.sendKeys(properties.getProperty("write_campaign"));

				Thread.sleep(5000);
				if (campaignNames.indexOf(campaignNameFromProp) > -1) {
					driver.findElement(By.name(properties.getProperty("ecampaignName"))).clear();
					driver.findElement(By.name(properties.getProperty("ecampaignName")))
							.sendKeys(properties.getProperty("write_campaign") + "_" + System.currentTimeMillis());
					Thread.sleep(10000);
				}
				Thread.sleep(1000);
				driver.findElement(By.xpath(
						"//*[@id=\"campaignDetailsForm\"]/div/div/div/div/div[2]/div/div/div/div[1]/switch/div/div/span[3]"))
						.click();

				driver.findElement(By.name("subjectLine")).sendKeys("subjectLine***");
				driver.findElement(By.name("preHeader")).sendKeys("preHeader***");
				Thread.sleep(3000);

				driver.findElement(By.xpath(properties.getProperty("notifyme_email"))).click();
				driver.findElement(By.xpath(properties.getProperty("notifyme_video"))).click();
				driver.findElement(By.xpath(properties.getProperty("cmpgn_dtls_next"))).click();

				for (int i = 0; i <= 8; i++) {
					driver.findElement(By.xpath(properties.getProperty("v_pagenation_nxt"))).click();

					Thread.sleep(5000);
				}
				driver.findElement(By.xpath(properties.getProperty("v_srch_vde"))).sendKeys("10");
				Thread.sleep(3000);
				driver.findElement(By.xpath(properties.getProperty("v_srch_vde_clck"))).click();

				WebElement vdrpdwn = driver.findElement(By.xpath(properties.getProperty("vds_ctgry")));
				Thread.sleep(3000);

				Select vd = new Select(vdrpdwn);
				Thread.sleep(5000);
				vd.selectByValue("1");
				Thread.sleep(15000);

				driver.findElement(By.xpath(properties.getProperty("slct_vd1"))).click();
				Thread.sleep(15000);
				driver.findElement(By.xpath(properties.getProperty("goto_top"))).click();
				Thread.sleep(15000);
				driver.findElement(By.xpath(properties.getProperty("vde_nxt"))).click();
				Thread.sleep(5000);

				/*
				 * driver.findElement(By.xpath(properties.getProperty("vd_nxt"))).click();
				 * Thread.sleep(5000);
				 */
				driver.findElement(By.xpath(properties.getProperty("srch_slct_prtnrlst")))
						.sendKeys("TGAInfoSolutions's Master Partners List");

				driver.findElement(By.xpath(properties.getProperty("srch_slct_prtnrlst_clck"))).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath(properties.getProperty("slct_partnr_prvw"))).click();
				Thread.sleep(5000);

				for (int j = 0; j <= 6; j++) {
					driver.findElement(By.xpath(properties.getProperty("slct_prtnr_prvw_pgntn"))).click();
					Thread.sleep(5000);
				}

				driver.findElement(By.xpath(properties.getProperty("clse_prtnr_prvw"))).click();
				Thread.sleep(10000);

				driver.findElement(By.xpath(properties.getProperty("slct_prtnrlst"))).click();
				Thread.sleep(10000);

				driver.findElement(By.xpath(properties.getProperty("slct_nxt"))).click();
				Thread.sleep(5000);

				/*
				 * driver.findElement(By.xpath(properties.getProperty("clck_tmplt2"))).click();
				 * Thread.sleep(7000);
				 * driver.findElement(By.xpath(properties.getProperty("clck_tmplt3"))).click();
				 * Thread.sleep(5000);
				 * driver.findElement(By.xpath(properties.getProperty("clck_tmplt4"))).click();
				 * Thread.sleep(5000);
				 */

				driver.findElement(By.xpath("//*[@id=\"myBtn\"]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("srch_tmplt"))).sendKeys("cobranding");
				Thread.sleep(5000);

				driver.findElement(By.xpath(properties.getProperty("srch_tmplt_clck"))).click();
				Thread.sleep(9000);

				/*
				 * driver.findElement(By.xpath(properties.getProperty("srch_tmplt_clck_clr"))).
				 * click(); Thread.sleep(5000);
				 */
				/*
				 * driver.findElement(By.xpath(properties.getProperty("srch_tmplt_clck_clr_srch"
				 * ))).click();
				 */

				driver.findElement(By.xpath(properties.getProperty("slct_tmplte"))).click();
				driver.findElement(By.xpath(properties.getProperty("email_tmplte_nxt"))).click();
				Thread.sleep(5000);
			}

			@Test(priority = 33, enabled = true)
			public void vde_autovistit1() throws InterruptedException {
				driver.findElement(By.xpath(properties.getProperty("auto_rspnse_website_vst"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("a_r_w_v_sub1"))).sendKeys("s:send if not clicked");
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("H:send if not clicked,plz click d mail");
				driver.switchTo().defaultContent();
				driver.findElement(By.xpath(properties.getProperty("a_r_w_v_now"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("a_r_w_v_now_launch"))).click();
				Thread.sleep(5000);
			}

			@Test(priority = 34, enabled = true)
			public void vde_autovistit2() throws InterruptedException {

				driver.findElement(By.xpath(properties.getProperty("auto_rspnse_website_vst2"))).click();
				Thread.sleep(5000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				Thread.sleep(5000);
				WebElement drpdwnv1 = driver.findElement(By.xpath(properties.getProperty("whn_to_snd_eml_drpdwn")));
				Select arv_vde = new Select(drpdwnv1);
				Thread.sleep(5000);
				arv_vde.selectByValue("20");
				Thread.sleep(15000);
				driver.findElement(By.xpath(properties.getProperty("a_r_w_v_sub2"))).sendKeys("s.send immediately after clicked");
				Thread.sleep(5000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("H:send immediately after clicked,tq for clicking immmediately");
				driver.switchTo().defaultContent();
				driver.findElement(By.xpath(properties.getProperty("a_r_w_v_now1"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("a_r_w_v_testmail"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("enter_testmailid"))).sendKeys("gayatrialla11@gmail.com");
				driver.findElement(By.xpath(properties.getProperty("testmailid_submit"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("test_mailid_s_ok"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("a_r_w_v_launch"))).click();
				Thread.sleep(5000);

			}

			@Test(priority = 35, enabled = true)
			public void vde_autovistit3() throws InterruptedException {
				driver.findElement(By.xpath(properties.getProperty("auto_rspnse_website_vst3"))).click();
				Thread.sleep(5000);
				WebElement drpdwnv1 = driver.findElement(By.xpath(properties.getProperty("whn_to_snd_eml_drpdwn2")));
				Select arv_vde = new Select(drpdwnv1);
				Thread.sleep(5000);
				arv_vde.selectByValue("21");
				Thread.sleep(15000);

				driver.findElement(By.xpath(properties.getProperty("a_r_w_v_sub3"))).sendKeys("s.schedule");
				Thread.sleep(5000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("Hello..scheduled");
				driver.switchTo().defaultContent();
				driver.findElement(By.xpath(properties.getProperty("a_r_w_v_schdul"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("a_r_w_v_date"))).click();
				Thread.sleep(5000);
				/*
				 * driver.findElement(By.xpath(properties.getProperty("a_r_w_v_nxtdate"))).click
				 * (); Thread.sleep(5000);
				 */

				driver.findElement(By.xpath(properties.getProperty("slct_a_r_w_v_date"))).click();
				WebElement v_sch_cntry_drpdwn1 = driver.findElement(By.xpath(properties.getProperty("a_r_w_v_country_drpdwn")));
				Select vde_sch_country1 = new Select(v_sch_cntry_drpdwn1);
				Thread.sleep(5000);
				vde_sch_country1.selectByValue("237");
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("a_r_w_v_scheduled"))).click();
				Thread.sleep(5000);
			}

			@Test(priority = 36, enabled = true)
			public void vde_autovistitemail1() throws InterruptedException {

				driver.findElement(By.xpath(properties.getProperty("auto_rspnse_email_vst"))).click();
				Thread.sleep(5000);
				WebElement rdrpdwnv1 = driver.findElement(By.xpath(properties.getProperty("Reason")));
		//rdrpdwn.click();
				Select arve_vde = new Select(rdrpdwnv1);
				Thread.sleep(5000);
				arve_vde.selectByValue("13");
				Thread.sleep(15000);
				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_sub1"))).sendKeys("email is opened..");
				Thread.sleep(5000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("Hello.email is opened:tq for opening the email");
				driver.switchTo().defaultContent();
				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_now1"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_now_launch"))).click();
				Thread.sleep(5000);
			}

			@Test(priority = 37, enabled = true)
			public void vde_autovistitemail2() throws InterruptedException {

				driver.findElement(By.xpath(properties.getProperty("auto_rspnse_email_vst2"))).click();
				Thread.sleep(5000);
				WebElement rdrpdwnv1 = driver.findElement(By.xpath(properties.getProperty("Reason2")));
		//rdrpdwn.click();
				Select arve_vde = new Select(rdrpdwnv1);
				Thread.sleep(5000);
				arve_vde.selectByValue("16");
				Thread.sleep(15000);

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_sub2")))
						.sendKeys("immediately after email opened.");
				Thread.sleep(5000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("H;send immediately after email is opened:tq for opening email ");

				driver.switchTo().defaultContent();

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_schdul"))).click();

				Thread.sleep(5000);

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_schdul_date"))).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_schdul_date_clck"))).click();
				Thread.sleep(10000);

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_slct_cntry"))).click();
				Thread.sleep(5000);

				WebElement vde_sch_cntry_drpdwn = driver
						.findElement(By.xpath(properties.getProperty("a_r_e_v_slct_cntry_drpdwn")));
				// country_drpdwn.click();
				Select v_sch_country = new Select(vde_sch_cntry_drpdwn);
				Thread.sleep(5000);
				v_sch_country.selectByValue("14");
				Thread.sleep(5000);

				WebElement vde_time_drpdwn = driver.findElement(By.xpath(properties.getProperty("a_r_e_v_slct_timezone")));
				// country_drpdwn.click();
				Select v_sch_time = new Select(vde_time_drpdwn);
				Thread.sleep(5000);
				v_sch_time.selectByValue("Australia/Sydney");
				Thread.sleep(5000);

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_schduled"))).click();
				Thread.sleep(5000);

			}

			@Test(priority = 38, enabled = true)
			public void vde_autovistitemail3() throws InterruptedException {

				driver.findElement(By.xpath(properties.getProperty("auto_rspnse_email_vst3"))).click();
				Thread.sleep(5000);

				WebElement rdrpdwnv1 = driver.findElement(By.xpath(properties.getProperty("Reason3")));
				Select arve_vde = new Select(rdrpdwnv1);
				Thread.sleep(5000);
				arve_vde.selectByValue("1");
				Thread.sleep(15000);

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_sub3"))).sendKeys("s:video is played..");
				Thread.sleep(5000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("H;video played:tq for playing video");

				driver.switchTo().defaultContent();
				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_save"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_saved"))).click();
				Thread.sleep(5000);
			}

			@Test(priority = 39, enabled = true)
			public void vde_autovistitemail4() throws InterruptedException {

				driver.findElement(By.xpath(properties.getProperty("auto_rspnse_email_vst4"))).click();
				Thread.sleep(5000);

				WebElement rdrpdwnv1 = driver.findElement(By.xpath(properties.getProperty("Reason4")));
				Select arve_vde = new Select(rdrpdwnv1);
				Thread.sleep(5000);
				arve_vde.selectByValue("17");
				Thread.sleep(15000);

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_sub4")))
						.sendKeys("immediately after video played..");
				Thread.sleep(5000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("H;immediately after video played:tq for playing video");

				driver.switchTo().defaultContent();

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_save1"))).click();

				Thread.sleep(5000);

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_saved1"))).click();
				Thread.sleep(5000);
			}

			@Test(priority = 40, enabled = true)
			public void vde_autovistitemail5() throws InterruptedException {

				driver.findElement(By.xpath(properties.getProperty("auto_rspnse_email_vst5"))).click();
				Thread.sleep(5000);

				WebElement rdrpdwnv1 = driver.findElement(By.xpath(properties.getProperty("Reason5")));
				Select arve_vde = new Select(rdrpdwnv1);
				Thread.sleep(5000);
				arve_vde.selectByValue("18");
				Thread.sleep(15000);

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_sub5"))).sendKeys("s;video is not  played..");
				Thread.sleep(5000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("H;video  is not played:please play the video");

				driver.switchTo().defaultContent();

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_nowlast"))).click();

				Thread.sleep(5000);

				driver.findElement(By.xpath(properties.getProperty("a_r_e_v_nowlast_launch"))).click();
				Thread.sleep(5000);

			}

		}

	