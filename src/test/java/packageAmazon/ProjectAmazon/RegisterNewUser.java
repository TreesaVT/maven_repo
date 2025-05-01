package packageAmazon.ProjectAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;




public class RegisterNewUser extends BaseClass 
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void RegisternewUser() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		Thread.sleep(2000);
		
		Homepage home=new Homepage(driver);
		home.acntndlst(driver);
		home.rgstr();
		
		LoginPage login=new LoginPage(driver);
		login.un();
		login.cont();
		login.pwd();
		login.signin();
		
		String expectedname=home.welcomemessage.getText();
		SoftAssert s1=new SoftAssert();
		s1.assertTrue(expectedname.contains("Treesa"));
		s1.assertAll();
	}

}
