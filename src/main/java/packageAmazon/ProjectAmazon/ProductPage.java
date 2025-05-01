package packageAmazon.ProjectAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	@FindBy(xpath="(//span[@class='a-price-whole'])[1]")
	WebElement price;
	
	
	
	public ProductPage()
	{
		PageFactory.initElements(driver, this);
	}
	

}
