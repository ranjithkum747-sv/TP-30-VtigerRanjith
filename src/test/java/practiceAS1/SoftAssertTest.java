package practiceAS1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest
{
	@Test
	public void m1()
	{
		int a=7;
		SoftAssert sa = new SoftAssert();
		System.out.println("----1----");
		System.out.println("----2----");
		sa.assertEquals("A", "O");
		sa.assertNull(a);
		System.out.println("----3----");
		System.out.println("----4----");
		sa.assertAll();
	}
	
	

}
