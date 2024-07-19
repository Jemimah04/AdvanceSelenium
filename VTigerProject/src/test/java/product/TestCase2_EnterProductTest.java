//Login to vtiger application->click on products link->click on create product lookup image->
//Enter product name->click on save Btn->
//verify whether the product is created in product Information page and Logout from the application.

package product;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Generic_Utilities.BaseClass;
import Object_Repository.CreateProductPage;
import Object_Repository.Vtiger_HomePage;
//@Listeners(Generic_Utilities.ListenerImplementation.class)
public class TestCase2_EnterProductTest extends BaseClass {
	//@Test(groups ={"smokeTest", "regressionTest"})
	@Test
	public void testCase2_EnterProductTest() throws Throwable {
	
		//click on Product module
		Vtiger_HomePage HomePage = new Vtiger_HomePage(driver);
		HomePage.clickProductsLink();
		CreateProductPage createPrdt = new CreateProductPage(driver);
		createPrdt.clickOnCreateProduct();
		int ranNum = jlib.getRandomNumber();
		String productData = elib.getExcelData("Product", 2, 0)+ranNum;
		//Assert.assertEquals(true, false);
		createPrdt.enterProductName(productData);
		createPrdt.clickOnSaveButton();
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
		System.out.println(actData);
		Assert.assertEquals(actData, productData);
	}
}
