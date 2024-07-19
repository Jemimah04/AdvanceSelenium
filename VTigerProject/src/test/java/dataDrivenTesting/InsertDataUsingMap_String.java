package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataUsingMap_String {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\ExcelTestData_VTiger.xlsx");
		//S2: keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		//S3: get control of sheet
		Sheet sheet = book.getSheet("Sheet4");
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("10", "Tryphena");
		map.put("20", "Tryphosa");
		map.put("30", "Osteen");
		map.put("40", "Leah");
		
		int rowNum=0;
		
		for (Entry<String, String> m : map.entrySet()) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue((String)m.getKey());
			row.createCell(1).setCellValue((String)m.getValue());
			
		}
	FileOutputStream fos = new FileOutputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\ExcelTestData_VTiger.xlsx");
	book.write(fos);
	book.close();
	
	}

}
