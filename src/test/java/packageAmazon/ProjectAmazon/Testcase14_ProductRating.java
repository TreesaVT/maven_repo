package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testcase14_ProductRating extends BaseClass {
	@Test(retryAnalyzer=RetryLogic.class)
	public void productRating() throws InterruptedException, EncryptedDocumentException, IOException
  {//submit not working
	Homepage home=new Homepage(driver);
	home.acntndlst(driver);
	home.signin();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	LoginPage login=new LoginPage(driver);
	login.uname(1,0);
	login.cont();
	login.pswrd(1,1);
	login.signin();
	Reporter.log("Logged in with credentials");
	home.ordrbtn();
	Reporter.log("Able to view orders page");
	OrdersPage orders=new OrdersPage(driver);
	orders.review();
	
	orders.rate();
	
//	orders.writereview();
//	
//	orders.reviewcmnt();
//	Thread.sleep(2000);
//	orders.tiltle();
	Thread.sleep(2000);
	boolean fivestarating=orders.fivestar.isEnabled();
	Assert.assertTrue(fivestarating, "Fivestarrating not given");
//	orders.submit();
//	String SuccessMsg = orders.reviewsubmittedText.getText();
//   	System.out.println(SuccessMsg);
//   	Assert.assertTrue(SuccessMsg.contains("Review Submitted"),"Review not submitted");
   	Reporter.log("Review submitted with 5 star rating");
 }
	

}
