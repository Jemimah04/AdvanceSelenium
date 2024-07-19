package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchMultipleData_Excel_AmazonLinks {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\Excel_TestData.xlsx");
		//S2: keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		//S3: get control of sheet
		Sheet sheet = book.getSheet("Sheet2");
		//S4: to print all links from amazon webpage to excel
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		//to print all the links in each row , we need to iterate row number. so use for loop
		for (int i = 0; i <allLinks.size(); i++)
		{
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0); //to write links in first column, so cell is 0
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
	}
	
	//S5: excel  sheet in write mode
	FileOutputStream fos = new FileOutputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\Excel_TestData.xlsx");
	
	book.write(fos);
	book.close();
	}
	
	

}
