package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Insert_data_to_propertiesfile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties.txt");
	Properties pro=new Properties();
	pro.setProperty("url","https://www.saucedemo.com/v1/inventory.html");
	pro.setProperty("username","standard_user");
	pro.setProperty("password","secret_sauce");
	FileOutputStream fos=new FileOutputStream("./src/test/resources/commonData.properties.txt");
	pro.store(fos, "data");
	
		
		
		

	}

}
