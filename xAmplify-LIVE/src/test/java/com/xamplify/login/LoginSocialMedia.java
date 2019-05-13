package com.xamplify.login;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import ch.qos.logback.core.net.SyslogOutputStream;
@Component
public class LoginSocialMedia {

	static WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile.readPropertyFile("datafile.properties");
	
    private final static Logger logger = LoggerFactory.getLogger(LoginSocialMedia.class);
    
public static void main(String[] args) throws InterruptedException {
	

	logger.debug("opening the browser");

		driver.manage().window().maximize();
		logger.debug("Entering the URL");

		driver.get("https://xamplify.io/");
		driver.findElement(By.xpath("//a[@class='loginTF']")).click();


	//driver.findElement(By.xpath("//a[@class='loginTF']")).click();
		logger.debug("opening the browser");


	logger.debug("starting of facebook login");
Thread.sleep(8000);	
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/a[1]")).click();
Thread.sleep(5000);
		WebElement fbUserName = driver.findElement(By.xpath("//input[@id='email']"));
		fbUserName.sendKeys("tejaswinid15@gmail.com");
		WebElement fbPwd = driver.findElement(By.xpath("//input[@id='pass']"));
		fbPwd.sendKeys("Madhulika456");
		driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
Thread.sleep(5000);
ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");
WebDriver driver =new ChromeDriver(options);
//driver.findElement(By.xpath(""));
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@id='logoutButton']//a")).click();
Thread.sleep(5000);
		//driver.findElement(By.xpath("//a[@class='loginTF']")).click();
		logger.debug("end of facebook login");

	logger.debug("Strating of twitter login");

Thread.sleep(5000);		
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[3]/a[1]")).click();
Thread.sleep(5000);
		WebElement TUserName = driver.findElement(By.xpath("//input[@id='username_or_email']"));
		TUserName.sendKeys("xamplifytesters@gmail.com");
		WebElement TPwd = driver.findElement(By.xpath("//input[@id='password']"));
		TPwd.sendKeys("Xamplify@11");
		driver.findElement(By.xpath("//input[@id='allow']")).click();
Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@id='logoutButton']//a")).click();
Thread.sleep(5000);
		//driver.findElement(By.xpath("//a[@class='loginTF']")).click();
		logger.debug("end of twitter login");

		logger.debug("starting of google drive login");
		//driver.findElement(By.xpath("//a[@class='loginTF']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='google']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("dtejashwini@stratapps.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Tejaswini15");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='passwordNext']//content[@class='CwaK9']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"headerdropDownLi\"]/a/i")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//li[@id='logoutButton']//a")).click();
		Thread.sleep(4000);
		logger.debug("end of google drive login");
	
		Thread.sleep(5000);		
		logger.debug("Strating of linkedin login");
		driver.findElement(By.xpath("//a[@class='loginTF']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[5]/a[1]")).click();
		Thread.sleep(5000);
		WebElement LUserName = driver.findElement(By.id("username"));
		LUserName.sendKeys("xamplifytesters@gmail.com");
		WebElement LPwd = driver.findElement(By.id("password"));
		LPwd.sendKeys("Linkedin1");
		LPwd.submit();
		//driver.findElement(By.partialLinkText("Sign in")).click();
Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@id='logoutButton']//a")).click();
Thread.sleep(5000);
		//driver.findElement(By.xpath("//a[@class='loginTF']")).click();
		logger.debug("end of linkedin login");

	//driver.get("https://release.xamplify.io/login");
	//driver.manage().window().maximize();
		logger.debug("login with credentials");

Thread.sleep(10000);
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='username']")); 
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
		usernameElement.sendKeys("dtejashwini@stratapps.com");
		passwordElement.sendKeys("Xamplify@11");
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"submitBitton\"]")).click();
		Thread.sleep(3000);
		logger.debug("end - login with credentials");
		System.out.println("dsfsfdssdasdf");

}

}



