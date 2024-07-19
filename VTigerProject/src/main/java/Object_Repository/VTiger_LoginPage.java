package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VTiger_LoginPage {
	
	//initialising the constructor
	public VTiger_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//declaration of Elements
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindBy(name="user_password")
	private WebElement PasswordField;
	
	@FindBy(id="submitButton")
	private WebElement LoginButton;

	//getter methods
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordField() {
		return PasswordField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	
	/**
	 * this method is used to login the application
	 */
	
	public void loginVTigerApp(String Username, String password ) {
		UserTextField.sendKeys(Username);
		PasswordField.sendKeys(password);
		LoginButton.click();
		
		
	}
	
	
	
	
	
	

}
