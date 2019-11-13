package com.xamplify.LIVE;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PartnerRedistribute {
	WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile.readPropertyFile("rdata.properties");
	private String campaignName;
	
	@Test(priority = 401, enabled=true)
	public void loginpartner() throws InterruptedException 
	
	{
		
		/*WebDriverWait wait=new WebDriverWait(driver,30);

		WebElement WelcomeXamplify = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Welcome to xAmplify')]")));
		System.out.println(WelcomeXamplify);*/
		
	Thread.sleep(7000);
	driver.findElement(By.xpath(properties.getProperty("clickmyprofile"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(properties.getProperty("clicklogout"))).click();
	
	/*
	System.setProperty("webdriver.chrome.driver", "D:/Selenium/chromedriver2.exe");
	Thread.sleep(3000);
	Thread.sleep(3000);

	driver.manage().window().maximize();
	driver.get("https://release.xamplify.io/");
	//driver.findElement(By.xpath("//*[@id=\"bs-navbar-collapse-1\"]/ul[2]/li[1]/a")).click();
		
	*/
	
	
	
	

	WebDriverWait wait=new WebDriverWait(driver,50);

	WebElement findLoginwithtext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Or login with')]")));
	System.out.println("findLoginwithtext" + findLoginwithtext.getAttribute("value"));
	
	driver.findElement(By.id(properties.getProperty("email"))).sendKeys(properties.getProperty("partnerusername"));
	driver.findElement(By.id(properties.getProperty("password"))).sendKeys(properties.getProperty("partnerpassword"));
		   Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='submitBitton']")).click();


	
	
	}
	
	@Test(priority=402,enabled=true)
	public void hoverRedistributecampaigns() throws InterruptedException
	{
		   Thread.sleep(5000);

		//driver.get("https://release.xamplify.io/home/dashboard/welcome");
		Thread.sleep(10000);	
		WebElement ele=driver.findElement(By.linkText("Campaign")); 	
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//span[contains(text(),'Redistribute Campaign')]")).click();

		//driver.findElement(By.xpath("//span[contains(text(),'Manage Campaigns')]")).click();
		
		
		WebDriverWait wait=new WebDriverWait(driver,30);

		WebElement RedistributePage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Vendor Company Name')]")));
		System.out.println("RedistributePage" + RedistributePage.getAttribute("value"));
		
		
		
		
		
		
		
	}
	
	@Test(priority = 403 , enabled=true)
	public void redistribute_campaign() throws InterruptedException 
	
	{
		
		Thread.sleep(10000);
		campaignName = VideoCampaign.getcurrentcampaignname();//Retrieve the name
        
        System.out.print("Your name is: " +campaignName);//Display the name

		WebElement getstring = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-partner-campaigns[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"));
		getstring.sendKeys(campaignName);// search box entering the campaign name which is already created in vendor account
		
		driver.findElement(By.xpath("//button[@class='search-box-item-click']")).click();	// click search icon	
		Thread.sleep(10000);
		driver.findElement(By.xpath("//i[@class='fa fa-eye mr5']")).click(); // click preview of the searched campaign before redistributing
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='email_template_preivew']//button[@class='close-circle']")).click();// closing the preview of the campaign window
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='fa fa-clone']")).click(); // click Redistribute icon
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='pull-right btn btn-primary btn-sm']")).click(); // click select button to view the contacts list
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[4]")).click();  // click preview of the contacts icon
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//button[@class='close-circle']")).click(); // close preview of the contacts window
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='form-group']//input[@id='3744']")).click();// select the contacts list with check box
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='btn-group btn-group-justified']//label[1]")).click();// click "Now" 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Launch')]")).click(); // click "Launch"
		WebDriverWait wait=new WebDriverWait(driver,30);

		WebElement RegisterLeadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Status')]")));
		System.out.println("RegisterLeadButton" + RegisterLeadButton.getAttribute("value"));

		
	}
		
}
