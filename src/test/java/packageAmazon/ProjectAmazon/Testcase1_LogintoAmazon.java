package packageAmazon.ProjectAmazon;

import org.testng.Assert;
import org.testng.annotations.Test;



public class Testcase1_LogintoAmazon extends BaseClass 
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void validcredentials() throws InterruptedException
	{
		Homepage home=new Homepage(driver);
		home.acntndlst(driver);
		home.signin();
		Thread.sleep(6000);
		
		LoginPage login=new LoginPage(driver);
		login.un();
		login.cont();
		login.pwd();
		login.signin();
		
		String expectedname=home.welcomemessage.getText();
		Assert.assertTrue(expectedname.contains("Treesa"), "login not successful");
		
	}

}

