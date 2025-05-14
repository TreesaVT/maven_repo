package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testcase10_AddandRemoveItemQuantity extends BaseClass {
	@Test(retryAnalyzer=RetryLogic.class)//assertion pending
	public void addandRemoveItemQuantity() throws InterruptedException, EncryptedDocumentException, IOException
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
		ProductPage product=new ProductPage(driver);
		product.addcart();
		product.gocart();
		CartPage cart=new CartPage(driver);
		int initialCount =Integer.parseInt(cart.itemquantity.getText()) ;

		
		cart.increment();
		Thread.sleep(4000);
		int updatedincrementCount =Integer.parseInt(cart.itemquantity.getText()) ;
	    Assert.assertEquals(updatedincrementCount, initialCount+1);
	    Reporter.log("ItemQuantity incremented");
	    System.out.println(updatedincrementCount);

		cart.decrement();
		Thread.sleep(4000);
		int updateddecrementCount =Integer.parseInt(cart.itemquantity.getText()) ;
	    Assert.assertEquals(updateddecrementCount, updatedincrementCount-1);
	    Reporter.log("ItemQuantity decremented");
	    System.out.println(updateddecrementCount);
	}
}
