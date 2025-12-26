package practiceAS1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDatainExcelTest
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TekPy Sh2.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet("Sheet3");
		sh.createRow(0).createCell(0).setCellValue(1000);
		sh.getRow(0).createCell(1).setCellValue("Hello");
		sh.createRow(1).createCell(0).setCellValue(2000);
		sh.getRow(1).createCell(1).setCellValue("Hi");
		
		//System.out.println(sh.getRow(0).getCell(0).getStringCellValue());
		
		DataFormatter df= new DataFormatter();
		String num = df.formatCellValue(sh.getRow(0).getCell(0));
		System.out.println(num);
		
		FileOutputStream fo= new FileOutputStream(".\\src\\test\\resources\\TekPy Sh2.xlsx");
		wb.write(fo);
		
		wb.close();		
	}

}
