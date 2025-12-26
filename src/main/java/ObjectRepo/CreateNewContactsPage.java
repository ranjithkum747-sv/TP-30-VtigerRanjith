package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class CreateNewContactsPage extends WebDriverUtils
{
	//Declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement orgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Logics
	public void createNewContact(String expCon)
	{
		lastNameEdt.sendKeys(expCon);
		saveBtn.click();
	}
	
	public void createNewContact(WebDriver driver, String expCon,String expOrg, String ctitle, String ptitle)
	{
		lastNameEdt.sendKeys(expCon);
		orgLookUpImg.click();
		switchToWindow(driver, ctitle);
		searchEdt.sendKeys(expOrg);
		searchBtn.click();
		waitUntilEleToBeVisible(driver, 25, driver.findElement(By.xpath("//a[text()='"+expOrg+"']")));
		driver.findElement(By.xpath("//a[text()='"+expOrg+"']")).click();
		switchToWindow(driver, ptitle);
		saveBtn.click();
	}

}
