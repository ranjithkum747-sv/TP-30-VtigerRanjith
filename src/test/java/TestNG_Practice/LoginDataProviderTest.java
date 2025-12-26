package TestNG_Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepo.LoginPage;

public class LoginDataProviderTest
{
	@Test(dataProvider = "Login_credentials")
	public void data(String un, String pwd)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pwd);
				
	}
	
	@DataProvider(name="Login_credentials")
	public Object[][] storeData()
	{
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="admin";
		obj[0][1]="admin";
		
		obj[1][0]="admin";
		obj[1][1]="password";
		
		return obj;
	}

}
