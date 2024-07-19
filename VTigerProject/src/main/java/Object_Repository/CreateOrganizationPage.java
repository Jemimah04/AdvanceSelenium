package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(css="[alt='Create Organization...']")
	private WebElement createOrg;
	
	@FindBy(name="accountname")
	private WebElement accountName;
	
	@FindBy(id="phone")
	private WebElement phoneNumber;
	
	@FindBy(name="email1")
	private WebElement emailID;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	//getter methods
	public WebElement getCreateOrg() {
		return createOrg;
	}

	public WebElement getAccountName() {
		return accountName;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getEmailID() {
		return emailID;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	/**this method is used to click on create organization link
	 * @author Jemimah 
	 */
	public void createOrg() {
		createOrg.click();
	}
	
	/**this method is used to enter the account name
	 * @author Jemimah 
	 */

	public void enterOrgData(String name, String phoneNum, String email) {
		accountName.sendKeys(name);	
		phoneNumber.sendKeys(phoneNum);
		emailID.sendKeys(email);
		
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}






}
