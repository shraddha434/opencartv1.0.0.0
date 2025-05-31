package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.TestBase;

public class MyAccountPage extends TestBase

{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//h2[normalize-space()='My Account']")
	WebElement Msgheadingpage;
	
	
	public boolean  verifyMyAccount() {
		
	try {
		return Msgheadingpage.isDisplayed();
	 }catch (Exception e) {
		
		 return false;
	 }
	
	
	
		
	}
	
	
	

}
