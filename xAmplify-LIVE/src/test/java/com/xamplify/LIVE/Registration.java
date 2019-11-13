package com.xamplify.LIVE;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Registration {

	WebDriver driver = Instance.getInstance();

	Properties prop = PropertiesFile.readPropertyFile("rdata.properties");

	@Test(priority = 1)
	public void launch() throws InterruptedException {
		driver.get("https://release.xamplify.io/login");
		// .get(prop.getProperty("baseUrl"));

		driver.manage().window().maximize();

		Thread.sleep(10000);
	}

	@Test(priority = 2, enabled = true)
	public void registration() throws InterruptedException, SQLException, ClassNotFoundException, IOException {

		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[2]/div[3]/p[1]/a[1]"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Tejashwini");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("D");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("lg.vendor11@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Xamplify@11");

		driver.findElement(By.xpath("//input[@id='comfirmPassword']")).sendKeys("Xamplify@11");
		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-signup[1]/div[1]/div[1]/div[2]/form[1]/div[6]/label[1]/input[1]"))
				.click();
		driver.findElement(By.xpath("//button[@id='register-submit-btn']")).click();

		/*
		 * try { Class.forName("org.postgresql.Driver"); Connection connection = null;
		 * 
		 * connection = DriverManager.getConnection(
		 * "jdbc:postgresql://xamplify-postgresql-sfo2-do-user-1344108-0.db.ondigitalocean.com:25060/xamplify-release?sslmode=require",
		 * "doadmin", "lc9uz6iftuum6vuj");
		 */
		// DatabaseQueries data = new DatabaseQueries();
		String query7 = "update xt_user_profile set status =?::status where email_id =?";

		Connection connection = DatabaseConnection.getDatabaseConnection();
		// Statement statement = connection.createStatement();
		PreparedStatement preparedStatement = connection.prepareStatement(query7);
		preparedStatement.setObject(1, Status.APPROVE.toString());
		preparedStatement.setString(2, "lg.vendor11@gmail.com");

		preparedStatement.executeUpdate();

		// Statement stmt1 = connection.createStatement();
		Thread.sleep(5000);
		driver.findElement(By.id(prop.getProperty("email"))).sendKeys("lg.vendor11@gmail.com");
		driver.findElement(By.id(prop.getProperty("password"))).sendKeys("Xamplify@11");
		driver.findElement(By.id(prop.getProperty("signin"))).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='companyName']")).sendKeys("TGAC Info solution");
		driver.findElement(By.xpath("//input[@id='companyProfileName']")).sendKeys("TGAC");

		driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("lg.vendor11@gmail.com");

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
        
        
     // DatabaseQueries data = new DatabaseQueries();
        
        
        String query11 = "delete from xt_partnership where vendor_company_id IN (select company_id from xt_user_profile where email_id =?)";
        
 		PreparedStatement preparedStatement11 = connection.prepareStatement(query11);
 		//preparedStatement.setObject(1, Status.APPROVE.toString());
 		preparedStatement11.setString(1, "lg.vendor11@gmail.com");

 		preparedStatement11.executeUpdate();
 		
 		
 		
 		String query12 = "delete from xt_partnership where partner_company_id IN (select company_id from xt_user_profile where email_id =?)";
 		//delete from xt_partnership where partner_company_id IN (select company_id from xt_user_profile where email_id = 'lg.vendor11@gmail.com')

 		PreparedStatement preparedStatement12 = connection.prepareStatement(query12);
 		//preparedStatement.setObject(1, Status.APPROVE.toString());
 		preparedStatement12.setString(1, "lg.vendor11@gmail.com");

 		preparedStatement12.executeUpdate();
 		
 		
 		
 		
 		String query13 = "delete from xt_partnership_status_history where created_by in (select user_id from xt_user_profile where email_id =?)";
 		//delete from xt_partnership_status_history where created_by in (select user_id from xt_user_profile where email_id = 'lg.vendor11@gmail.com')

 		PreparedStatement preparedStatement13 = connection.prepareStatement(query13);
 		//preparedStatement.setObject(1, Status.APPROVE.toString());
 		preparedStatement13.setString(1, "lg.vendor11@gmail.com");

 		preparedStatement13.executeUpdate();
        
        
        
        
        
        
        
        
        
     		//String query8 = "update xt_user_profile set status =?::status where email_id =?";
     		String query8 = "delete from xt_company_profile where company_id IN (select company_id from xt_user_profile where email_id =?)";
     		PreparedStatement preparedStatement1 = connection.prepareStatement(query8);
     		//preparedStatement.setObject(1, Status.APPROVE.toString());
     		preparedStatement1.setString(1, "lg.vendor11@gmail.com");

     		preparedStatement1.executeUpdate();
        
     		String query9 = "delete from xt_user_role where user_id IN (select user_id from xt_user_profile where email_id =?)";
     		PreparedStatement preparedStatement2 = connection.prepareStatement(query9);
     		//preparedStatement.setObject(1, Status.APPROVE.toString());
     		preparedStatement2.setString(1, "lg.vendor11@gmail.com");

     		preparedStatement2.executeUpdate();
        
     		
     		
     		String query121 = "delete from xt_drip_email_history where user_id = (select user_id from xt_user_profile where email_id = ?)";
     		

     		PreparedStatement preparedStatement4 = connection.prepareStatement(query121);
     		//preparedStatement.setObject(1, Status.APPROVE.toString());
     		preparedStatement4.setString(1, "lg.vendor11@gmail.com");

     		preparedStatement4.executeUpdate();    
     		
     		
     		
     		
     		
     		
     		
     		
     		
     		
     		
     		String query10 = "delete from xt_user_profile where email_id =?";
     		PreparedStatement preparedStatement3 = connection.prepareStatement(query10);
     		//preparedStatement.setObject(1, Status.APPROVE.toString());
     		preparedStatement3.setString(1, "lg.vendor11@gmail.com");

     		preparedStatement3.executeUpdate();
     		driver.close();
     		
     		
     		

		/*
		 * String query8 = prop.getProperty("query.deletecompanyprofile"); Statement
		 * stmt11 = connection1.createStatement();
		 * 
		 * ResultSet rs1 = stmt11.executeQuery(query8);
		 * 
		 * String query9 = prop.getProperty("query.deleteuserrole"); Statement stmt2 =
		 * connection1.createStatement();
		 * 
		 * 
		 * ResultSet rs2 = stmt2.executeQuery(query9); String query10 =
		 * prop.getProperty("query.getCampaignNamesByOrganizationId"); Statement stmt3 =
		 * connection1.createStatement();
		 * 
		 * ResultSet rs3 = stmt3.executeQuery(query10);
		 */

	}

}

enum Status {
	APPROVE, UnApproved;
}
