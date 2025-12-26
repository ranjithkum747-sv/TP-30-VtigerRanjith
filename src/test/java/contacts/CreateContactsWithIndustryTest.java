package contacts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepo.ContactsPage;
import ObjectRepo.CreateNewContactsPage;
import ObjectRepo.CreateNewOrgPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.OrganizationPage;
import genericUtilities.ExcelUtils;
import genericUtilities.FileUtilies;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;

public class CreateContactsWithIndustryTest
{
	public static void main(String[] args) throws Exception
	{
		//Creating Objects for generic utilities
		FileUtilies fLib = new FileUtilies();
		ExcelUtils eLib = new ExcelUtils();
		JavaUtils jLib = new JavaUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		
		//Reading data from the property file
		String Browser = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME =fLib.readDataFromPropertyFile("username");
		String PASSWORD =fLib.readDataFromPropertyFile("password");
		
		//Launch the browser and navigate to application
		WebDriver driver=null;

		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}

		wLib.maximizeWindow(driver);
		
		driver.get(URL);
		wLib.waitForPageLoad(driver, 15);
		
		//login to application
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		
		//Accessing data from the Excel
		String expCon =eLib.readSingleDataFromExcel("Contacts", 0, 1)+jLib.getRandomNumber();
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
		String actCon = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(actCon.contains(expCon))
		{
			System.out.println("Contact is Created");
		}
		else
		{
			System.out.println("Contact is not created");
		}
		
		//SignOut
		hp.signOut(driver);
		
		driver.quit();
	}

}
