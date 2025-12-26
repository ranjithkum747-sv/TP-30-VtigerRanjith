package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//Declaration
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy (name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getUsernameEdt()
	{
		return usernameEdt;
	}

	public WebElement getPasswordEdt()
	{
		return passwordEdt;
	}

	public WebElement getLoginBtn()
	{
		return loginBtn;
	}

	//Business Logic
	public void login(String un,String pwd)
	{
		usernameEdt.sendKeys(un);
		passwordEdt.sendKeys(pwd);
		loginBtn.click();
	}
	
	

}
