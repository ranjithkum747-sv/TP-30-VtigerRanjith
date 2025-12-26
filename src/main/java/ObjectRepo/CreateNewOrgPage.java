package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class CreateNewOrgPage extends WebDriverUtils
{
	//Declaration
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement indDD;
	
	//Initialization
	public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getIndDD() {
		return indDD;
	}
	
	//Business Logic
	public void createNewOrganization(String org)
	{
		//Click on the 'Organization  Name' textfield
		orgNameEdt.sendKeys(org);
		//Click on save.
		saveBtn.click();
	}
	
	public void createNewOrganization(String org,String ind)
	{
		orgNameEdt.sendKeys(org);
		dropdownSelectUsingContainsText(indDD, ind);
		saveBtn.click();
	}
	
	
}
