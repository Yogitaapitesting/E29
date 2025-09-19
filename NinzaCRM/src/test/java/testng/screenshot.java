package testng;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;


public class screenshot {
	@Test
	public void takess() throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.instagram.com/accounts/login/?hl=en");
		Date d=  new Date();
		String newdate = d.toString().replace(" ", "_").replace(":","_");
		TakesScreenshot ts= (TakesScreenshot) driver;
		File  temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./screenshot/takes_"+newdate+".png");
		FileHandler.copy(temp, perm);
		
		
		
				}
	
	

}
