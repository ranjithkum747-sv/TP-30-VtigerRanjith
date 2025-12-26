package practiceAS1;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest 
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\TekPy (1).xlsx");
		
		Workbook wb= WorkbookFactory.create(fs);
		
		Sheet sh = wb.getSheet("Sheet2");
		
		int lastrow= sh.getLastRowNum();
		
		for(int i=0;i<=lastrow;i++)
		{
			System.out.println(sh.getRow(i).getCell(0).getStringCellValue()+"<====>"+sh.getRow(i).getCell(1).getStringCellValue());
		}
		
	}

}
