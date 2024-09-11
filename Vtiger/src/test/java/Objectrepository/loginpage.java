[package Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	//initialization
	public loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(name="user_name")
	private WebElement userTextField;
	
	@FindBy(name="user_password")
	private WebElement passWordTextfield;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	
	//getter methods
	public WebElement getUserTextField() {
		return userTextField;
		
	}
	
	public WebElement getPasswordTextField()
	{
		return passWordTextfield;
		
	}
	
	public WebElement getloginButton()
	{
		return loginButton;
	}
	
	public void loginToApp(String userName, String passWord)
	{
		userTextField.sendKeys(userName);
		passWordTextfield.sendKeys(passWord);
		loginButton.click();
	}
	

}
