package TestSet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test1 {

	@Test
	@Parameters({"url","user"})  //parameter names
	void Facebook(String url1, String username) {
		String browserPath;
		String url;
		Logger log = Logger.getLogger("Facebook Login");		
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

		log.info("url###"+url1);
		log.info("username###"+username);
		browserPath="./drivers/chromedriver.exe";
		url=url1;
		System.setProperty("webdriver.chrome.driver", browserPath);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);	
		log.info(driver.getTitle());
	}
}