package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "campaignName")
	private WebElement campaignname;

	@FindBy(name = "campaignStatus")
	private WebElement campaignStatus;
	
	@FindBy(name="targetSize")
	private WebElement targetsize;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement expecteddate;
	
	@FindBy(xpath  = "//button[text()='Create Campaign']")
	private WebElement createcampaignbtn;

	public WebElement getCampaignname() {
		return campaignname;
	}

	public WebElement getCampaignStatus() {
		return campaignStatus;
	}

	public WebElement getTargetsize() {
		return targetsize;
	}

	public WebElement getExpecteddate() {
		return expecteddate;
	}

	public WebElement getCreatecampaignbtn() {
		return createcampaignbtn;
	}
	
	
}
