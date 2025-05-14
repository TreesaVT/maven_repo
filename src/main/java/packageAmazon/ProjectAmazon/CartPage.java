package packageAmazon.ProjectAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(xpath="//span[@class='a-icon a-icon-small-add']")
	WebElement incrementbutton;
	
	@FindBy(id="nav-cart-count")
	WebElement itemquantity;
	
//	@FindBy(xpath="//span[@class='a-icon a-icon-small-add']")
//	WebElement updatedquantity;
	
	@FindBy(xpath="//span[@class='a-icon a-icon-small-remove']")
	WebElement decrementbutton;
	
	@FindBy(name="proceedToRetailCheckout")
	WebElement proceedtobuybutton;
	
	//2
	public void increment()
	{
		incrementbutton.click();;
	}
	
	public void decrement()
	{
		decrementbutton.click();
	}
	public void proceedtobuy()
	{
		proceedtobuybutton.click();
	}
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
