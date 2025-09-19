package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement UN;

	@FindBy(id = "inputPassword")
	private WebElement PWD;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement LOGINBTN;

	public WebElement getUN() {
		return UN;
	}

	public WebElement getPWD() {
		return PWD;
	}

	public WebElement getLOGINBTN() {
		return LOGINBTN;
	}

	public void login(String url, String username, String password) {
		driver.manage().window().maximize();
		driver.get(url);
		UN.sendKeys(username);
		PWD.sendKeys(password);
		LOGINBTN.click();
	}
}
