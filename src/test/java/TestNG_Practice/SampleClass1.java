package TestNG_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class SampleClass1 extends BaseClass
{
//	@BeforeSuite
//	public void sbs1()
//	{
//		System.out.println("---S-Bs1---");
//	}
//	
//	@AfterSuite
//	public void sas1()
//	{
//		System.out.println("---S-As1---");
//	}
//	
//	@BeforeClass
//	public void sbc1()
//	{
//		System.out.println("---S-Bc1---");
//	}
//	@AfterClass
//	public void sac1()
//	{
//		System.out.println("---S-Ac1---");
//	}
//	
//	@BeforeMethod
//	public void sbm1()
//	{
//		System.out.println("---S-Bm1---");
//	}
//	
//	@AfterMethod
//	public void sam1()
//	{
//		System.out.println("---S-Am1---");
//	}
	
	@Test(groups="smoke")
	public void Sm1()
	{
		System.out.println("---S=method1--s-");
	}
}
