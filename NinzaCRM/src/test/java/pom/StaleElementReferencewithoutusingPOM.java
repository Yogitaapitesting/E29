package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class StaleElementReferencewithoutusingPOM {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement UN = driver.findElement(By.id("email"));
		WebElement PWD = driver.findElement(By.id("pass"));
		UN.sendKeys("amruta");
		PWD.sendKeys("12355678");
		driver.navigate().refresh();
		UN.sendKeys("amruta");
		PWD.sendKeys("12355678");
	

	}

}
