package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	/**
	 * This method is used to fetch data from Excel
	 * @param sheetName
	 * @param RowNum
	 * @param CellNum
	 * @return
	 * @throws Throwable
	 * @author Jemimah
	 */
	public String getExcelData(String sheetName, int RowNum, int CellNum) throws Throwable {
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\VTiger.xlsx");
		Workbook book = WorkbookFactory.create(fis1);	
		Sheet sheet = book.getSheet(sheetName);	
		Row row = sheet.getRow(RowNum);	
		Cell cell = row.getCell(CellNum);
		String ExcelData = cell.getStringCellValue();
		return ExcelData;
	}
	/**
	 * This method is used to fetch data from Excel using Data Formatter
	 * @param sheetName
	 * @param RowNum
	 * @param CellNum
	 * @return
	 * @throws Throwable
	 * @author Jemimah
	 */
	
	public String getExcelDataUsingDataFormatter(String SheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/VTiger.xlsx");
		//S2: keep excel in read mode
	Workbook book = WorkbookFactory.create(fis);
		//S3: get control of the sheet
	Sheet sheet = book.getSheet(SheetName);
		//S4: get control of the row
	Row row = sheet.getRow(rowNum);
		//S5: get control of the column
	Cell cell = row.getCell(cellNum);
	
DataFormatter format = new DataFormatter();
String cellFinalFormat = format.formatCellValue(cell);
	System.out.println(cellFinalFormat);
	return cellFinalFormat;
	}
	
	/**this method is used to add data from excel to DataProvider annotation
	 * @author Jemimah
	 * @throws Throwable 
	 * @throws Throwable 
	 */
	public Object[][]readDataFromDataProvider(String Sheetname) throws Throwable{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\VTiger.xlsx");
		Workbook book= WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(Sheetname);
		int lastRowNum = sheet.getLastRowNum()+1;
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArray= new Object[lastRowNum][lastCellNum];
		
		for(int i=0; i<lastRowNum; i++)
		{
			for(int j=0; j<lastCellNum; j++)
			{
				objArray[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return objArray;
		
	}
	
}
