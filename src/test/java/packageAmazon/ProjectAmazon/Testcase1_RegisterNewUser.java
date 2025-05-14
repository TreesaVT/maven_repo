package packageAmazon.ProjectAmazon;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testcase1_RegisterNewUser extends BaseClass 
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void RegisternewUser() throws InterruptedException, EncryptedDocumentException, IOException
	{
				
		Homepage home=new Homepage(driver);
		home.acntndlst(driver);
		home.rgstr();
		
		LoginPage login=new LoginPage(driver);
		login.uname(1,0);
		login.cont();
		login.pswrd(1,1);
		login.signin();
		
		String expectedname=home.welcomemessage.getText();
		SoftAssert s1=new SoftAssert();
		s1.assertTrue(expectedname.contains("Treesa"));
		s1.assertAll();
	}

}
