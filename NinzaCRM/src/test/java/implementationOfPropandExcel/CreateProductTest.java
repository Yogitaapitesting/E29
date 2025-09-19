package implementationOfPropandExcel;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import genericUtility.ExcelUtility;
import genericUtility.PropertiesFile;
import genericUtility.WebDriverUtility;

public class CreateProductTest {

	public static void main(String[] args) throws Exception {
		PropertiesFile plib = new PropertiesFile();
		ExcelUtility elib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// reading data from properties
		String BROWSER = plib.togetDatafromPropertiesFile("browser");
		String URL = plib.togetDatafromPropertiesFile("url");
		String USERNAME = plib.togetDatafromPropertiesFile("username");
		String PASSWORD = plib.togetDatafromPropertiesFile("password");

		// Reading data from excel
		String PRODUCT_NAME = elib.toReadDataFromExcelFile("CreateProduct", 1, 0);
		String DROPDOWN1 = elib.toReadDataFromExcelFile("CreateProduct", 1, 1);
		String QUANTITY = elib.toReadDataFromExcelFile("CreateProduct", 1, 2);
		String PRICE = elib.toReadDataFromExcelFile("CreateProduct", 1, 3);
		String DROPDOWN2 = elib.toReadDataFromExcelFile("CreateProduct", 1, 4);

		Random ran = new Random();
		int randomcount = ran.nextInt(1000);

		WebDriver driver = null;
		if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		wlib.waitforpageToload(driver);
		driver.get(URL);

		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		driver.findElement(By.name("productName")).sendKeys(PRODUCT_NAME + randomcount);

		WebElement dropdown1 = driver.findElement(By.name("productCategory"));
		wlib.select(DROPDOWN1,dropdown1);

		WebElement quantity = driver.findElement(By.name("quantity"));
		quantity.clear();
		quantity.sendKeys(QUANTITY);

		WebElement price = driver.findElement(By.name("price"));
		price.clear();
		price.sendKeys(PRICE);

		WebElement dropdown2 = driver.findElement(By.name("vendorId"));
		wlib.select(DROPDOWN2, dropdown2);
		driver.findElement(By.xpath("//button[text()='Add']")).click();

		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		wlib.waitForVisibilityOfElement(driver, toastmsg);
		String msg = toastmsg.getText();
		if (msg.contains(PRODUCT_NAME)) {
			System.out.println("product are created");
		} else {
			System.out.println("product not created");
		}

		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		wlib.ClickOnWebelement(driver, icon);
		driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		driver.quit();
	}

}
