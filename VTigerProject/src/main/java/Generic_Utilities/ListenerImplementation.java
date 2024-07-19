package Generic_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNumber();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sDriver; //since sDriver is static , we use classname to call the variable
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/failedScript+"+ranNum+".png");
		try {
			FileUtils.copyFile(src, dest);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
