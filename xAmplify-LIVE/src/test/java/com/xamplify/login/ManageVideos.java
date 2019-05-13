package com.xamplify.login;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManageVideos {
	
	Properties properties = PropertiesFile.readPropertyFile("datafile.properties");
	WebDriver driver = Instance.getInstance();
 
@BeforeMethod
	public void Managevideo_MouseHover() throws InterruptedException 
	{

		WebElement ele7=driver.findElement(By.xpath("//a[@href='javascript:;']//i[@class='fa fa-cloud-upload']"));//hover_uploadcontent
		Actions act6=new Actions(driver);
		act6.moveToElement(ele7).perform();
Thread.sleep(4000);		
		driver.findElement(By.xpath("//span[contains(text(),'Manage Videos')]")).click();
	}

@Test(priority=20,enabled=false)
	public void Video_delete() throws IOException, InterruptedException 
	{
Thread.sleep(15000);	
		
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-video[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/section[1]/div[1]/table[1]/tbody[1]/tr[10]/td[4]/div[1]/a[4]/i[1]")).click();
Thread.sleep(9000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/button[1]")).click();
Thread.sleep(9000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
Thread.sleep(8000);
	}

@Test(priority=21)
	public void search_Analystics_edit() throws IOException, InterruptedException 
	{

Thread.sleep(8000);
		WebElement Video_search = driver.findElement(By.xpath("//input[@placeholder='Search for a Video']")); 
		Video_search.sendKeys("Himalayas");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
Thread.sleep(8000);		
		driver.get("https://xamplify.io/home/videos/manage");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/app-manage-video/div/div[2]/div/div[2]/div/div/div[1]/div[2]/section[1]/div/table/tbody/tr[3]/td[4]/div/a[3]/i")).click();
Thread.sleep(20000);
		driver.findElement(By.xpath("//a[contains(text(),'Manage Videos')]")).click();
Thread.sleep(20000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-video[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/section[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]/div[1]/a[1]/i[1]")).click();

Thread.sleep(10000);
	
	Select dropdown = new Select(driver.findElement(By.xpath("//select[@title='select a category']")));
	dropdown.selectByVisibleText("Photography");
	
	WebElement Video_Tag = driver.findElement(By.xpath("//input[@placeholder='Add a tag & press Enter']")); 
	Video_Tag.sendKeys("Mountains Paraglading");
	Video_Tag.sendKeys(Keys.ENTER);
	
	WebElement Edit_radio=driver.findElement(By.xpath("//input[@value='2']"));
	Edit_radio.click();
	
	driver.findElement(By.xpath("//input[@id='ownFileuplad']")).click();
Thread.sleep(8000);
	Runtime.getRuntime().exec("D:\\Selenium\\Files\\thumbnail_video.exe"); 
Thread.sleep(5000);
	driver.findElement(By.xpath("//div[@class='portlet box blue']//div[@class='col-xs-12 caption p01']")).click();
Thread.sleep(8000);
	driver.findElement(By.xpath("//div[@class='bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-animate bootstrap-switch-off bootstrap-switch-small']//span[@class='bootstrap-switch-label']")).click();

	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-video[1]/div[1]/app-edit-video[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[9]/div[1]/switch[1]/div[1]/div[1]/span[2]")).click();
Thread.sleep(5000);
	driver.findElement(By.xpath("//h4[contains(text(),'Call to Action')]")).click();
Thread.sleep(4000);
	driver.findElement(By.xpath("//span[@class='bootstrap-switch-handle-on bootstrap-switch-success']")).click();
Thread.sleep(5000);	
	driver.findElement(By.xpath("//img[@id='myBtn']")).click();
Thread.sleep(8000);	
	driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();	
}

@Test(priority=22)
public void Sortby_view() throws IOException, InterruptedException
	{
Thread.sleep(8000);

//	Select dropdown_sort1 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-video[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/select[1]")));
//	dropdown_sort1.selectByVisibleText("Title (A-Z)");
//
//	Select dropdown_sort2 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-video[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/select[1]")));
//	dropdown_sort2.selectByVisibleText("Title (Z-A)");
//
//	Select dropdown_sort3 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-video[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/select[1]")));
//	dropdown_sort3.selectByVisibleText("Upload Date (ASC)");

	Select dropdown_sort4 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-video[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/select[1]")));
	dropdown_sort4.selectByVisibleText("Upload Date (DESC)");

Thread.sleep(10000);

	Select dropdown_cat = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-video[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
	dropdown_cat.selectByVisibleText("Accounting");	

Thread.sleep(8000);
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-video[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/span[2]/i[1]")).click();
Thread.sleep(8000);	
	driver.findElement(By.xpath("//i[@class='fa fa-th-list p10']")).click();
Thread.sleep(11000);
		WebElement Video_search1 = driver.findElement(By.xpath("//input[@placeholder='Search for a Video']"));
		Video_search1.sendKeys("Phone");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
Thread.sleep(8000);
	driver.findElement(By.xpath("//tbody//tr[1]//td[4]//div[1]//a[2]//i[1]")).click();
Thread.sleep(5000);		
	driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
Thread.sleep(5000);
	}
}
