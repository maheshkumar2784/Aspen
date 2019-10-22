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
	
	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnSignIn() {
		return btnSignIn;
	}

	public AspenLoginPage() {
		PageFactory.initElements(driver, this);
	}	
		
}
