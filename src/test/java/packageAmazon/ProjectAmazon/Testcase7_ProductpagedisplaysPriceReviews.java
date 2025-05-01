package packageAmazon.ProjectAmazon;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Testcase7_ProductpagedisplaysPriceReviews extends BaseClass {
	@Test(retryAnalyzer=RetryLogic.class)
	public void displaysPriceProductdescriptionReviews() throws InterruptedException
	{
		Homepage home=new Homepage(driver);
		home.search();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		home.productdetail();
		Thread.sleep(3000);
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> id=ids.iterator();
		String parentid=id.next();
		String childid1=id.next();
//		System.out.println(parentid);
//		System.out.println(childid1);
		
		driver.switchTo().window(childid1);
		ProductPage product=new ProductPage();
		boolean pricedisplayed=product.price.isDisplayed();
		Assert.assertTrue(pricedisplayed, "Price of the product is not displayed");
		
	}
	

}
