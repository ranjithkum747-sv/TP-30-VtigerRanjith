package practiceAS1;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadFromXmlFileTest 
{
	@Test
	public void readXMl(XmlTest test)
	{
		System.out.println(test.getParameter("browser"));
		System.out.println(test.getParameter("url"));
		System.out.println(test.getParameter("password"));
		System.out.println(test.getParameter("username"));
	}
}
