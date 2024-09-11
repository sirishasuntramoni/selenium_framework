package Generic_utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class file_utility {
	/**
	 * its used to return value from property file based on key
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Sirisha
	 */
	public String getKeyandVAlueData(String key) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/commonDatanew.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		
		return pro.getProperty(key);
		
	}

}
