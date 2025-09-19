package product;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import configuration.Baseclass;
import pomclasses.CreateProductPage;
import pomclasses.HomePage;

public class CreateProductTest extends Baseclass {
	@Test
	public void createproductwithmandatory() throws EncryptedDocumentException, IOException {

		// Reading data from Excel file
		String PRODUCT_NAME = elib.toReadDataFromExcelFile("CreateProduct", 1, 0);
		String DROPDOWN1 = elib.toReadDataFromExcelFile("CreateProduct", 1, 1);
		String QUANTITY = elib.toReadDataFromExcelFile("CreateProduct", 1, 2);
		String PRICE = elib.toReadDataFromExcelFile("CreateProduct", 1, 3);
		String DROPDOWN2 = elib.toReadDataFromExcelFile("CreateProduct", 1, 4);
		String product_name = PRODUCT_NAME+jlib.getRandomNumber();
		// product
		HomePage hp = new HomePage(driver);
		hp.getProducts().click();

		// enter all details
		CreateProductPage pp = new CreateProductPage(driver);
		pp.getAddproduct().click();
		pp.getProductname().sendKeys(product_name);
		wlib.select(pp.getProductCategory(), DROPDOWN1);
		pp.getQuantity().clear();
		pp.getQuantity().sendKeys(QUANTITY);
		pp.getPrice().clear();
		pp.getPrice().sendKeys(PRICE);
		wlib.select(DROPDOWN2, pp.getVendorId());
		pp.getAddproductbtn().click();

		WebElement toastmsg = hp.getToastmsg();
		wlib.waitForVisibilityOfElement(driver, toastmsg);
		String msg = toastmsg.getText();
		//System.out.println(msg);
		Assert.assertEquals(msg,"Product "+product_name+" Successfully Added");

	}
}
