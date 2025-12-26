package opportunities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepo.CreateNewOppPage;
import ObjectRepo.CreateNewOrgPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.OpportunitiesPage;
import ObjectRepo.OrganizationPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtils;
import genericUtilities.FileUtilies;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;

public class CreatingOpportWithMandatoryTest extends BaseClass
{
	@Test(groups = "regression")
	public  void creatingOpportWithMandatoryTest() throws Exception
	{
		
		//Creating the Organization
		//Accessing data from the Excel
		String Org =eLib.readSingleDataFromExcel("Opportunities", 1, 1)+jLib.getRandomNumber();

		//Navigate to the home page and click on the Organization link		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
	
		//Click on the 'create organization ' lookup image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnOrgLookUp();

		//Click on the 'Organization  Name' textfield
		CreateNewOrgPage no = new CreateNewOrgPage(driver);
		no.createNewOrganization(Org);
		
		//Accessing data from the Excel
		String OppName = eLib.readSingleDataFromExcel("Opportunities", 0, 1);
		
		//navigate to the home page and click on the Opportunities link
		//driver.navigate().refresh();
		wLib.torefresh(driver);
		
		hp.clickOnOppLink();
		
		//Click on the 'create opportunities ' lookup image
		OpportunitiesPage opp = new OpportunitiesPage(driver);
		opp.clickOnOppLookUp();
		
		//Click on the 'Opportunities name' text field
		driver.findElement(By.name("potentialname")).sendKeys(OppName);
		CreateNewOppPage nop = new CreateNewOppPage(driver);
		nop.createNewOpportunities(OppName, "Organization", driver, "Accounts&action", "Potentials&action", Org);
				
		//Click on the 'Calendar icon' to enter the Expected close date
		//driver.findElement(By.id("jscal_trigger_closingdate")).click();
		
		//Mark the date on '12-12-2025'
		//Click on the Sales status drop down and select 'Negotiation/ review' option
		
		//validate
		 WebElement actu = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		 wLib.waitUntilEleToBeVisible(driver, 15, actu);
		 String actual = actu.getText();
		 Assert.assertTrue(actual.contains(OppName));
		 System.out.println("Opportunities created");
	}

}
