package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	@Test
	public void sample() {
		String ExpectedResult = "fb";
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String ActualResult = driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(ActualResult, ExpectedResult);
		System.out.println("hello");
		System.out.println("hello");
		soft.assertAll();

	}
}
