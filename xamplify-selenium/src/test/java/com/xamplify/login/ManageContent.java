package com.xamplify.login;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ManageContent 
{
	Properties properties = PropertiesFile.readPropertyFile("datafile.properties");
	WebDriver driver = Instance.getInstance();

@Test(priority=23)
	public void ManageContent_MouseHover() throws InterruptedException 
		{
		WebElement ele8=driver.findElement(By.xpath("//a[@href='javascript:;']//i[@class='fa fa-cloud-upload']"));//hover_uploadcontent
		Actions act7=new Actions(driver);
		act7.moveToElement(ele8).perform();
		driver.findElement(By.xpath("//span[contains(text(),'Manage Content')]")).click();
Thread.sleep(5000);
		}

@Test(priority=24)
	public void DeleteContent() throws InterruptedException
	{
Thread.sleep(5000);
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-content-management[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/div[1]/a[2]/i[1]")).click();
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/button[1]")).click();
Thread.sleep(5000);	
	driver.findElement(By.xpath("//div[@class='alert alert-dismissible m0 alert-success']//button[@type='button']")).click();
Thread.sleep(5000);	
	}

@Test(priority=25)
	public void SortBy_Content() throws InterruptedException
	{
Thread.sleep(8000);
	
//	Select dropdown_Content1 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-content-management[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/select[1]")));
//	dropdown_Content1.selectByVisibleText("File Name (A-Z)");
	
//	Select dropdown_Content2 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-content-management[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/select[1]")));
//	dropdown_Content2.selectByVisibleText("File Name (Z-A)");
	
//	Select dropdown_Content3 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-content-management[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/select[1]")));
//	dropdown_Content3.selectByVisibleText("Upload Date (ASC)");

	Select dropdown_Content4 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-content-management[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/select[1]")));
	dropdown_Content4.selectByVisibleText("Upload Date (DESC)");
	
Thread.sleep(10000);

	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-content-management[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[2]/i[1]")).click();

Thread.sleep(13000);
	}

@Test(priority=26)
public void Searchcontent_Preview() throws InterruptedException
{
Thread.sleep(13000);
	WebElement Content_search = driver.findElement(By.xpath("//input[@placeholder='Search for a file']")); 
	Content_search.sendKeys("orders_fact_3.csv");
	driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
	
Thread.sleep(5000);
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-content-management[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/section[2]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[4]/span[1]/a[1]/i[1]")).click();
	}
}
