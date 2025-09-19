package campaign;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import configuration.Baseclass;
import pomclasses.CreateCampaignPage;
import pomclasses.HomePage;
@Listeners(listernersUtility.ListenersImplementation.class)
public class CampaignTest extends Baseclass {
	@Test(groups = "smoke")
	public void CreateCampaignTest() throws IOException {
		// reading data from excel
		String CAMPAIGN_NAME = elib.toReadDataFromExcelFile("CreateCampaign", 1, 2);
		String TARGET_SIZE = elib.toReadDataFromExcelFile("CreateCampaign", 1, 3);

		// homepage
		HomePage hp = new HomePage(driver);
		hp.getCreatecampaign().click();

		// createCampaign
		CreateCampaignPage cmp = new CreateCampaignPage(driver);
		cmp.getCampaignname().sendKeys(CAMPAIGN_NAME);
		cmp.getTargetsize().clear();
		cmp.getTargetsize().sendKeys(TARGET_SIZE);
		cmp.getCreatecampaignbtn().click();

		WebElement toastmsg = hp.getToastmsg();
		wlib.waitForVisibilityOfElement(driver, toastmsg);
		String msg = toastmsg.getText();
		Assert.assertEquals(msg,"Campaign "+CAMPAIGN_NAME+" Successfully Added");

	}

	@Test(groups = "integration")
	public void CreateCampaignWithStatusTest() throws IOException {

		// Reading data from excel
		String CAMPAIGN_NAME = elib.toReadDataFromExcelFile("CreateCampaign", 1, 2);
		String TARGET_SIZE = elib.toReadDataFromExcelFile("CreateCampaign", 1, 3);
		String STATUS = elib.toReadDataFromExcelFile("CreateCampaign", 1, 4);

		// homepage
		HomePage hp = new HomePage(driver);
		hp.getCreatecampaign().click();

		// createCampaign
		CreateCampaignPage cmp = new CreateCampaignPage(driver);
		cmp.getCampaignname().sendKeys(CAMPAIGN_NAME);
		cmp.getTargetsize().clear();
		cmp.getTargetsize().sendKeys(TARGET_SIZE);
		cmp.getCampaignStatus().sendKeys(STATUS);
		cmp.getCreatecampaignbtn().click();

		WebElement toastmsg = hp.getToastmsg();
		wlib.waitForVisibilityOfElement(driver, toastmsg);
		String msg = toastmsg.getText();
		Assert.assertEquals(msg,"Campaign "+CAMPAIGN_NAME+" Successfully Added");
	}

	@Test(groups = "smoke")
	public void CreateCampaignWithExpectedDateTest() throws IOException {

		// Reading data from excel
		String CAMPAIGN_NAME = elib.toReadDataFromExcelFile("CreateCampaign", 1, 2);
		String TARGET_SIZE = elib.toReadDataFromExcelFile("CreateCampaign", 1, 3);
		String STATUS = elib.toReadDataFromExcelFile("CreateCampaign", 1, 4);

		// homepage
		HomePage hp = new HomePage(driver);
		hp.getCreatecampaign().click();

		// createCampaign
		CreateCampaignPage cmp = new CreateCampaignPage(driver);
		cmp.getCampaignname().sendKeys(CAMPAIGN_NAME);
		cmp.getTargetsize().clear();
		cmp.getTargetsize().sendKeys(TARGET_SIZE);
		cmp.getCampaignStatus().sendKeys(STATUS);
		cmp.getExpecteddate().sendKeys(jlib.togetRequiredDate(30));
		cmp.getCreatecampaignbtn().click();
		
		WebElement toastmsg = hp.getToastmsg();
		wlib.waitForVisibilityOfElement(driver, toastmsg);
		String msg = toastmsg.getText();
		Assert.assertEquals(msg,"Campaign "+CAMPAIGN_NAME+" Successfully Added");
	}
}
