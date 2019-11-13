package com.xamplify.LIVE;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ReferAVendor {
	
	
	WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile.readPropertyFile("rdata.properties");


	@Test(priority = 1, enabled=true)
	public void launch() throws InterruptedException 
	
	{
		driver.get("https://release.xamplify.io/login");
		// .get(prop.getProperty("baseUrl"));

		driver.manage().window().maximize();

		Thread.sleep(20000);
	}
	
	@Test(priority = 2,enabled=true)
	public void referavendor() throws InterruptedException 
	{
		driver.findElement(By.xpath(properties.getProperty("referavendorbutton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("enteremailid"))).sendKeys("forever.abjv@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("subjectclick"))).click();
		Thread.sleep(2000);

		WebElement emailaddress =driver.findElement(By.xpath(properties.getProperty("clicksendbutton")));
		emailaddress.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("cancelwindow"))).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("clickmyprofile"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("clicklogout"))).click();

		Thread.sleep(10000);
	}
	

	@Test(priority = 3, enabled = true)
	public void registration() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
		
driver.get("https://release.xamplify.io/login");
Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("stratyourfreetrail")))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Firstnameplaceholder"))).sendKeys("Tejashwini");
		driver.findElement(By.xpath(properties.getProperty("lastnameplaceholder"))).sendKeys("D");
		driver.findElement(By.xpath(properties.getProperty("Emailplaceholder"))).sendKeys("forever.abjv@gmail.com");
		driver.findElement(By.xpath(properties.getProperty("passwordplaceholder"))).sendKeys("Xamplify@11");

		driver.findElement(By.xpath(properties.getProperty("confirmpasswordplaceholder"))).sendKeys("Xamplify@11");
		driver.findElement(By.xpath(properties.getProperty("agreetermsandcondtions"))).click();
		driver.findElement(By.xpath(properties.getProperty("clicksubmitregistraiton"))).click();

		/*
		  try { 
			  Class.forName("org.postgresql.Driver"); Connection connection = null;
		  }
		  
		  connection = DriverManager.getConnection(
		  "jdbc:postgresql://xamplify-postgresql-sfo2-do-user-1344108-0.db.ondigitalocean.com:25060/xamplify-release?sslmode=require",
		 "doadmin", "lc9uz6iftuum6vuj");
		 
		// DatabaseQueries data = new DatabaseQueries();
*/		String query7 = "update xt_user_profile set status =?::status where email_id =?";

		Connection connection = DatabaseConnection.getDatabaseConnection();
		// Statement statement = connection.createStatement();
		PreparedStatement preparedStatement = connection.prepareStatement(query7);
		preparedStatement.setObject(1, Status.APPROVE.toString());
		preparedStatement.setString(2, "forever.abjv@gmail.com");

		preparedStatement.executeUpdate();

		// Statement stmt1 = connection.createStatement();
		Thread.sleep(5000);
		driver.findElement(By.id(properties.getProperty("email"))).sendKeys("forever.abjv@gmail.com");
		driver.findElement(By.id(properties.getProperty("password"))).sendKeys("Xamplify@11");
		driver.findElement(By.id(properties.getProperty("signin"))).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='companyName']")).sendKeys("TGAC Info solution"+System.currentTimeMillis());
		driver.findElement(By.xpath("//input[@id='companyProfileName']")).sendKeys("TGAC"+System.currentTimeMillis());

		driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("forever.abjv@gmail.com");

		driver.findElement(By.xpath("//input[@id='tagLine']")).sendKeys("IT");
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-edit-company-profile[1]/div[1]/div[1]/div[3]/div[4]/form[1]/div[1]/div[2]/div[5]/fieldset[1]/int-phone-prefix[1]/div[1]/input[1]")).sendKeys("0987654321");
		Thread.sleep(1000);
		

		driver.findElement(By.xpath("//input[@id='website']")).sendKeys("https://release.xamplify.io/home/team/add-team");
		driver.findElement(By.xpath("//textarea[@id='aboutUs']")).sendKeys("About Us");
		driver.findElement(By.xpath("//span[contains(text(),'* Please upload company logo')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='btn green fileinput-button-css']")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("D:\\Selenium\\Files\\uploadcompanyimage.exe");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='saveOrUpdateCompanyButton']")).click();
        Thread.sleep(10000);
        WebElement partners = driver.findElement(By.xpath(properties.getProperty("hoverpartner")));
		Actions actions = new Actions(driver);
		actions.moveToElement(partners).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Onboarding"))).click();
		Thread.sleep(5000);
       
        driver.findElement(By.xpath(properties.getProperty("oneatatime"))).click();// one at a time
		Thread.sleep(2000);
		System.out.println("partners123");
		driver.findElement(By.id(properties.getProperty("emailid_1"))).sendKeys("rjagdish@stratapps.com");

		driver.findElement(By.xpath(properties.getProperty("firstname"))).sendKeys("First name");
		driver.findElement(By.xpath(properties.getProperty("lastname"))).sendKeys("Last Name");
		driver.findElement(By.xpath(properties.getProperty("companyname"))).sendKeys("Company");
		driver.findElement(By.xpath(properties.getProperty("jobtitle"))).sendKeys("Job Title");
		driver.findElement(By.xpath(properties.getProperty("address"))).sendKeys("Address");
		driver.findElement(By.xpath(properties.getProperty("city"))).sendKeys("City");
		driver.findElement(By.xpath(properties.getProperty("state"))).sendKeys("State");
		driver.findElement(By.xpath(properties.getProperty("zipcode"))).sendKeys("Zip code");

		Select countries = new Select(driver.findElement(By.xpath(properties.getProperty("country"))));
		countries.selectByValue("India");
		driver.findElement(By.xpath(properties.getProperty("countrycode"))).sendKeys("+91");
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("savepartner"))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[contains(text(),'Accept')]")).click();
		Thread.sleep(5000);
		  String Actualtext = driver.findElement(By.xpath("//div[@class='alert alert-dismissible m0 alert-danger']")).getText();
		  Thread.sleep(5000);
		  Assert.assertEquals(Actualtext, "Partnership with TGA Info Solutions already established via dtejashwini@stratapps.com");
		 
		  Thread.sleep(5000);
        
       /* 
		driver.get(properties.getProperty("baseUrl"));
		
		Thread.sleep(3000);
        
		driver.findElement(By.id(properties.getProperty("email"))).sendKeys("slokasri96@gmail.com");
		driver.findElement(By.id(properties.getProperty("password"))).sendKeys("Xamplify@11");
		driver.findElement(By.id(properties.getProperty("signin"))).click();
        Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("referavendorbutton"))).click();
		driver.findElement(By.xpath(properties.getProperty("enteremailid"))).sendKeys("forever.abjv@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/app-topnavbar[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/app-topnavbar[1]/div[3]/div[1]/div[2]/div[3]/button[2]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@id='requestForVendor']//a[@class='close-circle']")).click();
*/		Thread.sleep(5000);
        
		
		
		/*driver.findElement(By.xpath("//span[@class='username username-hide-on-mobile']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@id='logoutButton']//a[1]")).click();*/
		
		
	
        
        
        
        
        
        
        
        
        
        
    


	
	
	 String query11 = "delete from xt_partnership_status_history where partnership_id IN (select id from xt_partnership where vendor_company_id IN (select company_id from xt_user_profile where email_id = ?) OR partner_company_id IN (select company_id from xt_user_profile where email_id = ?))";

	 PreparedStatement preparedStatement11 = connection.prepareStatement(query11);
		//preparedStatement.setObject(1, Status.APPROVE.toString());
		preparedStatement11.setString(1, "forever.abjv@gmail.com");
		preparedStatement11.setString(2, "forever.abjv@gmail.com");


		preparedStatement11.executeUpdate();
		
		
		
		
		
		
		String query12 = "delete from xt_partnership where vendor_company_id IN (select company_id from xt_user_profile where email_id = ?) OR partner_company_id IN (select company_id from xt_user_profile where email_id = ?)";
		PreparedStatement preparedStatement12 = connection.prepareStatement(query12);
 		//preparedStatement.setObject(1, Status.APPROVE.toString());
 		preparedStatement12.setString(1, "forever.abjv@gmail.com");
		preparedStatement12.setString(2, "forever.abjv@gmail.com");

 		preparedStatement12.executeUpdate();
 		
 	
 		
 		
 		
        
        
        
        
        
        
        
        
        
     		//String query8 = "update xt_user_profile set status =?::status where email_id =?";
     		String query8 = "delete from xt_company_profile where company_id IN (select company_id from xt_user_profile where email_id =?)";
     		PreparedStatement preparedStatement1 = connection.prepareStatement(query8);
     		//preparedStatement.setObject(1, Status.APPROVE.toString());
     		preparedStatement1.setString(1, "forever.abjv@gmail.com");

     		preparedStatement1.executeUpdate();
        
     		String query9 = "delete from xt_user_role where user_id IN (select user_id from xt_user_profile where email_id =?)";
     		PreparedStatement preparedStatement2 = connection.prepareStatement(query9);
     		//preparedStatement.setObject(1, Status.APPROVE.toString());
     		preparedStatement2.setString(1, "forever.abjv@gmail.com");

     		preparedStatement2.executeUpdate();
        
     		
     		
     		String query121 = "delete from xt_drip_email_history where user_id = (select user_id from xt_user_profile where email_id = ?)";
     		

     		PreparedStatement preparedStatement4 = connection.prepareStatement(query121);
     		//preparedStatement.setObject(1, Status.APPROVE.toString());
     		preparedStatement4.setString(1, "forever.abjv@gmail.com");

     		preparedStatement4.executeUpdate();    
     		

     		
     		


     		String query123 = "delete from xt_user_userlist where user_list_id IN (select user_list_id from xt_user_list where company_id = (select company_id from xt_user_profile where email_id = ?))";
     		PreparedStatement preparedStatement41 = connection.prepareStatement(query123);
     		//preparedStatement.setObject(1, Status.APPROVE.toString());
     		preparedStatement41.setString(1, "forever.abjv@gmail.com");
     		preparedStatement41.executeUpdate();    

     		
     		String query1234 = "delete from xt_user_list where company_id = (select company_id from xt_user_profile where email_id = ?)";    		
     		PreparedStatement preparedStatement411 = connection.prepareStatement(query1234);
     		//preparedStatement.setObject(1, Status.APPROVE.toString());
     		preparedStatement411.setString(1, "forever.abjv@gmail.com");
     		preparedStatement411.executeUpdate();  
     		
     		
     		
     		
     		
     		
     		
     		
     		
     		
     		String query10 = "delete from xt_user_profile where email_id =?";
     		PreparedStatement preparedStatement3 = connection.prepareStatement(query10);
     		//preparedStatement.setObject(1, Status.APPROVE.toString());
     		preparedStatement3.setString(1, "forever.abjv@gmail.com");

     		preparedStatement3.executeUpdate();
     		driver.close();
     		
     		
     		
/*
		
		  String query8 = prop.getProperty("query.deletecompanyprofile"); Statement
		 stmt11 = connection1.createStatement();
		  
		  ResultSet rs1 = stmt11.executeQuery(query8);
		  
		  String query9 = prop.getProperty("query.deleteuserrole"); Statement stmt2 =
		  connection1.createStatement();
		  
		  
		  ResultSet rs2 = stmt2.executeQuery(query9); String query10 =
		  prop.getProperty("query.getCampaignNamesByOrganizationId"); Statement stmt3 =
		  connection1.createStatement();
		  
		  ResultSet rs3 = stmt3.executeQuery(query10);*/
		 
	}
}




