package packageAmazon.ProjectAmazon;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Testcase2_LogintoAmazon extends BaseClass 
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void validcredentials() throws InterruptedException, EncryptedDocumentException, IOException
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
		
		String expectedname=home.welcomemessage.getText();
		Assert.assertTrue(expectedname.contains("Treesa"), "login not successful");
		
	}

}

