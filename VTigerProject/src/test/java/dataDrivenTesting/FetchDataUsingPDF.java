package dataDrivenTesting;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchDataUsingPDF {

	public static void main(String[] args) throws Throwable  {
		
		//S1: set the path for the pdf file (here given eclipse location)
	File file = new File("./src/test/resources/Day02and03.pdf");
		//S2: PDDcument to load the file
	PDDocument doc = PDDocument.load(file);
	//to get the number of pages in pdf
	int totalPages = doc.getNumberOfPages();
	//System.out.println(totalPages);
	
		//S3: create constructor to use PDFTextStripper class to read the data in pdf file
	PDFTextStripper PDFdata = new PDFTextStripper();
		//S4:get the text from the pdf file
	//String text = PDFdata.getText(doc);
	//System.out.println(text);	
		
	//to get particular page to read
	PDFdata.setStartPage(2);
	String page2 = PDFdata.getText(doc);
	System.out.println(page2);
	
	//to read form page 2 to 3 like tht
	PDFdata.setStartPage(1);
	PDFdata.setEndPage(3);;
	
	String selectedPages = PDFdata.getText(doc);
	System.out.println(selectedPages);
	}

}
