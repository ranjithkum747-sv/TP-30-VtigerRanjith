package ObjectRepo;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class CalendarPage extends WebDriverUtils
{
	//Declaration
	@FindBy(linkText="Day")
	private WebElement daysLink;
	
	@FindBy(xpath="//td[@class='calAddButton']")
	private WebElement addHover;
	
	@FindBy(linkText="Meeting")
	private WebElement meetingLink;
	
	@FindBy(name="subject")
	private WebElement eventNameEdt;
	
	@FindBy(id="starthr")
	private WebElement hrDD;
	
	@FindBy(id="startmin")
	private WebElement minDD;
	
	@FindBy(id="startfmt")
	private WebElement ampmDD;
	
	@FindBy(xpath="//input[@alt='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CalendarPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getDaysLink() {
		return daysLink;
	}

	public WebElement getAddHover() {
		return addHover;
	}

	public WebElement getMeetingLink() {
		return meetingLink;
	}

	public WebElement getEventNameEdt() {
		return eventNameEdt;
	}

	public WebElement getHrDD() {
		return hrDD;
	}

	public WebElement getMinDD() {
		return minDD;
	}

	public WebElement getAmpmDD() {
		return ampmDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Logics
	public void addAnEventInDay(WebDriver driver, String event,String hr,String min, String fmt)
	{
		daysLink.click();
		moveToElement(driver, addHover);
		String parentID = driver.getWindowHandle();
		meetingLink.click();
		Set<String> handles = driver.getWindowHandles();
		switchToWindow(driver, handles, parentID);
		eventNameEdt.sendKeys(event);
		dropdownSelectUsingContainsText(hrDD,hr);
		dropdownSelectUsingContainsText(minDD,min);
		dropdownSelectUsingContainsText(ampmDD, fmt);
		scrollUntilEleIsVisibleJSE(driver, saveBtn);
		//scrollToElement(driver, saveBtn);
		saveBtn.click();
		switchToParentWindow(driver, parentID);
	}
	
	

}
