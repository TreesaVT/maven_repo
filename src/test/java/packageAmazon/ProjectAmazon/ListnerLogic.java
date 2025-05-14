package packageAmazon.ProjectAmazon;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnerLogic implements ITestListener
{
	public static WebDriver driver;
	static String date()
	{
		Date d1=new Date();
		String format1=	d1.toString();
		String month=	format1.substring(4, 7);
		String date=	format1.substring(8, 10);
		String year=	format1.substring(format1.length()-4);
		String hour=format1.substring(11, 13);
		String min=format1.substring(14, 16);
		String sec=format1.substring(17, 19);
		String format5=date.concat(" ").concat(month).concat(" ").concat(year).concat(" ").concat(hour).concat(" ").concat(min).concat(" ").concat(sec);
		return format5;
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		String methodName = result.getMethod().getMethodName();
		Reporter.log("Test case Passed "+methodName);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\User\\eclipse-workspace\\ProjectAmazon\\Screenshot\\Passed testcases\\"+methodName+" "+date()+".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		String methodName = result.getMethod().getMethodName();
		Reporter.log("Test case Failed"+methodName);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\User\\eclipse-workspace\\ProjectAmazon\\Screenshot\\Failed Testcases\\"+methodName+" "+date()+".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
