package campaigns;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class createCampaignsWithProduct {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//reading data from properties file
		//step 1:get the java representation object oft he physical file
		FileInputStream fis=new FileInputStream("./src/test/resources/commonDatanew.properties.txt");
		
		//step2:create an object to property class to load all the keys
		Properties pro=new Properties();
		pro.load(fis);
		
		//step 3:read the value using getProperty()
		String URL=pro.getProperty("Url");
		String USERNAME=pro.getProperty("UserName");
		String PASSWORD=pro.getProperty("PassWord");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//================================================
		driver.findElement(By.linkText("Products")).click();
		
	
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//to avoid duplicates
				Random ran=new Random();
				int ranNum=ran.nextInt(1000);
				
		        FileInputStream fes=new FileInputStream("C:\\Users\\Sirisha\\eclipse-workspace\\theory\\Vtiger\\src\\test\\resources\\Testdata.xlsx");
				
				//keep excel file in read mode
				Workbook book=WorkbookFactory.create(fes);
				
				//taking control of the excel sheet
				Sheet sheet=book.getSheet("organisation");
				
				//taking control of the rows
				Row row=sheet.getRow(0);
				
				//taking control of cell
				Cell cel=row.getCell(0);
				
				String prdData=cel.getStringCellValue()+ranNum;
				System.out.println(prdData);

		
		
		driver.findElement(By.name("productname")).sendKeys(prdData);
		
		//to click on save button
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
			driver.findElement(By.linkText("More")).click();
			driver.findElement(By.linkText("Campaigns")).click();
			driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
			
			
			 FileInputStream fes1=new FileInputStream("C:\\Users\\Sirisha\\eclipse-workspace\\theory\\Vtiger\\src\\test\\resources\\Testdata.xlsx");
				
				//keep excel file in read mode
				Workbook book1=WorkbookFactory.create(fes1);
				
				//taking control of the excel sheet
				Sheet sheet1=book1.getSheet("organisation");
				
				//taking control of the rows
				Row row1=sheet1.getRow(0);
				
				//taking control of cell
				Cell cel1=row1.getCell(0);
				
				String campData=cel1.getStringCellValue()+ranNum;
				System.out.println(campData);
				
				driver.findElement(By.name("campaignname")).sendKeys(campData);
				
				Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@alt='Select']")).click();
			Set<String>  wins=driver.getWindowHandles();
			Iterator<String> it=wins.iterator();
			while(it.hasNext())
			{
				String win=it.next();
				driver.switchTo().window(win);
				String currentTitle=driver.getTitle();
				if(currentTitle.contains("Products&action"))
				{
					break;
				}
			}
			driver.findElement(By.name("search_text")).sendKeys(prdData);
			driver.findElement(By.name("search")).click();
			
			driver.findElement(By.xpath("//a[text()='Bluetooth202']")).click();
			
			Set<String> wins1=driver.getWindowHandles();
			Iterator<String> it1=wins1.iterator();
			while(it1.hasNext())
			{
				String win1=it.next();
				driver.switchTo().window(win1);
				String currentTitle=driver.getTitle();
				if(currentTitle.contains("Campaigns&action"))
				{
					break;
				}
			}
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			driver.findElement(By.cssSelector("//[href='index.php?module=Users&action=Logout']")).click();
			
				
				
				
				
				
		 	
	}
}
	
		
