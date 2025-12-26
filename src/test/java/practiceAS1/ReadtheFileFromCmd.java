package practiceAS1;

import org.testng.annotations.Test;

public class ReadtheFileFromCmd 
{
	@Test
	public void readfromCMD()
	{
		String browser=System.getProperty("browser");
		String URL=System.getProperty("url");
		String Username=System.getProperty("username");
		String Password=System.getProperty("password");
		
		System.out.println(browser);
		System.out.println(URL);
		System.out.println(Username);
		System.out.println(Password);
	}
	
}
