package implementationOfPropandExcel;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import genericUtility.ExcelUtility;
import genericUtility.PropertiesFile;
import genericUtility.WebDriverUtility;

public class CreateCampaignTestWithStatus {

	public static void main(String[] args) throws IOException {
		PropertiesFile plib=new PropertiesFile();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		// reading data from properties 
		String BROWSER = plib.togetDatafromPropertiesFile("browser");
		String URL = plib.togetDatafromPropertiesFile("url");
		String USERNAME = plib.togetDatafromPropertiesFile("username");
		String PASSWORD = plib.togetDatafromPropertiesFile("password");
		
		//Reading data from excel
		String CAMPAIGN_NAME = elib.toReadDataFromExcelFile("CreateCampaign", 1, 2);
		String TARGET_SIZE = elib.toReadDataFromExcelFile("CreateCampaign", 1, 3);
		String STATUS = elib.toReadDataFromExcelFile("CreateCampaign", 1, 4);
		
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
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click(); 
		driver.findElement(By.name("campaignName")).sendKeys(CAMPAIGN_NAME);
		WebElement size = driver.findElement(By.name("targetSize"));
		size.clear();
		size.sendKeys(TARGET_SIZE);
		driver.findElement(By.name("campaignStatus")).sendKeys(STATUS);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
	   wlib.waitForVisibilityOfElement(driver, toastmsg);
		String msg = toastmsg.getText();
		if (msg.contains(CAMPAIGN_NAME)) {
			System.out.println("campaign created");
		} else {
			System.out.println("campaign not created");
		}
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		wlib.ClickOnWebelement(driver, icon);
		driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		driver.quit();
	}

}
