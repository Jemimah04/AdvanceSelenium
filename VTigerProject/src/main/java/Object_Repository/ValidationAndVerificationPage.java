package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage {

	public ValidationAndVerificationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**this method is used to validate the testcase:-TestCase3_CreateCampaign
	 * @author Jemimah
	 * @param driver
	 * @param campName
	 */
	public void Validation(WebDriver driver, String campName)
	{
		String actualCampName = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		if(actualCampName.contains(campName))
		{
			System.out.println("Campaign is created");
		}
		else
		{
			System.out.println("Campaign not created");
		}
	}
	
	/**This method is used to validate the Testcase:-TestCase4_CampaignWithProduct
	 * @author Jemimah
	 */
	public void ValidationCampProduct(WebDriver driver, String campName, String prodData ) {
		String actualCampName=driver.findElement(By.id("dtlview_Campaign Name")).getText();
		String actualPrdtName = driver.findElement(By.id("dtlview_Product")).getText();
		if(actualCampName.contains(campName)&& actualPrdtName.contains(prodData))
		{
			System.out.println("Campaign is created with Product");
		}
		else
		{
			System.out.println("Campaign with Product creating test case got failed");
		}
	}
	
	/**this method is used to validate the test case:- TestCase1_CreateOrganization
	 * @author Jemimah
	 */
	public void ValidateOrganizationCreated(WebDriver driver, String OrganizationName) {
		String actOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actOrgName.contains(OrganizationName))
		{
			System.out.println("Organzation created ");
		}
		else
			System.out.println("Organization is not created");
		
	}
	
}
