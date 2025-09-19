package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOn {
	@Test()
	public void createaccount() {
		Reporter.log("account is created",true);
	}

	@Test(dependsOnMethods ="createaccount")
	public void updateaccount() {
		Reporter.log("account is updated",true);
	}

	@Test(dependsOnMethods = {"createaccount","updateaccount"})
	public void deleteaccount() {
		
		Reporter.log("account is deleted",true);

	}
}
