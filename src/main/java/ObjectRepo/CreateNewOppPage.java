package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class CreateNewOppPage extends WebDriverUtils
{
	//Declaration
	@FindBy(name="potentialname")
	private WebElement oppNameEdt;
	
	@FindBy(id="related_to_type")
	private WebElement orgDD;
	
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img")
	private WebElement orgLookUp;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewOppPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOppNameEdt() {
		return oppNameEdt;
	}

	public WebElement getOrgDD() {
		return orgDD;
	}

	public WebElement getOrgLookUp() {
		return orgLookUp;
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
	
	//Business Logic
	public void createNewOpportunities(String OppName, String org, WebDriver driver,String ctitle, String ptitle, String Org)
	{
		//Click on the 'Opportunities name' text field
		oppNameEdt.clear();
		oppNameEdt.sendKeys(OppName);
		//Click on 'related to' drop down and select 'organization'
		dropdownSelectUsingContainsText(orgDD, org);
		//Click the 'select' lookup image near the 'related to' field
		orgLookUp.click();
		switchToWindow(driver, ctitle);
		//Click on the 'search' text field on the Organization popup window and search Org and press search
		searchEdt.sendKeys(Org);
		searchBtn.click();
		//click on the  organization name
		waitUntilEleToBeVisible(driver, 25, driver.findElement(By.xpath("//a[text()='"+Org+"']")));
		driver.findElement(By.xpath("//a[text()='"+Org+"']")).click();
		switchToWindow(driver, ptitle);
		//click on save button
		saveBtn.click();
	}

}
