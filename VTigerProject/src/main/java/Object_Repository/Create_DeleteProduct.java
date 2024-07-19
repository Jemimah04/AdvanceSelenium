package Object_Repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Create_DeleteProduct {
 public Create_DeleteProduct(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 
@FindBy(xpath="//input[@value=\"Delete\"]")
 private WebElement deletePrdt;

 //getter method
public WebElement getDeletePrdt() {
	return deletePrdt;
}

 //Dynamic xpath method
 public void selectProductCheckBox(WebDriver driver, String prodData) {
	 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prodData+"']/../preceding-sibling::td/input[@type='checkbox']")).click();	
		 
 }
 
 public void deleteProduct() {
	 deletePrdt.click(); 
 }
 
 /**this method is used to validate whether the product is deleted or not
  * @author Jemimah
  */
 public void validateDeleteProduct(WebDriver driver, String prodData) {
	 List<WebElement> allNames = driver.findElements(By.xpath("(//table[@class=\"lvt small\"]/tbody/tr//td[3])[position()>1]"));
		boolean flag=false;

		for(WebElement allProducts:allNames)
		{
		String actData = allProducts.getText();
		if(actData.equals(prodData))
		{
			flag=true;
			break;
		}
		}
		if(flag)
		{
			System.out.println("Product is deleted");
		}
		else
		System.out.println("Product not deleted");
 }
}
