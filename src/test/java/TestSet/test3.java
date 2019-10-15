package TestSet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test3 {
	
	@Test
	void Rediff() {
		String browserPath;
		String url;

		Logger log = Logger.getLogger("Rediff web");		
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

		browserPath="./drivers/chromedriver.exe";
		url="http://www.rediff.com";
		System.setProperty("webdriver.chrome.driver", browserPath);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);	
		log.info(driver.getTitle());
	}
}