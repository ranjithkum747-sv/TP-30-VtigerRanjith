package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class HomePage extends WebDriverUtils
{
	//Declaration
	@FindBy(linkText="Calendar")
	private WebElement calendarLink;

	@FindBy(linkText="Leads")
	private WebElement leadsLink;

	@FindBy(linkText="Organizations")
	private WebElement orgLink;

	@FindBy(linkText="Contacts")
	private WebElement conLink;

	@FindBy(linkText="Opportunities")
	private WebElement oppLink;

	@FindBy(linkText="Products")
	private WebElement productLink;

	@FindBy(id="qccombo")
	private WebElement quickCreateLink;

	@FindBy(name="company")
	private WebElement qccompanyNameEdt;

	@FindBy(name="lastname")
	private WebElement qclastNameEdt;

	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement qcsaveBtn;

	@FindBy(name="company")
	private WebElement companyQC;

	@FindBy(name="lastname")
	private WebElement lnameQc;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtnQc;


	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;

	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutLink;

	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeIcon;

	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization

	public WebElement getCalendarLink() {
		return calendarLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getConLink() {
		return conLink;
	}

	public WebElement getOppLink() {
		return oppLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getQuickCreateLink() {
		return quickCreateLink;
	}
	public WebElement getCompanyQC() {
		return companyQC;
	}

	public WebElement getLnameQc() {
		return lnameQc;
	}

	public WebElement getSaveBtnQc() {
		return saveBtnQc;
	}


	public WebElement getAdminIcon() {
		return adminIcon;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement gethomeIcon() {
		return homeIcon;
	}

	//Business Logic
	public void clickOncalLink()
	{
		calendarLink.click();
	}
	public void clickOnLeadsLink()
	{
		leadsLink.click();
	}
	public void clickOnOrgLink()
	{
		orgLink.click();
	}
	public void clickOnContactLink()
	{
		conLink.click();
	}
	public void clickOnOppLink()
	{
		oppLink.click();
	}
	public void clickOnProductLink()
	{
		productLink.click();
	}
	public void clickOnQCLink()
	{
		quickCreateLink.click();
	}

	public void createLeadsInQC(String op, String company, String Lname)
	{
		dropdownSelectUsingContainsText(quickCreateLink,op);
		companyQC.sendKeys(company);
		lnameQc.sendKeys(Lname);
		saveBtnQc.click();
	}
	public void clickOnHomeIcon()
	{
		homeIcon.click();
	}
	public void signOut(WebDriver driver)
	{
		mouseHover(driver, adminIcon);
		clickOnTheElementJSE(driver, adminIcon);
		//adminIcon.click();
		mouseHoverAndClickOnEle(driver,signoutLink);
	}

}
