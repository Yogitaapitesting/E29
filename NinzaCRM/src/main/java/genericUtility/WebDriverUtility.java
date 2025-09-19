package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitforpageToload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchTOframe(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToframe(WebDriver driver, String nameorid) {
		driver.switchTo().frame(nameorid);
	}

	public void switchToframe(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public void select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	public void select(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void mouseHoverOnWebelment(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void ClickOnWebelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}

	public void DoubleClickOnWebelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public void RightClickOnWebelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	public void SwitchToWindow(WebDriver driver) {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		child.remove(parent);
		for (String id : child) {
			driver.switchTo().window(id);
		}
	}
	public void TakesScreenShot(WebDriver driver, String Filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./folder" + Filename + ".png");
		FileHandler.copy(temp, perm);
	}
	public void switchToAlertandAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertandDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void switchToAlertandgetText(WebDriver driver) {
		driver.switchTo().alert().getText();	
	}
	public void switchToAlertandSendkeys(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}

}
