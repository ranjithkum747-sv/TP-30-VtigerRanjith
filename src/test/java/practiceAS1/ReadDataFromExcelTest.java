package practiceAS1;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest
{
	public static void main(String[] args) throws Exception
	{
		//1.getting the path
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\TekPy.xlsx");
		
		//2.open the file
		Workbook wb= WorkbookFactory.create(fs);
		
		//3.get sheet
		Sheet sh = wb.getSheet("Sheet1");
		
		//4. get row
		Row r = sh.getRow(0);
		
		//5.get cell
		Cell cel = r.getCell(0);
		String company= cel.getStringCellValue();
		
		//6.get bangalore location
		String place = r.getCell(1).getStringCellValue();
		
		System.out.println(company);
		System.out.println(place);
		
	}

}
