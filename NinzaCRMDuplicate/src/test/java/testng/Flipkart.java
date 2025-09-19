package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Flipkart {

	@Test(dataProvider = "productdetails")
	public void Flipkartsample(String productname) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.className("Pke_EE")).sendKeys("iphone");
		driver.findElement(By.tagName("svg")).click();
		List<WebElement> prdname = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		for (int i = 0; i < prdname.size(); i++) {
			String title = prdname.get(i).getText();
			String price = prices.get(i).getText();
			if (title.contains(productname)) {
				System.out.println(title + " - Price: " + price);
				
			}
		}
	}

	@DataProvider
	public Object[][] productdetails() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Pooja\\Desktop\\flip.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum();
		Object[][] objarr = new Object[rowcount][1];
		for (int i = 0; i < rowcount; i++) {
			objarr[i][0] = sh.getRow(i + 1).getCell(0).getStringCellValue();

		}
		return objarr;
	}
}
