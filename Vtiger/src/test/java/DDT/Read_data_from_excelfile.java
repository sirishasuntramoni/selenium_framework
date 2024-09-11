package DDT;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_data_from_excelfile {
	public static void main(String[] args) throws Throwable {
		//open and read data from excel file
		FileInputStream file=new FileInputStream("./Testdata/Testdata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		Row row=sheet.getRow(0);
		Cell cell=row.getCell(0);
		System.out.println(cell);
	}
		
		 
	}


