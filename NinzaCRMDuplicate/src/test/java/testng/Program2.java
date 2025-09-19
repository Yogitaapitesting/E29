package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Program2 {
	@Test
public void createCampaign() {
	Reporter.log("Campaign created",true);
}
	@Test
public void updatecampaign() {
	Reporter.log("Campaign updated",true);
}
	@Test
public void deletecampaign() {
	Reporter.log("Campaign deleted",true);
}
}
