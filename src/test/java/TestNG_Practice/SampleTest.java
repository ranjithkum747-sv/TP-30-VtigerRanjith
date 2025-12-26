package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenerImplementationClass.class)
public class SampleTest extends BaseClass
{
	@Test(groups={"smoke","regression"})
	public void sample_M4() 
	{
		System.out.println("----Create-sr--");
		Assert.fail();
	}
	
	@Test(groups="smoke")
	public void sample_M2()
	{
		System.out.println("----Edit-s---");
		
	}
	
	@Test(groups="regression",priority = -1)
	public void sample_M3()
	{
		System.out.println("-----Delete-r-1---");
		
	}
	
	@Test(groups="regression")
	public void sample_M1()
	{
		System.out.println("-----Test-r----");
	}
}
