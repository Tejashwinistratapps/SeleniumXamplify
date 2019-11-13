package com.xamplify.LIVE;

import java.io.BufferedReader;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.csvreader.CsvWriter;
import com.google.common.base.Function;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import junit.framework.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Xamplifypartners {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile.readPropertyFile("rdata.properties");
	public static Logger logger = LoggerFactory.getLogger(UploadContent.class);

	@BeforeMethod(enabled = true)
	public void partners_hover() throws InterruptedException, SQLException, IOException {

		/*
		 * @Test(priority=1) public void launchdriver() throws InterruptedException {
		 * 
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:/Selenium/chromedriver2.exe"); Thread.sleep(3000); driver = new
		 * ChromeDriver(); Thread.sleep(3000); }
		 */
		/*
		 * @Test(priority=4,enabled=true) public void signin() throws
		 * InterruptedException {
		 * 
		 * driver.manage().window().maximize();
		 * driver.get("https://release.xamplify.io/"); Thread.sleep(3000);
		 * driver.findElement(By.xpath("//*[@id=\"bs-navbar-collapse-1\"]/ul[2]/li[1]/a"
		 * )).click(); Thread.sleep(3000);
		 * 
		 * driver.findElement(By.name(properties.getProperty("username"))).sendKeys(
		 * properties.getProperty("user.name"));
		 * driver.findElement(By.name(properties.getProperty("password"))).sendKeys(
		 * "Xamplify@11"); Thread.sleep(10000);
		 * driver.findElement(By.name(properties.getProperty("password"))).submit();
		 * //driver.findElement(By.id(prop.getProperty("submit"))).click();//sign in
		 * button Thread.sleep(10000);
		 * 
		 * 
		 * 
		 * }
		 */
		/*
		 * logger.debug("Entering the URL"); driver.manage().window().maximize();
		 * driver.get("https://release.xamplify.io/");
		 * //driver.findElement(By.xpath("//a[@class='loginTF']")).click();
		 * Thread.sleep(5000); WebElement usernameElement =
		 * driver.findElement(By.xpath("//input[@id='username']")); WebElement
		 * passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
		 * usernameElement.sendKeys("agayatri@stratapps.com");
		 * passwordElement.sendKeys("Automation@123"); Thread.sleep(3000);
		 * 
		 * // driver.findElement(By.xpath(
		 * "/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[2]/form[1]/button[1]"
		 * )).click(); Thread.sleep(5000);
		 * driver.findElement(By.xpath("//*[@id=\"submitBitton\"]")).click(); //
		 * driver.findElement(By.id("submitBitton")).click();
		 * 
		 * // driver.get("https://xamplify.io/home/dashboard/welcome");
		 * 
		 * Thread.sleep(5000);
		 */

		WebElement partners = driver.findElement(By.xpath(properties.getProperty("hoverpartner")));
		Actions actions = new Actions(driver);
		actions.moveToElement(partners).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Onboarding"))).click();

	}

	@Test(priority = 1, enabled = true)
	public void one_at_a_time() throws InterruptedException, SQLException, IOException 
	{

		logger.debug("Starting creating partner using one at time");
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("oneatatime"))).click();// one at a time
		Thread.sleep(2000);
		System.out.println("partners123");
		driver.findElement(By.xpath(properties.getProperty("firstname"))).sendKeys("First name");
		driver.findElement(By.xpath(properties.getProperty("lastname"))).sendKeys("Last Name");
		driver.findElement(By.xpath(properties.getProperty("companyname"))).sendKeys("Company");
		driver.findElement(By.xpath(properties.getProperty("jobtitle"))).sendKeys("Job Title");

		DatabaseQueries data = new DatabaseQueries();
		String query1 = properties.getProperty("query.getPartnersEmailidsBBOrganizationId");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames = data.listNames(query1, "email_id");
		String campaignNameFromProp = properties.getProperty("oneatatimeemailid").toLowerCase();

		driver.findElement(By.id(properties.getProperty("emailid_1")))
				.sendKeys(properties.getProperty("oneatatimeemailid"));
		Thread.sleep(5000);
		// if (campaignNames.indexOf(campaignNameFromProp) > -1) {
		driver.findElement(By.id(properties.getProperty("emailid_1"))).clear();
		driver.findElement(By.id(properties.getProperty("emailid_1"))).sendKeys(System.currentTimeMillis() + "_");
		driver.findElement(By.id(properties.getProperty("emailid_1")))
				.sendKeys(properties.getProperty("oneatatimeemailid"));

		// }

		driver.findElement(By.xpath(properties.getProperty("address"))).sendKeys("Address");
		driver.findElement(By.xpath(properties.getProperty("city"))).sendKeys("City");
		driver.findElement(By.xpath(properties.getProperty("state"))).sendKeys("State");
		driver.findElement(By.xpath(properties.getProperty("zipcode"))).sendKeys("Zip code");

		Select countries = new Select(driver.findElement(By.xpath(properties.getProperty("country"))));
		countries.selectByValue("India");
		// countries.selectByIndex(1);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(properties.getProperty("countrycode"))).sendKeys("+91");
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("savepartner"))).click();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("//*[@id='tcModal']/div/div/div[3]/button[2]")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath(properties.getProperty("cancelwindow"))).click();
		WebElement partnertext = driver.findElement(By.xpath("//span[@id='responseMessage']"));
		String hello = partnertext.getText();
		// System.out.println(partnertext.getText());
		Assert.assertEquals(hello, "Your Partner(s) have been saved successfully.");

		System.out.println("exceuted successfully");
		logger.debug("End creating partner using one at time");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//app-contacts-campaigns-mails//tr[@class='row_0']//td[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='sendMailsModal']/div/div/div[3]/button")).click();
		//driver.findElement(By.xpath("//button[contains(text(),'Send')]")).click();
	}

	@Test(priority = 2, enabled = false)
	public void copy_from_clipboard() throws InterruptedException, SQLException, IOException

	{
		/*
		 * Actions actions1 = new Actions(driver); WebElement partners1 =
		 * driver.findElement(By.xpath(properties.getProperty("hoverpartner")));
		 * actions1.moveToElement(partners1).build().perform(); Thread.sleep(2000);
		 * System.out.println("cfcpartners");
		 * driver.get("https://release.xamplify.io/home/partners/add");
		 */
		logger.debug("Starting creating partner using copy from clipboard - comma separated");

		driver.findElement(By.id("copyFromClipBoard")).click();// click copy from clipboard
		Select delimiter = new Select(
				driver.findElement(By.xpath("//div[@class='col-xs-6']//select[@class='opts form-control']")));
		delimiter.selectByValue("CommaSeperated");
		WebElement textarea = driver.findElement(By.xpath(properties.getProperty("cfcfield")));
		textarea.click();
		Thread.sleep(3000);
		// textarea.sendKeys(properties.getProperty("cffielddata"));

		DatabaseQueries data1 = new DatabaseQueries();
		String query11 = properties.getProperty("query.getPartnersEmailidsBBOrganizationId");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames1 = data1.listNames(query11, "email_id");
		String campaignNameFromProp1 = properties.getProperty("cffielddata1").toLowerCase();
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("cfcfield"))).click();
		driver.findElement(By.xpath(properties.getProperty("cfcfield")))
				.sendKeys(properties.getProperty("cffielddata"));
		driver.findElement(By.xpath(properties.getProperty("cfcfield")))
				.sendKeys(properties.getProperty("cffielddata1"));
		driver.findElement(By.xpath(properties.getProperty("cfcfield")))
				.sendKeys(properties.getProperty("cffielddata2"));

		driver.findElement(By.xpath("//button[contains(text(),'SHOW PREVIEW')]")).click();

		driver.findElement(By.xpath("//button[@id='save&delete_button']//span")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[@id='save_button']")).click();

		Thread.sleep(8000);
		// if (campaignNames1.indexOf(campaignNameFromProp1) > -1) {
		driver.findElement(By.xpath(properties.getProperty("cfcfield"))).clear();
		driver.findElement(By.xpath(properties.getProperty("cfcfield")))
				.sendKeys(properties.getProperty("cffielddata"));
		driver.findElement(By.xpath(properties.getProperty("cfcfield"))).sendKeys(System.currentTimeMillis() + "");
		driver.findElement(By.xpath(properties.getProperty("cfcfield")))
				.sendKeys(properties.getProperty("cffielddata1"));
		driver.findElement(By.xpath(properties.getProperty("cfcfield")))
				.sendKeys(properties.getProperty("cffielddata2"));

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'SHOW PREVIEW')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='save&delete_button']//span")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[@id='save_button']")).click();
		Thread.sleep(5000);

		// driver.findElement(By.xpath("//span[@id='responseMessage']"));

		WebElement partnertext1 = driver.findElement(By.xpath("//span[@id='responseMessage']"));
		String hello1 = partnertext1.getText();
		// System.out.println(partnertext.getText());
		Assert.assertEquals(hello1, "Your Partner(s) have been saved successfully.");

		// driver.findElement(By.id("save_button")).click();
		// driver.findElement(By.xpath("//a[@id='save_button']")).click();
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//*[@id=\"sendMailsModal\"]/div/div/div[1]/button")).click();
		logger.debug("End creating partner using copy from clipboard - comma separated");

		// Tab Separated
		Thread.sleep(5000);
		Actions actions11 = new Actions(driver);
		WebElement partners11 = driver.findElement(By.xpath(properties.getProperty("hoverpartner")));
		actions11.moveToElement(partners11).build().perform();
		Thread.sleep(2000);
		System.out.println("cfcpartners");
		driver.get("https://release.xamplify.io/home/partners/add");
		logger.debug("Starting creating partner using copy from clipboard - Tab separated");

		driver.findElement(By.id("copyFromClipBoard")).click();// click copy from clipboard
		Select delimiter1 = new Select(
				driver.findElement(By.xpath("//div[@class='col-xs-6']//select[@class='opts form-control']")));
		delimiter1.selectByValue("TabSeperated");
		WebElement textarea1 = driver.findElement(By.xpath(properties.getProperty("cfcfield")));
		textarea1.click();

		Thread.sleep(3000);
		// textarea.sendKeys(properties.getProperty("cffielddata"));

		DatabaseQueries data11 = new DatabaseQueries();
		String query111 = properties.getProperty("query.getPartnersEmailidsBBOrganizationId");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames11 = data11.listNames(query111, "email_id");
		String campaignNameFromProp11 = properties.getProperty("cffielddata1tabseparated").toLowerCase();
		Thread.sleep(8000);

		// driver.findElement(By.xpath(properties.getProperty("cfcfeild1"))).click();

		WebElement send = driver.findElement(By.id("copyFromclipTextArea"));
		send.click();

		// ((JavascriptExecutor)driver).executeAsyncScript("arguments[0].value='Teja
		// Doddipati Stratapps QAAutomationEngineer banoj@stratapps.com vertical
		// Telangana partner Accouts Address Hyderabad telangana 500032 India
		// 9086353738'" ,send);
		((JavascriptExecutor) driver).executeScript(
				"document.getElementById('copyFromclipTextArea').value='Teja	Doddipati	Stratapps	QAAutomationEngineer	banoj@stratapps.com	vertical	Telangana	partner	Accouts	Address	Hyderabad	telangana	500032	India	9086353738';");

		Thread.sleep(5000);

		// driver.findElement(By.xpath(properties.getProperty("cfcfeild1"))).sendKeys("
		// vertical andhra partnertype course address rajamundary ap 534342 india
		// 9490925078");

		driver.findElement(By.xpath("//button[contains(text(),'SHOW PREVIEW')]")).click();
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript(
				"document.getElementById('copyFromclipTextArea').value='Teja	Doddipati	Stratapps	QAAutomationEngineer	banoj@stratapps.com vertical	Telangana	partner	Accouts	Address	Hyderabad	telangana	500032	India	9086353738';");
		Thread.sleep(2000);

		// driver.findElement(By.xpath("//button[@id='save&delete_button']//span")).click();
		// Thread.sleep(8000);
		// driver.findElement(By.xpath("//a[@id='save_button']")).click();
		// driver.findElement(By.xpath("//span[contains(text(),'Actions')]")).click();
		// Thread.sleep(8000);

		// driver.findElement(By.xpath("//a[@id='save_button']")).click();

		DatabaseQueries data12 = new DatabaseQueries();
		String query112 = properties.getProperty("query.getPartnersEmailidsBBOrganizationId");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames12 = data12.listNames(query112, "email_id");
		String campaignNameFromProp12 = properties.getProperty("cfcfield").toLowerCase();
		Thread.sleep(8000);
		((JavascriptExecutor) driver).executeScript(
				"document.getElementById('copyFromclipTextArea').value='Teja	Doddipati	Stratapps	QAAutomationEngineer	';");
		Thread.sleep(5000);
		driver.findElement(By.id(properties.getProperty("cfcfieldid")))
				.sendKeys(System.currentTimeMillis() + "banoj@stratapps.com	");
		Thread.sleep(5000);
		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	vertical");
		Thread.sleep(2000);

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	Telangana");

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	partner");

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	Accouts");

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	Address");

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	Hyderabad");

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	telangana");

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	500032");

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	India");

		// driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("");//");
		// ((JavascriptExecutor)driver).executeScript("document.getElementById('copyFromclipTextArea').value='
		// ';");

		// banoj@stratapps.com vertical Telangana partner Accounts Address Hyderabad
		// telangana 500032 India 9086353738';");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'SHOW PREVIEW')]")).click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();// home button
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[2]/button[1]")).click();// save button on pop up window
		logger.debug("End creating partner using copy from clipboard - Tab separated");

		// driver.findElement(By.xpath("//span[contains(text(),'Actions')]")).click();
		Thread.sleep(8000);
//driver.findElement(By.xpath("//a[@id='save_button']")).click();

		// driver.findElement(By.xpath("//span[@id='responseMessage']"));
		// driver.findElement(By.xpath("//div[@class='modal-dialog']//div[@class='modal-header']//button[@type='button']")).click();
		Thread.sleep(2000);

		// WebElement
		// partnertext11=driver.findElement(By.xpath("//span[@id='responseMessage']"));
		// String hello11 = partnertext11.getText();
		// System.out.println(partnertext.getText()); Assert.assertEquals(hello11,"Your
		// Partner(s) have been saved successfully.");

	}

	@Test(priority = 3, enabled = false)
	public void uploadcsv() throws InterruptedException, IOException {

		// driver.findElement(By.id("save_button")).click();
		// driver.findElement(By.xpath("//a[@id='save_button']")).click();
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//*[@id=\"sendMailsModal\"]/div/div/div[1]/button")).click();

		String fileToUpdate = "D:\\Selenium\\Files\\UPLOAD_PARTNER_LIST _EMPTY (8).CSV", replace = "@gmail.com",
				replace1 = "teja";
		int row = 1, col = 4;

		File inputFile = new File(fileToUpdate);

// Read existing file 

		@SuppressWarnings("deprecation")
		CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
		List<String[]> csvBody = reader.readAll();
		// get CSV row column and replace with by using row and column
		csvBody.get(row)[col] = replace1 + System.currentTimeMillis() + replace;
		reader.close();

// Write to CSV file which is open
		@SuppressWarnings("deprecation")
		CSVWriter writer = new CSVWriter(new FileWriter(inputFile), CSVWriter.DEFAULT_SEPARATOR);
		writer.writeAll(csvBody, false);
		writer.flush();
		writer.close();

		Actions actions111 = new Actions(driver);

		WebElement partners111 = driver.findElement(By.xpath(properties.getProperty("hoverpartner")));
		actions111.moveToElement(partners111).build().perform();
		Thread.sleep(3000);
		System.out.println("partners");
		// driver.findElement(By.xpath(properties.getProperty("onboardingpartners"))).click();
		// //onboardingpartners
		driver.get("https://release.xamplify.io/home/partners/add");
		logger.debug("starting creating partner using upload csv");

		Thread.sleep(5000);
		driver.findElement(By.id("uploadCSV")).click();
		// driver.findElement(By.xpath("//*[@id=\"uploadCSV\"]/input")).click();
		// driver.findElement(By.partialLinkText("Upload a CSV")).click();
		// driver.findElement(By.xpath("//*[@id=\"uploadCSV\"]/span")).click();
		Thread.sleep(7000);
		Runtime.getRuntime().exec("D:\\Selenium\\Files\\uploadcsv.exe");
		Thread.sleep(7000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-add-partners[1]/div[1]/div[3]/div[2]/button[1]/span[1]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-add-partners[1]/div[1]/div[3]/div[2]/ul[1]/li[1]/a[1]"))
				.click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-add-partners[1]/div[3]/app-contacts-campaigns-mails[1]/div[1]/div[1]/div[1]/div[1]/button[1]"))
				.click();
		logger.debug("End creating partner using upload csv");
	}

	@Test(priority = 3, enabled = false)
	public void onboardingpartner_ListofPartners() {

	}
}
//}
/*
 * JavascriptExecutor js1 = (JavascriptExecutor) driver;
 * js1.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
 * driver.findElement(By.xpath(
 * "//*[@id=\'manageContacts\']/app-edit-contacts/div[1]/ul/li[2]/a")).click();
 * Thread.sleep(15000);
 */

/*
 * @Test(priority=9,enabled=false) public void team() throws
 * InterruptedException {
 * 
 * driver.get("https://release.xamplify.io/home/dashboard/welcome");
 * 
 * driver.findElement(By.xpath(properties.getProperty("hoverteam"))).click();
 * Thread.sleep(5000);
 * driver.findElement(By.xpath(properties.getProperty("addteammember"))).click()
 * ;
 * driver.findElement(By.xpath(properties.getProperty("first_name"))).sendKeys(
 * "FirstName");
 * driver.findElement(By.xpath(properties.getProperty("last_name"))).sendKeys(
 * "LastName");
 * driver.findElement(By.xpath(properties.getProperty("emailidclick"))).sendKeys
 * ("wuca@xcodes.net");
 * driver.findElement(By.xpath(properties.getProperty("save"))).click();
 * driver.findElement(By.xpath(properties.getProperty("downloadcsv"))).click();
 * driver.findElement(By.xpath(properties.getProperty("uploadcsvteammember"))).
 * click();
 * 
 * 
 * 
 * }
 */ /*
	 * @Test(priority=10,enabled=true) public void createcontacts() throws
	 * InterruptedException, SQLException
	 * 
	 * { //driver.get("https://release.xamplify.io/home/dashboard/welcome");
	 * 
	 * 
	 * Actions actions = new Actions(driver); WebElement contacts =
	 * driver.findElement(By.xpath(properties.getProperty("hovercontacts")));
	 * actions.moveToElement(contacts).build().perform(); Thread.sleep(3000);
	 * driver.findElement(By.xpath(properties.getProperty("onboardingpartners"))).
	 * click(); //onboarding contacts
	 * driver.findElement(By.xpath("//span[contains(text(),'One at a time')]")).
	 * click();//one at a time Thread.sleep(2000);
	 * driver.findElement(By.xpath("//input[@id='firstName']")).
	 * sendKeys("First name");
	 * driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Last Name"
	 * );
	 * driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Company");
	 * driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Job Title");
	 * driver.findElement(By.xpath(properties.getProperty("contactemailid"))).
	 * sendKeys(properties.getProperty("contactemail"));
	 * 
	 * driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Address");
	 * driver.findElement(By.xpath("//input[@id='city']")).sendKeys("City");
	 * driver.findElement(By.xpath("//input[@id='state']")).sendKeys("State");
	 * driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("Zip code");
	 * 
	 * driver.findElement(By.xpath("//select[@placeholder='Country']")).sendKeys("")
	 * ; Select countries = new
	 * Select(driver.findElement(By.xpath("//select[@placeholder='Country']")));
	 * countries.selectByVisibleText("India"); driver.findElement(By.
	 * xpath("//div[@class='input-group']//input[@class='form-control ng-untouched ng-pristine ng-valid']"
	 * )).sendKeys("+91");
	 * driver.findElement(By.xpath("//button[@type='submit']")).click();
	 * Thread.sleep(5000);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * DatabaseQueries data = new DatabaseQueries(); String query2 =
	 * properties.getProperty("query.getcontactlistnames");//.replaceAll(":emailId",
	 * properties.getProperty("user.name")); List<String> campaignNames =
	 * data.listNames(query2, "user_list_name"); String campaignNameFromProp =
	 * properties.getProperty("contactoneatatimelistname").toLowerCase();
	 * 
	 * driver.findElement(By.xpath(properties.getProperty(
	 * "contactoneatatimelistnamexpath"))).sendKeys(properties.getProperty(
	 * "contactoneatatimelistname")); Thread.sleep(5000);
	 * if(campaignNames.indexOf(campaignNameFromProp)>-1) {
	 * driver.findElement(By.xpath(properties.getProperty(
	 * "contactoneatatimelistnamexpath"))).clear();
	 * driver.findElement(By.xpath(properties.getProperty(
	 * "contactoneatatimelistnamexpath"))).sendKeys(System.currentTimeMillis()+"_");
	 * driver.findElement(By.xpath(properties.getProperty(
	 * "contactoneatatimelistnamexpath"))).sendKeys(properties.getProperty(
	 * "contactoneatatimelistname")); Thread.sleep(3000); }
	 * 
	 * 
	 * 
	 * driver.findElement(By.xpath("//button[@id='sample_editable_1_new']")).click()
	 * ; }
	 * 
	 */
