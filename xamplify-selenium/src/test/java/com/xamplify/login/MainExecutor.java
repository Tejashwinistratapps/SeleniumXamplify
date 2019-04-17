package com.xamplify.login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

public class MainExecutor{
	
    private final Logger logger = LoggerFactory.getLogger(MainExecutor.class);

	
@Test
public void samplemethod() throws InterruptedException {
	
	// TODO Auto-generated method stub
	System.out.println("hello");
	System.setProperty("webdriver.chrome.driver", "D:/Selenium/chromedriver2.exe");
	Thread.sleep(3000);
	//WebDriver driver=new ChromeDriver();
    logger.debug("------ Starting Ant------");

    TestListenerAdapter tla = new TestListenerAdapter();
	TestNG testng = new TestNG();
	List<String> suites = Lists.newArrayList();
	suites.add("C:\\Users\\dtejashwini\\eclipse-workspace\\xamplify-selenium\\testng.xml");//path to xml..
	//suites.add("c:/tests/testng2.xml");
	testng.setTestSuites(suites);
	testng.run();

//	ChromeOptions options = new ChromeOptions();
//	options.addArguments("--disable-extensions");
//	WebDriver driver = new ChromeDriver(options);
	/*Thread.sleep(3000);
	driver.get("https://socialubuntu.com/");
	driver.manage().window().maximize();

	driver.findElement(By.xpath("//*[@id=\"bs-navbar-collapse-1\"]/ul[2]/li[1]/a")).click();
	Thread.sleep(3000);

	driver.findElement(By.name("username")).sendKeys("dtejashwini@stratapps.com");//Username
	driver.findElement(By.name("password")).sendKeys("Automation@123");//password
	Thread.sleep(3000);
	driver.findElement(By.id("submitBitton")).click();//sign in button
	Thread.sleep(5000);

	driver.quit();
	System.out.println("Executed successfully");*/

	
	
}

}


