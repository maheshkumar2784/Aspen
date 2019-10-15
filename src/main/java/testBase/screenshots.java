package testBase;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sun.media.jfxmedia.logging.Logger;


public class screenshots {
	public String takeScreenshot(WebDriver driver, String screenName) throws IOException {
		LocalDateTime ldt=LocalDateTime.now();
		DateTimeFormatter formatDate=DateTimeFormatter.ofPattern("ddMMMyyyy_HHmmss");
		String dateFormatting=formatDate.format(ldt);
		File screenShot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  //capture screenshot
		String screenshotLocation=System.getProperty("user.dir")+"/screenshots/"+screenName+dateFormatting+".png";  //creating a file location to save screenshot
		System.out.println(screenshotLocation);
		FileUtils.copyFile(screenShot, new File(screenshotLocation));  //copying screenshot to the file
		System.out.println(screenshotLocation);
		return screenshotLocation;

		//		String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		//		FileUtils.copyFile(screenshotBase64, screenshotBase64);
	}

}
