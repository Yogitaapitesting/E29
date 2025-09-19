package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String toReadDataFromExcelFile(String sheetname, int Rownum, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\E23.xlsx");
		System.out.println("Calling WorkbookFactory.create");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook wb = WorkbookFactory.create(fis);
		System.out.println("Called WorkbookFactory.create");
		Sheet sh = wb.getSheet(sheetname);
		String data = sh.getRow(Rownum).getCell(cell).getStringCellValue();
		wb.close();
		return data;
	}

	public int togetLastRowNum(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\E23.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rownum = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rownum;
	}
}
