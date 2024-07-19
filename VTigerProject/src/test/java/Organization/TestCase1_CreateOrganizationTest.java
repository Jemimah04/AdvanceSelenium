//1. Login to vtiger application->click on organizations link->click on 
//create organization lookup image->Enter organisation name,phone number and email->click on save Btn->verify whether the organization is created in Organization Information page 
//and Logout from the application

package Organization;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Generic_Utilities.BaseClass;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.Create_Campaign;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.Vtiger_HomePage;
//@Listeners(Generic_Utilities.ListenerImplementation.class)
public class TestCase1_CreateOrganizationTest extends BaseClass{

//@Test(groups ={"smokeTest", "regressionTest"})
	@Test
	public void testCase1_CreateOrganizationTest() throws Throwable {
				
		Vtiger_HomePage HomePage = new Vtiger_HomePage(driver);
		HomePage.clickOrganizationLink();
		Thread.sleep(2000);
		
		CreateOrganizationPage org = new CreateOrganizationPage(driver);
		org.createOrg();
		//get the Random number method from Java_Utility class
		int ranNum = jlib.getRandomNumber();
		//fetch Organization name from excel-->enter organization name, ph, mail and save
		String OrganizationName = elib.getExcelDataUsingDataFormatter("Organization", 1, 0)+ranNum;
		String email = elib.getExcelDataUsingDataFormatter("Organization", 1, 1);
		String phoneNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 2);
		org.enterOrgData(OrganizationName, phoneNum, email);
		Thread.sleep(2000);
		org.clickOnSaveButton();
		//Validation
		ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
		validate.ValidateOrganizationCreated(driver, OrganizationName);
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
		System.out.println(actData);
		Assert.assertEquals(actData,OrganizationName );
		
	}
	//@Test(groups ="smokeTest")
	@Test
	public void testCase3_CreateCampaignTest()  throws Throwable {
		//use mouse over action to click on More 
		Vtiger_HomePage Home=new Vtiger_HomePage(driver);
		Home.clickMoreLink();
		Home.clickCampaignsLink();
		Thread.sleep(2000);
		Create_Campaign campPage = new Create_Campaign(driver);
		campPage.clickonPlusSgin();
		//to create random number
		//get the Random number method from Java_Utility class
		int ranNum = jlib.getRandomNumber();
		//fetch campaign name from excel	
		String campName = elib.getExcelData("Campaign", 0, 0)+ranNum;
		campPage.enterCampName(campName);
		Thread.sleep(2000);
		//Assert.assertEquals(true, false);
		campPage.clickOnSaveButton();
		Thread.sleep(2000);
		ValidationAndVerificationPage validationPage = new ValidationAndVerificationPage(driver);
		validationPage.Validation(driver, campName);
	}
}
