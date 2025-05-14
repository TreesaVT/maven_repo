package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testcase13_ApplyforCouponCodeWhileOrdering extends BaseClass {
	@Test(retryAnalyzer=RetryLogic.class)
	public void applyforCouponCodeWhileOrdering() throws InterruptedException, EncryptedDocumentException, IOException
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
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		checkout.entrcouponcode();
		checkout.apply();
		wait.until(ExpectedConditions.visibilityOf(checkout.alertText));
		String expectedText = checkout.alertText.getText();
		System.out.println(expectedText);
		Assert.assertTrue(expectedText.contains("The promotional code you entered is not valid"));

		Reporter.log("Couponcode entered");	

	}

}
