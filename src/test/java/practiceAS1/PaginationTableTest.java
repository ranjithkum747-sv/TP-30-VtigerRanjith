package practiceAS1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PaginationTableTest
{
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://testautomationpractice.blogspot.com/");

		Actions act=new Actions(driver);
		act.scrollToElement(driver.findElement(By.id("Stats1"))).perform();

		String product="Portable Charger";
//		boolean found=false;
//		for(int i=1;i<=4;i++)
//		{
//			List<WebElement> li= driver.findElements(By.xpath("//div[@id='HTML8']//tbody//td[2]"));
//			for(WebElement l: li)
//			{
//				if(product.equalsIgnoreCase(l.getText()))
//				{
//					driver.findElement(By.xpath("//td[text()='"+product+"']/following-sibling::td/input")).click();
//					found=true;
//					break;
//				}
//			}
//			if(found)
//				break;
//			driver.findElement(By.xpath("//ul[@id='pagination']//a[text()='"+i+"']")).click();
//		}

		//Thread.sleep(4000);
				for(int i=1;i<=4;i++)
				{
					try
					{
						driver.findElement(By.xpath("//td[text()='"+product+"']/following-sibling::td/input")).click();
						break;
					}
					catch(Exception e)
					{
						driver.findElement(By.xpath("//ul[@id='pagination']//a[text()='"+i+"']")).click();
					}
				}


		//		for(int i=0;i<=4;i++)
		//		{
		//			if()
		//			driver.findElement(By.xpath("//td[text()='"+product+"']/following-sibling::td/input")).click();
		//			driver.findElement(By.xpath("//ul[@id='pagination']//a[text()='3']")).click();
		//		}



		driver.quit();
	}
}

