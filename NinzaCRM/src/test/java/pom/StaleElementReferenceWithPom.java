package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaleElementReferenceWithPom {
	
	public  StaleElementReferenceWithPom(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="email")
	private WebElement UN;
	
	@FindBy(id="pass")
	private WebElement PWD;

	public WebElement getUN() {
		return UN;
	}
	public WebElement getPWD() {
		return PWD;
	}
}
