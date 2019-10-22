package aspenPageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class AspenHomePage extends TestBase{



	@FindBy(xpath="//*[@id='header']/div/div[4]/div/ul/li[3]/a") 
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//*[@title='Schedule an Appointment']")
	WebElement lnkScheduleAppt;
	
	@FindBy(xpath="//*[@id='location']/div[1]/div/div[2]/h2")
	WebElement ConfLoc;
	
	public WebElement getLnkMyAccount() {
		return lnkMyAccount;
	}
	
	public WebElement getLnkScheduleAppt() {
		return lnkScheduleAppt;
		
	}
	
	public WebElement getConfloc() {
		return ConfLoc;	
		
	}

	public AspenHomePage() {
		PageFactory.initElements(driver, this);
	}	
		
}
