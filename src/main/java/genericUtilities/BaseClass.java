package genericUtilities;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;

@Listeners(genericUtilities.ListenerImplementationClass.class)

public class BaseClass
{
	public FileUtilies fLib=new FileUtilies();
	public ExcelUtils eLib=new ExcelUtils();
	public JavaUtils jLib=new JavaUtils();
	public WebDriverUtils wLib=new WebDriverUtils();
	public DatabaseUtils dLib=new DatabaseUtils();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	public static ThreadLocal<WebDriver> wdriver=new ThreadLocal<WebDriver>();
	
	@BeforeSuite(alwaysRun = true)
	public void connectToDB()
	{
		System.out.println("---Connect to DB---");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void launchTheBrowser() throws IOException
	//public void launchTheBrowser(@Optional("Chrome") String BROWSER) throws IOException
	{
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		
		sdriver=driver;
		
		wLib.maximizeWindow(driver);
		driver.get(URL);
		wLib.waitForPageLoad(driver, 15);
		System.out.println("Browser Launched");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginToAppln() throws IOException
	{
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		
		System.out.println("Logged into Appln");
	}
	
	@AfterMethod(alwaysRun = true)
	public void logOutFromAppln()
	{
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
		System.out.println("Logged out From Appln");
	}
	
	@AfterClass(alwaysRun = true)
	public void closingBrowser()
	{
		driver.quit();
		System.out.println("Browser closed");
	}
	
	@AfterSuite(alwaysRun = true)
	public void disConnectFromDB()
	{
		System.out.println("---DisConnect from DB---");
	}
}
