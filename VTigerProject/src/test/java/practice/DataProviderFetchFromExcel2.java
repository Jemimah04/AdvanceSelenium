package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateContact;
import Object_Repository.VTiger_LoginPage;
import Object_Repository.Vtiger_HomePage;


public class DataProviderFetchFromExcel2 {
	@Test(dataProvider = "getDataFromExcel")
	public void createCampaign(String lastName, String mobNum) throws Throwable {
		
		//open the browser and enter the url
		File_Utility flib = new File_Utility();
		String browser = flib.getKeyAndValuePair("browser");
		WebDriver driver;
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			driver= new ChromeDriver();
		}
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.implicitly_Wait(driver);
		
		String URL = flib.getKeyAndValuePair("url");
		String Username = flib.getKeyAndValuePair("username");
		String Password = flib.getKeyAndValuePair("password");
		
		VTiger_LoginPage login = new VTiger_LoginPage(driver);
		driver.get(URL);
		login.loginVTigerApp(Username, Password);
		login.getLoginButton();
		
		CreateContact contact = new CreateContact(driver);
		contact.clickOnContactsLink();
		contact.clickOnPlusSign();
		Java_Utility jlib = new Java_Utility();
		int ranNum=jlib.getRandomNumber();
		contact.enterLastName(lastName+ranNum);
		contact.enterMobileNum(mobNum);
		contact.clickOnSaveButton();
		Thread.sleep(2000);
		Vtiger_HomePage home = new Vtiger_HomePage(driver);
		home.logout(driver);
		driver.quit();
		
		
}
	@DataProvider
	public Object[][] getDataFromExcel() throws Throwable{
		Excel_Utility elib = new Excel_Utility();
		Object[][] data=elib.readDataFromDataProvider("Contact");
		return data;
	}
}
