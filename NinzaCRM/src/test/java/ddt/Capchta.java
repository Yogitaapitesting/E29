package ddt;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Capchta {

	public static void main(String[] args) throws IOException, TesseractException {
		ChromeOptions setting = new ChromeOptions();
		setting.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(setting);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("//a[text()=' LOGIN ']")).click();
		WebElement capatcha = driver.findElement(By.xpath("//img[@class='captcha-img']"));
		File temp = capatcha.getScreenshotAs(OutputType.FILE);
		File perm=new File("./screenshot/capatcha.png");
		FileHandler.copy(temp, perm);
		
		Tesseract tss=new Tesseract();
		tss.setDatapath("C:\\Users\\Pooja\\Downloads\\Tess4J-3.4.8-src (2)\\Tess4J\\tessdata");
		String st = tss.doOCR(perm);
		String img = st.replace(" ", "");
		System.out.println(img);
		
	}

}
