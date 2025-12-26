package product;

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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepo.CreateNewProductPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.ProductPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtils;
import genericUtilities.FileUtilies;
import genericUtilities.JavaUtils;
import genericUtilities.RetryImplementationClass;
import genericUtilities.WebDriverUtils;
//
//@Listeners(genericUtilities.ListenerImplementationClass.class)
public class AddingProductTest extends BaseClass 
{
	@Test(groups = {"smoke","regression"}, retryAnalyzer = genericUtilities.RetryImplementationClass.class)
	public  void addingProductTest() throws Exception
	{
		//Accessing data from the Excel
		String product= eLib.readSingleDataFromExcel("Product", 0, 1);
		
		//Navigate to the home page and click on the Product link
		HomePage hp = new HomePage(driver);
		hp.clickOnProductLink();

		//Click on the 'create product' ' lookup image
		ProductPage pp = new ProductPage(driver);
		pp.clickOnProductLookUp();

		CreateNewProductPage np = new CreateNewProductPage(driver);
		np.createNewProduct(product);
		
		//validate
		 WebElement actu = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		 wLib.waitUntilEleToBeVisible(driver, 15, actu);
		 String actual = actu.getText();
		 Assert.assertTrue(actual.contains(product));
		 System.out.println("Product displayed");
	}

}
