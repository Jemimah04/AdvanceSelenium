package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContact {
	
	public CreateContact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Contacts")
	private WebElement createContactLink;
	
	@FindBy(css="[alt=\"Create Contact...\"]")
	private WebElement pluSign;
		
	@FindBy(name="lastname")
	private WebElement lastnameField;
	
	@FindBy(name="mobile")
	private WebElement mobileField;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	//getter methods
	public WebElement getCreateContactLink() {
		return createContactLink;
	}

	public WebElement getPluSign() {
		return pluSign;
	}

	public WebElement getLastnameField() {
		return lastnameField;
	}

	public WebElement getMobileField() {
		return mobileField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**this method is used to create contact with lastname and mobile number and save
	 * @author Jemimah
	 */
	public void clickOnContactsLink() {
		createContactLink.click();
	}
	
	public void clickOnPlusSign() {
		pluSign.click();
	}
	public void enterLastName(String lastName) {
		lastnameField.sendKeys(lastName);
	}
	public void enterMobileNum(String mobNum) {
		mobileField.sendKeys(mobNum);
	}
	public void clickOnSaveButton() {
		saveButton.click();
	}
}
