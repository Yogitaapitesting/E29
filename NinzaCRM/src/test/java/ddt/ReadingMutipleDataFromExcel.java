package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingMutipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\productDetail.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("product");
		int rowcount = sh.getLastRowNum();
		for (int i = 1; i <= rowcount; i++) {
			String productcateory = sh.getRow(i).getCell(0).getStringCellValue();
			String productname = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(productcateory + "==" + productname);
		}

	}

}
