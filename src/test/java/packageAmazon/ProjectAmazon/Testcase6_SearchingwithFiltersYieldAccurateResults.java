package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase6_SearchingwithFiltersYieldAccurateResults extends BaseClass
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void searchingwithFiltersYieldAccurateResults() throws InterruptedException, EncryptedDocumentException, IOException
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
		searchresult.category();
		for(int i=0; i<searchresult.productlist.size();i++)
		{
			String productName = searchresult.productlist.get(i).getText();
			Assert.assertTrue(productName.contains("ASIAN"));
		}

		
}
}