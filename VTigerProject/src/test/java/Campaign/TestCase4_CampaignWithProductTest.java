package Campaign;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Generic_Utilities.BaseClass;
import Object_Repository.CampWtihProductWindowSwitching;
import Object_Repository.CreateCampaignWithProduct;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.Vtiger_HomePage;
//@Listeners(Generic_Utilities.ListenerImplementation.class)
public class TestCase4_CampaignWithProductTest extends BaseClass{
	@Test(groups ="smokeTest")
	//@Test
	public void testCase4_CampaignWithProductTest() throws Throwable {
	
		//go to products to add product
		Vtiger_HomePage Home=new Vtiger_HomePage(driver);
		Home.clickProductsLink();
		CreateCampaignWithProduct campaignWithProduct = new CreateCampaignWithProduct(driver);
		campaignWithProduct.createProduct();
		//get the Random number method from Java_Utility class
		int ranNum = jlib.getRandomNumber();
		//to fetch product name from excel
		String prodData = elib.getExcelData("Product", 0, 0)+ranNum;
		//enter product name adn save
		campaignWithProduct.enterProductName(prodData);
		campaignWithProduct.submitProduct();
		//go to campaign and create campaign 
		Home.clickMoreLink();
		Home.clickCampaignsLink();
		campaignWithProduct.createCampaign();
		String campName = elib.getExcelData("Campaign", 0, 0)+ranNum;
		campaignWithProduct.enterCampaignName(campName);
		campaignWithProduct.clickOnPlusSign();
			
		//to switch to product window
		wlib.windowHandling(driver, "Products&action");
		//Assert.assertEquals(true, false);
		CampWtihProductWindowSwitching Switching = new CampWtihProductWindowSwitching(driver);
		Switching.getSearchText();
		Switching.getSearch();
		Switching.productDynamicElement(driver, prodData);
		//to switch to main window
		wlib.windowHandling(driver, "Campaigns&action");
		campaignWithProduct.clickOnSaveButton();
		Thread.sleep(2000);
		ValidationAndVerificationPage Validate = new ValidationAndVerificationPage(driver);
		Validate.ValidationCampProduct(driver, campName, prodData);
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
		System.out.println(actData);
		Assert.assertEquals(actData, campName);
			
		
	}

}
