package DDT;



public class Read_data_from_PropertiesFile {

	public static void main(String[] args) throws Throwable {
	
		WebDriver driver=new  ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		driver.get(URL);
		Thread.sleep(2000);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		
		
		

	}

}
