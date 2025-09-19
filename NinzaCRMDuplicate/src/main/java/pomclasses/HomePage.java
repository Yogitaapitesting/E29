package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Campaigns")
	private WebElement campaigns;

	@FindBy(linkText = "Products")
	private WebElement products;

	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createcampaign;

	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement usericon;

	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement logout;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement toastmsg;

	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement closemsg;

	public WebElement getCampaigns() {
		return campaigns;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getCreatecampaign() {
		return createcampaign;
	}

	public WebElement getUsericon() {
		return usericon;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getToastmsg() {
		return toastmsg;
	}

	public WebElement getClosemsg() {
		return closemsg;
	}

}
