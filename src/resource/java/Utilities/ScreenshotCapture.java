package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCapture 
{
	WebDriver driver;
	public static String CaptureScreenshot(WebDriver driver, String ScreenshotName) throws IOException
	{
		String ScreenshotFolderPath=System.getProperty("user.dir")+"/src/ScreenshotCapture/"+ScreenshotName+".png";
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File fs=takescreenshot.getScreenshotAs(OutputType.FILE);
		File destination=new File(ScreenshotFolderPath);
		FileUtils.copyFile(fs, destination);
		return ScreenshotFolderPath;
	}
}
