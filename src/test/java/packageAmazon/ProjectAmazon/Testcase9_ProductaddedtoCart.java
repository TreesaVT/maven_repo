package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testcase9_ProductaddedtoCart extends BaseClass {
	@Test(retryAnalyzer=RetryLogic.class)
	public void productaddedtocart() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Homepage home=new Homepage(driver);
		home.acntndlst(driver);
		home.signin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage login=new LoginPage(driver);
		login.uname(1,0);
		login.cont();
		login.pswrd(1,1);
		login.signin();
		home.search();
		home.productdetail();
		home.switchtochild(driver);	
		Reporter.log("Control passed to child window");	
		ProductPage product=new ProductPage(driver);
		product.addcart();
		String SuccessMsg = product.addedTocartText.getText();
	   	System.out.println(SuccessMsg);
	   	Assert.assertTrue(SuccessMsg.contains("Added to cart"),"Product not added to cart");
	}
}