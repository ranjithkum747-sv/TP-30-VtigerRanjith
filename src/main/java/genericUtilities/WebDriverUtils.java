package genericUtilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils
{
	/**
	 *This method is used to maximize the window
	 * @author Arvind
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to wait the page to load till the implicit time
	 * @author Arvind
	 * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver, int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	public void torefresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	/**
	 * This method is used to explicitly wait the element until it is visible
	 * @author Arvind
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitUntilEleToBeVisible(WebDriver driver, int sec, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 *  This method is used to explicitly wait the element until it is click
	 * @author Arvind
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waituntilelementToBeClickable(WebDriver driver, int sec, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 *  This method is used to create select class object 
	 * @author Arvind
	 * @param element
	 * @return
	 */
	public Select dropdown(WebElement element)
	{
		Select sel = new Select(element);
		return sel;
	}
	/**
	 * This method is used to select the DD by using value
	 * @author Arvind
	 * @param element
	 * @param value
	 */
	public void dropdownSelectUsingValue(WebElement element,String value)
	{
		dropdown(element).selectByValue(value);
	}
	/**
	 * This method is used to select the DD by using visible text
	 * @author Arvind
	 * @param element
	 * @param text
	 */
	public void dropdownSelectUsingVisibleText(WebElement element,String text)
	{
		dropdown(element).selectByVisibleText(text);
	}
	/**
	 * This method is used to select the option by contains text
	 * @author Arvind
	 * @param element
	 * @param text
	 */
	public void dropdownSelectUsingContainsText(WebElement element, String text)
	{
		dropdown(element).selectByContainsVisibleText(text);
	}
	/**
	 * This method is used to select the DD by using index
	 * @author Arvind
	 * @param element
	 * @param index
	 */
	public void dropdownSelectUsingIndex(WebElement element,int index)
	{
		dropdown(element).selectByIndex(index);
	}
	/**
	 * This method is used to create the object for action
	 * @author Arvind
	 * @param driver
	 * @return
	 */
	public Actions actions(WebDriver driver)
	{
		Actions act=new Actions(driver);
		return act;
	}
	/**
	 * This method is used to mouse hover on the element
	 * @author Arvind
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		actions(driver).moveToElement(element).perform();
	}
	/**
	 * This method is used to mouse hover and click on the element 
	 * @author Arvind
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAndClickOnEle(WebDriver driver, WebElement element)
	{
		actions(driver).moveToElement(element).click(element).perform();
	}
	public void clickOnElement(WebDriver driver, WebElement element)
	{
		actions(driver).click(element).perform();
	}
	public void draganddrop(WebDriver driver, WebElement sr,WebElement des)
	{
		actions(driver).dragAndDrop(sr, des).perform();
	}
	public void dragAndDropBy(WebDriver driver,WebElement element, int x, int y)
	{
		actions(driver).dragAndDropBy(element, x, y).perform();
	}
	public void doubleClick(WebDriver driver)
	{
		actions(driver).doubleClick().perform();
	}
	public void doubleonElement(WebDriver driver, WebElement element)
	{
		actions(driver).doubleClick(element).perform();
	}
	public void rightClick(WebDriver driver)
	{
		actions(driver).contextClick().perform();
	}
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		actions(driver).contextClick(element).perform();
	}
	public void clickAndHold(WebDriver driver, WebElement element)
	{
		actions(driver).clickAndHold(element).perform();
	}
	public void clickAndHoldAndrelease(WebDriver driver, WebElement element)
	{
		actions(driver).clickAndHold(element).release().perform();
	}
	public void moveByOffset(WebDriver driver,int x, int y)
	{
		actions(driver).moveByOffset(x, y).perform();
	}
	public void moveToElement(WebDriver driver,WebElement element)
	{
		actions(driver).moveToElement(element).perform();
	}
	public void  scrollOnWebPage(WebDriver driver, int x, int y)
	{
		actions(driver).scrollByAmount(x, y).perform();;
	}
	public void scrollToElement(WebDriver driver,WebElement element)
	{
		actions(driver).scrollToElement(element).perform();
	}
	
	
	public void switchToChildWindows(WebDriver driver,String expTitle)
	{
		String parentID=driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String curWin = it.next();
			String actTitle = driver.switchTo().window(curWin).getTitle();
			if(actTitle.contains(expTitle))
				break;
		}
	}
	
	public void switchToParentWindow(WebDriver driver, String parentID)
	{
		driver.switchTo().window(parentID);
	}
	
	public void switchToWindow(WebDriver driver, String expTitle)
	{
//		String parentID = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String curWin = it.next();
			String actTitle = driver.switchTo().window(curWin).getTitle();
			if(actTitle.contains(expTitle))
				break;
		}
	}
	public void switchToWindow(WebDriver driver, Set<String> handles, String parentID)
	{
		parentID=driver.getWindowHandle();
		for(String handle:handles)
		{
			driver.switchTo().window(handle);
			if(!(handle.equals(parentID)))
				break;
					
		}
	}
	//frames
	public void switchtoChildFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchtoChildFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	public void switchtoChildFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	public void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	//Alerts
	public void acceptAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void getTextFromAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	public void enterValueIntoAlertTextfield(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	//JavaScript Executor
	
	public JavascriptExecutor javaScriptExecutor(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js;
	}
	
	public void scrollHeight(WebDriver driver)
	{
		javaScriptExecutor(driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollUntilEleIsVisibleJSE(WebDriver driver,WebElement element)
	{
		javaScriptExecutor(driver).executeScript("arguments[0].scrollIntoView()", element);
	}
	public void clickOnTheElementJSE(WebDriver driver,WebElement element)
	{
		javaScriptExecutor(driver).executeScript("arguments[0].click()", element);
	}
	public void enterValueIntoTextfieldJSE(WebDriver driver,WebElement element, String value)
	{
		javaScriptExecutor(driver).executeScript("arguments[0].value=arguments[1]",element,value);
	}
	public void scrollToEleUsingXYCordinate(WebDriver driver,WebElement element)
	{
		Point loc = element.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		javaScriptExecutor(driver).executeScript("window.scrollBy("+x+","+y+")");
	}
	
	

}
