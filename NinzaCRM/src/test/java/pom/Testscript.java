package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testscript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		StaleElementReferenceWithPom lp=new StaleElementReferenceWithPom(driver);
		lp.getUN().sendKeys("amruta");
		lp.getPWD().sendKeys("12345");
		driver.navigate().refresh();
		lp.getUN().sendKeys("amruta");
		lp.getPWD().sendKeys("12345");
	}

}
