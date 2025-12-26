package practiceAS1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrokenLinksATPTest
{
	public static void main(String[] args) throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://testautomationpractice.blogspot.com/");

		Actions act = new Actions(driver);
		act.scrollByAmount(0, 2600).perform();
		
		String link=null;
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='broken-links']/a"));
		try 
		{
			for(WebElement elink:links)
			{
				link=elink.getAttribute("href");

				URL url = new URL(link);

				HttpURLConnection http =(HttpURLConnection) url.openConnection();

				int status = http.getResponseCode();

				if(status>=400)
				{
					System.out.println("Broken Link===>"+link+"===>Code===>"+status);
				}
				else
				{
					System.out.println("Other Link===>"+link+"===>Code===>"+status);
				}

			}
		}
		catch(Exception e)
		{
			System.out.println("Other than href links===> "+link);
		}
		
		driver.quit();

	}

}
