package com.xamplify.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class xamplifycontacts {
	

	 Properties properties = PropertiesFile.readPropertyFile("datafile.properties");
	 WebDriver driver = Instance.getInstance();


	@Test(priority=11,enabled=true)
	public void copycontacts() throws InterruptedException, SQLException 
	{
		driver.get("https://release.xamplify.io/home/dashboard/welcome");

	Actions actions = new Actions(driver);
	WebElement contacts = driver.findElement(By.xpath(properties.getProperty("hovercontacts")));
	actions.moveToElement(contacts).build().perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath(properties.getProperty("onboardingpartners"))).click();
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-add-contacts[1]/div[1]/div[5]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]")).click();
	Select delimiter1 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-add-contacts[1]/div[1]/div[5]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/select[1]")));
	delimiter1.selectByValue("CommaSeperated");
	WebElement textarea1 = driver.findElement(By.xpath("//textarea[@id='copyFromclipTextArea']"));
	textarea1.click();
	textarea1.sendKeys("Teja,d,stratapps,Testing,tiwis@idx4.com,above BOI,hyderabad,Telangana,500081,india,90752748746");
	driver.findElement(By.xpath("//button[contains(text(),'SHOW PREVIEW')]")).click();
	
	
	
	

	
	DatabaseQueries data = new DatabaseQueries();
	String query8 = properties.getProperty("query.getcontactlistnames");//.replaceAll(":emailId",properties.getProperty("user.name"));
	List<String> campaignNames = data.listNames(query8, "user_list_name");
	String campaignNameFromProp = properties.getProperty("contactcopyfromclipboardlistnam").toLowerCase();

	driver.findElement(By.xpath(properties.getProperty("contactcopyfromclipboardlistnamexpath"))).sendKeys(properties.getProperty("contactcopyfromclipboardlistnam"));	
	Thread.sleep(5000);
	if(campaignNames.indexOf(campaignNameFromProp)>-1) {
	driver.findElement(By.xpath(properties.getProperty("contactcopyfromclipboardlistnamexpath"))).clear();
	driver.findElement(By.xpath(properties.getProperty("contactcopyfromclipboardlistnamexpath"))).sendKeys(System.currentTimeMillis()+"_");
	driver.findElement(By.xpath(properties.getProperty("contactcopyfromclipboardlistnamexpath"))).sendKeys(properties.getProperty("contactcopyfromclipboardlistnam"));
	Thread.sleep(3000);
	}			
	
	
	
	
	
	driver.findElement(By.xpath("//*[@id=\"sample_editable_1_new\"]")).click();
	

	}
	
	@Test(priority=12,enabled=true)
	public void uploadcsvcontacts() throws InterruptedException, IOException 
	{	driver.get("https://release.xamplify.io/home/dashboard/welcome");

		Actions actions = new Actions(driver);
		WebElement contacts = driver.findElement(By.xpath(properties.getProperty("hovercontactsupload")));
		actions.moveToElement(contacts).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("onboardingpartners"))).click();
		
		//driver.findElement(By.xpath("//div[@class='hidden-xs']//button[@type='button']")).click();
		driver.findElement(By.id("uploadCSV")).click();
	    Thread.sleep(8000);

	    Runtime.getRuntime().exec("D:\\Selenium\\Files\\uploadcsvcontacts.exe");
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-add-contacts[1]/div[1]/div[4]/ul[1]/li[1]/a[1]")).click();
	    Thread.sleep(8000);
	    WebElement Upd=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/input[1]"));
	    Upd.sendKeys("Uplaodcsv123");
	    
	    driver.findElement(By.xpath("/html/body/div/div[2]/button[1]")).click();
	    Thread.sleep(5000);

		
	}
	
	@Test(priority=13,enabled=true)
	public void managecontacts() throws InterruptedException
	{
		driver.get("https://release.xamplify.io/home/dashboard/welcome");

		Actions actions = new Actions(driver);
		WebElement contacts = driver.findElement(By.xpath(properties.getProperty("hovercontacts")));
		actions.moveToElement(contacts).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/app-leftsidebar[1]/div[1]/div[1]/ul[1]/li[4]/ul[1]/li[2]/a[1]/span[1]")).click();
		Thread.sleep(5000);
		   driver.findElement(By.xpath("//tbody//tr[1]//td[5]//div[1]//a[1]//i[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/app-add-contact-modal[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]")).sendKeys("1");
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/app-add-contact-modal[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[8]/div[1]/int-phone-prefix[1]/div[1]/input[1]")).sendKeys("1");
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/app-add-contact-modal[1]/div[1]/div[1]/div[1]/div[3]/button[2]")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();// delete
		driver.findElement(By.xpath("/html/body/div/div[2]/button[1]")).click();
		//WebElement copycontact = driver.findElement(By.xpath("//tbody//tr[2]//td[5]//div[1]//a[2]//i[1]"));//copy
		//System.out.println(copycontact);
		// /html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-contacts[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/a[2]/i[1]
															
		//copycontact.click();
	}								
	

}
