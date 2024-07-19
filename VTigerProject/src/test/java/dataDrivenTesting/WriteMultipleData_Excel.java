package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteMultipleData_Excel {

	public static void main(String[] args) throws Throwable {
		//S1: connection path to excel file
//				FileInputStream fis = new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\ExcelTestData_VTiger.xlsx");
//				//S2: keep excel file in read mode
//				Workbook book = WorkbookFactory.create(fis);
//				//S3: get control of sheet
//				Sheet sheet = book.getSheet("Sheet3");
//				//S4: to print all links from amazon webpage to excel
//				WebDriver driver= new ChromeDriver();
//				driver.get("https://www.amazon.in/");
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//				
//				List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
				
//				//to print all the links in each row , we need to iterate row number. so use for loop
//				for (int i = 0; i <allLinks.size(); i++)
//				{
//					Row row = sheet.createRow(i);
//					Cell cell = row.createCell(0); //to write links in first column, so cell is 0
//					cell.setCellValue(allLinks.get(i).getAttribute("href"));
//					String data = cell.getStringCellValue();
//					System.out.println(data);
//				
//				}
//				
//				//S5: excel  sheet in write mode
//				FileOutputStream fos = new FileOutputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\ExcelTestData_VTiger.xlsx");
//				
//				book.write(fos);
//				book.close();
//		
				//instead of line 41,42 we write like this.
				FileInputStream fis = new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\ExcelTestData_VTiger.xlsx");
				Workbook book = WorkbookFactory.create(fis);//read mode
				Sheet sheet = book.getSheet("Sheet3");//control to sheet
				int rowNum= sheet.getLastRowNum();// need to print till last row . so we need lastRowNum()
				//System.out.println(rowNum);
				
				for(int i=0; i<=rowNum; i++)//i=0, i=1
				{
					Row row=sheet.getRow(i);
					//to get cell value
					for(int j=0; j<row.getLastCellNum(); j++)  //since only row is increemented, and cell is 0  , the last cellnum is 0 only. 
					{
						Cell cell=row.getCell(j); //j=0 i=0  //j=0, i=1
						String link = cell.getStringCellValue(); // (0,0) data is taken and printed  (1,0) data is printed....
						System.out.println(link);
						//instead of 66,67 lines, use dataformatter
						DataFormatter format = new DataFormatter();
						String data = format.formatCellValue(cell);
						System.out.println(data);
						
					}
				}

	}

}
