package packageAmazon.ProjectAmazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
	
	@FindBy(xpath="//span[@class='rush-component s-latency-cf-section']/div/div")
	List<WebElement> listofsearch;
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

	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
