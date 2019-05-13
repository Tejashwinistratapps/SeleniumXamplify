package com.xamplify.login;


import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class PartnerLogin {

		Properties properties = PropertiesFile.readPropertyFile("datafile.properties");
		public static ChromeDriver driver;
	@Test(priority=42)
		public void partner_login() throws InterruptedException
		{
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/chromedriver2.exe");
		Thread.sleep(3000);
		 driver = new ChromeDriver();
		Thread.sleep(3000);

		driver.manage().window().maximize();
		driver.get("https://release.xamplify.io/");
		driver.findElement(By.xpath("//*[@id=\"bs-navbar-collapse-1\"]/ul[2]/li[1]/a")).click();
		
	Thread.sleep(5000);

		WebElement usernameElement = driver.findElement(By.name("username")); 
		WebElement passwordElement = driver.findElement(By.name("password"));

		   usernameElement.sendKeys("gayatrialla11@gmail.com"); 
		   passwordElement.sendKeys("Xamplify@11");
		   Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='submitBitton']")).click();
		}
	
	@Test(priority=43)
	public void hoverRedistributecampaigns() throws InterruptedException
	{
		   Thread.sleep(5000);

		driver.get("https://release.xamplify.io/home/dashboard/welcome");
		Thread.sleep(10000);	
		WebElement ele=driver.findElement(By.xpath("//body[@class='login page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid page-sidebar-closed-hide-logo']/app-root[@ng-version='4.3.6']/app-home/div[@class='page-container']/app-leftsidebar/div[@class='page-sidebar-wrapper']/div[@class='page-sidebar navbar-collapse collapse']/ul[@class='page-sidebar-menu page-sidebar-menu-hover-submenu']/li[3]/a[1]")); 	
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		//driver.findElement(By.xpath("//span[contains(text(),'Manage Campaigns')]")).click();
		driver.findElement(By.xpath("//a[@href='/home/campaigns/partner/all']")).click();
		
		
		
		
		
	}

	
	@Test(priority=44)
		public void Redistribute() throws InterruptedException
		{
	Thread.sleep(5000);
		driver.findElement(By.xpath("//tbody//tr[1]//td[5]//div[1]//a[2]//i[1]")).click();
	Thread.sleep(5000);	
		driver.findElement(By.xpath("//a[@class='pull-right btn btn-primary btn-sm']")).click();
	Thread.sleep(5000);
		WebElement Sub=driver.findElement(By.xpath("//input[@id='subjectLine']"));
	Thread.sleep(3000);	
		Sub.clear();
		Sub.sendKeys("Vendor Campaign Redistribute");
	Thread.sleep(3000);
		WebElement Pre=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-edit-partner-campaigns[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/fieldset[1]/form[1]/div[5]/input[1]"));
	Thread.sleep(3000);
		Pre.clear();
		Pre.sendKeys("Automated");
	Thread.sleep(3000);	
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-edit-partner-campaigns[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/fieldset[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/switch[1]/div[1]/div[1]/span[2]")).click();
	Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-edit-partner-campaigns[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/fieldset[1]/form[1]/div[7]/div[1]/div[1]/div[1]/div[1]/switch[1]/div[1]/div[1]/span[2]")).click();
		driver.findElement(By.xpath("//div[@class='col-xs-5']//button[1]")).click();
	Thread.sleep(3000);	
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-edit-partner-campaigns[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/fieldset[2]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/input[1]")).click();
		}

	@Test(priority=45,enabled=false)
		public void Auto_Email() throws InterruptedException, SQLException
		{
	Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-edit-partner-campaigns[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/div[1]/div[1]/div[3]/div[2]/a[1]")).click();
	Thread.sleep(4000);
		Select dropdown_sort = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-edit-partner-campaigns[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/div[1]/div[1]/div[3]/div[3]/fieldset[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/select[1]")));
		dropdown_sort.selectByVisibleText("Email is not opened");
	Thread.sleep(5000);
		WebElement Sub1=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-edit-partner-campaigns[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/div[1]/div[1]/div[3]/div[3]/fieldset[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/input[1]"));
	Thread.sleep(3000);
		Sub1.clear();
		Sub1.sendKeys("Auto Response Email");
	Thread.sleep(4000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello Test!");

		driver.switchTo().defaultContent();
	Thread.sleep(3000);	
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-edit-partner-campaigns[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/fieldset[1]/div[2]/div[1]/button[2]")).click();
		
		
		DatabaseQueries data = new DatabaseQueries();
		String query10 = properties.getProperty("query.getCampaignNamesByOrganizationId").replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames = data.listNames(query10, "campaign_name");
		String campaignNameFromProp = properties.getProperty("write_campaign").toLowerCase();
		
		//driver.findElement(By.name(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("write_campaign"));	
		
		Thread.sleep(5000);
		if(campaignNames.indexOf(campaignNameFromProp)>-1) {
		//driver.findElement(By.id(properties.getProperty("ecampaignName"))).clear();
		driver.findElement(By.id(properties.getProperty("ecampaignName"))).sendKeys(properties.getProperty("write_campaign")+"_"+System.currentTimeMillis());
		Thread.sleep(25000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-edit-partner-campaigns[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/fieldset[1]/div[2]/div[1]/button[2]")).click();

		}
		}
	@Test(priority=46)
	public void hoverManagecampaigns() throws InterruptedException
	{
Thread.sleep(10000);	
	WebElement ele=driver.findElement(By.xpath("//body[@class='login page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid page-sidebar-closed-hide-logo']/app-root[@ng-version='4.3.6']/app-home/div[@class='page-container']/app-leftsidebar/div[@class='page-sidebar-wrapper']/div[@class='page-sidebar navbar-collapse collapse']/ul[@class='page-sidebar-menu page-sidebar-menu-hover-submenu']/li[3]/a[1]")); 	
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	driver.findElement(By.xpath("//span[contains(text(),'Manage Campaigns')]")).click();
	//driver.findElement(By.xpath("//a[@href='/home/campaigns/partner/all']")).click();
	Thread.sleep(8000);
	
	driver.findElement(By.xpath("//li[contains(text(),'Email')]")).click();
								
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-publish[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/div[1]/span[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-publish[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/app-edit-partner-campaigns/div[1]/div/div[2]/div[2]/form/div[4]/fieldset/div[1]/div[1]/label[3]")).click();
	driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/app-edit-partner-campaigns/div[1]/div/div[2]/div[2]/form/div[4]/fieldset/div[2]/div/button[2]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/app-manage-publish/div[1]/div[3]/div/div/div/div[1]/div/div/span[2]/i")).click();
	Thread.sleep(5000);
	WebElement ele1=driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/app-manage-publish/div[1]/div[3]/div/div/div/div[2]/div/div/div[1]/div/div[3]")); 	
	Actions act1=new Actions(driver);
	act.moveToElement(ele1).perform();
	Thread.sleep(5000);

	driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/app-manage-publish/div[1]/div[3]/div/div/div/div[2]/div/div/div[1]/div/div[3]/a[2]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/app-preview-campaign/div[1]/div/div[2]/div[1]/a")).click();
	Thread.sleep(5000);
	WebElement hello1 = driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/app-manage-publish/div[1]/div[3]/div/div/div/div[1]/div/div/div/div[1]/select"));
	Select oSelect = new Select(hello1);
	oSelect.selectByVisibleText("Name (A-Z)");
	Thread.sleep(5000);
	oSelect.selectByVisibleText("Created Date (ASC)");

	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/app-manage-publish/div[1]/div[3]/div/div/div/div[1]/div/div/div/div[2]/div/input")).sendKeys("Redistribute");
	driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/app-manage-publish/div[1]/div[3]/div/div/div/div[1]/div/div/div/div[2]/div/button[2]")).click();
	Thread.sleep(8000);
	driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/app-manage-publish/div[1]/div[3]/div/div/div/div[1]/div/div/div/div[2]/div/button[1]")).click();
	Thread.sleep(8000);
	driver.findElement(By.xpath("//*[@id=\"headerdropDownLi\"]/a")).click();
	Thread.sleep(8000);
	driver.findElement(By.xpath("//*[@id=\"logoutButton\"]/a")).click();
	}


	
	
	}
