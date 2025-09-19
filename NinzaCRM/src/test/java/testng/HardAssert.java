package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

public class HardAssert {
	@Test
	public void sample() {
		String ExpectedResult = "fb";
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String ActualResult = driver.getTitle();
		Assert.assertEquals(ActualResult, ExpectedResult);
		System.out.println("hello");
		System.out.println("hello");

	}
}
