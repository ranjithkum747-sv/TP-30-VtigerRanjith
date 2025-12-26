package TestNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1 
{
	@Test(dataProvider = "storedata")
	public void getData(String com, String loc)
	{
		System.out.println("Company="+com+" Location"+loc);
	}

	@DataProvider(name="Company and location")
	public Object[][] storedata()
	{
		Object[][] obj = new Object[3][2];

		obj[0][0]="Testyantra";
		obj[0][1]="Bangalore";

		obj[1][0]="Tekpyramid";
		obj[1][1]="Hyderabad";

		obj[2][0]="TCS";
		obj[2][1]="Mysore";

		return obj;
	}

	@DataProvider(name="products and price")//if we are providing the "name" then we should call the method using "name" only
	public Object[][] product()
	{
		Object[][] obj = new Object[2][2];
		obj[0][0]="Apple";
		obj[0][1]=2000;

		obj[1][0]="samsung";
		obj[1][1]=1000;

		return obj;
	}

}
