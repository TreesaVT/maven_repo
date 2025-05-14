package packageAmazon.ProjectAmazon;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchResultPage {
	WebDriver driver;
	@FindBy(xpath="//a[@aria-label='Apply the filter ASIAN to narrow results']")
	WebElement filtercategory;
	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base']")
	List<WebElement> productlist;

	@FindBy(css="#s-result-sort-select")
	WebElement sortbybutton;
	
	@FindBy(xpath="//span[@class='a-price-whole']")//cssselector//span[@class='a-price-whole']
	List<WebElement> priceofeachshoe;
	
	
	
	//2
	public void category()
	{
		filtercategory.click();
	}
	public void sortby()
	{
		Select s1 = new Select(sortbybutton);
		s1.selectByIndex(1);
	}
	
	

	public SearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
