package dataDrivenTesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchData_Excel {

	public static void main(String[] args) throws Throwable {
		
		//S1:- Path connection of the physical excel file
		
	FileInputStream fis = new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\ExcelTestData_VTiger.xlsx");
		//S2: keep excel in read mode
	Workbook book = WorkbookFactory.create(fis);
		//S3: get control of the sheet
	Sheet sheet = book.getSheet("Sheet1");
		//S4: get control of the row
	Row row = sheet.getRow(6);
		//S5: get control of the column
	Cell cell = row.getCell(1);
	//S6: get value of the Cell
	String ExcelData = cell.getStringCellValue();
		//S7: print the value 
	System.out.println(ExcelData);
	
	
	Row row1 = sheet.getRow(3);
	Cell cell1 = row1.getCell(0);
String phone = cell1.getStringCellValue();
System.out.println(phone);
	}

}
