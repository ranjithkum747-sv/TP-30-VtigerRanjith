package Sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(genericUtilities.ListenerImplementationClass.class)

public class BaseclassSample 
{
	@BeforeSuite
	public void beforeSuitMehod()
	{
		System.out.println("---BS---");
	}
	@BeforeTest
	public void beforeTestMethod()
	{
		System.out.println("---BT---");
	}
	
	@BeforeClass
	public void beforeClassMethod()
	{
		System.out.println("---BC---");
	}
	@BeforeMethod
	public void beforeMethodMethod()
	{
		System.out.println("---BM---");
	}
	@AfterSuite
	public void afterSuitMehod()
	{
		System.out.println("---AS---");
	}
	@AfterTest
	public void afterTestMethod()
	{
		System.out.println("---AT---");
	}
	
	@AfterClass
	public void afterClassMethod()
	{
		System.out.println("---AC---");
	}
	@AfterMethod
	public void afterMethodMethod()
	{
		System.out.println("---AM---");
	}

}
