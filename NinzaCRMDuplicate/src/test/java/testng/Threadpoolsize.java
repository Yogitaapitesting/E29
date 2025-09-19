package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Threadpoolsize {
	@Test(invocationCount = 10,threadPoolSize = 4)
public void sample() {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	Reporter.log("login done",true);
	driver.quit();
}
}
