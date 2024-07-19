package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampWtihProductWindowSwitching {

	public CampWtihProductWindowSwitching(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(name="search_text")
	private WebElement searchText;
	
	@FindBy(name="search")
	private WebElement search;

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearch() {
		return search;
	}
	
	
	/**this method is for dynamic xpath 
	 * @author Jemimah
	 */
	public void searchText(String name) {
		searchText.sendKeys(name);
	}
	public void productDynamicElement(WebDriver driver, String data) {
		 driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
		
	}
	
	
}
