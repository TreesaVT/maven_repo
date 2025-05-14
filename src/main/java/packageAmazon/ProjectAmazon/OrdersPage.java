package packageAmazon.ProjectAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
	WebDriver driver;

	@FindBy(xpath="//*[contains(text(), 'Write a product review')]")
	WebElement reviewproduct;
	
	@FindBy(xpath="//a[.='Amazon Brand - Solimo Collage Set of 11 Black Photo Frames ( 4 x 6 Inch - 2 & 5 X 5 Inch - 6, 5 X 7 inch - 2 & 8 X 10 inch - 1 ), Rectangular, Synthetic, Tabletop']/following-sibling::div/button[5]")//((//div[@class='a-section ryp__review-candidate__star-container'])[4]/button)[5]
	WebElement fivestar;//(//div[@class='in-context-ryp__form-field--starRating']/span)[5]
	
	@FindBy(xpath="//*[contains(text(), 'Write a review')]")
	WebElement writeareview;
	
	@FindBy(xpath="//textarea[@placeholder='What should other customers know?']")
	WebElement reviewcomment;
	
	@FindBy(xpath="//input[@id='reviewTitle']")
	WebElement reviewtitle;
	
	@FindBy(xpath="(//span[@class='a-button-text'])[1]")
	WebElement submitreview;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement reviewsubmittedText;
	
	//2
	public void review()
	{
		reviewproduct.click();
	}
	
	public void rate()
	{
		fivestar.click();
	}
	public void writereview()
	{
		writeareview.click();
	}
	public void reviewcmnt()
	{
		reviewcomment.sendKeys("good");
	}
	public void tiltle()
	{
		reviewtitle.sendKeys("good");
	}
	public void submit()
	{
		submitreview.click();
	}
	
	public OrdersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
