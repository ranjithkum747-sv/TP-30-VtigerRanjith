package TestNG_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class DemoClass1 extends BaseClass
{
//	@BeforeSuite
//	public void dbs()
//	{
//		System.out.println("---D-Bs1---");
//	}
//	
//	@AfterSuite
//	public void das1()
//	{
//		System.out.println("---D-As1---");
//	}
//	
//	@BeforeClass
//	public void dbc1()
//	{
//		System.out.println("---D-Bc1---");
//	}
//	
//	@AfterClass
//	public void dac1()
//	{
//		System.out.println("---D-Ac1---");
//	}
	
//	@BeforeMethod
//	public void dbm1()
//	{
//		System.out.println("---D-Bm1---");
//	}
//	
//	@AfterMethod
//	public void dam1()
//	{
//		System.out.println("---D-Am1---");
//	}
	
//	@BeforeMethod
//	public void dbm2()
//	{
//		System.out.println("---D-Bm2---");
//	}
	
//	@AfterMethod
//	public void dam2()
//	{
//		System.out.println("---D-Am2---");
//	}
	
	@Test(groups="regression")
	public void dm1()
	{
		System.out.println("---D=method1-r--");
	}
	
	@Test(groups="smoke")
	public void dm2()
	{
		System.out.println("---D=method2-s--");
	}
	
	
	@Test
	public void impact()
	{
		System.out.println("---regional regression---");
	}
	
	@Test
	public void impact1()
	{
		System.out.println("--e-regional regression---");
	}
}
