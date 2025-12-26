package practiceAS1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderATPtest
{
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 1800).perform();
		
		act.clickAndHold(driver.findElement(By.xpath("//span[@style='left: 15%;']"))).moveByOffset(15, 0).release(driver.findElement(By.xpath("//span[@style='left: 15%;']"))).build().perform();
		act.clickAndHold(driver.findElement(By.xpath("//span[@style='left: 60%;']"))).moveByOffset(61, 0).release(driver.findElement(By.xpath("//span[@style='left: 60%;']"))).build().perform();
		
		
	}

}
