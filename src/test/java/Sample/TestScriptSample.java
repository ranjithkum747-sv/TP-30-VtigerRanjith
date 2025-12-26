package Sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.RetryImplementationClass;

public class TestScriptSample extends BaseclassSample
{
	@Test(retryAnalyzer = genericUtilities.RetryImplementationClass.class)
	public void g()
	{
		Assert.assertEquals(true, false);
		System.out.println("@Test-g-method");
	}
	
	@Test
	public void d()
	{
		System.out.println("@Test-d-method");
	}
}
