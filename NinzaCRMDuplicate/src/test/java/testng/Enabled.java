package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled {
	 @Test(enabled = false)
		public void amazon()
		{
			Reporter.log("hello amazon",true);
		}
	   @Test(enabled = true)
	   public void amazon1()
		{
			Reporter.log("hello amazon1",true);
		}
	   @Test
		public void blinkit()
		{
			Reporter.log("hello blinkit",true);
		}
}
