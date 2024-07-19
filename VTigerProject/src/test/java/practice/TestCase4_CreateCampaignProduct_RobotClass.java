//Login to vtiger application->mouseOverOn more Link->click on campaigns->
//click on create campaign lookup image->Enter campaignName->Click on Product plus img->Handle the 
//PopUp->Product name should be added to campaign createpage->
//click on save Btn->verify whether the campaign is created in campaign Information page and Logout from the application.

package practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase4_CreateCampaignProduct_RobotClass
{

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//login credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//use mouse over action to click on More 
				WebElement moreLink = driver.findElement(By.xpath("//a[text()='More']"));
				Actions act=new Actions(driver);
				act.moveToElement(moreLink).click().perform();
				driver.findElement(By.name("Campaigns")).click();
				Thread.sleep(2000);
			 WebElement campaign = driver.findElement(By.cssSelector("[alt='Create Campaign...']"));
			 campaign.click();	
			 driver.findElement(By.name("campaignname")).sendKeys("July10");
				driver.findElement(By.xpath("//img[@alt='Select']")).click();
				
				Thread.sleep(2000);
				//to take control of pop up window, use Robot class
			 Robot rob= new Robot();
			 rob.keyPress(KeyEvent.VK_TAB);
			 rob.keyRelease(KeyEvent.VK_TAB);
			 Thread.sleep(2000);
			 rob.keyPress(KeyEvent.VK_TAB);
			 rob.keyRelease(KeyEvent.VK_TAB);
			 Thread.sleep(2000);
			 rob.keyPress(KeyEvent.VK_TAB);
			 rob.keyRelease(KeyEvent.VK_TAB);
			 Thread.sleep(2000);
			 rob.keyPress(KeyEvent.VK_TAB);
			 rob.keyRelease(KeyEvent.VK_TAB);
			 Thread.sleep(2000);
			 rob.keyPress(KeyEvent.VK_TAB);
			 rob.keyRelease(KeyEvent.VK_TAB);
			 Thread.sleep(2000);
			 rob.keyPress(KeyEvent.VK_TAB);
			 rob.keyRelease(KeyEvent.VK_TAB);
			 Thread.sleep(2000);
			 rob.keyPress(KeyEvent.VK_ENTER);
			 rob.keyRelease(KeyEvent.VK_ENTER);
			 
			 driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			 						
	}

}
