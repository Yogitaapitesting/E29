package configuration;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtiliy;
import genericUtility.PropertiesFile;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomclasses.HomePage;
import pomclasses.LoginPage;

public class Baseclass {
	public PropertiesFile plib = new PropertiesFile();
	public WebDriverUtility wlib = new WebDriverUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtiliy jlib = new JavaUtiliy();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;//listener class
	

	@BeforeSuite(groups = { "smoke", "integration" })
	public void beforeSuite() {
		Reporter.log("db connection", true);
	}

	@AfterSuite(groups = { "smoke", "integration" })
	public void afterSuite() {
		Reporter.log("db close", true);
	}

	//@Parameters("BROWSER")
	@BeforeClass(groups = { "smoke", "integration" })
	public void beforeClass() throws IOException {
	//String BROWSER=browser;
	String BROWSER = plib.togetDatafromPropertiesFile("browser");

		if (BROWSER.equals("edge")) {
			WebDriverManager.edgedriver().driverVersion("140.0.3485.66").setup();// 140.0.3485.66
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}

	}

	@AfterClass(groups = { "smoke", "integration" })
	public void afterClass() {
		driver.quit();
	}

	@BeforeMethod(groups = { "smoke", "integration" })
	public void beforemethod() throws IOException {
		String URL = plib.togetDatafromPropertiesFile("url");
		String USERNAME = plib.togetDatafromPropertiesFile("username");
		String PASSWORD = plib.togetDatafromPropertiesFile("password");
		driver.manage().window().maximize();
		wlib.waitforpageToload(driver);
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPWD().sendKeys(PASSWORD);
		lp.getLOGINBTN().click();
	}

	@AfterMethod(groups = { "smoke", "integration" })
	public void aftermethod() {
		HomePage hp = new HomePage(driver);
		WebElement icon = hp.getUsericon();
		wlib.ClickOnWebelement(driver, icon);
		hp.getLogout().click();
	}
}
