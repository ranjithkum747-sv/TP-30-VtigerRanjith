package leads;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

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

import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import genericUtilities.ExcelUtils;
import genericUtilities.FileUtilies;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;

public class CreatingLeadsWithQuickCreate
{
	public static void main(String[] args) throws Exception
	{
		//Creating Object for generic utilities
		FileUtilies fLib = new FileUtilies();
		ExcelUtils eLib = new ExcelUtils();
		JavaUtils jLib = new JavaUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		
		//Reading data from the property file
		String Browser = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");

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

		//Accessing data from the Excel
		String Lname =eLib.readSingleDataFromExcel("Leads", 0, 2);
		String company=eLib.readSingleDataFromExcel("Leads", 1, 2);
		
		//Navigate to the home page and click on the 'Quick create'  Drop down
		driver.findElement(By.id("qccombo")).click();
		HomePage hp = new HomePage(driver);
		hp.clickOnQCLink();
		
		//Select "New Lead' to add the lead

		hp.createLeadsInQC("New Lead", company, Lname);
		
		//Enter the 'Apple' in the Company name text field
		//Enter the 'Cook' in the last name text field 
		//Click on save.		
		//validate
		String actu = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(actu.contains(Lname))
			System.out.println("Leads Created");
		else
			System.out.println("Leads not created");
		
		//sign out
		hp.signOut(driver);
		
		driver.quit();
		
	}

}
