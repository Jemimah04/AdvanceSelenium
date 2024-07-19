	package product;
	//create product and delete the same product which was created
import org.testng.annotations.Test;
import Generic_Utilities.BaseClass;
import Object_Repository.CreateProductPage;
import Object_Repository.Create_DeleteProduct;
import Object_Repository.Vtiger_HomePage;

public class Testcase5_CretaProduct_DeleteProductTest extends BaseClass {
	//@Test(groups ="regressionTest")
	@Test
	public void testcase5_CretaProduct_DeleteProductTest() throws Throwable {
	
		//go to products to add product
		Vtiger_HomePage Home=new Vtiger_HomePage(driver);
		Home.clickProductsLink();
		CreateProductPage createPrdt = new CreateProductPage(driver);
		createPrdt.clickOnCreateProduct();
		//get the Random number method from Java_Utility class
		int ranNum = jlib.getRandomNumber();
		//fetch product name from excel
		String prodData = elib.getExcelData("Product", 1, 0)+ranNum;
		//to add productname and save
		createPrdt.enterProductName(prodData);
		createPrdt.clickOnSaveButton();
		Thread.sleep(2000);
		//again go to products and search and delete the created product
		Home.clickProductsLink();
		Create_DeleteProduct deleteProduct=new Create_DeleteProduct(driver);
		deleteProduct.selectProductCheckBox(driver, prodData);
		deleteProduct.deleteProduct();
		//handle the alert pop up
		wlib.alertAccept(driver);
		deleteProduct.validateDeleteProduct(driver, prodData);
		Thread.sleep(2000);
		 
		}
		}

