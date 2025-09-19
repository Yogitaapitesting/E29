package hardcoding;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testcase3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8098/");
		Random random = new Random();
		int randomcount = random.nextInt(1000);
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		driver.findElement(By.name("productName")).sendKeys("shoe"+randomcount);
		
	

		WebElement dropdown1 = driver.findElement(By.name("productCategory"));
		Select sel = new Select(dropdown1);
		sel.selectByVisibleText("Electronics");

		WebElement quantity = driver.findElement(By.name("quantity"));
		quantity.clear();
		quantity.sendKeys("2");

		WebElement price = driver.findElement(By.name("price"));
		price.clear();
		price.sendKeys("678");

		WebElement dropdown2 = driver.findElement(By.name("vendorId"));
		Select sel1 = new Select(dropdown2);
		sel1.selectByVisibleText("Vendor_68300 - (Electronics)");
		
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		if (msg.contains("shoe")) {
			System.out.println("product are created");
		} else {
			System.out.println("product not created");
		}

		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act = new Actions(driver);
		act.moveToElement(icon).click().perform();
		WebElement logout = driver.findElement(By.xpath("//div[text()='Logout ']"));
		act.moveToElement(logout).click().perform();
		driver.quit();

	}

}
