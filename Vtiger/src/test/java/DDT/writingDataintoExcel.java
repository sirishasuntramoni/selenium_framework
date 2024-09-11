package DDT;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writingDataintoExcel {
	public static void main(String[] args) throws Throwable {
		//open the file in writing mode
		FileOutputStream file=new FileOutputStream("./Testdata/myfile.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook("Sheet1");
        XSSFSheet sheet=wb.createSheet("data");
        XSSFRow row=sheet.createRow(0);
        row.createCell(0).setCellValue("java");
        wb.write(file);
        wb.close();
	}
}



