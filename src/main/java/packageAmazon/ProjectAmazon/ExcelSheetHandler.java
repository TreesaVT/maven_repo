package packageAmazon.ProjectAmazon;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetHandler 
{
	public static String exceldata(int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
  	FileInputStream f1= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\ProjectAmazon\\ExcelSheet\\LoginCredential.xlsx");
	Workbook w1= WorkbookFactory.create(f1);
//	String UN=w1.getSheet("LoginCredential").getRow(0).getCell(1).getStringCellValue();
//	String PWD=w1.getSheet("LoginCredential").getRow(1).getCell(1).getStringCellValue();
	Row r1=w1.getSheet("Login").getRow(rownum);
	Cell c1=r1.getCell(cellnum);
	return c1.getStringCellValue();
	}
}
