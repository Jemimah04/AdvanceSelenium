package practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utilities.BaseClass;
import Object_Repository.Create_Campaign;
import Object_Repository.Vtiger_HomePage;

public class SoftAssertEx extends BaseClass {
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
			campPage.clickOnSaveButton();
			Thread.sleep(2000);
			
//			ValidationAndVerificationPage validationPage = new ValidationAndVerificationPage(driver);
//			validationPage.Validation(driver, campName);
			String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
			System.out.println(actData);
			//Assert.assertEquals(actData, campName); hardassert
			SoftAssert soft= new SoftAssert();
			//soft.assertEquals(actData, campName);
			//soft.assertTrue(actData.contains(campName),campName+"Campaign name not created");
			soft.assertTrue(actData.contains(campName));
			soft.assertAll(); //this line is must for all softassert . shd be given at the end
			
		
		}
		public void test()
		{
			System.out.println("test1 updated");
		}
	}
	
