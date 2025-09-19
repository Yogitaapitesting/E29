package testng;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Sample {
	@Test
	public void script() {
		Reporter.log("testscript done", true);
	}
	@Test
	public void script1() {
		Reporter.log("testscript1 done", true);
	}                                               
	                                                

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("db connection", true);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("db close", true);
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("launching browser", true);
	}

	@AfterClass
	public void afterClass() {
		Reporter.log("closing browser", true);
	}

	@BeforeMethod
	public void beforemethod() {
		Reporter.log("login", true);
	}

	@AfterMethod
	public void aftermethod() {
		Reporter.log("logout", true);
	}

}
