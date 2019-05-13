package com.xamplify.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmailTemplate {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile.readPropertyFile("C:\\Users\\dtejashwini\\eclipse-workspace\\xamplify-selenium\\datafile.properties");
	private final static Logger logger = LoggerFactory.getLogger(EmailTemplate.class);

	public static void main(String[] args) throws InterruptedException, SQLException, IOException {

		logger.debug("opening the browser");

		driver.manage().window().maximize();
		logger.debug("Entering the URL");

		driver.get("https://xamplify.io/");
		driver.findElement(By.xpath("//a[@class='loginTF']")).click();
		Thread.sleep(10000);
		logger.debug("Login");

		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
		usernameElement.sendKeys("dtejashwini@stratapps.com");
		passwordElement.sendKeys("Automation@123");
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[2]/form[1]/button[1]"))
				.click();
		Thread.sleep(5000);
		logger.debug("login successful");

		Thread.sleep(8000);
		
		WebElement element = driver.findElement(By.xpath(properties.getProperty("email_hover")));
		Thread.sleep(8000);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		WebElement subelement = driver.findElement(By.xpath(properties.getProperty("create_email_temp")));
		action.moveToElement(subelement);
		action.click();
		action.perform();
		Thread.sleep(5000);

		logger.debug("click basic template module");

		WebElement we_basic = driver.findElement(By.xpath(properties.getProperty("Basic_click")));
		we_basic.click();
		Thread.sleep(15000);
		logger.debug("creating Basic ecommerce email tamplate ");

		Actions basic = new Actions(driver);
		WebElement wbasic = driver.findElement(By.xpath(properties.getProperty("Basic_Ecommerce")));
		basic.moveToElement(wbasic).build().perform();
		wbasic.click();
		Thread.sleep(20000);

		driver.switchTo().defaultContent();
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='btn
		// btn-primary ng-binding ng-scope']")));
		//driver.switchTo().frame(
				//driver.findElement(By.xpath("//iframe[@src='https://app.getbee.io/v18.12.18.0923/index.html']")));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//*[@id=\'bee-plugin-container\']/iframe")));
		Thread.sleep(25000);
		driver.findElement(By.xpath("/html/body/bee-app/div/div/div/div[2]/div[1]/div/div[2]/button")).click();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		DatabaseQueries data = new DatabaseQueries();
		String query5i = properties.getProperty("query.getEmailTemplates");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames = data.listNames(query5i, "name");
		String campaignNameFromProp = properties.getProperty("BasicEcom_data").toLowerCase();
		driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name")))
				.sendKeys(properties.getProperty("BasicEcom_data"));
		Thread.sleep(5000);
		if (campaignNames.indexOf(campaignNameFromProp) > -1) {
			driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name"))).clear();
			driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name")))
					.sendKeys(properties.getProperty("BasicEcom_data") + "_" + System.currentTimeMillis());
			Thread.sleep(25000);
		}
		driver.findElement(By.xpath(properties.getProperty("BasicEcom_save"))).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#save"));
		Thread.sleep(10000);
		logger.debug("Saved Basic ecommerce email tamplate ");

		driver.get("https://xamplify.io/home/emailtemplates/manage");

		WebElement element1 = driver.findElement(By.xpath(properties.getProperty("email_hover")));
		Thread.sleep(5000);
		Actions action1 = new Actions(driver);
		action1.moveToElement(element1).perform();
		WebElement subelement1 = driver.findElement(By.xpath(properties.getProperty("create_email_temp")));
		action1.moveToElement(subelement1);
		action1.click();
		action1.perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("basic"))).click();
		Actions basic1 = new Actions(driver);
		logger.debug("creating Basic newsletter email tamplate ");

		WebElement wbasic1 = driver.findElement(By.xpath(properties.getProperty("Basic_NewsLetter_temp")));
		basic1.moveToElement(wbasic1).build().perform();
		Thread.sleep(20000);

		driver.findElement(By.xpath(properties.getProperty("Basic_NewsLetter_tempClick"))).click();
		Thread.sleep(20000);

		driver.switchTo().defaultContent();
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='btn
		// btn-primary ng-binding ng-scope']")));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//*[@id=\'bee-plugin-container\']/iframe")));
		Thread.sleep(15000);
		driver.findElement(By.xpath("/html/body/bee-app/div/div/div/div[2]/div[1]/div/div[2]/button")).click();
		driver.switchTo().defaultContent();

		DatabaseQueries data1 = new DatabaseQueries();
		String query5i1 = properties.getProperty("query.getEmailTemplates");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames1 = data1.listNames(query5i1, "name");
		String campaignNameFromProp1 = properties.getProperty("BasicEcom_data").toLowerCase();
		Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name")))
				.sendKeys(properties.getProperty("BasicEcom_data"));
		Thread.sleep(5000);
		if (campaignNames1.indexOf(campaignNameFromProp1) > -1) {
			driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name"))).clear();
			driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name")))
					.sendKeys(properties.getProperty("BasicEcom_data") + "_" + System.currentTimeMillis());
			Thread.sleep(25000);
		}
		driver.findElement(By.xpath("//*[@id='save']")).click();
		driver.findElement(By.xpath("//*[@id='save']")).click();

		//driver.findElement(By.id("save")).click();

		//driver.findElement(By.xpath(properties.getProperty("BasicEcom_save"))).click();
		Thread.sleep(10000);
		logger.debug("saved Basic newsletter email tamplate ");

		driver.get("https://xamplify.io/home/emailtemplates/manage");

		WebElement element2 = driver.findElement(By.xpath(properties.getProperty("email_hover")));
		Thread.sleep(5000);
		Actions action2 = new Actions(driver);
		action2.moveToElement(element2).perform();
		WebElement subelement2 = driver.findElement(By.xpath(properties.getProperty("create_email_temp")));
		action2.moveToElement(subelement2);
		action2.click();
		action2.perform();
		Thread.sleep(5000);
		logger.debug("creating Basic promo email tamplate ");

		WebElement we_basic1 = driver.findElement(By.xpath(properties.getProperty("Basic_click")));

		we_basic1.click();
		Actions basic2 = new Actions(driver);
		WebElement wbasic2 = driver.findElement(By.xpath(properties.getProperty("Basic_Promo_Temp")));
		basic2.moveToElement(wbasic2).build().perform();
		Thread.sleep(20000);

		driver.findElement(By.xpath(properties.getProperty("Basic_Promo_Temp_click"))).click();
		Thread.sleep(20000);

		driver.switchTo().defaultContent();
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='btn
		// btn-primary ng-binding ng-scope']")));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//*[@id=\'bee-plugin-container\']/iframe")));
		Thread.sleep(15000);
		driver.findElement(By.xpath("/html/body/bee-app/div/div/div/div[2]/div[1]/div/div[2]/button")).click();
		driver.switchTo().defaultContent();

		DatabaseQueries data2 = new DatabaseQueries();
		String query5i2 = properties.getProperty("query.getEmailTemplates");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames2 = data2.listNames(query5i2, "name");
		String campaignNameFromProp2 = properties.getProperty("BasicEcom_data").toLowerCase();
		driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name")))
				.sendKeys(properties.getProperty("BasicEcom_data"));
		Thread.sleep(5000);
		if (campaignNames2.indexOf(campaignNameFromProp2) > -1) {
			driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name"))).clear();
			driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name")))
					.sendKeys(properties.getProperty("BasicEcom_data") + "_" + System.currentTimeMillis());
			Thread.sleep(25000);
		}
		driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name"))).submit();

		//driver.findElement(By.xpath(properties.getProperty("BasicEcom_save"))).click();
		logger.debug("saved Basic promo email tamplate ");

		Thread.sleep(10000);

		driver.get("https://xamplify.io/home/emailtemplates/manage");

		WebElement element3 = driver.findElement(By.xpath(properties.getProperty("email_hover")));
		Thread.sleep(5000);
		Actions action3 = new Actions(driver);
		action3.moveToElement(element3).perform();
		WebElement subelement3 = driver.findElement(By.xpath(properties.getProperty("create_email_temp")));
		action3.moveToElement(subelement3);
		action3.click();
		action3.perform();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("basic"))).click();
		Actions basic3 = new Actions(driver);
		WebElement wbasic3 = driver.findElement(By.xpath(properties.getProperty("Basic_simple")));
		basic3.moveToElement(wbasic3).build().perform();
		Thread.sleep(20000);
		logger.debug("creating Basic simple email tamplate ");
		Thread.sleep(20000);

		driver.findElement(By.xpath(properties.getProperty("Basic_simpleclick"))).click();
		Thread.sleep(20000);

		driver.switchTo().defaultContent();
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='btn
		// btn-primary ng-binding ng-scope']")));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//*[@id=\'bee-plugin-container\']/iframe")));
		Thread.sleep(15000);
		driver.findElement(By.xpath("/html/body/bee-app/div/div/div/div[2]/div[1]/div/div[2]/button")).click();
		driver.switchTo().defaultContent();

		DatabaseQueries data3 = new DatabaseQueries();
		String query5i3 = properties.getProperty("query.getEmailTemplates");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames3 = data3.listNames(query5i3, "name");
		String campaignNameFromProp3 = properties.getProperty("BasicEcom_data").toLowerCase();
		driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name")))
				.sendKeys(properties.getProperty("BasicEcom_data"));
		Thread.sleep(5000);
		if (campaignNames3.indexOf(campaignNameFromProp3) > -1) {
			driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name"))).clear();
			driver.findElement(By.xpath(properties.getProperty("BasicEcom_temp_name")))
					.sendKeys(properties.getProperty("BasicEcom_data") + "_" + System.currentTimeMillis());
			Thread.sleep(25000);
		}

		driver.findElement(By.xpath(properties.getProperty("BasicEcom_save"))).click();
		Thread.sleep(5000);
		
		logger.debug("saved Basic simple email tamplate ");
		
		driver.get("https://xamplify.io/home/emailtemplates/manage");

		WebElement element4 = driver.findElement(By.xpath(properties.getProperty("email_hover")));
		Thread.sleep(5000);
		Actions action4 = new Actions(driver);
		action4.moveToElement(element4).perform();
		WebElement subelement4 = driver.findElement(By.xpath(properties.getProperty("create_email_temp")));
		action4.moveToElement(subelement4);
		action4.click();
		action4.perform();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("default"))).click();
		Thread.sleep(5000);
		Actions default1 = new Actions(driver);
		WebElement def_ele = driver.findElement(By.xpath(properties.getProperty("default1_path")));
		action4.moveToElement(def_ele).build().perform();
		def_ele.click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("default1_preview"))).click();
		Thread.sleep(5000);
		logger.debug("Preview  defualt video  template 1");

		Actions default2 = new Actions(driver);
		WebElement def_ele2 = driver.findElement(By.xpath(properties.getProperty("default2_path")));
		action4.moveToElement(def_ele2).build().perform();
		def_ele2.click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("default2_preview"))).click();
		Thread.sleep(5000);
		logger.debug("Preview  defualt video  template 2");

		Actions default3 = new Actions(driver);
		WebElement def_ele3 = driver.findElement(By.xpath(properties.getProperty("default3_path")));
		action4.moveToElement(def_ele3).build().perform();
		def_ele3.click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("default3_preview"))).click();
		Thread.sleep(5000);
		logger.debug("Preview  defualt video  template 1");


		// UPload_CUSTOM//
		logger.debug("Creating upload video template");

		WebElement upld_cstm = driver.findElement(By.xpath(properties.getProperty("upload_custom")));
		upld_cstm.click();
		Thread.sleep(3000);
		Actions upld_tmp1 = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(properties.getProperty("upld_create_temp")));
		action4.moveToElement(we).build().perform();
		we.click();
		Thread.sleep(5000);

		DatabaseQueries data4 = new DatabaseQueries();
		String query5i4 = properties.getProperty("query.getEmailTemplates");// .replaceAll(":emailId",prop.getProperty("user.name"));
		List<String> campaignNames4 = data4.listNames(query5i4, "name");
		String campaignNameFromProp4 = properties.getProperty("upld_tmp_name_senddata").toLowerCase();

		driver.findElement(By.xpath(properties.getProperty("upld_tmp_name")))
				.sendKeys(properties.getProperty("upld_tmp_name_senddata"));
		Thread.sleep(5000);
		if (campaignNames4.indexOf(campaignNameFromProp4) > -1) {
			driver.findElement(By.xpath(properties.getProperty("upld_tmp_name"))).clear();
			driver.findElement(By.xpath(properties.getProperty("upld_tmp_name")))
					.sendKeys(properties.getProperty("upld_tmp_name_senddata") + "_" + System.currentTimeMillis());
			Thread.sleep(25000);
		}

		// driver.findElement(By.xpath(prop.getProperty("upld_tmp_name"))).sendKeys(prop.getProperty("upld_tmp_name_senddata"));
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("upld_custmfile_tmp"))).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("D:\\Selenium\\Files\\upld_cstm1.exe");
		Thread.sleep(6000);
		driver.findElement(By.xpath(properties.getProperty("upldcustm_save"))).click();
		Thread.sleep(5000);
		logger.debug("saved upload video template");
		logger.debug("creating upload regular template");

		WebElement upl_reg = driver.findElement(By.xpath(properties.getProperty("emailhover2")));
		Thread.sleep(5000);
		Actions action_reg = new Actions(driver);
		action_reg.moveToElement(upl_reg).perform();
		WebElement subele_reg = driver.findElement(By.xpath(properties.getProperty("create_email_temp2")));
		action_reg.moveToElement(subele_reg);
		action_reg.click();
		action_reg.perform();
		Thread.sleep(5000);

		WebElement upl_reg2 = driver.findElement(By.xpath(properties.getProperty("upld_custom2")));
		upl_reg2.click();
		Thread.sleep(5000);
		Actions upld_tmp2 = new Actions(driver);
		WebElement we_up = driver.findElement(By.xpath(properties.getProperty("regular_create_temp")));
		upld_tmp2.moveToElement(we_up).build().perform();
		we_up.click();
		Thread.sleep(5000);

		DatabaseQueries data5 = new DatabaseQueries();
		String query5i5 = properties.getProperty("query.getEmailTemplates");// .replaceAll(":emailId",prop.getProperty("user.name"));
		List<String> campaignNames5 = data5.listNames(query5i5, "name");
		String campaignNameFromProp5 = properties.getProperty("regular_temp_senddata").toLowerCase();

		driver.findElement(By.xpath(properties.getProperty("regular_temp_name")))
				.sendKeys(properties.getProperty("regular_temp_senddata"));
		Thread.sleep(5000);
		if (campaignNames5.indexOf(campaignNameFromProp5) > -1) {
			driver.findElement(By.xpath(properties.getProperty("regular_temp_name"))).clear();
			driver.findElement(By.xpath(properties.getProperty("regular_temp_name")))
					.sendKeys(properties.getProperty("regular_temp_senddata") + "_" + System.currentTimeMillis());
			Thread.sleep(25000);
		}

		// driver.findElement(By.xpath(prop.getProperty("regular_temp_name"))).sendKeys(prop.getProperty("regular_temp_senddata"));
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("regular_upld_file"))).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("D:\\Selenium\\upld_cstm1.exe");
		Thread.sleep(6000);
		driver.findElement(By.xpath(properties.getProperty("regular_temp_save"))).click();
		Thread.sleep(5000);
		logger.debug("saved upload regular template");

		// VideoTemplate//
		
		driver.get("https://xamplify.io/home/emailtemplates/manage");

		WebElement element5 = driver.findElement(By.xpath(properties.getProperty("email_hover")));
		Thread.sleep(8000);
		Actions action5 = new Actions(driver);
		action5.moveToElement(element5).perform();
		WebElement subelement5 = driver.findElement(By.xpath(properties.getProperty("create_email_temp")));
		action5.moveToElement(subelement5);
		action5.click();
		action5.perform();
		
		logger.debug("creating  video template");
		
		Thread.sleep(8000);
		WebElement we_basic5 = driver.findElement(By.linkText(properties.getProperty("Basic_video_click")));
		we_basic5.click();

		Thread.sleep(15000);

		Actions basic5 = new Actions(driver);
		WebElement wbasic5 = driver.findElement(By.xpath(properties.getProperty("Basic_Video")));
		action5.moveToElement(wbasic5).build().perform();
		wbasic5.click();
		Thread.sleep(20000);

		driver.switchTo().defaultContent();
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='btn
		// btn-primary ng-binding ng-scope']")));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//iframe[@src='https://app.getbee.io/v18.12.18.0923/index.html']")));
		Thread.sleep(15000);
		driver.findElement(By.xpath("/html/body/bee-app/div/div/div/div[2]/div[1]/div/div[2]/button")).click();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		DatabaseQueries data6 = new DatabaseQueries();
		String query5i6 = properties.getProperty("query.getEmailTemplates");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames6 = data6.listNames(query5i6, "name");
		String campaignNameFromProp6 = properties.getProperty("BasicVideo_data").toLowerCase();
		driver.findElement(By.xpath(properties.getProperty("BasicVideo_temp_name")))
				.sendKeys(properties.getProperty("BasicVideo_data"));
		Thread.sleep(5000);
		if (campaignNames6.indexOf(campaignNameFromProp6) > -1) {
			driver.findElement(By.xpath(properties.getProperty("BasicVideo_temp_name"))).clear();
			driver.findElement(By.xpath(properties.getProperty("BasicVideo_temp_name")))
					.sendKeys(properties.getProperty("BasicVideo_data") + "_" + System.currentTimeMillis());
			Thread.sleep(25000);
		}

		driver.findElement(By.xpath(properties.getProperty("BasicEcom_save"))).click();

		Thread.sleep(5000);
		logger.debug("saved  video template");

		// EMAILCO-BRANDING//
		driver.get("https://xamplify.io/home/emailtemplates/manage");

		WebElement element6 = driver.findElement(By.xpath(properties.getProperty("email_hover")));
		Thread.sleep(8000);
		Actions action6 = new Actions(driver);
		action6.moveToElement(element6).perform();
		WebElement subelement6 = driver.findElement(By.xpath(properties.getProperty("create_email_temp")));
		action6.moveToElement(subelement6);
		action6.click();
		action6.perform();
		Thread.sleep(8000);
		logger.debug("creating   Email-Co branding template");

		WebElement we_basic6 = driver.findElement(By.cssSelector(properties.getProperty("Email_CO_Click")));
		we_basic6.click();

		Thread.sleep(15000);

		Actions basic6 = new Actions(driver);
		WebElement wbasic6 = driver.findElement(By.xpath(properties.getProperty("Basic_Video")));
		action6.moveToElement(wbasic6).build().perform();
		wbasic6.click();
		Thread.sleep(50000);

		driver.switchTo().defaultContent();
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='btn
		// btn-primary ng-binding ng-scope']")));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//iframe[@src='https://app.getbee.io/v18.12.18.0923/index.html']")));
		Thread.sleep(15000);
		driver.findElement(By.xpath("/html/body/bee-app/div/div/div/div[2]/div[1]/div/div[2]/button")).click();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		DatabaseQueries data7 = new DatabaseQueries();
		String query5i7 = properties.getProperty("query.getEmailTemplates");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames7 = data7.listNames(query5i7, "name");
		String campaignNameFromProp7 = properties.getProperty("Email_Cobrand_data").toLowerCase();
		driver.findElement(By.xpath(properties.getProperty("BasicVideo_temp_name")))
				.sendKeys(properties.getProperty("Email_Cobrand_data"));
		Thread.sleep(5000);
		if (campaignNames7.indexOf(campaignNameFromProp7) > -1) {
			driver.findElement(By.xpath(properties.getProperty("BasicVideo_temp_name"))).clear();
			driver.findElement(By.xpath(properties.getProperty("BasicVideo_temp_name")))
					.sendKeys(properties.getProperty("Email_Cobrand_data") + "_" + System.currentTimeMillis());
			Thread.sleep(25000);
		}

		driver.findElement(By.xpath(properties.getProperty("BasicEcom_save"))).click();

		Thread.sleep(5000);
		logger.debug("saved   Email-Co branding template");

		// VIDEOCO-BRANDING//
		driver.get("https://xamplify.io/home/emailtemplates/manage");

		WebElement element7 = driver.findElement(By.xpath(properties.getProperty("email_hover")));
		Thread.sleep(8000);
		Actions action7 = new Actions(driver);
		action7.moveToElement(element7).perform();
		WebElement subelement7 = driver.findElement(By.xpath(properties.getProperty("create_email_temp")));
		action7.moveToElement(subelement7);
		action7.click();
		action7.perform();
		Thread.sleep(8000);
		logger.debug("creating   Video-Co branding template");

		WebElement we_basic7 = driver.findElement(By.cssSelector(properties.getProperty("Video_CO_Click")));
		we_basic7.click();

		Thread.sleep(15000);

		Actions basic7 = new Actions(driver);
		WebElement wbasic7 = driver.findElement(By.xpath(properties.getProperty("Basic_Video")));
		action7.moveToElement(wbasic7).build().perform();
		wbasic7.click();
		Thread.sleep(50000);

		driver.switchTo().defaultContent();
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='btn
		// btn-primary ng-binding ng-scope']")));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//iframe[@src='https://app.getbee.io/v18.12.18.0923/index.html']")));
		Thread.sleep(15000);
		driver.findElement(By.xpath("/html/body/bee-app/div/div/div/div[2]/div[1]/div/div[2]/button")).click();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		DatabaseQueries data8 = new DatabaseQueries();
		String query5i8 = properties.getProperty("query.getEmailTemplates");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames8 = data8.listNames(query5i8, "name");
		String campaignNameFromProp8 = properties.getProperty("Video_Cobrand_data").toLowerCase();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("BasicVideo_temp_name"))).sendKeys(properties.getProperty("Video_Cobrand_data"));
		Thread.sleep(5000);
		if (campaignNames8.indexOf(campaignNameFromProp8) > -1) {
			driver.findElement(By.xpath(properties.getProperty("BasicVideo_temp_name"))).clear();
			driver.findElement(By.xpath(properties.getProperty("BasicVideo_temp_name")))
					.sendKeys(properties.getProperty("Video_Cobrand_data") + "_" + System.currentTimeMillis());
			Thread.sleep(25000);
		}

		driver.findElement(By.xpath(properties.getProperty("BasicEcom_save"))).click();

		Thread.sleep(8000);
		logger.debug("saved   Video-Co branding template");

		//driver.findElement(By.xpath(properties.getProperty("LogoClick"))).click();
	}

}
