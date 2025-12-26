package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage
{
	//Declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement ContactsLookUp;
	
	//Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContactsLookUp() {
		return ContactsLookUp;
	}
	
	//Business Logic
	public void clickOnContactLookUp()
	{
		ContactsLookUp.click();
	}
	
	

}
