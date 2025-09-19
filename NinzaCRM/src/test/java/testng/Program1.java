package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Program1 {
   @Test
	public void amazon()
	{
		Reporter.log("hello amazon",true);
	}
   @Test
   public void amazon1()
	{
		Reporter.log("hello amazon1",true);
	}
   @Test
	public void blinkit()
	{
		Reporter.log("hello blinkit",true);
	}
   @Test
	public void flipkart()
	{
		Reporter.log("hello flipkart",true);
	}
   @Test
	public void meesho()
	{
		Reporter.log("hello meesho",true);
	}
}
