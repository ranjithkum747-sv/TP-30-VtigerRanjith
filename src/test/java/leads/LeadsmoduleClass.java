package leads;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

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
import org.testng.annotations.Test;

import ObjectRepo.CreateNewLeadsPage;
import ObjectRepo.HomePage;
import ObjectRepo.LeadsPage;
import ObjectRepo.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtils;
import genericUtilities.FileUtilies;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;

public class LeadsmoduleClass extends BaseClass
{
	@Test(groups = "smoke")
	public  void creatingALeadsTest() throws Exception
	{

		//Accessing data from the Excel
		String Lname = eLib.readSingleDataFromExcel("Leads", 0, 1);
		String company=eLib.readSingleDataFromExcel("Leads", 1, 1);

		//Navigate to the home page and click on the Leads link
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsLink();

		//Click on the 'create Leads ' lookup image
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnLeadsLookUp();
		
		CreateNewLeadsPage nl = new CreateNewLeadsPage(driver);
		nl.createNewLeads(Lname, company);

		//validate
		 WebElement actu = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		 wLib.waitUntilEleToBeVisible(driver, 15, actu);
		 String actual = actu.getText();
		 Assert.assertTrue(actual.contains(Lname));
		 System.out.println("Leads Created"); 
		
	}
	
	@Test(groups = "regression")
	public  void creatingLeadsWithQuickCreate() throws Exception
	{

		//Accessing data from the Excel
		String Lname =eLib.readSingleDataFromExcel("Leads", 0, 2);
		String company=eLib.readSingleDataFromExcel("Leads", 1, 2);
		
		//Navigate to the home page and click on the 'Quick create'  Drop down
		driver.findElement(By.id("qccombo")).click();
		HomePage hp = new HomePage(driver);
		hp.clickOnQCLink();
		
		//Select "New Lead' to add the lead
		//Enter the 'Apple' in the Company name text field
		//Enter the 'Cook' in the last name text field 
		//Click on save.
		hp.createLeadsInQC("New Lead", company, Lname);
		//validate
		WebElement actu = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		wLib.waitUntilEleToBeVisible(driver, 15, actu);
		String actual = actu.getText();
		Assert.assertTrue(actual.contains(Lname));
		System.out.println("Leads Created By using QC");
		
	}

}
