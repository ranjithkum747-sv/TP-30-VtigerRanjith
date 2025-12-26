package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage 
{
	//Declaration
	@FindBy(xpath="//img[@alt='Create Opportunity...']")
	private WebElement oppLookUp;
	
	//Initialization
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOppLookUp() {
		return oppLookUp;
	}
	
	//Business logic
	public void clickOnOppLookUp()
	{
		oppLookUp.click();
	}

}
