package com.xamplify.LIVE;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Logoutin {
	
	WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile.readPropertyFile("ldata.properties");
	private String y;
	
	@Test
	public void logoutvendor_loginpartner() throws InterruptedException 
	
	{
		Thread.sleep(7000);
		driver.findElement(By.xpath(properties.getProperty("clickmyprofile"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("clicklogout"))).click();
		
		WebDriverWait wait=new WebDriverWait(driver,60);

		WebElement findLoginwithtext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu-item-4236\"]/a")));
		System.out.println("findLoginwithtext" + findLoginwithtext.getAttribute("value"));
		
		driver.findElement(By.id(properties.getProperty("email"))).sendKeys(properties.getProperty("partnerusername"));
		driver.findElement(By.id(properties.getProperty("password"))).sendKeys(properties.getProperty("partnerpassword"));
			   Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@id='submitBitton']")).click();
}
	
	@Test
	public void redistribute_campaign() throws InterruptedException 
	
	{
		
		Thread.sleep(10000);
		y = Emailcampaign.getcurrentecampaignname();//Retrieve the name
        
        System.out.print("Your name is: " +y);//Display the name

		WebElement getstring = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-partner-campaigns[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"));
		getstring.sendKeys(y);// search box entering the campaign name which is already created in vendor account
		
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

		/*WebElement RegisterLeadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Status')]")));
		System.out.println("RegisterLeadButton" + RegisterLeadButton.getAttribute("value"));*/

		
	}
}

