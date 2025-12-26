package organization;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ObjectRepo.CreateNewOrgPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.OrganizationPage;
import genericUtilities.ExcelUtils;
import genericUtilities.FileUtilies;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;

public class CreatingOrgWithIndTypeTest
{
	public static void main(String[] args) throws Exception
	{
		//Creating Objects for generic utilities
		FileUtilies fLib = new FileUtilies();
		ExcelUtils eLib = new ExcelUtils();
		JavaUtils jLib = new JavaUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		
		//Accessing the method from FileUtilities class(property file) by passing the keys as argument. 
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
		wLib.waitForPageLoad(driver, 15);

		driver.get(URL);

		//login to application
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		
		//Accessing the method from ExcelUtilis class(Excel file).
		String Org =eLib.readSingleDataFromExcel("Organization", 0, 1)+jLib.getRandomNumber();
		String Ind = eLib.readSingleDataFromExcel("Organization", 1, 1);

		//Navigate to the home page and click on the Organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();

		//Click on the 'create organization ' lookup image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnOrgLookUp();
		
		//Click on the 'Organization  Name' textfield and enter industry then save
		CreateNewOrgPage no = new CreateNewOrgPage(driver);
		no.createNewOrganization(Org, Ind);

		//Validate the organization
		String actu = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if(actu.contains(Org))
		{
			System.out.println("Organization created");
		}
		else
		{
			System.out.println("Organization not created");
		}

		//SignOut
		hp.signOut(driver);
		driver.quit();
	}

}
