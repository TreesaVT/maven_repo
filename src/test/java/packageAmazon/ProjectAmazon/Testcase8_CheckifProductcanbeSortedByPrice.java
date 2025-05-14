package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase8_CheckifProductcanbeSortedByPrice extends BaseClass
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void checkifProductcanbeSortedByPrice() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Homepage home=new Homepage(driver);
		home.acntndlst(driver);
		home.signin();
		
		LoginPage login=new LoginPage(driver);
		login.uname(1,0);
		login.cont();
		login.pswrd(1,1);
		login.signin();
		
		home.search();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		SearchResultPage searchresult=new SearchResultPage(driver);
		searchresult.sortby();
		List<Integer> actualPrices = new ArrayList<Integer>();
		//Thread.sleep(5000);
		
		for (int i = 5; i < searchresult.priceofeachshoe.size(); i++) {
				String priceText = searchresult.priceofeachshoe.get(i).getText().replace(",", "").trim();
				System.out.println("prices: "+priceText);
				if (!priceText.isEmpty())
				{
					try
					{
						
						actualPrices.add(Integer.parseInt(priceText));
					}
					catch(NumberFormatException e)
					{
						System.out.println("Skipped non-numeric price: " + priceText);
					}
				}
		}
					System.out.println("Actual prices: " + actualPrices);
				

		// Sort and compare
		List<Integer> sortedPrices = new ArrayList<Integer>(actualPrices);
		Collections.sort(sortedPrices);
		System.out.println("Sorted prices: "+sortedPrices);

		// Assertion
		Assert.assertNotEquals(actualPrices, sortedPrices, "Prices are NOT sorted low to high!");
		System.out.println("Price sorting check complete.");
		
}
}