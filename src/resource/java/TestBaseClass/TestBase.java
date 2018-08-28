package TestBaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase {

	
	String reportPath=System.getProperty("user.dir")+"/src/ExtentReports/"+getClass().getSimpleName()+".html";

	protected WebDriver driver;
	public ExtentHtmlReporter e1;
	public ExtentReports e2;
	public ExtentTest e3;
	
	
	@BeforeSuite
	public void InitialisingExtentReports()
	{
		e1=new ExtentHtmlReporter(reportPath);
		e2=new ExtentReports();
		e2.attachReporter(e1);
		
		e2.setSystemInfo("User Name", "DheerajPratapSingh@gmail.com");
		e2.setSystemInfo("Tester Name", "Dheeraj Pratap Singh");
		e2.setSystemInfo("Enviroment", "QA");
		e2.setSystemInfo("Sprint Version", "V.23123");
		e2.setSystemInfo("Sprint Name", "Auqaman");
		e2.setSystemInfo("Host Name", "KJKLEKWLKDJ23123");
		e2.setSystemInfo("Host Number", "127.0.0.1");
		
		e1.config().setDocumentTitle(getClass().getSimpleName() + " Secenario Test for the WesterUnion site");
		e1.config().setReportName(this.getClass().getSimpleName());
		e1.config().setTestViewChartLocation(ChartLocation.TOP);
		e1.config().setTheme(Theme.DARK);
	}
	
	@AfterSuite
	public void GeneratingReport()
	{
		e2.flush();
	}
	@BeforeTest
	public void OpeningBrowser() {
		
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://www.westernunion.com/gb/en/home.html");

	}
	
	@AfterClass
	public void ClosingBrowser() throws Exception
	{
		Thread.sleep(3000);
		driver.close();
	}
}
