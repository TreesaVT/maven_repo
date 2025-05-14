package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase3_LoginFailswithIncorrectEmailorPassword  extends BaseClass 
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void invalidcredentials() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Homepage home=new Homepage(driver);
		home.acntndlst(driver);
		home.signin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginPage login=new LoginPage(driver);
		login.uname(2,0);
		login.cont();
//		login.pswrd("dtdf");
//		login.signin();
		Thread.sleep(2000);
		String expectedalert=login.invalidemail.getText();
		System.out.println(expectedalert);
		Assert.assertTrue(expectedalert.contains("Invalid"), "Testing invalid email failure");
		
    }
}
