package packageAmazon.ProjectAmazon;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;


@Listeners(ListnerLogic.class)
public class BaseClass extends ListnerLogic{
	//WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void launch(String nameofbrowser) throws InterruptedException
	{
		if(nameofbrowser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		if(nameofbrowser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		if(nameofbrowser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
	
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterMethod
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
