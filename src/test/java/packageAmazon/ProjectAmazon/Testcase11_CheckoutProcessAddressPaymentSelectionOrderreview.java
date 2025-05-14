package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testcase11_CheckoutProcessAddressPaymentSelectionOrderreview extends BaseClass {
	@Test(retryAnalyzer=RetryLogic.class)
	public void checkoutProcessAddressPaymentSelectionOrderreview() throws InterruptedException, EncryptedDocumentException, IOException
	{//assertion pending
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
		Reporter.log("control passed");	
		ProductPage product=new ProductPage(driver);
		product.addcart();
		product.gocart();
		Reporter.log("Product added to cart");	
		CartPage cart=new CartPage(driver);
		cart.proceedtobuy();
		CheckoutPage checkout=new CheckoutPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String dlvryadress=checkout.deliveryadress.getText();
		Assert.assertTrue(dlvryadress.contains("Treesa"));
		checkout.adresschng();
		wait.until(ExpectedConditions.elementToBeClickable(checkout.selectadress));
		checkout.slctaddress();
		wait.until(ExpectedConditions.elementToBeClickable(checkout.submitadress));
		checkout.sbmtadress();
		wait.until(ExpectedConditions.elementToBeClickable(checkout.nothanksbutton));
		checkout.nothanks();
		String dlvryadressupdated=checkout.deliveryadress.getText();
		Assert.assertTrue(dlvryadressupdated.contains("Sachin"));
		Reporter.log("Address selection is done");	
		
		wait.until(ExpectedConditions.elementToBeClickable(checkout.paymentchangbutton));
		checkout.pymntcng();
//		Thread.sleep(6000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("windows.scrollBy(600)");
		wait.until(ExpectedConditions.elementToBeClickable(checkout.cashondelivery));
		checkout.cod();
		Thread.sleep(6000);
		Assert.assertTrue(checkout.cashondelivery.isSelected());
//		checkout.sbmtpaymnt();
		Reporter.log("Payment selection is done");
		wait.until(ExpectedConditions.elementToBeClickable(checkout.revieworder));
//		checkout.review();
		
	    Assert.assertTrue(checkout.revieworder.isDisplayed());
		Reporter.log("Review page comtains product detail");
		
	}

}
