package com.xamplify.LIVE;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutoResponsesEmail extends Emailcampaign {

	@Test(priority = 1, enabled = true)
	public void autoResponsesEmail() throws InterruptedException {

		driver.findElement(By.xpath(properties.getProperty("eautoresponse1"))).click(); // auto responses
		
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		Thread.sleep(4000);
		WebElement ele_drpdwn = driver.findElement(By.xpath(properties.getProperty("edrop_down_click"))); // select drop
																											// down
		// rdrpdwn.click();
		Select when_to_send_email = new Select(ele_drpdwn);
		Thread.sleep(5000);
		when_to_send_email.selectByValue("20");
		Thread.sleep(5000);
		driver.findElement(By.name(properties.getProperty("earwv_subject")))
				.sendKeys("subject line:send immediately after clicked"); // select "send immediatley after clicked"
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement()
				.sendKeys("Hello:send immediately after clicked,thanku for clicking immediately");

		driver.switchTo().defaultContent();

		WebElement avaiable_dropdown1 = driver
				.findElement(By.xpath(properties.getProperty("eselect_earwv_avaiable_url"))); // select drop down
		avaiable_dropdown1.click();
		Select url = new Select(avaiable_dropdown1);
		Thread.sleep(5000);
		url.selectByVisibleText("https://www.facebook.com/"); // select facebook link
		// url.selectByValue(2);
		Thread.sleep(8000);

		// driver.findElement(By.xpath(properties.getProperty("edrop_down_click2")));
		// //drop down
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollTo(document.body.scrollHeight,0)");

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("eautoresponse2"))).click(); // auto response
		Thread.sleep(5000);
		// WebElement ele_drpdwn2 =
		driver.findElement(By.xpath(properties.getProperty("edrop_down_click2"))); // drop down
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.xpath(properties.getProperty("esubject2"))).sendKeys("subject line2:send if not clicked"); // subject
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/ckeditor[1]/div[1]/div[1]/div[1]/iframe[1]"))); // switch
																																																																							// to
																																																																							// frame
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello,send if not clicked:please click the mail");

		driver.switchTo().defaultContent();

		JavascriptExecutor js21 = (JavascriptExecutor) driver;
		js21.executeScript("window.scrollTo(document.body.scrollHeight,0)");

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("eautoresponse3"))).click(); // auto response
		Thread.sleep(5000);
		JavascriptExecutor js31 = (JavascriptExecutor) driver;
		js31.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		WebElement ele_drpdwn4 = driver.findElement(By.xpath(properties.getProperty("edrop_down_click3"))); // drop down
																											// click
		// rdrpdwn.click();
		Select when_to_send_email2 = new Select(ele_drpdwn4); // select drop down
		Thread.sleep(5000);
		when_to_send_email2.selectByValue("21");
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("email_xdays"))).sendKeys("1"); // select x days
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("esubject3"))).sendKeys("sub3:schedule"); // subject
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/ckeditor[1]/div[1]/div[1]/div[1]/iframe[1]"))); // switch
																																																																							// to
																																																																							// frame
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:campgin is scheduled for 1 day...");
		driver.switchTo().defaultContent();
		WebElement avble_drpdwn = driver.findElement(By.xpath(properties.getProperty("eselect_earwv_avaiable_url3"))); // select
																														// drop
																														// down
		avble_drpdwn.click();
		Select url3 = new Select(avble_drpdwn);
		Thread.sleep(5000);
		url3.selectByVisibleText("https://www.facebook.com/"); // select facebook link
		// url.selectByValue(2);
		Thread.sleep(8000);

		JavascriptExecutor js211 = (JavascriptExecutor) driver;
		js211.executeScript("window.scrollTo(document.body.scrollHeight,0)");

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("email_visit_email"))).click(); // autoresponse
		Thread.sleep(5000);

		WebElement rdrpdwn = driver.findElement(By.xpath(properties.getProperty("eresponse_drpdwn"))); // select drop
																										// down
		// rdrpdwn.click();

		Select reason = new Select(rdrpdwn);
		Thread.sleep(5000);
		reason.selectByValue("13");
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("are_xdays"))).sendKeys("1"); // select x days
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("evsubject4"))).sendKeys("subject:email is opened"); // subject
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]/ckeditor[1]/div[1]/div[1]/div[1]/iframe[1]"))); // switch
																																																																							// to
																																																																							// frame
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:email is opened,thanku for opening email");

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath(properties.getProperty("email_visit_email2"))).click(); // autoresponse
		Thread.sleep(5000);

		JavascriptExecutor js13 = (JavascriptExecutor) driver;
		js13.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("are2_xdays"))).sendKeys("1"); // select x days
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("evsubject5"))).sendKeys("email not opened---)"); // subject
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]/ckeditor[1]/div[1]/div[1]/div[1]/iframe[1]"))); // switch
																																																																							// the
																																																																							// frame

		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:email is not opened;please open the email");

		driver.switchTo().defaultContent();

		JavascriptExecutor js14 = (JavascriptExecutor) driver;
		js14.executeScript("window.scrollTo(document.body.scrollHeight,0)");

		driver.findElement(By.xpath(properties.getProperty("email_visit_email3"))).click(); // auto response
		Thread.sleep(5000);

		JavascriptExecutor js15 = (JavascriptExecutor) driver;
		js15.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement rdrpdwn2 = driver.findElement(By.xpath(properties.getProperty("eresponse_drpdwn3"))); // select drop
																											// down
		// rdrpdwn.click();
		Select reason1 = new Select(rdrpdwn2);
		Thread.sleep(5000);
		reason1.selectByValue("16");
		Thread.sleep(15000);

		driver.findElement(By.xpath(properties.getProperty("evsubject6")))
				.sendKeys("send immeditely after email is opnd"); // subject
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]/ckeditor[1]/div[1]/div[1]/div[1]/iframe[1]"))); // switch
																																																																							// to
																																																																							// frame
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:send immeditely after email is opnd,thnku for opening");
		driver.switchTo().defaultContent();

		JavascriptExecutor js16 = (JavascriptExecutor) driver;
		js16.executeScript("window.scrollTo(document.body.scrollHeight,0)");

		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("email_visit_email4"))).click(); // auto response
		Thread.sleep(5000);

		JavascriptExecutor js17 = (JavascriptExecutor) driver;
		js17.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		Thread.sleep(5000);
		WebElement rdrpdwn11 = driver.findElement(By.xpath(properties.getProperty("eresponse_drpdwn4"))); // select drop
																											// down
		// rdrpdwn.click();
		Select reason11 = new Select(rdrpdwn11);
		Thread.sleep(3000);
		reason11.selectByValue("22");
		Thread.sleep(5000);
		/* Remove the comment of the below line. In order, to choose the template*/
		
		//driver.findElement(By.xpath("//*[@id=\"reply-7\"]/div[1]/div[2]/div/switch/div/div/span[2]")).click(); 
		

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("evsubject7"))).sendKeys(" redistribute mail.");
		driver.findElement(By.xpath(properties.getProperty("emin_1day"))).sendKeys("1"); // schedule time
		Thread.sleep(5000);
		
		/*
		 * Keep the code in comment from line-232 to line-242, if you choose the template.
		 */
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[2]/div[1]/div[1]/div[3]/fieldset[1]/div[4]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]/ckeditor[1]/div[1]/div[1]/div[1]/iframe[1]")));
		
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:Redistriute campaign section for minimiun 1 day");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		JavascriptExecutor js171 = (JavascriptExecutor) driver;
		js171.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
		/* Remove the comment for below code, if you choose the template above*/
		
		/*driver.findElement(By.xpath(properties.getProperty("eautoresponse_template_senddata"))).sendKeys("emailcon-merge");
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("eautoresponse_templateclicksearch"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("eautoresponse_selecttemplate"))).click();
		Thread.sleep(5000);*/

	}

}
