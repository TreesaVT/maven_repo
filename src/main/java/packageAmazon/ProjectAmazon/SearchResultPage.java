package packageAmazon.ProjectAmazon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver driver;
	@FindBy(xpath="//a[@aria-label='Apply the filter ASIAN to narrow results']")
	WebElement filtercategory;
	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base']")
	List<WebElement> productlist;

	@FindBy(xpath="//span[.='Sort by:']")
	WebElement sortbybutton;
	
	@FindBy(xpath="(//div[@class='a-popover-inner']/ul/li)[2]")
	WebElement sortlowtohigh;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-base']")
	List<WebElement> listofshoes;
	
	@FindBy(xpath="//span[@class='a-price-whole']")
	WebElement priceofeachshoe;
	
	
	
	//2
	public void category()
	{
		filtercategory.click();
	}
	public void sortby()
	{
		sortbybutton.click();
	}
	
	public void lowtohigh()
	{
		sortlowtohigh.click();
	}
	
//	public void sorting()
//	{
//		List<Integer> priceList = new ArrayList<Integer>();
//	}
	
	public SearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
