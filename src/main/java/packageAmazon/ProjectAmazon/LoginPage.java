package packageAmazon.ProjectAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
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
	
	//2
	public void un()
	{
		username.sendKeys("treesa.jincy43@gmail.com");
	}
	
	public void cont()
	{
		continuebutton.click();
	}
	public void pwd()
	{
		password.sendKeys("Jincy@43");
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
