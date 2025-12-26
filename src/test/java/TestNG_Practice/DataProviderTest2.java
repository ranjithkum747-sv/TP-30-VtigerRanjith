package TestNG_Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtils;

public class DataProviderTest2
{
	@Test(dataProviderClass = DataProviderTest1.class, dataProvider = "products and price" )
	public void getData(String pn, int pr)
	{
		System.out.println("Product--> "+pn+" Price -->"+pr);
	}
	
	@DataProvider
	public Object[][] excelData() throws EncryptedDocumentException, IOException
	{
		ExcelUtils eLib = new ExcelUtils();
		Object[][] value = eLib.excelDataProvider("DataProvider");
		return value;
	}
	
//	public Object[][] excelData() throws EncryptedDocumentException, IOException
//	{
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\S-Excel.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("DataProvider");
//		int rowcou = sh.getLastRowNum()+1;
//		short cellcou = sh.getRow(0).getLastCellNum();
//		
//		Object[][] obj = new Object[rowcou][cellcou];
//		
//		for(int i=0;i<rowcou;i++)
//		{
//			for(int j=0; j<cellcou;j++)
//			{
//				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
//			}
//		}
//		return obj;
//		
//	}
	
	@Test(dataProvider = "excelData")
	public void getExcelData(String pn, String pr)
	{
		System.out.println(pn+"----->"+pr);
	}
	
}
