package com.xamplify.login;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadVideo
{

	static WebDriver driver = Instance.getInstance();
	//static Properties properties = PropertiesFile.readPropertyFile("C:\\Users\\dtejashwini\\eclipse-workspace\\xamplify-selenium\\datafile.properties");
	static Properties properties = PropertiesFile.readPropertyFile("datafile.properties");
	public  static Logger logger = LoggerFactory.getLogger(UploadVideo.class);


	public static void main(String[] args) throws InterruptedException, IOException {

		driver.manage().window().maximize();
		logger.debug("Entering the URL");

		driver.get("https://xamplify.io/");
		driver.findElement(By.xpath("//a[@class='loginTF']")).click();
		logger.debug("login with credentials");

		Thread.sleep(10000);
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='username']")); 
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
		usernameElement.sendKeys("dtejashwini@stratapps.com");
		passwordElement.sendKeys("Xamplify@11");
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@id=\"submitBitton\"]")).click();
		Thread.sleep(3000);
		logger.debug("end - login with credentials");

		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Content_Mousehover")));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Upload_Click"))).click();
		Thread.sleep(10000);



		logger.debug("starting video browse");

		driver.findElement(By.xpath(properties.getProperty("vBrowse_click"))).click();

		Thread.sleep(10000);

		Runtime.getRuntime().exec(properties.getProperty("AutoIt")); 
		Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("vBrowse_Upload"))).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("vBrowse_Home_click"))).click();
		Thread.sleep(3000);
		logger.debug(" video is processing");

		driver.findElement(By.xpath(properties.getProperty("vBrowse_popupsave"))).click();
		Thread.sleep(10000);
		logger.debug("end video upload browse");

		Thread.sleep(3000);
		WebElement ele111 = driver.findElement(By.xpath(properties.getProperty("Content_Mousehover")));
		Actions act111 = new Actions(driver);
		act111.moveToElement(ele111).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Upload_Click"))).click();
		Thread.sleep(10000);
		logger.debug("starting record video from webcam");


		driver.findElement(By.xpath(properties.getProperty("webclick"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("camclick"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("record"))).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(properties.getProperty("stop"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("vBrowse_Home_click"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("vBrowse_popupsave"))).click();
		
		//driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();	
		//driver.findElement(By.xpath(properties.getProperty("crossclick"))).click();
		Thread.sleep(6000);
		logger.debug("end record video from webcam");
		
		Thread.sleep(3000);
		WebElement eledb = driver.findElement(By.xpath(properties.getProperty("Content_Mousehover")));
		Actions actdb = new Actions(driver);
		actdb.moveToElement(eledb).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Upload_Click"))).click();
		Thread.sleep(10000);
		logger.debug("Starting select video from dropbox");

		driver.findElement(By.xpath(properties.getProperty("vdropbox_click"))).click();

		Set<String> hashset = (HashSet<String>) driver.getWindowHandles();
		List<String> list = new ArrayList<String>(hashset);
		System.out.println(list.toString());

		Thread.sleep(5000);

		driver.switchTo().window(list.get(1));
		System.out.println(list.get(1));

		Thread.sleep(17000);

		driver.findElement(By.xpath(properties.getProperty("vdropbox_signin"))).click();

		WebElement EmailidElement = driver.findElement(By.xpath(properties.getProperty("vdrop_box_username_click"))); 
		EmailidElement.sendKeys(properties.getProperty("vdrop_box_username"));
		driver.findElement(By.xpath(properties.getProperty("vdrop_box_next_click"))).click();

		Thread.sleep(3000);

		WebElement EmailpwdElement = driver.findElement(By.name(properties.getProperty("vdrop_box_pwd_click"))); 
		EmailpwdElement.sendKeys(properties.getProperty("vdrop_box_pwd"));
		driver.findElement(By.xpath(properties.getProperty("vdrop_box_pwd_next"))).click();

		Thread.sleep(20000);				

		driver.findElement(By.className(properties.getProperty("vdrop_box_item_select"))).click();
		driver.findElement(By.xpath(properties.getProperty("vdrop_box_choose"))).click();

		Thread.sleep(8000);

		driver.switchTo().window(list.get(0));

		driver.findElement(By.xpath(properties.getProperty("vBrowse_Home_click"))).click();
		driver.findElement(By.xpath(properties.getProperty("vBrowse_popupsave"))).click();

		Thread.sleep(10000);
		logger.debug("end select video from dropbox");
		WebElement ele11 = driver.findElement(By.xpath(properties.getProperty("Content_Mousehover")));
		Actions act11 = new Actions(driver);
		act11.moveToElement(ele11).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Upload_Click"))).click();
		Thread.sleep(10000);

		logger.debug("Starting select video from box");

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("vbox_click"))).click();

		Set<String> hashset1 = (HashSet<String>) driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(hashset1);
		System.out.println(list1.toString());

		Thread.sleep(5000);

		driver.switchTo().window(list1.get(1));
		System.out.println(list1.get(1));

		Thread.sleep(17000);

		WebElement EmailidElement1 = driver.findElement(By.name(properties.getProperty("vbox_login"))); 
		EmailidElement1.sendKeys(properties.getProperty("vbox_Username"));

		driver.findElement(By.xpath(properties.getProperty("vbox_login_submit"))).click();

		Thread.sleep(3000);

		WebElement EmailpwdElement1 = driver.findElement(By.name(properties.getProperty("vbox_pwd_click"))); 
		EmailpwdElement1.sendKeys(properties.getProperty("vbox_pwd"));

		driver.findElement(By.xpath(properties.getProperty("vbox_submit"))).click();

		Thread.sleep(12000);

		WebElement radio1=driver.findElement(By.xpath(properties.getProperty("vbox_item_radio")));
		radio1.click();

		driver.findElement(By.xpath(properties.getProperty("vbox_item_select"))).click();

		Thread.sleep(5000);

		driver.switchTo().window(list1.get(0));

		driver.findElement(By.xpath(properties.getProperty("vBrowse_Home_click"))).click();
		driver.findElement(By.xpath(properties.getProperty("vBrowse_popupsave"))).click();

		Thread.sleep(10000);

		logger.debug("end select video from box");

		WebElement ele3 = driver.findElement(By.xpath(properties.getProperty("Content_Mousehover")));
		Actions act3 = new Actions(driver);
		act3.moveToElement(ele3).perform();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("Upload_Click"))).click();
		Thread.sleep(10000);

		logger.debug("selecting video from google drive");

		driver.findElement(By.xpath(properties.getProperty("GD_click"))).click();
		Thread.sleep(5000);

		Set<String> hashset2 = (HashSet<String>) driver.getWindowHandles();
		List<String> list2 = new ArrayList<String>(hashset2);
		System.out.println(list2.toString());
		System.out.println("size of current windows " + list2.size());
		if(Integer.valueOf(list2.size())==2) 
		{

			Set<String> hashset21 = (HashSet<String>) driver.getWindowHandles();
			List<String> list21 = new ArrayList<String>(hashset21);
			System.out.println(list21.toString());

			Thread.sleep(5000);

			driver.switchTo().window(list21.get(1));
			//System.out.println("Google drive window" +list21.get(1));
			//System.out.println("switched to googledrive window");
			Thread.sleep(3000);

			WebElement EmailidElement2 = driver.findElement(By.id(properties.getProperty("GD_username_click")));
			EmailidElement2.sendKeys(properties.getProperty("GD_username"));

			driver.findElement(By.xpath(properties.getProperty("GD_Next"))).click();

			Thread.sleep(3000);

			WebElement PwdElement2 = driver.findElement(By.xpath(properties.getProperty("GD_pwd_click")));
			PwdElement2.sendKeys(properties.getProperty(("GD_pwd")));

			driver.findElement(By.xpath(properties.getProperty("GD_Next1"))).click();
			Thread.sleep(4000);
			driver.switchTo().window(list2.get(0));
			Thread.sleep(10000);

			driver.switchTo().frame(2);

			System.out.println("successfully switched the frame");
			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("GD_video"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("GD_video_select"))).click();
			logger.debug("selecting the video from google drive completed");

			System.out.println("successfully uploaded the video from google drive");
		}
		else 
		{
			driver.switchTo().defaultContent();
			Thread.sleep(5000);

			driver.switchTo().frame(2);

			System.out.println("successfully switched the frame");
			Thread.sleep(8000);

			driver.findElement(By.xpath(properties.getProperty("GD_video"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("GD_video_select"))).click();
			System.out.println("successfully uploaded the video from google drive");
		}
		logger.debug("selecting the video from google drive completed");
		Thread.sleep(3000);
		//driver.close();


/*
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-upload-video[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/img[1]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-upload-video[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/button[1]")).click();
	Thread.sleep(5000);
	
	Map<String, Object> prefs = new HashMap<String, Object>();
	prefs.put("profile.default_content_setting_values.notifications", 2);
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", prefs);
	Thread.sleep(4000);
	driver.switchTo().alert().accept();

*/

}
}
	
			
    
    
	//new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
	/*ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");*/
	//WebDriver driver = Instance.getInstance();

	//System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver2.exe");
	//WebDriver driver =new ChromeDriver(options);


	

	
