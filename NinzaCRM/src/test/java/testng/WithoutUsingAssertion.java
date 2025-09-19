package testng;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WithoutUsingAssertion {
@Test
	public void sample() {
		String expected = "fb";
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		String actual = driver.getTitle();
		if(expected.equals(actual)) {
		System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		
	}
}
