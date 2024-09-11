package Generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Objectrepository.HomePage;
import Objectrepository.loginpage;


public class baseclass {
	public WebDriver driver;
	@BeforeSuite(groups= {"smoke test","regression test"})
	public void BS()
	{
		System.out.println("database connection open");
		
	}
	
	@BeforeTest(groups= {"smoke test","regression test"})
	public void BT()
	{
		System.out.println("parallel execution");
		
	}
	
	@BeforeClass(groups= {"smoke test","regression test"})
	public void BC()
	{
	flib=new file_utility();
	String BROWSER=flib.getPropertiesData("Browser");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();	
	}
	else if (BROWSER.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();	
	}
	else
	{
		driver=new ChromeDriver();
	}
	System.out.println("browser launched");
	}
	
	@BeforeMethod(groups= {"smoke test","regression test"})
	public void BM()
	{
		file_utility flib=new file_utility();
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitPageToLoad(driver);
		
		
		//reading data from property file
		String URL=flib.getPropertiesData("URL");
		String USERNAME=flib.getPropertiesData("UserName");
		String PASSWORD=flib.getPropertiesData("PassWord");
		
		driver.get(URL);
		//using business logics
		loginpage login=new loginpage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		System.out.println("logon to apllication");
	}
	
	@AfterMethod(groups= {"smoke test","regression test"})
	public void AM()
	{
		HomePage home=new HomePage(driver);
		home.signOutApp(driver);
		System.out.println("logout from appliaction");
	}
	
	@AfterClass(groups= {"smoke test","regression test"})
	public void Ac()
	{
		driver.quit();
		System.out.println("close browser");
	}
	
	@AfterTest(groups= {"smoke test","regression test"})
	public void AT() {
		System.out.println("parallel execution done");
	}
	
	@AfterSuite(groups= {"smoke test","regression test"})
		public void AS()
		{
			System.out.println("close data base connection");
		}
}

		
