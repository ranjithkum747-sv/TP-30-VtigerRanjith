package contacts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepo.ContactsPage;
import ObjectRepo.CreateNewContactsPage;
import ObjectRepo.CreateNewOrgPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.OrganizationPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtils;
import genericUtilities.FileUtilies;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;

public class ContactsModuleClass extends BaseClass
{
	@Test(groups = "regression")
	public  void createContactsTest() throws Exception
	{
		
		//Accessing data from the Excel
		String expCon = eLib.readSingleDataFromExcel("Contacts", 0, 1)+jLib.getRandomNumber();

		//navigate to the home page and click on the Contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		
		//Click on the 'create Contact' lookup image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnContactLookUp();
		
		//Enter the data in the 'Last Name' text field and save
		CreateNewContactsPage nc = new CreateNewContactsPage(driver);
		nc.createNewContact(expCon);
		
		//validating the output
		
		WebElement actu = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		wLib.waitUntilEleToBeVisible(driver, 15, actu);
		String actual = actu.getText();
		Assert.assertTrue(actual.contains(expCon));
		System.out.println("Contact Created"); 

	}
	
	@Test(groups = "smoke")
	public  void createContactsWithIndustryTest() throws Exception
	{
		
		//Accessing data from the Excel
		String expCon=eLib.readSingleDataFromExcel("Contacts", 0, 1)+jLib.getRandomNumber();
		String expOrg=eLib.readSingleDataFromExcel("Contacts", 1, 1)+jLib.getRandomNumber();
				
		//Click on  'Organization' link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		//click on 'Create Organization' lookup image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnOrgLookUp();
		
		//Entering the Organization name
		CreateNewOrgPage no = new CreateNewOrgPage(driver);
		no.createNewOrganization(expOrg);
		
		//Click on the Contacts link
		wLib.torefresh(driver);
		hp.clickOnContactLink();
		
		//Click on 'Create Contact' lookup image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnContactLookUp();
		
		CreateNewContactsPage nc = new CreateNewContactsPage(driver);
		nc.createNewContact(driver, expCon, expOrg,"Accounts&action=P","Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		//Validate the Contact name
		WebElement actu = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		wLib.waitUntilEleToBeVisible(driver, 15, actu);
		String actual = actu.getText();
		Assert.assertTrue(actual.contains(expCon));
		System.out.println("Contact with Industry field is Created");
	}
}
