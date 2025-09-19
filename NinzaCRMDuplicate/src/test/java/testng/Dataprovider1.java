package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider1 {
	
  @Test(dataProvider ="logindetails" )
	public void login(String username,String password) {
		System.out.println(username+"==="+password);
	}
	
	@DataProvider
	public Object[][] logindetails(){
		
		Object[][] objarr=new Object[3][2];
		
		objarr[0][0]="amruta";
		objarr[0][1]="amruta123";
		
		objarr[1][0]="harisha";
		objarr[1][1]="h123";
		
		objarr[2][0]="basamma";
		objarr[2][1]="b1234";
		
		return objarr;
	}
}
