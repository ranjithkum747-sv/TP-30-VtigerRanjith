package calender;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import ObjectRepo.CalendarPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtils;
import genericUtilities.FileUtilies;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;

public class AddingAnEventinaDayTest extends BaseClass
{
	@Test(groups = "smoke")
	public  void addingAnEventinaDayTest() throws Exception
	{
		//Creating Object for generic Utilities
//		FileUtilies fLib = new FileUtilies();
//		ExcelUtils eLib = new ExcelUtils();
//		JavaUtils jLib = new JavaUtils();
//		WebDriverUtils wLib = new WebDriverUtils();
//
//		//Reading data from the property file
//		String BROWSER = fLib.readDataFromPropertyFile("browser");
//		String URL = fLib.readDataFromPropertyFile("url");
//		String USERNAME = fLib.readDataFromPropertyFile("username");
//		String PASSWORD = fLib.readDataFromPropertyFile("password");
//
//		//Launch the browser and navigate to application
//		WebDriver driver=null;
//
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//
//		wLib.maximizeWindow(driver);
//
//		driver.get(URL);
//		wLib.waitForPageLoad(driver, 15);

		//		Scheduling an Event
		String event="EventInADay";

		//Login application
		//		driver.findElement(By.name("user_name")).sendKeys("admin");
		//		driver.findElement(By.name("user_password")).sendKeys("admin");
		//		driver.findElement(By.id("submitButton")).click();

		//LoginPage
//		LoginPage lp = new LoginPage(driver);
//		lp.login(USERNAME, PASSWORD);

		//Navigate to the home page and click on the Calender link
		//		driver.findElement(By.linkText("Calendar")).click();
		HomePage hp = new HomePage(driver);
		hp.clickOncalLink();

		CalendarPage cp = new CalendarPage(driver);
		cp.addAnEventInDay(driver, event, "08", "00", "PM");

		//Click on the 'days' link 
		//		driver.findElement(By.linkText("Day")).click();
		//		
		//		//Mouse hover on the 'Add' hover menu
		//		wLib.moveToElement(driver,driver.findElement(By.xpath("//td[@class='calAddButton']")));
		//		
		//		String parentID = driver.getWindowHandle();
		//			
		//		Click on 'meeting' from the options
		//		driver.findElement(By.linkText("Meeting")).click();
		//		
		//		Enter the 'Sprint plan meeting' in the 'Event name' text field
		//		Set<String> windows = driver.getWindowHandles();
		//		for(String win:windows)
		//		{
		//			driver.switchTo().window(win);
		//			if(!(win.equals(parentID)))
		//					break;		
		//		}
		//		
		//		driver.findElement(By.name("subject")).sendKeys(event);
		//
		//		Select the time for Start the event in the drop down
		//		wLib.dropdownSelectUsingValue(driver.findElement(By.id("starthr")), "08");
		//		wLib.dropdownSelectUsingValue(driver.findElement(By.id("startmin")), "00");
		//		wLib.dropdownSelectUsingValue(driver.findElement(By.id("startfmt")), "pm");
		//		
		//		wLib.scrollOnWebPage(driver, 0, 400);
		//		
		//		click on save button
		//		driver.findElement(By.xpath("(//input[@alt='Save [Alt+S]'])[1]")).click();
		//		
		//		driver.switchTo().window(parentID);

		//		Click on the 'Home' button link
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).click();
		hp.clickOnHomeIcon();
		System.out.println("Event Added");
		//		//validate
		//		String PendingActivities = driver.findElement(By.id("maincont_row_13")).getText();
		//		
		//		System.out.println(PendingActivities);
		//		
		//		if(PendingActivities.contains(Event))
		//			System.out.println("Event is Scheduled");
		//		else
		//			System.out.println("Event is not scheduled");

		//Nandan Validating Method
		//		List<WebElement> listlink = driver.findElements(By.xpath("//div[@id='stuff_13']//tbody//tr//a"));
		//		for(WebElement list :listlink )
		//		{
		//			System.out.println(list.getText());
		//			String k =list.getText();
		//			
		//			if(k.contains(event))
		//			{	
		//				
		//				System.out.println("Event is Scheduled");
		//				break;
		//			}
		//			else
		//			{	System.out.println(k);
		//				
		//			}
		//		}

		//		Click on the 'sign out' link
		//	wLib.mouseHover(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		//wLib.clickOnElement(driver, driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")));
//		hp.signOut(driver);
//		driver.quit();

	}

}
