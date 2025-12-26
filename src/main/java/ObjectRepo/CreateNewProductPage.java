package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateNewProductPage
{
	//Declaration
	@FindBy(name="productname")
	private WebElement productnameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getProductnameEdt() {
		return productnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Logic
	public void createNewProduct(String product)
	{
		//Click on the 'product name' text field and enter the 'laptops' in it
		productnameEdt.sendKeys(product);
		Assert.assertEquals(true,false);
		//click on save button
		saveBtn.click();
	}

}
