package packageAmazon.ProjectAmazon;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ExcelSheetHandler
{
	WebDriver driver;
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(id="continue")
	WebElement continuebutton;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signinbutton;
	
	@FindBy(xpath="(//div[@class='a-box-inner a-alert-container'])[3]")
	WebElement invalidemail;
	//2
	public void uname(int row,int column) throws EncryptedDocumentException, IOException
	{
		String un=ExcelSheetHandler.exceldata(row, column);
		username.sendKeys(un);
	}
	public void cont()
	{
		continuebutton.click();
	}
	public void pswrd(int row,int column) throws EncryptedDocumentException, IOException
	{
		String pwd=ExcelSheetHandler.exceldata(row, column);
		password.sendKeys(pwd);
	}
	public void signin()
	{
		signinbutton.click();
	}
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
