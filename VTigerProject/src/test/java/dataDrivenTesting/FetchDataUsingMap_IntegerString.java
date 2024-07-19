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

public class FetchDataUsingMap_IntegerString {
	
		public static void main(String[] args) throws Throwable {
			// TODO Auto-generated method stub
			FileInputStream fis = new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\ExcelTestData_VTiger.xlsx");
			//S2: keep excel file in read mode
			Workbook book = WorkbookFactory.create(fis);
			//S3: get control of sheet
			Sheet sheet = book.getSheet("Sheet5");
			
			LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
			map.put(100, "Tryphena");
			map.put(200, "Tryphosa");
			map.put(304, "Osteen");
			map.put(405, "Leah");
			
			int rowNum=0;
			
			for (Entry<Integer, String> m : map.entrySet()) {
				Row row=sheet.createRow(rowNum++);
				row.createCell(0).setCellValue((Integer)m.getKey());
				row.createCell(1).setCellValue((String)m.getValue());
				
			}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\ExcelTestData_VTiger.xlsx");
		book.write(fos);
		book.close();
		
		}

	}



