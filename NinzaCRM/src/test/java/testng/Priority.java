package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority {
	@Test(priority = 1)
public void createCampaign() {
	Reporter.log("Campaign created",true);
}
	@Test(priority = 2)
public void updatecampaign() {
	Reporter.log("Campaign updated",true);
}
	@Test(priority = 3)
public void deletecampaign() {
	Reporter.log("Campaign deleted",true);
}
}
