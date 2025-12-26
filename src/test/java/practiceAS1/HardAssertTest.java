package practiceAS1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest
{
	@Test
	public void m1()
	{
		//String exp="vtiger CRM 5 - Commercial Open Source CRM";
		String exp="vtiger";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888");
		String title = driver.getTitle();
		
		//Assert.assertEquals(title, exp);
		Assert.assertTrue(title.contains(exp));
		System.out.println(title);
		
		driver.quit();
	}

}
