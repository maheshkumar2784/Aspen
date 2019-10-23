package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase extends commonObjects{

	@BeforeSuite
	public void beforeSuite() throws IOException {
		System.out.println("############BeforeSuite##########");
		initializelog4j();
		initializeProperties();
		initializeExtentReports();
	}

	public static void initializelog4j() {
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		log.info("Welcome to log4j");
		log.error("This is demonstration to log4j");
	}

	public void initializeProperties() throws IOException {
		prpt=new Properties();
		File file1=new File("./config/configuration.properties");  //locating configuration file
		File file2=new File("./config/configuration2.properties");
		log.info("Configuration file is located"+file1);
		FileInputStream ipFile1=new FileInputStream(file1); //reading input file
		FileInputStream ipFile2=new FileInputStream(file2);
		log.info("Reading Input File"+ipFile1.toString());
		prpt.load(ipFile1);  //reading properties from input file
		prpt.load(ipFile2);  //reading properties from input file
		log.info("Reading properties file");
		browserValue=prpt.getProperty("browser");
		log.info("Browser value is: "+browserValue);
		String environmentValue=prpt.getProperty("environment");
		log.info("Environment value is: "+environmentValue);
		urlTest=prpt.getProperty("urlTest");
		urlStage=prpt.getProperty("urlStage");
		env=prpt.getProperty("environment");
		url=prpt.getProperty("url");
	}

	public void initializeExtentReports() {
		String extentReportPath=System.getProperty("user.dir")+"/ExtentReports/"+"Report1.html";
		extentReports=new ExtentReports();
		extentHtmlReporter=new ExtentHtmlReporter(extentReportPath);
		extentHtmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/config/ExtentReportConfig.xml");
		extentReports.attachReporter(extentHtmlReporter); 
		extentReports.setSystemInfo("Environment",  prpt.getProperty("environment"));
		extentReports.setSystemInfo("Author Name", "Mahesh");
		extentReports.setSystemInfo("Release", prpt.getProperty("release"));
		extentReports.setSystemInfo("Project Name", "Aspen Demo");
		extentReports.setSystemInfo("Executor", "Maheshkumar");
		extentReports.setSystemInfo("Reviewer", "Jagannathan");
		//		extentTest=extentReports.createTest("TestCase1");   //creating test case to enter log details pass/fail statements
		//closing the report
	}



	@AfterSuite
	public void afterSuite() throws InterruptedException {	
		extentReports.flush(); 
		log.info("Closing extent reports");
		System.out.println("This is After Suite Method");
		Thread.sleep(5000);
		log.info("Browser is closing");
		driver.quit();
	}
	/*
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is Before Test Method");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("This is After Test Method");
	}
	 */

	@BeforeClass
	public void beforeClass() {
		System.out.println("This is Before Class Method");
		openBrowser();
		enterURL();
	}

	private void openBrowser() {
		if(browserValue.equalsIgnoreCase("chrome")) {
			String browserPathChrome="./drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", browserPathChrome);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--start-maximized");
			//			options.addArguments("--disable-popup-blocking");
			options.setCapability("pageLoadStrategy", "none");
			options.addArguments("disable-infobars");
			//			options.addArguments("headless");  //to open browser in headless mode
			driver=new ChromeDriver(options);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		}else
			if(browserValue.equalsIgnoreCase("ie")) {
				String browserPathIE="./drivers/IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", browserPathIE);
				driver=new InternetExplorerDriver();
			}	
		//		driver.manage().window().maximize();  
		log.info("Chrome Browser opened");	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  //webelement
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);  //browser
	}

	public void enterURL() {
		if(env.equalsIgnoreCase("test")) {
			driver.get(urlTest);		
		}else
			if(env.equalsIgnoreCase("stage")) {
				driver.get(urlStage);		
			}	
			else {
				driver.get(url);
			}
		log.info("url entered");
	}

	public void enterURL(String url) {
		driver.get(url);
		log.info("url entered: "+url);
	}

	@AfterClass
	public void afterClass() {
		//		driver.quit();  //close the browser
		System.out.println("This is After Class Method");
	}

	@BeforeMethod
	public void beforeMethod() {
		//		System.out.println("This is Before Method"+ getClass().getEnclosingClass());
		//		System.out.println(getClass().getEnclosingClass().getEnclosingMethod().getName());
	}

	@AfterMethod
	public void afterMethod() {
		//		System.out.println("This is After Method"+this.getClass().getEnclosingMethod().getName());

	}

	public boolean isDisplayed(WebElement element) {

		if(element.isDisplayed()){
			log.info("Element is displayed");
			return true;
		}else
		{
			log.error("Element is not displayed");
			return false;
		}		
	}
	public boolean isenabled(WebElement element) {
		if(element.isEnabled()){
			log.info("Element is displayed");
			return true;
		}else
		{
			log.error("Element is not displayed");
			return false;
		}		
	}

	public boolean isSelected(WebElement element) {
		if(element.isSelected()){
			log.info("Element is displayed");
			return true;
		}else
		{
			log.error("Element is not displayed");
			return false;
		}		
	}

	public void selectByValue(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByValue(value);
		log.info("Value selected from dropdown: "+value);
	}

	public void selectByIndex(WebElement element, int value) {
		Select select=new Select(element);
		select.selectByIndex(value);
		log.info("Index selected from dropdown: "+value);
	}

	public void selectByVisibleText(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByVisibleText(value);
		log.info("Visiv=ble text selected from dropdown: "+value);
	}

	public void click(WebElement element) {
		try {
			WebDriverWait wait= new WebDriverWait(driver, 40);  //time is in seconds
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();		
		}catch(Exception e) {
			log.error("Element is not clickable"+element);
		}
	}
}

