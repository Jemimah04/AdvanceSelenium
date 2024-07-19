package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase5_deleteAllProducts {
	//Dynamic xpath to select the products and delete it 
	
	@Test(groups ="regressionTest")
	
	public void clickOnCheckBoxes() {
		
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr//td//input[@name=\"selectall\"]")).click();
		driver.findElement(By.cssSelector("[value=\"Delete\"]")).click();
		
		driver.switchTo().alert().accept();
		

	}
}
