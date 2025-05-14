package packageAmazon.ProjectAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	@FindBy(xpath="//a[@class='a-link-normal expand-panel-button celwidget']")
	WebElement adresschangebutton;
	
	@FindBy(xpath="(//div[@class='a-row']/div)[4]")
	WebElement selectadress;
	
	@FindBy(xpath="//span[@class='a-button-inner']")
	WebElement submitadress;
	
	@FindBy(xpath="//a[@id='prime-interstitial-nothanks-button']")
	WebElement nothanksbutton;
	
	@FindBy(xpath="//h2[@id='deliver-to-customer-text']")
	WebElement deliveryadress;
	
	@FindBy(xpath="(//a[@class='a-link-normal expand-panel-button celwidget'])[2]")
	WebElement paymentchangbutton;
	
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[7]")
	WebElement cashondelivery;
	
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[3]")
	WebElement creditordebitcard;
	
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[2]")
	WebElement amazonpay;
	
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[4]")
	WebElement netbanking;
	
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[5]")
	WebElement otherupi;
	
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[6]")
	WebElement emi;
	
	@FindBy(xpath="//input[@placeholder='Enter Code']")
	WebElement entercouponcode;
	
	@FindBy(xpath="//input[@name='ppw-claimCodeApplyPressed']")
	WebElement applycoupon;
	
	@FindBy(xpath="(//div[.='The promotional code you entered is not valid.'])")
	WebElement alertText;
	
	@FindBy(xpath="//*[contains(text(), 'Review Order')]")
	WebElement revieworder;
		
	@FindBy(linkText="(//input[@class='a-button-input'])[1]")//(//*[contains(text(), 'Use this payment method')])[1]
	WebElement submitpaymentmethod;
	
	//2
	public void adresschng()
	{
		adresschangebutton.click();
	}
	
	public void slctaddress()
	{
		selectadress.click();
	}
	public void sbmtadress()
	{
		submitadress.click();
	}
	public void nothanks()
	{
		nothanksbutton.click();
	}
	public void pymntcng()
	{
		paymentchangbutton.click();
	}
	
	public void cod()
	{
		cashondelivery.click();
	}
	public void card()
	{
		creditordebitcard.click();
	}
	public void amznpay()
	{
		amazonpay.click();
	}
	public void netbnkng()
	{
		netbanking.click();
	}
	public void upi()
	{
		otherupi.click();
	}
	public void emipay()
	{
		emi.click();
	}
	public void entrcouponcode()
	{
		entercouponcode.sendKeys("newuser");
	}
	public void apply()
	{
		applycoupon.click();
	}
	public void review()
	{
		revieworder.click();
	}
	public void sbmtpaymnt()
	{
		submitpaymentmethod.click();
	}

	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
