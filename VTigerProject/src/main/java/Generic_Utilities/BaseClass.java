package Generic_Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.mysql.jdbc.Driver;

import Object_Repository.VTiger_LoginPage;
import Object_Repository.Vtiger_HomePage;

public class BaseClass {
	
	public WebDriver driver;
	//re-initialize the driver
	public static WebDriver sDriver;
	
	public File_Utility flib = new File_Utility();
	public Java_Utility jlib = new Java_Utility();
	public Excel_Utility elib = new Excel_Utility();
	public WebDriver_Utility wlib = new WebDriver_Utility();
	@BeforeSuite
	public void BS() throws Throwable {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		System.out.println("DataBase connection is ready");
	}
	
	@BeforeTest(groups ={"smokeTest", "regressionTest"})
	public void BT() {
		System.out.println("Parallel execution setup is ready");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups ={"smokeTest", "regressionTest"})
	public void BC() throws Throwable {
		//reading browser value from cmd
//	String Browser  = System.getProperty("browser");
//	System.getProperty("url");
//		System.out.println(Browser);
		
		String Browser = flib.getKeyAndValuePair("browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else 
			if(Browser.equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
			}
			else if(Browser.equalsIgnoreCase("firefox"))
			{
				driver= new FirefoxDriver();
			}
			else
			{
				driver=new ChromeDriver();//if no browsers given in the pair, by default chrome will open
			}
		
		sDriver=driver;//since we cant use the driver for listenerImplementation, we re-initialise the driver
		System.out.println("to launch the browser");
	}
	//@Parameters({"Username", "Password"})
	@BeforeMethod(groups ={"smokeTest", "regressionTest"})
	public void BM() throws Throwable {
		wlib.maximizeWindow(driver);
		wlib.implicitly_Wait(driver);
		//to get login credentials from cmd 
//		String url = System.getProperty("url");
//		String Username = System.getProperty("username");
//		String password = System.getProperty("password");
		//to get Login Credentials from Property file
		String URL = flib.getKeyAndValuePair("url");
		String Username=flib.getKeyAndValuePair("username");
		String password=flib.getKeyAndValuePair("password");
		driver.get(URL);
		//login credentials -- from pom class
		VTiger_LoginPage Login = new VTiger_LoginPage(driver);
		Login.loginVTigerApp(Username, password);
		System.out.println("to login to the application");
	}
	@AfterMethod(groups ={"smokeTest", "regressionTest"})
	public void AM() {
		Vtiger_HomePage Home=new Vtiger_HomePage(driver);
		Home.logout(driver);
		System.out.println("Application is logged out");
	}
	@AfterClass(groups ={"smokeTest", "regressionTest"})
	public void AC() {
		driver.close();
		System.out.println("Browser is closed");
	}
	@AfterTest(groups ={"smokeTest", "regressionTest"})
	public void AT() {
		System.out.println("Parallel execution is done");
	}
	@AfterSuite(groups ={"smokeTest", "regressionTest"})
	public void AS() throws Throwable {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details","root","jemi");
		conn.close();
		System.out.println("DataBase connection is closed");
	}
	
	
	
}
