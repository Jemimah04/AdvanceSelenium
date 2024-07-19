package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[alt='Create Product...']")
	private WebElement createPrdt;
	
	@FindBy(name="productname")
	private WebElement prdtName;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement saveButton;

	public WebElement getCreatePrdt() {
		return createPrdt;
	}

	public WebElement getPrdtName() {
		return prdtName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 * this method is used to click on Create product
	 * @author Jemimah
	 */
	public void clickOnCreateProduct() {
		createPrdt.click();
	}
	
	/**
	 * this method is used to enter the product name
	 * @author Jemimah
	 */
	public void enterProductName(String name) {
		prdtName.sendKeys(name);
	}
	/**
	 * this method is used to click on save button
	 * @author Jemimah
	 */
	public void clickOnSaveButton(){
		saveButton.click();
	}
	
	
	
	
	
	
	
	
}
