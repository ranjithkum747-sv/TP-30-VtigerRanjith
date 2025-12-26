package genericUtilities;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils
{
	/**
	 * This method is used to read a single value from the excel
	 * @author Arvind
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readSingleDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to read multiple data from the excel file
	 * @author Arvind
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public ArrayList<String> readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int LastRow = sh.getLastRowNum();
		int LastCell = sh.getRow(0).getLastCellNum();
		
		ArrayList<String> list= new ArrayList<String>();
				
		for(int i=0;i<=LastRow;i++)
		{
			for(int j=0;j<LastCell;j++)
			{
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				list.add(value);
			}
		}
		
		return list;
	}
	
	/**
	 * This method is used to get the row count in a excel file
	 * @author Arvind
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	
	
	/**
	 * This method is used to get the cell count in the excel file
	 * @author Arvind
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getCellCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int cellCount = sh.getRow(0).getLastCellNum();
		return cellCount;
	}
	
	public void writeDataIntoExcel(String sheetName, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(0);
		Cell c = r.createCell(0);
		c.setCellType(CellType.STRING);
		c.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IpathConstants.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	public Object[][] excelDataProvider(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int rowcou = sh.getLastRowNum()+1;
		short cellcou = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowcou][cellcou];
		
		for(int i=0;i<rowcou;i++)
		{
			for(int j=0; j<cellcou;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}

}
