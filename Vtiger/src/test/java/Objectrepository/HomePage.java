package Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement OrgLink;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdminLink;
	
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOut;
	
	/*public WebElement getOrgLink() {
	return OrgLink;
	}
	
	public WebElement getAdminLink() {
		return AdminLink;
		
	}
	
	public WebElement getClickOnSignOut() {
		return signOut;
	}
	*/
	
	/**this method is used to sign out from application
	 * using mouse action/hover
	 * @param driver
	 */
	
	public void signOutApp(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(AdminLink).perform();
		signOut.click();
	}
	public void logOutFromApp()
	{
		AdminLink.click();
		signOut.click();
	}
}
