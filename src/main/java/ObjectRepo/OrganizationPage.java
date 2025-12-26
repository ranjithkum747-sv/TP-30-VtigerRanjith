package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class OrganizationPage extends WebDriverUtils
{
	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement OrgLookUp;
	
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement delBtn;
	
	//Initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgLookUp() {
		return OrgLookUp;
	}
	public WebElement getDelBtn() {
		return delBtn;
	}
	
	//Business Logic
	public void clickOnOrgLookUp()
	{
		OrgLookUp.click();
	}
	
	public void deleteAnOrg(String del, WebDriver driver) throws Exception
	{
		driver.findElement(By.xpath("//a[.='"+del+"']/../..//input")).click();
		delBtn.click();
		acceptAlertPopup(driver);
		Thread.sleep(3000);
		torefresh(driver);
		Thread.sleep(3000);
	}

}
