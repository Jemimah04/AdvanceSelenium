package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * this method is used to maximize the window
 * @author Jemimah
 *
 */
public class WebDriver_Utility {

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method is used to wait the elements to load implicitlyWait
	 * @param driver
	 */
	public void implicitly_Wait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * this method is used to handle multiple windows
	 * @param driver
	 * @param partial_Value
	 */
	public void windowHandling(WebDriver driver, String partial_Value ) {
		Set<String> wins1 = driver.getWindowHandles();
	    Iterator<String> it1 = wins1.iterator();
		 while(it1.hasNext())
	    {
	    	String win1 = it1.next();
	    	driver.switchTo().window(win1);
	    	String currentTitle1 = driver.getTitle();
	    if(currentTitle1.contains(partial_Value))
	    {
	    	break;
	    }}
		 
	}
	/**
	 * this method is used to accept the alert pop up
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method is used to dismiss the alert pop up
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**this method is used for action class to perform mouse over action
	 * @author Jemimah
	 */
	
	public void moveToElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public static String takeScreenShot(WebDriver driver, String screenShotName) throws Throwable {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+screenShotName+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();	
	}
	
}
