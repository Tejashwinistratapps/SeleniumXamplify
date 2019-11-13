package com.xamplify.LIVE;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VideoOpportunities {
	
	WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile.readPropertyFile("rdata.properties");
	private String campaignName;
	@Test(priority = 340, enabled=true)
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
	
	@Test(priority=341,enabled=true)
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
	
	@Test(priority = 342 , enabled=true)
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
		
	@Test(priority = 344, enabled = true)
	public void play_video() throws InterruptedException, SQLException 
	{
		Integer userId = 14824;
		Integer campaignId = getCampaignIdByCampaignNameAndCustomerId(campaignName, 19999);
		Integer videoId = getVideoIdByCampaignId(campaignId);
		insertVideoAction(campaignId, videoId, userId);
		insertEmailLog(campaignId, videoId, userId);

	}
	
	
	public Integer getCampaignIdByCampaignNameAndCustomerId(String campaignName, Integer customerId) throws SQLException {
		Integer campaignId = null;
		Connection connection = DatabaseConnection.getDatabaseConnection();
		String query = "SELECT campaign_id FROM xt_campaign WHERE campaign_name = '"+campaignName+"' AND customer_id = "+customerId;
		
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next())
				campaignId = resultSet.getInt(1);
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (statement != null) {
				statement.close();
			}
		}
		return campaignId;
	}
	
	Integer getVideoIdByCampaignId(Integer campaignId) throws SQLException {
		Integer videoId = null;
		Connection connection = DatabaseConnection.getDatabaseConnection();
		String query = "SELECT video_id FROM xt_campaign_videos WHERE campaign_id = "+campaignId;
		
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next())
				videoId = resultSet.getInt(1);
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (statement != null) {
				statement.close();
			}
		}
		return videoId;
	}
	
	Integer insertVideoAction(Integer campaignId, Integer videoId, Integer userId) throws SQLException{
		Integer actionId = 1;
		String sessionId = "d2c3f454-5703-fbbb-85c8-" + System.currentTimeMillis();

		Connection connection = DatabaseConnection.getDatabaseConnection();
		String query = "INSERT INTO xt_xtremand_log (user_id, video_id, campaign_id, action_id, start_time, end_time, device_type, os, city, state, zip, country, isp, ip_address, latitude, longitude, country_code, session_id, start_duration, stop_duration, open_count) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement preparedStatement1 = connection.prepareStatement(query);
		preparedStatement1.setInt(1, userId);
		
		preparedStatement1.setInt(2, videoId);
		
		preparedStatement1.setInt(3, campaignId);
		
		preparedStatement1.setInt(4, actionId);
		
		preparedStatement1.setDate(5, new Date(System.currentTimeMillis()));
		
		preparedStatement1.setDate(6, new Date(System.currentTimeMillis()+1000));
		
		preparedStatement1.setString(7, "mobile");
		
		preparedStatement1.setString(8, "ios");
		
		preparedStatement1.setString(9, "hyderabd");
		
		preparedStatement1.setString(10, "Telangana");
		
		preparedStatement1.setInt(11, 1234567);
		
		preparedStatement1.setString(12, "India");
		
		preparedStatement1.setInt(13, 13131);
		
		preparedStatement1.setInt(14, 65634);
		
		preparedStatement1.setInt(15, 12345678);
		
		preparedStatement1.setInt(16, 98765);
		
		preparedStatement1.setInt(17, +91);
		
		preparedStatement1.setString(18, sessionId);
		
		preparedStatement1.setInt(19, 12);
		
		preparedStatement1.setInt(20, 56);
		
		preparedStatement1.setInt(21, 56);
		
        int row = preparedStatement1.executeUpdate();
		return row;
		
	}

	Integer insertEmailLog(Integer campaignId, Integer videoId, Integer userId) throws SQLException {
		Connection connection = DatabaseConnection.getDatabaseConnection();
		String query = "INSERT INTO public.xt_email_log(user_id, video_id, action_id, campaign_id, \"time\", open_count, subject) VALUES (?, ?, ?, ?, ?, ?, ?);";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setInt(1, userId);
		preparedStatement.setInt(2, videoId);
		preparedStatement.setInt(3, 13);
		preparedStatement.setInt(4, campaignId);
		preparedStatement.setDate(5, new Date(System.currentTimeMillis()));
		preparedStatement.setInt(6, 0);
		preparedStatement.setString(7, "subjectLine***");// subject
		
        int row = preparedStatement.executeUpdate();
		return row;
	}
	
	
	
	@Test(priority = 345 , enabled=true)
	public void register_lead() throws InterruptedException 
	
	{
		
		
		Thread.sleep(10000);
        String nameMo = VideoCampaign.getcurrentcampaignname();//Retrieve the name
        
        System.out.print("Your name is: " +nameMo);//Display the name

		WebElement getstring = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		getstring.sendKeys(nameMo);
		
		driver.findElement(By.xpath("//button[@class='search-box-item-click']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='actions-block override-actions']//i[@class='fa fa-line-chart']")).click();// click analytics of the redistributed campaign
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='progress']")).click();// click any contact to get the register lead button
		Thread.sleep(5000);
		
		
		

		WebDriverWait wait=new WebDriverWait(driver,30);

		WebElement RegisterLeadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-success']")));
		System.out.println("RegisterLeadButton" + RegisterLeadButton.getAttribute("value"));

		
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		
		
		
	}
	
	@Test(priority = 346 , enabled=true)
	public void fillLeadRegistrationForm() throws InterruptedException
	
	{
		WebDriverWait wait=new WebDriverWait(driver,30);

		WebElement LeadDetailsForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='caption']")));
		System.out.println(LeadDetailsForm.getAttribute("value"));
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("First Name");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Last Name");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("company name");
		driver.findElement(By.xpath("//div[@class='input-group']//input[@class='form-control ng-untouched ng-pristine ng-valid']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//textarea[@id='leadStreet']")).sendKeys("Address");
		driver.findElement(By.xpath("//input[@id='leadCity']")).sendKeys("city");
		driver.findElement(By.xpath("//input[@id='leadState']")).sendKeys("state");
		driver.findElement(By.xpath("//input[@id='leadPostalCode']")).sendKeys("12345");
		Select drpCountry = new Select(driver.findElement(By.xpath("//select[@id='leadCountry']")));
		drpCountry.selectByValue("India");
		driver.findElement(By.xpath("//button[@id='saveDeal']")).click();
		WebDriverWait wait1=new WebDriverWait(driver,30);

		WebElement updateLeadSuccessfully = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='responseMessage']")));
		System.out.println(updateLeadSuccessfully.getAttribute("value"));
		
		// Update Lead
		Thread.sleep(5000);
		WebElement companyField = driver.findElement(By.xpath("//input[@id='company']"));
		companyField.clear();
		companyField.sendKeys("Company name" + System.currentTimeMillis());
		driver.findElement(By.xpath("//*[@id='saveDeal']")).click();
		
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-analytics[1]/div[9]/div[1]/div[1]/div[1]/a[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Opportunities')]")).click();
		WebDriverWait wait2=new WebDriverWait(driver,50);

		WebElement opportunitiesPage = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Total Leads')]")));
		
		System.out.println(opportunitiesPage.getAttribute("value"));
		
        String nameMo = VideoCampaign.getcurrentcampaignname();//Retrieve the name
        

		WebElement getstring = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		getstring.sendKeys(nameMo);
		driver.findElement(By.xpath("//button[@class='search-box-item-click']")).click();
		WebDriverWait wait3=new WebDriverWait(driver,30);

		WebElement specificCampaignToRegisterDeal = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-deals[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/a[2]/span[1]")));
		
		System.out.println(specificCampaignToRegisterDeal.getAttribute("value"));
		driver.findElement(By.xpath("//a[2]//span[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary register_deal']")).click();// Register Deal button click
		WebDriverWait wait4=new WebDriverWait(driver,30);

		WebElement opportunitesDetailsPage = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Opportunity Details')]")));
		
		System.out.println(opportunitesDetailsPage.getAttribute("value"));
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-deals[1]/section[1]/div[1]/app-deal-registration[1]/div[1]/div[3]/div[1]/form[1]/div[1]/div[1]/div[5]/input[1]")).sendKeys("Jobtitle");
		
		driver.findElement(By.xpath("//input[@id='website']")).sendKeys("https://release.xamplify.io/home");//Question
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Title");
		Select selectDealType = new Select(driver.findElement(By.xpath("//select[@id='dealType']")));//Deal Type *
		selectDealType.selectByValue("deal1");
		
		driver.findElement(By.xpath("//input[@id='opportunityAmount']")).sendKeys("$ 30.00");//Opportunity Amount *
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-deals[1]/section[1]/div[1]/app-deal-registration[1]/div[1]/div[3]/div[1]/form[1]/div[2]/div[5]/div[1]/div[1]/input[1]")).sendKeys("Answer1");
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-deals[1]/section[1]/div[1]/app-deal-registration[1]/div[1]/div[3]/div[1]/form[1]/div[2]/div[5]/div[2]/div[1]/input[1]")).sendKeys("Answer 2");
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-deals[1]/section[1]/div[1]/app-deal-registration[1]/div[1]/div[3]/div[1]/form[1]/div[2]/div[5]/div[3]/div[1]/input[1]")).sendKeys("Answer 3");
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-deals[1]/section[1]/div[1]/app-deal-registration[1]/div[1]/div[3]/div[1]/form[1]/div[3]/a[1]")).click();//add your comments button
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-deals[1]/section[1]/div[1]/app-deal-registration[1]/div[1]/div[3]/div[1]/form[1]/div[4]/fieldset[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")).sendKeys("Comment Title");//comment title
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-deals[1]/section[1]/div[1]/app-deal-registration[1]/div[1]/div[3]/div[1]/form[1]/div[4]/fieldset[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/textarea[1]")).sendKeys("Comment");// comment text area
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("First Name");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='saveDeal']")).click();
		

		
		
		
	}
	
	

}
