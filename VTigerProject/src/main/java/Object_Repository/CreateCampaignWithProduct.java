package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignWithProduct {
	
	public CreateCampaignWithProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	//Locators
	@FindBy(css="[alt='Create Product...']")
	private WebElement createPdt;
	
	@FindBy(name="productname")
	private WebElement enterPdtName;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitPdt;
	
	@FindBy(css="[alt='Create Campaign...']")
	private WebElement createCampaign;
	
	@FindBy(name="campaignname")
	private WebElement enterCampaignName;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement plusSignProduct;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	
	//getter methods
	public WebElement getCreatePdt() {
		return createPdt;
	}

	public WebElement getEnterPdtName() {
		return enterPdtName;
	}

	public WebElement getSubmitPdt() {
		return submitPdt;
	}

	public WebElement getCreateCampaign() {
		return createCampaign;
	}

	public WebElement getEnterCampaignName() {
		return enterCampaignName;
	}

	public WebElement getPlusSignProduct() {
		return plusSignProduct;
	}
	public WebElement getSaveButton() {
		return saveButton;
		
	}
	
	//Business logic
	/**below methods is used to create campaign with product
	 * @author Jemimah
	 */
public void createProduct()
{
	createPdt.click();
}
public void enterProductName(String name) {
	enterPdtName.sendKeys(name);
}
public void submitProduct() {
	submitPdt.click();
}
public void createCampaign() {
createCampaign.click();
}
public void enterCampaignName(String campaignName) {
	enterCampaignName.sendKeys(campaignName);
}
public void clickOnPlusSign() {
	plusSignProduct.click();
}
public void clickOnSaveButton() {
	saveButton.click();
}

}
