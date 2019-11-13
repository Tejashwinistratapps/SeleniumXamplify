package com.xamplify.LIVE;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import junit.framework.Assert;

public class ManagePartners {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile.readPropertyFile("rdata.properties");
	public static Logger logger = LoggerFactory.getLogger(UploadContent.class);

	@Test(priority = 3, enabled = true)
	public void manage_partners() throws InterruptedException, SQLException, IOException {
		// driver.get("https://release.xamplify.io/home/dashboard/welcome");
		Actions actions1111 = new Actions(driver);

		WebElement partners1111 = driver.findElement(By.xpath(properties.getProperty("hoverpartner")));
		actions1111.moveToElement(partners1111).build().perform();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("/html/body/app-root/app-home/div/app-leftsidebar/div/div/ul/li[2]/ul/li[2]/a/span")).click();
		logger.debug("start - copying partners list");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//a[2]//i[1]")).click();// click copy icon in manage partners
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();// close copy window
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//a[2]//i[1]")).click();// click copy icon in manage partners
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Save changes')]")).click();
		Thread.sleep(5000);
		logger.debug("End - copying partners list");
		logger.debug("start - download partners list");

		driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//a[3]//i[1]")).click();

		logger.debug("End - download partners list");

		logger.debug("start - delete partners list");
		driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//a[4]//i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='swal2-confirm styled']")).click();
		logger.debug("End - delete partners list");













		logger.debug("starting Edit partner");


		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/a[1]/i[1]"))
		.click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/div[1]/a[1]/i[1]"))
		.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).clear();

		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Gayatri Laxmi");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/app-add-contact-modal[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]")).clear();
		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/app-add-contact-modal[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]"))
		.sendKeys("StratApps Solutions");
		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/app-add-contact-modal[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]"))
		.clear();
		driver.findElement(By.xpath("//*[@id=\"addContactModal\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(10000);
		logger.debug("End Edit  partner");

		logger.debug("Starting sort by functionality");
		Select dropdown = new Select(driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/select[1]")));

		dropdown.selectByValue("1: Object");
		Thread.sleep(5000);

		dropdown.selectByValue("2: Object");
		Thread.sleep(5000);

		dropdown.selectByValue("3: Object");
		Thread.sleep(5000);

		dropdown.selectByValue("4: Object");
		Thread.sleep(5000);

		dropdown.selectByValue("5: Object");
		Thread.sleep(5000);

		dropdown.selectByValue("7: Object");
		Thread.sleep(5000);

		dropdown.selectByValue("8: Object");
		Thread.sleep(5000);

		dropdown.selectByValue("10: Object");
		Thread.sleep(5000);
		logger.debug("End sort by functionality");
		logger.debug("strating  search partner");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]"))
		.sendKeys("gayatri");// search
		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/button[2]"))
		.click();
		Thread.sleep(10000);
		logger.debug("End  search partner");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		logger.debug("starting  delete partner");

		//		driver.findElement(By.xpath(
		//				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/div[1]/a[2]/i[1]"))
		//				.click();// delete
		Thread.sleep(10000);
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/button[1]")).click();
		logger.debug("end  delete partner");
		Thread.sleep(5000);
		String deletemessage1 = "Your Partners have been deleted successfully.";

		String deletemessage =driver.findElement(By.xpath("//span[@id='responseMessage']")).getText();	
		System.out.println(deletemessage);
		/*if (deletemessage == deletemessage1) {
			System.out.println("successfully deleted");
		}

		else

		{
			driver.findElement(
					By.xpath("/html/body/app-root/app-home/div/app-leftsidebar/div/div/ul/li[2]/ul/li[2]/a/span")).click();

		}
		 */





		logger.debug("starting Manage partner-Edit partner-download csv template");
		Thread.sleep(5000);

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, -250);");

		driver.findElement(By.xpath("//button[contains(text(),'Download CSV Template')]")).click();
		logger.debug("Ending Manage partner-Edit partner-download csv template");
	}

	@AfterMethod
	public void manage_partners_edit() throws InterruptedException, SQLException, IOException {


		logger.debug("starting Manage partner-edit partner-one at a time");
		driver.findElement(By.xpath("//button[@id='add_contact']")).click();

		driver.findElement(By.xpath("//input[@id='email1']")).click();

		DatabaseQueries data = new DatabaseQueries();
		String query1 = properties.getProperty("query.getPartnersEmailidsBBOrganizationId");// .replaceAll(":emailId",properties.getProperty("user.name"));
	/*	List<String> campaignNames = data.listNames(query1, "email_id");
		String campaignNameFromProp = properties.getProperty("edit_oneatatimeemailid").toLowerCase();*/
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("emailid_1"))).sendKeys(properties.getProperty("edit_oneatatimeemailid"));
		Thread.sleep(5000);
		//if (campaignNames.indexOf(campaignNameFromProp) > -1) {
		driver.findElement(By.xpath(properties.getProperty("emailid_1"))).clear();
		driver.findElement(By.xpath(properties.getProperty("emailid_1"))).sendKeys(System.currentTimeMillis() + "_");
		driver.findElement(By.xpath(properties.getProperty("emailid_1")))
		.sendKeys(properties.getProperty("edit_oneatatimeemailid"));
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
		driver.findElement(By.xpath(properties.getProperty("edit_oneatatimevertical"))).sendKeys(properties.getProperty("vertical"));
		driver.findElement(By.xpath(properties.getProperty("edit_oneatatimeregion"))).sendKeys(properties.getProperty("region"));
		driver.findElement(By.xpath(properties.getProperty("edit_oneatatimepartnertype"))).sendKeys(properties.getProperty("partner_type"));
		driver.findElement(By.xpath(properties.getProperty("edit_oneatatimecategory"))).sendKeys(properties.getProperty("category"));


		driver.findElement(By.xpath(properties.getProperty("countrycode"))).sendKeys("+91");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("edit_oneatatime_savepartner"))).click();
		Thread.sleep(8000);
		// driver.findElement(By.xpath(properties.getProperty("cancelwindow"))).click();
		WebElement partnertext = driver.findElement(By.xpath("//span[@id='responseMessage']"));
		String hello = partnertext.getText();
		// System.out.println(partnertext.getText());
		//Assert.assertEquals(hello, "Your Partner has been updated successfully.");


		driver.findElement(By.xpath("//button[@id='save&delete_button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='saveAs_button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//input[@id='campaignName']")).clear();
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//input[@id='campaignName']")).sendKeys(System.currentTimeMillis()+ "partners_list");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//button[@class='btn btn-secondary'][contains(text(),'Close')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='save&delete_button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='saveAs_button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//input[@id='campaignName']")).clear();
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//input[@id='campaignName']")).sendKeys(System.currentTimeMillis()+ "partners_list");			Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//button[@class='btn btn-primary'][contains(text(),'Save changes')]")).click();
		Thread.sleep(5000);

		driver.findElement(
				By.xpath("//*[@id=\'manageContacts\']/div/div/div/div/div/div/section/section/div/table/tbody/tr[1]/td[5]/div/a[1]/i")).click();

		driver.findElement(By.xpath("//button[@id='save&delete_button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='exportToExcel']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='save&delete_button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='delete_button']")).click();
		Thread.sleep(1000);


		driver.findElement(By.xpath("//button[@id='copyFrom_clipboard']")).click();
		Thread.sleep(1000);


		logger.debug("Starting creating partner using copy from clipboard - comma separated");

		//driver.findElement(By.id("copyFromClipBoard")).click();// click copy from clipboard
		Thread.sleep(2000);
		Select delimiter = new Select(
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/select[1]")));
		delimiter.selectByValue("CommaSeperated");
		WebElement textarea = driver.findElement(By.xpath(properties.getProperty("cfcfield1")));
		textarea.click();
		Thread.sleep(3000);
		// textarea.sendKeys(properties.getProperty("cffielddata"));

		DatabaseQueries data1 = new DatabaseQueries();
		String query11 = properties.getProperty("query.getPartnersEmailidsBBOrganizationId");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames1 = data1.listNames(query11, "email_id");
		String campaignNameFromProp1 = properties.getProperty("cffielddata1").toLowerCase();
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("cfcfield1"))).click();
		driver.findElement(By.xpath(properties.getProperty("cfcfield1")))
		.sendKeys(properties.getProperty("cffielddata"));
		driver.findElement(By.xpath(properties.getProperty("cfcfield1")))
		.sendKeys(properties.getProperty("cffielddata1"));
		driver.findElement(By.xpath(properties.getProperty("cfcfield1")))
		.sendKeys(properties.getProperty("cffielddata2"));

		driver.findElement(By.xpath("//button[contains(text(),'SHOW PREVIEW')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("save&delete_button")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[@id='save_button']")).click();

		Thread.sleep(8000);



		// Tab Separated

		logger.debug("Starting creating partner using copy from clipboard - Tab separated");


		driver.findElement(By.xpath("//button[@id='copyFrom_clipboard']")).click();
		Select delimiter1 = new Select(
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/select[1]")));
		delimiter1.selectByValue("TabSeperated");
		WebElement textarea1 = driver.findElement(By.xpath(properties.getProperty("cfcfield1")));
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
		String campaignNameFromProp12 = properties.getProperty("cfcfield1").toLowerCase();
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

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	Accounts");

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	Address");

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	Hyderabad");

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	Telangana");

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	500032");

		driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	India");

		// driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("");//");
		// ((JavascriptExecutor)driver).executeScript("document.getElementById('copyFromclipTextArea').value='
		// ';");

		// banoj@stratapps.com vertical Telangana partner Accounts Address Hyderabad
		// telangana 500032 India 9086353738';");
		JavascriptExecutor js = (JavascriptExecutor) driver;  

		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-250)");

		driver.findElement(By.xpath("//button[contains(text(),'SHOW PREVIEW')]")).click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

		Thread.sleep(5000);
		driver.findElement(By.id("save&delete_button")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[@id='save_button']")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();// home button
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html/body/div/div[2]/button[1]")).click();// save button on pop up window
		logger.debug("End creating partner using copy from clipboard - Tab separated");
		Thread.sleep(2000);






		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();// click filter
		Thread.sleep(5000);
		//driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")).click();
		Select fieldName = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
		fieldName.selectByVisibleText("First Name");// select field name
		Thread.sleep(1000);
		Select condition = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
		condition.selectByVisibleText("Contains");
		driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("gayatri");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='cancel_button']")).click(); // cancel filter
		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
		Thread.sleep(2000);
		Select fieldName1 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));

		fieldName1.selectByVisibleText("Last Name");// select last name from the drop down list
		Select condition1 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));

		condition1.selectByVisibleText("Contains");
		driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("laxmi");// pass data to field
		driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='cancel_button']")).click();


		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
		Thread.sleep(2000);
		Select fieldName2 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
		fieldName2.selectByVisibleText("Company");// select last name from the drop down list
		Select condition2 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
		condition2.selectByVisibleText("Contains");
		driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("sa");// pass data to field
		driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
		Thread.sleep(5000);
		driver.findElement(By.id("cancel_button")).click();

		Thread.sleep(5000);


		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
		Thread.sleep(2000);
		Select fieldName3 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
		fieldName3.selectByVisibleText("Job Title");// select last name from the drop down list
		Select condition3 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
		condition3.selectByVisibleText("Contains");
		driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("sa");// pass data to field
		driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='cancel_button']")).click();




		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
		Thread.sleep(2000);
		Select fieldName4 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
		fieldName4.selectByVisibleText("Email Id");// select last name from the drop down list
		Select condition4 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
		condition4.selectByVisibleText("Contains");
		driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("sa");// pass data to field
		driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='cancel_button']")).click();




		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
		Thread.sleep(2000);
		Select fieldName5 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
		fieldName5.selectByVisibleText("Country");// select last name from the drop down list
		Select condition5 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
		condition5.selectByVisibleText("Contains");
		driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("sa");// pass data to field
		driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='cancel_button']")).click();




		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
		Thread.sleep(2000);
		Select fieldName6 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
		fieldName6.selectByVisibleText("City");// select last name from the drop down list
		Select condition6 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
		condition6.selectByVisibleText("Contains");
		driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("sa");// pass data to field
		driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='cancel_button']")).click();





		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
		Thread.sleep(2000);
		Select fieldName7 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
		fieldName7.selectByVisibleText("Mobile Number");// select last name from the drop down list
		Select condition7 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
		condition7.selectByVisibleText("Contains");
		driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("sa");// pass data to field
		driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='cancel_button']")).click();


		// delete and add more filters in filter section

		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); //
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-default pull-right']")).click(); // add extra filter by clicking +
		driver.findElement(By.xpath("//div[@class='modal-body']//div[2]//div[1]//div[1]//div[4]//span[1]//i[1]")).click();// remove extra filter button
		driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Cancel')]")).click(); // cancel filter window

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();// select first partner to export to excel
		driver.findElement(By.xpath("//button[@id='save&delete_button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='exportToExcel']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='save&delete_button']")).click();// Actions button

		//driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();// select first partner to export to excel
		driver.findElement(By.xpath("//a[@id='delete_button']")).click();// delete partner
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='swal2-confirm styled']")).click();// delete button on pop up window button



		/*String fileToUpdate = "D:\\Selenium\\Files\\UPLOAD_PARTNER_LIST _EMPTY (8).CSV", replace = "@gmail.com",replace1 = "_hello45";
int row = 1, col = 4;

File inputFile = new File(fileToUpdate);

//Read existing file 
CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
List<String[]> csvBody = reader.readAll();
//get CSV row column  and replace with by using row and column
csvBody.get(row)[col] =   System.currentTimeMillis()  + replace;
reader.close();

//Write to CSV file which is open
CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
writer.writeAll(csvBody);
writer.flush();
writer.close();

Actions actions111 = new Actions(driver);

WebElement partners111 = driver.findElement(By.xpath(properties.getProperty("hoverpartner")));
actions111.moveToElement(partners111).build().perform();
Thread.sleep(3000);
System.out.println("partners");
// driver.findElement(By.xpath(properties.getProperty("onboardingpartners"))).click();
// //onboardingpartners
logger.debug("starting creating partner using upload csv");

Thread.sleep(5000);
driver.findElement(By.xpath("//div[@id='upload_csv']")).click();
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
		 */




























		/*
				driver.findElement(By.xpath("//button[@id='add_contact']")).click();
				Thread.sleep(1000);


			driver.findElement(By.xpath("//input[@id='email1']")).click();

			DatabaseQueries data2 = new DatabaseQueries();
			String query2 = properties.getProperty("query.getPartnersEmailidsBBOrganizationId");// .replaceAll(":emailId",properties.getProperty("user.name"));
			List<String> campaignNames2 = data2.listNames(query2, "email_id");
			String campaignNameFromProp2 = properties.getProperty("edit_oneatatimeemailid").toLowerCase();

			driver.findElement(By.id(properties.getProperty("emailid_1"))).sendKeys(properties.getProperty("edit_oneatatimeemailid"));
			Thread.sleep(5000);
			//if (campaignNames.indexOf(campaignNameFromProp) > -1) {
				driver.findElement(By.id(properties.getProperty("emailid_1"))).clear();
				driver.findElement(By.id(properties.getProperty("emailid_1"))).sendKeys(System.currentTimeMillis() + "_");
				driver.findElement(By.id(properties.getProperty("emailid_1")))
						.sendKeys(properties.getProperty("edit_oneatatimeemailid"));
				driver.findElement(By.xpath(properties.getProperty("firstname"))).sendKeys("First name");
				driver.findElement(By.xpath(properties.getProperty("lastname"))).sendKeys("Last Name");
				driver.findElement(By.xpath(properties.getProperty("companyname"))).sendKeys("Company");
				driver.findElement(By.xpath(properties.getProperty("jobtitle"))).sendKeys("Job Title");

				driver.findElement(By.xpath(properties.getProperty("address"))).sendKeys("Address");
				driver.findElement(By.xpath(properties.getProperty("city"))).sendKeys("City");
				driver.findElement(By.xpath(properties.getProperty("state"))).sendKeys("State");
				driver.findElement(By.xpath(properties.getProperty("zipcode"))).sendKeys("Zip code");

				Select countries1 = new Select(driver.findElement(By.xpath(properties.getProperty("country"))));
				countries1.selectByValue("India");
				driver.findElement(By.xpath(properties.getProperty("edit_oneatatimevertical"))).sendKeys(properties.getProperty("vertical"));
				driver.findElement(By.xpath(properties.getProperty("edit_oneatatimeregion"))).sendKeys(properties.getProperty("region"));
				driver.findElement(By.xpath(properties.getProperty("edit_oneatatimepartnertype"))).sendKeys(properties.getProperty("partner_type"));
				driver.findElement(By.xpath(properties.getProperty("edit_oneatatimecategory"))).sendKeys(properties.getProperty("category"));


				driver.findElement(By.xpath(properties.getProperty("countrycode"))).sendKeys("+91");
				Thread.sleep(2000);
				driver.findElement(By.xpath(properties.getProperty("edit_oneatatime_savepartner"))).click();
				Thread.sleep(8000);
				// driver.findElement(By.xpath(properties.getProperty("cancelwindow"))).click();
				WebElement partnertext1 = driver.findElement(By.xpath("//span[@id='responseMessage']"));
				String hello1 = partnertext1.getText();
				// System.out.println(partnertext.getText());
				Assert.assertEquals(hello1, "Your Partner(s) have been saved successfully.");

				// copy from clip board







		 */			

	}

	@Test(priority = 5, enabled = true)
	public void gridview_managepartners() throws InterruptedException, SQLException {

		Actions actions11111 = new Actions(driver);

		WebElement partners11111 = driver.findElement(By.xpath(properties.getProperty("hoverpartner")));
		actions11111.moveToElement(partners11111).build().perform();
		Thread.sleep(2000);		
		driver.findElement(
				By.xpath("/html/body/app-root/app-home/div/app-leftsidebar/div/div/ul/li[2]/ul/li[2]/a/span")).click();			






		driver.findElement(By.xpath("//i[@class='fa fa-th-large p10']")).click();// grid view
		Thread.sleep(8000);
		Actions actions111111 = new Actions(driver);
		Thread.sleep(5000);
		WebElement partners111111 = driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]"));
		actions111111.moveToElement(partners111111).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/a[1]")).click();
		JavascriptExecutor jse4 = (JavascriptExecutor)driver;

		jse4.executeScript("window.scrollBy(0,-400)");

		driver.findElement(By.xpath("//a[contains(text(),'Manage')]")).click();
		Thread.sleep(8000);
		Actions actions1111111 = new Actions(driver);

		WebElement partners1111111 = driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/a[1]"));

		actions1111111.moveToElement(partners1111111).build().perform();
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/a[1]/i[1]")).click();
		Thread.sleep(1000);





		/*		driver.findElement(By.xpath("//button[@id='add_contact']")).click();

		driver.findElement(By.xpath("//input[@id='email1']")).click();

		DatabaseQueries data = new DatabaseQueries();
		String query1 = properties.getProperty("query.getPartnersEmailidsBBOrganizationId");// .replaceAll(":emailId",properties.getProperty("user.name"));
		List<String> campaignNames = data.listNames(query1, "email_id");
		String campaignNameFromProp = properties.getProperty("edit_oneatatimeemailid").toLowerCase();

		driver.findElement(By.id(properties.getProperty("emailid_1"))).sendKeys(properties.getProperty("edit_oneatatimeemailid"));
		Thread.sleep(5000);
		//if (campaignNames.indexOf(campaignNameFromProp) > -1) {
			driver.findElement(By.id(properties.getProperty("emailid_1"))).clear();
			driver.findElement(By.id(properties.getProperty("emailid_1"))).sendKeys(System.currentTimeMillis() + "_");
			driver.findElement(By.id(properties.getProperty("emailid_1")))
					.sendKeys(properties.getProperty("edit_oneatatimeemailid"));
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
			driver.findElement(By.xpath(properties.getProperty("edit_oneatatimevertical"))).sendKeys(properties.getProperty("vertical"));
			driver.findElement(By.xpath(properties.getProperty("edit_oneatatimeregion"))).sendKeys(properties.getProperty("region"));
			driver.findElement(By.xpath(properties.getProperty("edit_oneatatimepartnertype"))).sendKeys(properties.getProperty("partner_type"));
			driver.findElement(By.xpath(properties.getProperty("edit_oneatatimecategory"))).sendKeys(properties.getProperty("category"));


			driver.findElement(By.xpath(properties.getProperty("countrycode"))).sendKeys("+91");
			Thread.sleep(2000);
			driver.findElement(By.xpath(properties.getProperty("edit_oneatatime_savepartner"))).click();
			Thread.sleep(8000);
			// driver.findElement(By.xpath(properties.getProperty("cancelwindow"))).click();
			WebElement partnertext = driver.findElement(By.xpath("//span[@id='responseMessage']"));
			String hello = partnertext.getText();
			// System.out.println(partnertext.getText());
			//Assert.assertEquals(hello, "Your Partner has been updated successfully.");


			driver.findElement(By.xpath("//button[@id='save&delete_button']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='saveAs_button']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//input[@id='campaignName']")).clear();
			driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//input[@id='campaignName']")).sendKeys(System.currentTimeMillis()+ "partners_list");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//button[@class='btn btn-secondary'][contains(text(),'Close')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='save&delete_button']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='saveAs_button']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//input[@id='campaignName']")).clear();
			driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//input[@id='campaignName']")).sendKeys(System.currentTimeMillis()+ "partners_list");			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='modal-dialog modal-css']//button[@class='btn btn-primary'][contains(text(),'Save changes')]")).click();
			Thread.sleep(5000);

			driver.findElement(
					By.xpath("//*[@id=\'manageContacts\']/div/div/div/div/div/div/section/section/div/table/tbody/tr[1]/td[5]/div/a[1]/i")).click();

			driver.findElement(By.xpath("//button[@id='save&delete_button']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='exportToExcel']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='save&delete_button']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='delete_button']")).click();
			Thread.sleep(1000);


			driver.findElement(By.xpath("//button[@id='copyFrom_clipboard']")).click();
			Thread.sleep(1000);


			logger.debug("Starting creating partner using copy from clipboard - comma separated");

			//driver.findElement(By.id("copyFromClipBoard")).click();// click copy from clipboard
			Thread.sleep(2000);
			Select delimiter = new Select(
					driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/select[1]")));
			delimiter.selectByValue("CommaSeperated");
			WebElement textarea = driver.findElement(By.xpath(properties.getProperty("cfcfield1")));
			textarea.click();
			Thread.sleep(3000);
			// textarea.sendKeys(properties.getProperty("cffielddata"));

			DatabaseQueries data1 = new DatabaseQueries();
			String query11 = properties.getProperty("query.getPartnersEmailidsBBOrganizationId");// .replaceAll(":emailId",properties.getProperty("user.name"));
			List<String> campaignNames1 = data1.listNames(query11, "email_id");
			String campaignNameFromProp1 = properties.getProperty("cffielddata1").toLowerCase();
			Thread.sleep(8000);

			driver.findElement(By.xpath(properties.getProperty("cfcfield1"))).click();
			driver.findElement(By.xpath(properties.getProperty("cfcfield1")))
					.sendKeys(properties.getProperty("cffielddata"));
			driver.findElement(By.xpath(properties.getProperty("cfcfield1")))
					.sendKeys(properties.getProperty("cffielddata1"));
			driver.findElement(By.xpath(properties.getProperty("cfcfield1")))
					.sendKeys(properties.getProperty("cffielddata2"));

			driver.findElement(By.xpath("//button[contains(text(),'SHOW PREVIEW')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("save&delete_button")).click();
			Thread.sleep(8000);
			driver.findElement(By.xpath("//a[@id='save_button']")).click();

			Thread.sleep(8000);



				// Tab Separated

				logger.debug("Starting creating partner using copy from clipboard - Tab separated");


				driver.findElement(By.xpath("//button[@id='copyFrom_clipboard']")).click();
				Select delimiter1 = new Select(
						driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/select[1]")));
				delimiter1.selectByValue("TabSeperated");
				WebElement textarea1 = driver.findElement(By.xpath(properties.getProperty("cfcfield1")));
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
				String campaignNameFromProp12 = properties.getProperty("cfcfield1").toLowerCase();
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

				driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	Accounts");

				driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	Address");

				driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	Hyderabad");

				driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	Telangana");

				driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	500032");

				driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("	India");

				// driver.findElement(By.id(properties.getProperty("cfcfieldid"))).sendKeys("");//");
				// ((JavascriptExecutor)driver).executeScript("document.getElementById('copyFromclipTextArea').value='
				// ';");

				// banoj@stratapps.com vertical Telangana partner Accounts Address Hyderabad
				// telangana 500032 India 9086353738';");
		        JavascriptExecutor jse1 = (JavascriptExecutor) driver;

				Thread.sleep(2000);
				jse1.executeScript("window.scrollBy(0,-250)");

				driver.findElement(By.xpath("//button[contains(text(),'SHOW PREVIEW')]")).click();
				Thread.sleep(2000);
				((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

				Thread.sleep(5000);
				driver.findElement(By.id("save&delete_button")).click();
				Thread.sleep(8000);
				driver.findElement(By.xpath("//a[@id='save_button']")).click();
				//driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();// home button
				Thread.sleep(2000);
				//driver.findElement(By.xpath("/html/body/div/div[2]/button[1]")).click();// save button on pop up window
				logger.debug("End creating partner using copy from clipboard - Tab separated");
				Thread.sleep(2000);






driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();// click filter
Thread.sleep(5000);
//driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")).click();
Select fieldName = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
fieldName.selectByVisibleText("First Name");// select field name
Thread.sleep(1000);
Select condition = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
condition.selectByVisibleText("Contains");
driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("gayatri");
Thread.sleep(1000);
driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
Thread.sleep(2000);
driver.findElement(By.xpath("//button[@id='cancel_button']")).click(); // cancel filter
driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
Thread.sleep(2000);
Select fieldName1 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));

fieldName1.selectByVisibleText("Last Name");// select last name from the drop down list
Select condition1 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));

condition1.selectByVisibleText("Contains");
driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("laxmi");// pass data to field
driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
Thread.sleep(5000);
driver.findElement(By.xpath("//button[@id='cancel_button']")).click();


driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
Thread.sleep(2000);
Select fieldName2 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
fieldName2.selectByVisibleText("Company");// select last name from the drop down list
Select condition2 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
condition2.selectByVisibleText("Contains");
driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("sa");// pass data to field
driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
Thread.sleep(5000);
driver.findElement(By.id("cancel_button")).click();



driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
Thread.sleep(2000);
Select fieldName3 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
fieldName3.selectByVisibleText("Job Title");// select last name from the drop down list
Select condition3 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
condition3.selectByVisibleText("Contains");
driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("sa");// pass data to field
driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
Thread.sleep(1000);
driver.findElement(By.xpath("//button[@id='cancel_button']")).click();




driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
Thread.sleep(2000);
Select fieldName4 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
fieldName4.selectByVisibleText("Email Id");// select last name from the drop down list
Select condition4 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
condition4.selectByVisibleText("Contains");
driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("sa");// pass data to field
driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
Thread.sleep(1000);
driver.findElement(By.xpath("//button[@id='cancel_button']")).click();




driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
Thread.sleep(2000);
Select fieldName5 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
fieldName5.selectByVisibleText("Country");// select last name from the drop down list
Select condition5 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
condition5.selectByVisibleText("Contains");
driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("sa");// pass data to field
driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
Thread.sleep(3000);
driver.findElement(By.xpath("//button[@id='cancel_button']")).click();




driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
Thread.sleep(2000);
Select fieldName6 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
fieldName6.selectByVisibleText("City");// select last name from the drop down list
Select condition6 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
condition6.selectByVisibleText("Contains");
driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("sa");// pass data to field
driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
Thread.sleep(1000);
driver.findElement(By.xpath("//button[@id='cancel_button']")).click();





driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();//
Thread.sleep(2000);
Select fieldName7 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
fieldName7.selectByVisibleText("Mobile Number");// select last name from the drop down list
Select condition7 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]")));
condition7.selectByVisibleText("Contains");
driver.findElement(By.xpath("//input[@placeholder='value*']")).sendKeys("sa");// pass data to field
driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Submit')]")).click();// submit filter
Thread.sleep(1000);
driver.findElement(By.xpath("//button[@id='cancel_button']")).click();


// delete and add more filters in filter section

driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); // remove filter
driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click(); //
Thread.sleep(2000);
driver.findElement(By.xpath("//button[@class='btn btn-default pull-right']")).click(); // add extra filter by clicking +
driver.findElement(By.xpath("//div[@class='modal-body']//div[2]//div[1]//div[1]//div[4]//span[1]//i[1]")).click();// remove extra filter button
driver.findElement(By.xpath("//div[@id='manageContacts']//button[@class='btn green'][contains(text(),'Cancel')]")).click(); // cancel filter window

Thread.sleep(2000);
driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();// select first partner to export to excel
driver.findElement(By.xpath("//button[@id='save&delete_button']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//a[@id='exportToExcel']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//button[@id='save&delete_button']")).click();// Actions button

//driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-manage-partners[1]/app-manage-contacts[1]/div[1]/div[1]/app-edit-contacts[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();// select first partner to export to excel
driver.findElement(By.xpath("//a[@id='delete_button']")).click();// delete partner
Thread.sleep(1000);
driver.findElement(By.xpath("//button[@class='swal2-confirm styled']")).click();// delete button on pop up window button







		 */































	}

}
