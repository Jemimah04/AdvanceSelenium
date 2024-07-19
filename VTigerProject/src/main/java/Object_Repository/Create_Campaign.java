package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Campaign {

	public Create_Campaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement plusSign;
	
	@FindBy(name="campaignname")
	private WebElement campName;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	//getters method
	
	public WebElement getPlusSign() {
		return plusSign;
	}

	public WebElement getCampName() {
		return campName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * this method is used to create campaign
	 * @author Jemimah
	 */
	public void clickonPlusSgin() {
		plusSign.click();
	}
	
	public void enterCampName(String name) {
		campName.sendKeys(name);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	
	
	
	
	
}