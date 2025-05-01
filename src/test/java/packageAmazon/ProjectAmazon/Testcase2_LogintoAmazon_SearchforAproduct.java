package packageAmazon.ProjectAmazon;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;



public class Testcase2_LogintoAmazon_SearchforAproduct extends BaseClass
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void validcredentials_searchingproduct() throws InterruptedException
	{
		Homepage home=new Homepage(driver);
		home.acntndlst(driver);
		home.signin();
		
		LoginPage login=new LoginPage(driver);
		login.un();
		login.cont();
		login.pwd();
		login.signin();
		
		home.search();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int countofshoes=home.listofsearch.size();
		System.out.println(countofshoes);
		Assert.assertEquals(countofshoes>50, true);
		
	}

}

