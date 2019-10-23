package aspenPageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;


public class AspenLoginPage extends TestBase{

	
	@FindBy(id="username") 
	WebElement txtUserName;

	
	@FindBy(id="password") 
	WebElement txtPassword;
		
	@FindBy(id="sign-in-submit") 
	WebElement btnSignIn;
	
	@FindBy(xpath="//div[@id='failure']//span") 
	WebElement Errmsg;
	
			
	//String actualMsg = driver2.findElement(By.xpath("//div[@id='statusMsg']/div[@class='alert in fade alert-error']")).getAttribute("innerHTML");
	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnSignIn() {
		return btnSignIn;
	}

	public WebElement getErrmsg() {
		return Errmsg;
	}
	
	public AspenLoginPage() {
		PageFactory.initElements(driver, this);
	}	
		
}
