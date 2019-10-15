package testBase;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class commonObjects extends screenshots{
	public static Logger log = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	public static String urlTest;
	public static String urlStage;
	public static String browserValue;
	public static String env;
	static String url;
	public ExtentReports extentReports; //instance of reports
	public ExtentHtmlReporter extentHtmlReporter;  //designing html report
	public ExtentTest extentTest;  //instance of the logs
	public Properties prpt;
}
