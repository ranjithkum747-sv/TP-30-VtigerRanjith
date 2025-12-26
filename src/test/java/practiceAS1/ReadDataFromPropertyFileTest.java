package practiceAS1;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromPropertyFileTest
{
	public static void main(String[] args) throws Exception
	{
		//1. create object for physical representation of file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		
		//2.create object for properties class
		Properties pobj = new Properties();
		
		//3. Load all the keys
		pobj.load(fis);
		
		//4. Fetch the value using "getProperty" method
		String Browser = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String UN = pobj.getProperty("username");
		String Pd = pobj.getProperty("password");
		
		//5. launch the browser
		WebDriver driver=null;
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
	    }
		else if(Browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		//6. maximize and wait for page load
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//get url
		driver.get(URL);
		
		//Login values
		driver.findElement(By.xpath("//input[@name='user_name']")).clear();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		
		driver.findElement(By.xpath("//input[@name='user_password']")).clear();
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Pd);
		
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
