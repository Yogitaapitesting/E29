package implementationOfPropandExcel;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import genericUtility.ExcelUtility;
import genericUtility.PropertiesFile;
import genericUtility.WebDriverUtility;
import pomclasses.CreateCampaignPage;
import pomclasses.HomePage;
import pomclasses.LoginPage;

public class CreateCampaignTest {

	public static void main(String[] args) throws IOException {
		PropertiesFile plib = new PropertiesFile();
		ExcelUtility elib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// reading data from properties
		String BROWSER = plib.togetDatafromPropertiesFile("browser");
		String URL = plib.togetDatafromPropertiesFile("url");
		String USERNAME = plib.togetDatafromPropertiesFile("username");
		String PASSWORD = plib.togetDatafromPropertiesFile("password");

		// reading data from excel
		String CAMPAIGN_NAME = elib.toReadDataFromExcelFile("CreateCampaign", 1, 2);
		String TARGET_SIZE = elib.toReadDataFromExcelFile("CreateCampaign", 1, 3);

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
		// login
		LoginPage lp = new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPWD().sendKeys(PASSWORD);
		lp.getLOGINBTN().click();

		// homepage
		HomePage hp = new HomePage(driver);
		hp.getCreatecampaign().click();
		
		//createCampaign
		CreateCampaignPage cmp=new CreateCampaignPage(driver);
		cmp.getCampaignname().sendKeys(CAMPAIGN_NAME);
		cmp.getTargetsize().clear();
		cmp.getTargetsize().sendKeys(TARGET_SIZE);
		cmp.getCreatecampaignbtn().click();
		
		WebElement toastmsg = hp.getToastmsg();
		wlib.waitForVisibilityOfElement(driver, toastmsg);
		String msg = toastmsg.getText();
		if (msg.contains(CAMPAIGN_NAME)) {
			System.out.println("campaign created");
		} else {
			System.out.println("campaign not created");
		}
		WebElement icon = hp.getUsericon();
		wlib.ClickOnWebelement(driver, icon);
		hp.getLogout().click();
		driver.quit();
	}

}
