package packageAmazon.ProjectAmazon;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	WebDriver driver;
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	WebElement accountandlist;
	
	@FindBy(linkText="Start here.")
	WebElement register;
	
	@FindBy(xpath="(//span[.='Sign in'])[1]")
	WebElement signinbutton;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchbutton;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement welcomemessage;
	
	@FindBy(xpath="//div[@class='a-section aok-relative s-image-tall-aspect']")
	List<WebElement> listofsearch;
	
	@FindBy(xpath="//button[@class='sc-fqkvVR sc-kMkxaj lajAPo qrSrg']")////button[.='Manage Profiles']
	WebElement manageprofile;
	
	@FindBy(id="nav-orders")
	WebElement ordersbutton;
	
	@FindBy(xpath="//a[@id='nav-cart']")
	WebElement cartbutton;
	
	
	
	//2
	public void acntndlst(WebDriver driver)
	{
		Actions a1=new Actions(driver);
	    a1.moveToElement(accountandlist).perform();
	}
	
	public void signin()
	{
		signinbutton.click();
	}
	
	public void rgstr()
	{
		register.click();
	}
	
	public void search()
	{
		searchbutton.sendKeys("shoe"+Keys.ENTER);
	}
	public void productdetail()
	{
		listofsearch.get(1).click();
	}
	public void switchtochild(WebDriver driver)
	{
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> id=ids.iterator();
		String parentid=id.next();
		String childid1=id.next();
		driver.switchTo().window(childid1);
	}
	public void mngprfl()
	{
		manageprofile.click();
	}
	public void ordrbtn()
	{
		ordersbutton.click();
	}
	public void cart()
	{
		cartbutton.click();
	}
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
