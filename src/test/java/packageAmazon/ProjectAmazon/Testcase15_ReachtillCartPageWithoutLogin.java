package packageAmazon.ProjectAmazon;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testcase15_ReachtillCartPageWithoutLogin extends BaseClass {
	@Test(retryAnalyzer=RetryLogic.class)
	public void reachtillCartPageWithoutLogin() throws InterruptedException
	{
		Homepage home=new Homepage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		home.search();
		home.productdetail();
		home.switchtochild(driver);	
		Reporter.log("Control passed to child window");	
		ProductPage product=new ProductPage(driver);
		product.addcart();
		String SuccessMsg = product.addedTocartText.getText();
		Assert.assertTrue(SuccessMsg.contains("Added to cart"),"Product not added to cart");
		CartPage cart=new CartPage(driver);
		cart.proceedtobuy();
		LoginPage login=new LoginPage(driver);
		Assert.assertTrue(login.username.isDisplayed());
		Reporter.log("Reached till cart but cannot proceed to buy without login");
	   
	}
}
