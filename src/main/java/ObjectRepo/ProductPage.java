package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
	//Declaration
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement productLookUp;
	
	//Initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getProductLookUp() {
		return productLookUp;
	}
	
	//business logic
	public void clickOnProductLookUp() 
	{
		productLookUp.click();
	}
}
