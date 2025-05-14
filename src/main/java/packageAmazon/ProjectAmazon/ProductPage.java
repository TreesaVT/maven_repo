package packageAmazon.ProjectAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy(xpath="(//span[@class='a-price-whole'])[1]")
	WebElement price;
	
	@FindBy(xpath="//h2[.=' Product description  ']")
	WebElement description;
	
	@FindBy(xpath="//h2[.='Customer reviews']")
	WebElement reviews;
	
	@FindBy(xpath="//*[contains(text(), 'Added to cart')]")
	WebElement addedTocartText;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement addtocart;
	
	@FindBy(xpath="//*[contains(text(), 'Go to Cart')]")
	WebElement gotocart;
	
	
	public void addcart()
	{
		addtocart.click();
	}
	public void gocart()
	{
		gotocart.click();
	}
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

}
