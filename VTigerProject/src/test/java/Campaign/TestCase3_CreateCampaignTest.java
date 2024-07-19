//Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image->Enter campaignName->
//click on save Btn->verify whether the campaign is created in campaign Information page and Logout from the application. 

package Campaign;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Generic_Utilities.BaseClass;
import Object_Repository.Create_Campaign;
import Object_Repository.Vtiger_HomePage;
//@Listeners(Generic_Utilities.ListenerImplementation.class)
public class TestCase3_CreateCampaignTest extends BaseClass{
	@Test
	//@Test(retryAnalyzer = Generic_Utilities.RetryAnalyserImp.class)
		public void testCase3_CreateCampaignTest()  throws Throwable {
		//use mouse over action to click on More 
		Vtiger_HomePage Home=new Vtiger_HomePage(driver);
		Home.clickMoreLink();
		Home.clickCampaignsLink();
		Thread.sleep(2000);
		 
		Create_Campaign campPage = new Create_Campaign(driver);
		campPage.clickonPlusSgin();
		//Assert.assertEquals(true, false);
		//to create random number
		//get the Random number method from Java_Utility class
		int ranNum = jlib.getRandomNumber();
		//fetch campaign name from excel	
		String campName = elib.getExcelData("Campaign", 0, 0)+ranNum;
		campPage.enterCampName(campName);
		Thread.sleep(2000);
		campPage.clickOnSaveButton();
		Thread.sleep(2000);
//		ValidationAndVerificationPage validationPage = new ValidationAndVerificationPage(driver);
//		validationPage.Validation(driver, campName);
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
		System.out.println(actData);
		Assert.assertEquals(actData, campName);

	}
	

}
