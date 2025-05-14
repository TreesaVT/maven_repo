package packageAmazon.ProjectAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	WebDriver driver;
	
	@FindBy(linkText="View")
	WebElement accountholder;
	
	@FindBy(xpath="//div[@class='profile-name desktop']")
	WebElement profilename;
	
	@FindBy(xpath="//button[.='Edit your details']")
	WebElement editbutton;
	
	@FindBy(xpath="//input[@id='editProfileNameInputId']")
	WebElement editprofile;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement editcontinuebutton;
	
	//2
	
	public void acnthldr()
	{
		accountholder.click();
	}
	public void edtbtn()
	{
		editbutton.click();
	}
	public void edtprfl()
	{
		editprofile.clear();
		editprofile.sendKeys("Treesa VT");
	}
	public void edtprflToDefaultname()
	{
		editprofile.clear();
		editprofile.sendKeys("Treesa");
	}
	public void edtcnt()
	{
		editcontinuebutton.click();	
	}
	

	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
