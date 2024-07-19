package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class Vtiger_HomePage {
	
	//Initialising the constructor
	public Vtiger_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//declaration of elements
	@FindBy(linkText="Organizations")
	private WebElement Organizations;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement Products;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement More;
	
	@FindBy(name="Campaigns")
	private WebElement Campaigns;
	
	@FindBy(linkText="Contacts")
	private WebElement Contacts;

	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdmImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOut;
	
	
	
	//getter methods
	public WebElement getOrganizations() {
		return Organizations;
	}
	public WebElement getProducts() {
		return Products;
	}
	public WebElement getMore() {
		return More;
	}
	public WebElement getCampaigns() {
		return Campaigns;
	}
	public WebElement getContacts() {
		return Contacts;
	}
	public WebElement getAdmImg() {
		return AdmImg;
	}
	public WebElement getSignOut() {
		return signOut;
	}
	
	
	
	/**this method is to click on Organisation page
	 * @author Jemimah
	 */
	public void clickOrganizationLink() {
		Organizations.click();
	}
	/**this method is to click on Product page
	 * @author Jemimah
	 */
	public void clickProductsLink() {
		Products.click();
	}
	/**this method is to click on More page
	 * @author Jemimah
	 */
	public void clickMoreLink() {
		More.click();
	}
	/**this method is to click on Campaign page
	 * @author Jemimah
	 */
	public void clickCampaignsLink() {
		Campaigns.click();
	}
	/**this method is to click on Contacts page
	 * @author Jemimah
	 */
	public void clickContactsLink() {
		Contacts.click();
	}
	/**this method is to click on Administrator Image
	 * @author Jemimah
	 */
	public void clickAdmImg() {
		AdmImg.click();
	}
	/**this method is to click on Sign out page
	 * @author Jemimah
	 */
	public void clickOnSignOut() {
		signOut.click();
	}
	
	public void logout(WebDriver driver) {
		WebDriver_Utility wlib= new WebDriver_Utility();
		wlib.moveToElement(driver, AdmImg);
		signOut.click();
		
	}
	
}
