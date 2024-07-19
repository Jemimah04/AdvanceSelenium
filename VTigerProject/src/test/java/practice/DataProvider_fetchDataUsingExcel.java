package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;

public class DataProvider_fetchDataUsingExcel {

	@Test(dataProvider ="getReadData")
	public void createOrganization(String orgName, String phnNum, String email) throws Throwable {
		
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNumber();
		driver.findElement(By.name("accountname")).sendKeys(orgName+ranNum);
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		driver.quit();
			
	}
	@DataProvider
	public Object[][]getReadData() throws Throwable {
		 
		Excel_Utility elib = new Excel_Utility();
		Object[][] data = elib.readDataFromDataProvider("DataProviderDatas");
		return data;
	}
	
}
