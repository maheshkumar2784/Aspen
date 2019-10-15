package TestSet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test2 {

	@Test
	void Selenium() {
		String browserPath;
		String url;

		Logger log = Logger.getLogger("Selenium Page");		
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

		browserPath="./drivers/chromedriver.exe";
		url="http://www.seleniumhq.org";
		System.setProperty("webdriver.chrome.driver", browserPath);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);	
		log.info(driver.getTitle());
	}
}