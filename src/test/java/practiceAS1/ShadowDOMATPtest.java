package practiceAS1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShadowDOMATPtest 
{
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 3100).perform();
		
		SearchContext shost = driver.findElement(By.id("shadow_host")).getShadowRoot();
		
		shost.findElement(By.cssSelector("input[type='text']")).sendKeys("Hello World!");
		shost.findElement(By.cssSelector("input[type='file']")).sendKeys("C:\\Users\\Arvind\\eclipse-workspace\\basic_selenium\\src\\test\\java\\PracticeWebDriverMethods\\TSS1.java");
		
		driver.quit();
	}

}
