package organization;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.OrganizationPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtils;
import genericUtilities.FileUtilies;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;

public class DelectingTheOrganizationTest extends BaseClass
{
	@Test
	public  void delectingTheOrganizationTest() throws Exception
	{
		
		String del="TekOffice891";

		//navigate to the home page and click on the Organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();

		//Select the check box of the required organization to delete
		OrganizationPage op = new OrganizationPage(driver);
		op.deleteAnOrg(del, driver);
		//Click the 'delete' button 

		//handling the alert

		Thread.sleep(3000);
		//validate
		List<WebElement> lists = driver.findElements(By.xpath("//a[@title='Organizations']"));
//		SoftAssert sa = new SoftAssert();
		for(WebElement l:lists)
		{ 
			boolean b = del.equals(l.getText());
			
			if(b==true)
				Assert.assertTrue(del.equals(l.getText()));
		}
		System.out.println("Deleted");
		//sa.assertAll();
		
		
//		boolean a=false;
//		for(WebElement orga:lists)
//		{
//			if(del.equals(orga.getText()))
//			{
//				System.out.println(del+" Organization is not deleted");
//				a=true;
//				break;
//			}
//		}
//		if(!a)
//			System.out.println(del+" is deleted");
//		


	}

}
