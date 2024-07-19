package dataDrivenTesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingData_PropertyFile {

	public static void main(String[] args) throws Throwable {
		
		
		
		//FileInputStream fis = new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\PropertiesFileData.properties");
		//to fetch data from file which is pasted in src/test/resources
		
		
		FileInputStream fis=new FileInputStream("./src/test/resources/PropertiesFileData.properties");
		
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String URL = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("btn_action")).click();
		driver.close();
	
	}

}
