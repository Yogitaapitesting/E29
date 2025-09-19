package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class flip {
	
		@Test(dataProvider = "getData")
		public void getproduct(String brandname, String productname) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://www.flipkart.com/");

			// search product
			driver.findElement(By.name("q")).sendKeys(brandname, Keys.ENTER);

			// capture product info
			WebElement price = driver.findElement(By.xpath("//div[text()='"+productname+"']/../../div[2]/div[1]/div/div[1]"));
			System.out.println(price.getText());
			driver.quit();
		}

		@DataProvider
		public Object[][] getData() throws EncryptedDocumentException, IOException {
			

			FileInputStream fis = new FileInputStream("C:\\Users\\Pooja\\Desktop\\flip.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet1");
			int rowcount = sh.getLastRowNum();
			Object[][] objArr = new Object[rowcount][2];
			for (int i = 0; i < rowcount; i++) {
				objArr[i][0] = sh.getRow(i + 1).getCell(0).getStringCellValue();
				objArr[i][1] = sh.getRow(i + 1).getCell(1).getStringCellValue();

			}
			return objArr;
		}
	}


