package practice;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 {
//how to call the datas using dataprovider annotation
	@Test(dataProvider="getData")
	public void createOrganization(String orgName, String phNum, String email) throws Throwable {
		
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys(phNum);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr= new Object[3][3];
		Random ran= new Random();
		int ranNum = ran.nextInt();
		objArr[0][0]= "AAA"+ranNum;
		objArr[0][1]="4562382992";
		objArr[0][2]="abc@gmail.com";
		
		objArr[1][0]="BBB"+ranNum;
		objArr[1][1]="38479348231";
		objArr[1][2]="efg@gmail.com";
		
		objArr[2][0]="CCC"+ranNum;
		objArr[2][1]="23479348231";
		objArr[2][2]="hij@gmail.com";
		
		
		
		return objArr;
		
	}
	
}
