package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Testcase5_LogintoAmazon_SearchforAproduct extends BaseClass
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void validcredentials_searchingproduct() throws InterruptedException, EncryptedDocumentException, IOException
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
		int countofshoes=home.listofsearch.size();
		System.out.println(countofshoes);
		Assert.assertEquals(countofshoes>50, true);
		
	}

}

