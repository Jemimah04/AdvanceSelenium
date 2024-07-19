package dataDrivenTesting;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart_xpathEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("phone");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
//		List<WebElement> allPhoneprices = driver.findElements(By.xpath("//div[@class=\"KzDlHZ\"]/../following-sibling::div//div[@class=\"Nx9bqj _4b5DiR\"]"));
//		
//		for (WebElement price : allPhoneprices) {
//			System.out.println("priceDetails="+price.getText());
//			
//			List<WebElement> phoneNames = driver.findElements(By.xpath("//div[@class=\"KzDlHZ\"]"));
//			
//			for (WebElement phone : phoneNames) {
//				System.out.println("phone name: "+phone.getText()+":price Details: "+price.getText());
//			}
		
		//another way to print phone and price together
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class=\"KzDlHZ\"]/../following-sibling::div//div[@class=\"Nx9bqj _4b5DiR\"]"));
		List<WebElement> phones = driver.findElements(By.xpath("//div[@class=\"KzDlHZ\"]"));
		for(int i=0; i<phones.size(); i++)
		{
			System.out.println(phones.get(i).getText()+"---"+prices.get(i).getText());
			
			
		}
		
				
			
		}
		
		
	}


