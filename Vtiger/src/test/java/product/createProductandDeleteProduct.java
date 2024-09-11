package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.graphbuilder.math.func.RandFunction;

public class createProductandDeleteProduct {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\commonDatanew.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		
		String URL=pro.getProperty("Url");
		String USERNAME=pro.getProperty("UserName");
		String PASSWORD=pro.getProperty("PassWord");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
		
		FileInputStream fes=new FileInputStream("C:\\Users\\Sirisha\\eclipse-workspace\\theory\\Vtiger\\src\\test\\resources\\Testdata.xlsx");
		
		//keep excel file in read mode
		Workbook book=WorkbookFactory.create(fes);
		
		//taking control of the excel sheet
		Sheet sheet=book.getSheet("product");
		
		//taking control of the rows
		Row row=sheet.getRow(0);
		
		//taking control of cell
		Cell cel=row.getCell(0);
		
		
		String prdName=cel.getStringCellValue()+ranNum;
		System.out.println(prdName);
		
		
		driver.findElement(By.name("productname")).sendKeys(prdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*navigating to product table
		driver.findElement(By.linkText("Products")).click();
		
		driver.findElement(By.xpath("//table[@class='Ivt//small']/tbody/tr//td//a[text()='Product//Name']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
		
		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		List<WebElement> allNames=driver.findElements(By.xpath("//table[@class='Ivtsmall']/tbody//tr//td[3])[position()>1]"));
		boolean flag=false;
		
		for(WebElement name:allNames)
		{
			String actData=name.getText();
			if(actData.contains(prdName))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("product name is deleted");
		}
		else
		{
			System.out.println("product name is not deleted");
		}
		*/
		List<WebElement> productList=driver.findElements(By.xpath("//table[@class='Ivtsmall']/tbody//tr//td[3])[position()>1]"));
		boolean flag=false;
		for(WebElement prdName1:productList)
		{
			String actData=prdName1.getText();
			if(actData.contains(prdName))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("product data is deleted");
		}
		else
		{
			System.out.println("product data not deleted");
		}
	}
}
		
	
		
		
		
		
		
		
		
		
		
	

