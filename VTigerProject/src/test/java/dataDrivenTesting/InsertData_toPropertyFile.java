package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertData_toPropertyFile {

	public static void main(String[] args) throws Throwable {
		//to write data into excel---> first do fileinputstream , then go to write mode that is set. then store in fileoutputstream.
		FileInputStream fis= new FileInputStream("./src/test/resources/PropertiesFileData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		pro.setProperty("URL", "https://www.saucedemo.com/v1/");
		pro.setProperty("UserName", "standard_user");
		pro.setProperty("Password", "secret_sauce");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/PropertiesFileData.properties");
		
		pro.store(fos, "CommonData");
		System.out.println("data added");
		
		//----------------------------//
	//to read data from that stored file
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/PropertiesFileData.properties");
		pro.load(fis1);
		
		String url = pro.getProperty("URL");
		String UserName1 = pro.getProperty("UserName");
		String Password1 = pro.getProperty("Password");
		
		WebDriver driver= new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("user-name")).sendKeys(UserName1);
		driver.findElement(By.id("password")).sendKeys(Password1);
		driver.findElement(By.id("login-button")).click();
		
		
		
		

	}

}
