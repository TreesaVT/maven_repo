package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testcase12_SelectEachPaymentMethod extends BaseClass {
	@Test(retryAnalyzer=RetryLogic.class)
	public void selectEachPaymentMethod() throws InterruptedException, EncryptedDocumentException, IOException
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

		home.cart();
		CartPage cart=new CartPage(driver);
		cart.proceedtobuy();
		CheckoutPage checkout=new CheckoutPage(driver);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(checkout.cashondelivery));
		checkout.amznpay();
		Assert.assertTrue(checkout.amazonpay.isSelected(), "amazonpay not selected");
		Thread.sleep(4000);
		Reporter.log("Selected amazonpay");
		checkout.card();
		Assert.assertTrue(checkout.creditordebitcard.isSelected(), "creditordebitcard not selected");
		Thread.sleep(4000);
		Reporter.log("Selected creditordebitcard");
		checkout.netbnkng();
		Assert.assertTrue(checkout.netbanking.isSelected(), "netbanking not selected");
		Thread.sleep(4000);
		Reporter.log("Selected netbanking");
		checkout.emipay();
		Assert.assertTrue(checkout.emi.isSelected(), "emi not selected");
		Thread.sleep(4000);
		Reporter.log("Selected emi");
		checkout.upi();
		Assert.assertTrue(checkout.otherupi.isSelected(), "otherupi not selected");
		Thread.sleep(4000);
		Reporter.log("Selected upi");
		checkout.cod();
		Assert.assertTrue(checkout.cashondelivery.isSelected(), "cashondelivery not selected");
		Thread.sleep(4000);
		Reporter.log("Selected cashondelivery");
		Reporter.log("payment selection is done");	

	}

}
