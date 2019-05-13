package com.xamplify.login;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Registrationvendor {
	
	

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile.readPropertyFile("datafile.properties");

	
	@Test(enabled=true,priority=1)
	public void start() throws InterruptedException {
		
	 
	driver.get(properties.getProperty("baseUrl"));
	
	driver.manage().window().maximize();
	}
	
	@Test(enabled=true,priority=2)
	public void registration_vendor() throws InterruptedException, SQLException {
		
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-intro[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/ul[2]/li[2]/a[1]")).click();
	
	driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("gayatri");

	driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("lucky");

	
	
	driver.findElement(By.xpath(properties.getProperty("reg_email"))).sendKeys(properties.getProperty("user.name"));	

	
	
	//driver.findElement(By.xpath(properties.getProperty("reg_email"))).sendKeys(properties.get);
	
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Xamplify@11");
	
	driver.findElement(By.xpath("//input[@id='comfirmPassword']")).sendKeys("Xamplify@11");
	
	
	driver.findElement(By.xpath("//label[@class='check']//input[@type='checkbox']")).click();
	System.out.println("checkbox");
	driver.findElement(By.id("register-submit-btn")).click();
System.out.println("submit");
Thread.sleep(10000);


DatabaseQueries data = new DatabaseQueries();
String query6 = properties.getProperty("query.getregistrationvByOrganizationId");//.replaceAll(":emailId",properties.getProperty("user.name"));//
List<String> campaignNames = data.listNames(query6, "email_id");
String campaignNameFromProp = properties.getProperty("user.name").toLowerCase();
System.out.println(driver.findElement(By.xpath(properties.getProperty("reg_email"))));
Thread.sleep(5000);

//driver.findElement(By.xpath(properties.getProperty("reg_email"))).sendKeys(properties.getProperty("user.name"));	

if(campaignNames.indexOf(campaignNameFromProp)>-1)
{
	
driver.findElement(By.xpath(properties.getProperty("reg_email"))).click();
driver.findElement(By.xpath(properties.getProperty("reg_email"))).clear();
driver.findElement(By.xpath(properties.getProperty("reg_email"))).sendKeys(System.currentTimeMillis()+"_");
driver.findElement(By.xpath(properties.getProperty("reg_email"))).sendKeys(properties.getProperty("user.name"));

Thread.sleep(25000);
}

driver.findElement(By.id("register-submit-btn")).click();
Thread.sleep(15000);

//driver.findElement(By.xpath(properties.getProperty("loginclick"))).click();
Thread.sleep(5000);
driver.findElement(By.id(properties.getProperty("email"))).sendKeys(properties.getProperty("user.name"));
driver.findElement(By.id(properties.getProperty("password"))).sendKeys(properties.getProperty("user.password"));
driver.findElement(By.id(properties.getProperty("signin"))).click();
Thread.sleep(5000);
driver.findElement(By.xpath(properties.getProperty("useracclick"))).click();
Thread.sleep(5000);

driver.findElement(By.xpath(properties.getProperty("cmpny_prfile"))).click();
Thread.sleep(5000);
	}
@Test(enabled=true,priority=3)
public void companyName1() throws InterruptedException, SQLException{
DatabaseQueries data1 = new DatabaseQueries();
String query9 = properties.getProperty("query.getCompanyName");//.replaceAll(":emailId",properties.getProperty("user.name"));//
List<String> campaignNames = data1.listNames(query9, "lower");
String campaignNameFromProp = properties.getProperty("Companyname").toLowerCase();
Thread.sleep(5000);

driver.findElement(By.xpath(properties.getProperty("Company_name"))).sendKeys(properties.getProperty("Companyname"));	

if(campaignNames.indexOf(campaignNameFromProp)>-1)
{
	
driver.findElement(By.xpath(properties.getProperty("Company_name"))).click();
driver.findElement(By.xpath(properties.getProperty("Company_name"))).clear();
driver.findElement(By.xpath(properties.getProperty("Company_name"))).sendKeys(System.currentTimeMillis()+"_");
driver.findElement(By.xpath(properties.getProperty("Company_name"))).sendKeys(properties.getProperty("Companyname"));

Thread.sleep(5000);
}



/*WebElement cmpnyname=driver.findElement(By.xpath(properties.getProperty("Company_name")));
		cmpnyname.clear();
		cmpnyname.sendKeys(properties.getProperty("Companyname"));*/
Thread.sleep(5000);

WebElement cmpnyemail=driver.findElement(By.xpath(properties.getProperty("cmpny_email")));
cmpnyemail.clear();
cmpnyemail.sendKeys("abc11@stratapps.com");
Thread.sleep(5000);

WebElement cmpnyphone=driver.findElement(By.xpath(properties.getProperty("phone")));
cmpnyphone.clear();
cmpnyphone.sendKeys("9414433328");
Thread.sleep(5000);

WebElement url=driver.findElement(By.xpath(properties.getProperty("website_url")));
url.clear();
url.sendKeys("www.stratapps.com");
Thread.sleep(5000);

WebElement about=driver.findElement(By.xpath(properties.getProperty("aboutus")));
about.clear();
about.sendKeys("Stratapps Solutions Private Limited is a Private incorporated on 27 November 2009. It is classified as Non-govt company and is registered at Registrar of Companies, Mumbai. Its authorized share capital is Rs. 500,000 and its paid up capital is Rs. 100,000. It is inolved in Business activities n.e.c.\r\n" + 
		"\r\n" + 
		"Stratapps Solutions Private Limited's Annual General Meeting (AGM) was last held on 12 August 2017 and as per records from Ministry of Corporate Affairs (MCA), its balance sheet was last filed on 31 March 2017.\r\n" + 
		"\r\n" + 
		"Directors of Stratapps Solutions Private Limited are Sudhir Balakrishnan Nambiar, Venugopal Padmanabhan, Pokancheri Vazhakali Jayaprakash and Aravindu Sandela.");
Thread.sleep(5000);
driver.findElement(By.xpath(properties.getProperty("update1"))).click();
Thread.sleep(2000);	
driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/app-topnavbar[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
Thread.sleep(2000);	
driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/app-topnavbar[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/ul[1]/li[7]/a[1]")).click();
Thread.sleep(8000);

}
}
	
