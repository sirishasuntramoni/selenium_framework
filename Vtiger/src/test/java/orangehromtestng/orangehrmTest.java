package orangehromtestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
 * open application
 * test logo presence
 * login
 * close
 */


public class orangehrmTest
{
	WebDriver driver;
	@Test(priority=1)
	void open()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	void testLogo()
	{
		boolean status=driver.findElement(By.xpath("//img[@src='/web/images/ohrm_branding.png?v=1721393199309']")).isDisplayed();
		System.out.println("logo is displayed");
	}
	
	@Test(priority=3)
	void login() 
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(priority=4)
	void logout() 
	{
		driver.quit();
	}
	
}
