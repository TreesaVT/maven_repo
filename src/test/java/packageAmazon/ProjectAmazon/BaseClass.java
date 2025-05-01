package packageAmazon.ProjectAmazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	WebDriver driver;
	//@Parameters("browser")
	@BeforeMethod
	public void launch() throws InterruptedException
	{
//		if(nameofbrowser.equals("chrome"))
//		{
			driver=new ChromeDriver();
//		}
//		if(nameofbrowser.equals("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//		if(nameofbrowser.equals("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
	
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterMethod
	public void quit()
	{
		driver.close();
	}
}
