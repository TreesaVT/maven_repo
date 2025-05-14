package packageAmazon.ProjectAmazon;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase4_EditProfileInfo extends BaseClass 
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void editProfileInfo() throws AWTException, InterruptedException, EncryptedDocumentException, IOException
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
		
		home.acntndlst(driver);
		home.mngprfl();
		ProfilePage profile=new ProfilePage(driver);
		profile.acnthldr();
		String name=profile.profilename.getText();
		System.out.println(name);
		profile.edtbtn();
		profile.edtprfl();
		Thread.sleep(2000);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(profile.editcontinuebutton));
		profile.edtcnt();
		Thread.sleep(2000);
		String editedname=profile.profilename.getText();
		System.out.println(editedname);
		Assert.assertNotEquals(name, editedname,"Profile not updated" );
		
		//reverting back
		profile.edtbtn();
		profile.edtprflToDefaultname();
		Thread.sleep(2000);
		profile.edtcnt();
		
	}

	
}

