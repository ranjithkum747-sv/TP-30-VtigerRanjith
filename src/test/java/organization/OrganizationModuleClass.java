package organization;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import javax.security.auth.login.LoginContext;

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
import org.testng.Assert.*;
import org.testng.annotations.Test;

import ObjectRepo.CreateNewOrgPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.OrganizationPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtils;
import genericUtilities.FileUtilies;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;

public class OrganizationModuleClass extends BaseClass
{
	@Test(priority = -1,groups = "smoke")
	public  void createOrgWithMandatoryFieldTest() throws Exception
	{
		//Creating objects for Generic Utilities
//		FileUtilies fLib = new FileUtilies();
//		ExcelUtils eLib = new ExcelUtils();
//		JavaUtils jLib = new JavaUtils();
//		WebDriverUtils wLib = new WebDriverUtils();
		
		//Reading data from the property file
//		FileInputStream fi1 = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
//		Properties pobj=new Properties();
//		pobj.load(fi1);
//		String Browser = fLib.readDataFromPropertyFile("browser");
//		String URL = fLib.readDataFromPropertyFile("url");
//		String USERNAME = fLib.readDataFromPropertyFile("username");
//		String PASSWORD=fLib.readDataFromPropertyFile("password");
//
//		String Browser = pobj.getProperty("browser");
//		String URL = pobj.getProperty("url");
//		String USERNAME = pobj.getProperty("username");
//		String PASSWORD = pobj.getProperty("password");

		//Launch the browser and navigate to application
//		WebDriver driver=null;
//
//		if(Browser.equalsIgnoreCase("chrome"))
//		{
//			driver=new ChromeDriver();
//		}
//		else if(Browser.equalsIgnoreCase("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		else if(Browser.equalsIgnoreCase("edge"))
//		{
//			driver=new EdgeDriver();
//		}


		//driver.manage().window().maximize();
//		wLib.maximizeWindow(driver);
//		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		wLib.waitForPageLoad(driver, 15);
//
//		driver.get(URL);

		//Login to application
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
//		LoginPage lp = new LoginPage(driver);
//		lp.login(USERNAME, PASSWORD);

		//Creating the Organization
//		Random ran= new Random();
//		int random = ran.nextInt(500);
		
		String Org = eLib.readSingleDataFromExcel("Organization", 0, 1)+jLib.getRandomNumber();
		//Accessing data from the Excel
//		FileInputStream fi2= new FileInputStream(".\\src\\test\\resources\\S-Excel.xlsx");
//
//		Workbook wb = WorkbookFactory.create(fi2);
//		Sheet sh = wb.getSheet("Organization");
//		String Org = sh.getRow(0).getCell(1).getStringCellValue()+random;

		//Navigate to the home page and click on the Organization link
		//driver.findElement(By.linkText("Organizations")).click();
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
	
		//Click on the 'create organization ' lookup image
	//	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		OrganizationPage or = new OrganizationPage(driver);
		or.clickOnOrgLookUp();

		//Click on the 'Organization  Name' textfield
		//driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(Org);
		CreateNewOrgPage no = new CreateNewOrgPage(driver);
		no.createNewOrganization(Org);

		//Click on save.
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Validate the organization
		 WebElement actu = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		 wLib.waitUntilEleToBeVisible(driver, 15, actu);
		 String actual = actu.getText();
		 assertTrue(actual.contains(Org));
		 System.out.println("Organization with mandatory field created");
		 
//		if(actu.contains(Org))
//		{
//			System.out.println("Organization with mandatory field created");
//		}
//		else
//		{
//			System.out.println("Organization not created");
//		}

		//SignOut
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//wLib.mouseHover(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		//Actions act= new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']"))).click().perform();
		//wLib.clickOnElement(driver,driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")));
//		hp.signOut(driver);
//		driver.quit();
	}

	@Test(groups = "regression")
	public  void creatingOrgWithIndTypeTest() throws Exception
	{
		
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
		 WebElement actu = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		 wLib.waitUntilEleToBeVisible(driver, 15, actu);
		 String actual = actu.getText();
		 Assert.assertTrue(actual.contains(Org));
		 System.out.println("Organization with Industry field is created");
	}

}


