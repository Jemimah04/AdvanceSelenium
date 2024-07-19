package dataDrivenTesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataUsingDataFormatter {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\ExcelTestData_VTiger.xlsx");
			//S2: keep excel in read mode
		Workbook book = WorkbookFactory.create(fis);
			//S3: get control of the sheet
		Sheet sheet = book.getSheet("Sheet1");
			//S4: get control of the row
		Row row = sheet.getRow(3);
			//S5: get control of the column
		Cell cell = row.getCell(0);
		
	DataFormatter format = new DataFormatter();
String phoneNumber = format.formatCellValue(cell);
		System.out.println(phoneNumber);
		
		
	}

}
