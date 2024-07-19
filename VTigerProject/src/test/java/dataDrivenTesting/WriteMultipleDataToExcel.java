package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.j2objc.annotations.Property;

public class WriteMultipleDataToExcel {
public static void main(String[] args) throws Throwable {
	
	FileInputStream fis= new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\PracticeExcel.xlsx");
	Properties prop= new Properties();
	prop.load(fis);
	Workbook book= WorkbookFactory.create(fis);
	Sheet sheet = book.getSheet("InsertData");
	
	
			
	
	
}
}
