package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.Vtiger_HomePage;

//go to contacts --create new contact---add organization name and save and logout
public class TestCase_CreateContactWithOrganization {

	public static void main(String[] args) throws Throwable {
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility flib = new File_Utility();
		
		//S1: open browser and login 
		WebDriver driver;
		String Broswer = flib.getKeyAndValuePair("browser");
		if(Broswer.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else 
			if(Broswer.equalsIgnoreCase("edge"))
			{
				driver= new EdgeDriver();
			}
			else
				if (Broswer.equalsIgnoreCase("firefox"))
				{
					driver= new FirefoxDriver();
				}
				else
				{
					driver= new EdgeDriver();
				}
		String URL=flib.getKeyAndValuePair("url");
		driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.implicitly_Wait(driver);
		
		String username=flib.getKeyAndValuePair("username");
		String password= flib.getKeyAndValuePair("password");
		
		
		//login credentials
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//S2: go to Contacts page and create new Contacts
		Vtiger_HomePage home=new Vtiger_HomePage(driver);
		home.clickContactsLink();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
		//get the Random number method from Java_Utility class
		int ranNum = jlib.getRandomNumber();
		String contactName = elib.getExcelDataUsingDataFormatter("Contact", 0, 0)+ranNum;
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		//add organization name
		driver.findElement(By.xpath("(//img[@src=\"themes/softed/images/select.gif\"])[1]")).click();
		
		//switch to organization window
		wlib.windowHandling(driver, "Accounts&action");	
		driver.findElement(By.xpath("//a[text()=\"Qspiders969\"]")).click();
		Thread.sleep(2000);
		
		//to switch to main window
		wlib.windowHandling(driver, "Contacts&action");
		
		//to save and logout
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(2000);
		home.clickAdmImg();
		home.clickOnSignOut();
	}
}
