package practiceAS1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteMultipledatainExcelTest
{
	public static void main(String[] args) throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.flipkart.com/search?q=mobiles&as=on&as-show=on&otracker=AS_Query_TrendingAutoSuggest_1_0_na_na_na&otracker1=AS_Query_TrendingAutoSuggest_1_0_na_na_na&as-pos=1&as-type=TRENDING&suggestionId=mobiles&requestId=edddf2d3-14af-4a19-ad4c-651336f162d2");
		
//		driver.findElement(By.xpath("//input[@class='Pke_EE']")).clear();
//		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("mobiles",Keys.ENTER);
		
		List<WebElement> eles = driver.findElements(By.xpath("//div[@class='RG5Slk']"));
		
		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TekPy Sh2.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.createSheet("Sheet6");
		
		for(int i=0; i<eles.size();i++)
		{
			sh.createRow(i).createCell(0).setCellValue(eles.get(i).getText());
		}
		
		FileOutputStream fo= new  FileOutputStream(".\\src\\test\\resources\\TekPy Sh2.xlsx");
		wb.write(fo);
		
		wb.close();
		driver.quit();
		
	
	}

}
