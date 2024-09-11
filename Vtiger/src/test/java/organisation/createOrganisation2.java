package organisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createOrganisation2 {

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
		
		//click on organisation link
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on lookup image
		driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
		
		
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
		
		String OrgName=cel.getStringCellValue()+ranNum;
		System.out.println(OrgName);
		
		//fetching phonenumber
		//step4: taking control of the rows
		Row row1=sheet.getRow(1);
		
		//step5:taking control of the cells
		 Cell cell=row1.getCell(0);
		 
		 DataFormatter format=new DataFormatter();
		 String phnNum=format.formatCellValue(cell);
		 System.out.println(phnNum);
		 
		 //fetching emailid
		//step4: taking control of the rows
			Row row2=sheet.getRow(2);
			
			//step5:taking control of the cells
			 Cell cell2=row2.getCell(0);
			 
			
			 String mailid=cell2.getStringCellValue();
			 System.out.println(mailid);
		 
		 
		
		//create organization data
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(mailid);
		
		
		//to click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		driver.findElement(By.cssSelector("//[href='index.php?module=Users&action=Logout']")).click();
		
		
		//logout from application
		Thread.sleep(2000);
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
