package practiceAS1;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultiple1ValuesFromEXcelTest
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\TekPy Sh2.xlsx");
		
		Workbook wb= WorkbookFactory.create(fs);
		Sheet sh = wb.getSheet("Sheet2");
		
		int lastrow= sh.getLastRowNum();
		System.out.println(lastrow);
		int lastcell= sh.getRow(lastrow).getLastCellNum();
		System.out.println(lastcell);
		for(int i=0; i<=lastrow; i++)
		{
			for(int j=0; j<lastcell;j++)
			{
				System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
				
			}
			System.out.println();
		}
		
	}

}
