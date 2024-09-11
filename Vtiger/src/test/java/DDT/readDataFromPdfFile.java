package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class readDataFromPdfFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File fis=new File("./src/test/resources/sirisha updated resume (1).pdf");
		PDDocument doc=PDDocument.load(fis);
		int pages=doc.getNumberOfPages();
		System.out.println(pages);
		
		PDFTextStripper pdfData=new PDFTextStripper();
		String read=pdfData.getText(doc);
		System.out.println(read);
		
		pdfData.setStartPage(5);
		
		String read1=pdfData.getText(doc);
		
		System.out.println(read1);
		
		

	}

}
