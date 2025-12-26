package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadsPage
{
	//Declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="company")
	private WebElement companyNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewLeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getCompanyNameEdt() {
		return companyNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Logic
	public void createNewLeads(String Lname, String company)
	{
		//Click on the 'Last  Name' textfield
		lastNameEdt.sendKeys(Lname);
		
		//click on the company text field
		companyNameEdt.sendKeys(company);
		
		//Click on save.
		saveBtn.click();
	}

}
