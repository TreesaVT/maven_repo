package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		searchresult.lowtohigh();
		List<Integer> priceList = new ArrayList<Integer>();
		System.out.println(priceList);
		for (WebElement shoe : searchresult.listofshoes) {
			try {
				String priceText = searchresult.priceofeachshoe.getText().replace(",", "").trim();
				System.out.println(priceText);
				if (!priceText.isEmpty() && priceText.matches("\\d+")) {
					priceList.add(Integer.parseInt(priceText));
					System.out.println("Found price: " + priceText);
				} else {
					System.out.println("Skipped invalid price: " + priceText);
				}
			} catch (NoSuchElementException e) {
				System.out.println("Price not found in this shoe block — skipping.");
			}
		}

		// Sort and compare
		List<Integer> sortedPrices = new ArrayList<Integer>(priceList);
		Collections.sort(sortedPrices);

		// Assertion
		Assert.assertEquals(priceList, sortedPrices, "Prices are NOT sorted low to high!");
		System.out.println("Price sorting check complete.");
		
}
}