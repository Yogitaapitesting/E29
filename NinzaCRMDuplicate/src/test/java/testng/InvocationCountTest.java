package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCountTest {
	@Test(invocationCount = 5)
public void sampleTest() {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	Reporter.log("login done",true);
	driver.quit();
}
}
