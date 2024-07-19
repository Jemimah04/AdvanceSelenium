package dataDrivenTesting;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchDataFromJsonFile {

	public static void main(String[] args) throws Throwable {
		File file=new File("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\JsonData.json");
		ObjectMapper jsonData = new ObjectMapper();
		JsonNode data = jsonData.readTree(file); //select readTree(file);
	
		String URL = data.get("url").asText();
		String UserName=data.get("username").asText(); //give fieldName as how it is given in the json file 
		String Password=data.get("password").asText();
		
		
		WebDriver driver= new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys(UserName);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("login-button")).click();
	}
}
