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
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Emailcampaign {
    private static String y = "";


	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile.readPropertyFile("rdata.properties");

	//@BeforeMethod   [for auto responses...comment @test annotation ,use @Beforemethod  ]
	@Test
	public void ecampaign() throws InterruptedException, SQLException {
		driver.get("https://release.xamplify.io/home/dashboard/welcome");

		Thread.sleep(5000);
		Properties properties = PropertiesFile.readPropertyFile("rdata.properties");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// Wait till the element is not visible

		WebElement campele = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("e_campaignhover"))));
		campele.click(); // hover on campaign

		Actions camp_action = new Actions(driver);
		camp_action.moveToElement(campele).perform();
		Thread.sleep(5000);
		WebElement create_campele = driver.findElement(By.xpath(properties.getProperty("e_createcampaign"))); //click on create campaign
		camp_action.moveToElement(create_campele);
		camp_action.click();
		camp_action.perform();
		Thread.sleep(5000);
		WebDriverWait waitc = new WebDriverWait(driver, 40);
		WebElement opncamp = waitc.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("e_openecampaign")))); //select email campaign
		opncamp.click();

		List<String> campaignNames = new ArrayList<String>();
		String query = properties.getProperty("query.getCampaignNamesByOrganizationId").replaceAll(":emailId",
				properties.getProperty("user.name"));
		ResultSet resultSet = DatabaseConnection.getResultSet(query);
		while (resultSet.next()) {
			campaignNames.add(resultSet.getString("campaign_name").toLowerCase());			//query,if campaign name already exists checking 
		}
		String campaignNameFromProp = properties.getProperty("ewrite_campaign").toLowerCase();

		driver.findElement(By.id(properties.getProperty("ecampaignName")))
				.sendKeys(properties.getProperty("ewrite_campaign"));
		Thread.sleep(5000);
		if (campaignNames.indexOf(campaignNameFromProp) > -1) {
			driver.findElement(By.id(properties.getProperty("ecampaignName"))).clear();
			driver.findElement(By.id(properties.getProperty("ecampaignName")))
					.sendKeys(properties.getProperty("ewrite_campaign") + "_" + System.currentTimeMillis());
		}
		WebElement ecampaignName = 	driver.findElement(By.id(properties.getProperty("ecampaignName")));

		System.out.println(ecampaignName.getAttribute("value"));

		String getcampaignname = ecampaignName.getAttribute("value");

        y = getcampaignname;

		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		WebElement w2 = wait2.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("e_through_partner"))));  //toggle through partner
		w2.click();
		// through partner//
		driver.findElement(By.xpath(properties.getProperty("esubjectline"))).sendKeys("subject :-)...");    //subjectline 

		driver.findElement(By.name(properties.getProperty("epreheader"))).sendKeys("preHeader:-)");			//preheader
		Thread.sleep(3000); // through partner//

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		WebDriverWait wait3 = new WebDriverWait(driver, 50);
		WebElement w3 = wait3
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("enotify"))));		//notify me
		w3.click();

		WebDriverWait wait4 = new WebDriverWait(driver, 50);
		WebElement w4 = wait4.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("emarketo_notify"))));	//marketo notify
		w4.click();
		Thread.sleep(5000);

		WebDriverWait wait5 = new WebDriverWait(driver, 50);
		WebElement w5 = wait5
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(properties.getProperty("enext1"))));			//next page
		w5.click();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("e_prtnrlst_srch"))).sendKeys("gayatri test mails");			//Search for partner list
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("esrch_slct_prtnrlst_clck"))).click();					//Click on search
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("eslct_prtnrlst"))).click();							//select the partner list
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("epartnerlist_preview"))).click();				//preview of selected partner list
		Thread.sleep(5000);

		/*
		 * WebElement
		 * c1=driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation"
		 * )));
		 * 
		 * for(int a=0;a<=6;a++) {
		 * driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation")))
		 * .click(); Thread.sleep(3000); }
		 */

		/*
		 * WebElement eg =
		 * driver.findElement(By.xpath(properties.getProperty("eplist")));
		 * List<WebElement> links = eg.findElements(By.tagName("li")); for (int i = 0; i
		 * <= links.size()+2; i++) { System.out.println(i); //
		 * System.out.println(links.size()); //
		 * System.out.println(links.get(i).getText());
		 * 
		 * 
		 * WebElement
		 * c1=driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation"
		 * ))); c1.click(); Thread.sleep(2000); System.out.println(i +"clicked");
		 * 
		 * 
		 * }
		 * 
		 * 
		 * Thread.sleep(5000);
		 */
		driver.findElement(By.xpath(properties.getProperty("eclose_partnerpreview"))).click();			//close the selected partner preview list
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("enext2"))).click();							//next page
		Thread.sleep(5000);

		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollTo(0,document.body.scrollHeight)");						//to scroll down the page

		/*
		 * WebElement eg1 =
		 * driver.findElement(By.xpath(properties.getProperty("eplist2")));
		 * List<WebElement> links1 = eg1.findElements(By.tagName("li")); for (int j = 1;
		 * j <= links1.size()-2; j++) { System.out.println(j);
		 * System.out.println(links1.size());
		 * System.out.println(links1.get(j).getText());
		 * 
		 * 
		 * WebElement
		 * c2=driver.findElement(By.xpath(properties.getProperty("epagenation")));
		 * Thread.sleep(10000); c2.click(); Thread.sleep(9000); System.out.println(j
		 * +"clicked");
		 * 
		 * 
		 * }
		 */

		WebDriverWait wait6 = new WebDriverWait(driver, 50);
		WebElement w6 = wait6
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("egoto_top"))));		//go to top navigation
		w6.click();

		/*
		 * driver.findElement(By.xpath(properties.getProperty("ebasic_tmplt"))).click();
		 * Thread.sleep(8000);
		 * 
		 * driver.findElement(By.xpath(properties.getProperty("eupld_tmplt"))).click();
		 * Thread.sleep(8000);
		 * 
		 * driver.findElement(By.xpath(properties.getProperty("erglr_tmplt"))).click();
		 * Thread.sleep(8000);
		 * driver.findElement(By.xpath(properties.getProperty("eall_tmplt"))).click();
		 * Thread.sleep(8000);
		 * driver.findElement(By.xpath(properties.getProperty("esrch_tmplt"))).sendKeys(
		 * "basicEcomTemp"); Thread.sleep(5000);
		 */

		driver.findElement(By.xpath(properties.getProperty("esearch_template"))).sendKeys("emailcon-merge");						//search for template
		Thread.sleep(5000);
		
		
		WebDriverWait wait7 = new WebDriverWait(driver, 50);
		WebElement w7 = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("esearch_template_clck"))));			//click on search
		w7.click();
		
		WebDriverWait wait8 = new WebDriverWait(driver, 50);
		WebElement w8 = wait8
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("esearch_template_select"))));			//select  template
		w8.click();
		
		
		

		
		driver.findElement(By.xpath(properties.getProperty("etemplate_preview"))).click();
		Thread.sleep(5000);
		
		
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"show_email_template_preivew\"]/div/div/div[2]"));
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("etemplate_preview_close"))).click();
		Thread.sleep(5000);
		

		driver.findElement(By.xpath(properties.getProperty("enext3"))).click();							//next page
		Thread.sleep(5000);

	}
	public static String getcurrentecampaignname()
	{
		return y;
	}
	
}
