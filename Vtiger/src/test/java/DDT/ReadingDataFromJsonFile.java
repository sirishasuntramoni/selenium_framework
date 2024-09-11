package DDT;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadingDataFromJsonFile {
	public static void main(String[] args) throws Throwable {
		File fis=new File("./src/test/resources/jackson.json");
		ObjectMapper jsonData=new ObjectMapper();
		JsonNode data=jsonData.readTree(fis);
	}

}  
