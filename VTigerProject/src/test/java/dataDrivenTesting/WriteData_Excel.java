package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteData_Excel {

	public static void main(String[] args) throws Throwable {
		//S1: connection path to excel file
		FileInputStream fis = new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\ExcelTestData_VTiger.xlsx");
		//S2: keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		//S3: get control of sheet
		Sheet sheet = book.getSheet("Sheet1");
		//S4: get control of row
		Row row = sheet.createRow(5);
		//S5: get control of column
		Cell cell = row.createCell(3);
		//s6: enter the data to write on the excel
		 cell.setCellValue("Leah");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\ExcelTestData_VTiger.xlsx");
		
		book.write(fos);
		book.close();

	}

}
