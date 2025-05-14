package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class Testcase7_ProductpagedisplaysPriceReviews extends BaseClass {
	@Test(retryAnalyzer=RetryLogic.class)
	public void displaysPriceProductdescriptionReviews() throws InterruptedException, EncryptedDocumentException, IOException
	{//only price done
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
		boolean pricedisplayed=product.price.isDisplayed();
		System.out.println(pricedisplayed);
		Assert.assertTrue(pricedisplayed, "Price of the product is not displayed");
		Reporter.log("Price is displayed");
		String productDescription=product.description.getText();
		Assert.assertTrue(productDescription.contains("Product description"));
		Reporter.log("product Description is displayed");
		String customerReviews=product.reviews.getText();
		Assert.assertTrue(customerReviews.contains("Customer reviews"));
		Reporter.log("Customer Reviews is displayed");		
	}
	

}
