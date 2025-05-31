package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePage extends TestBase  {
	
	
	// constructor 
	public HomePage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver,this );

		}

// locators 
	
	@FindBy (xpath="//span[normalize-space()='My Account']")
	WebElement account;
	
	@FindBy (xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy (xpath="//a[normalize-space()='Login']")
	
	WebElement Login;
	
	
	@FindBy (xpath="(//a[normalize-space()='Logout'])[1]")
	
	WebElement logout ;
	
	
	//Actions/method
	
	public void clickMyaccount() {
		account.click();
	}
	
	public void clickRegister() {
		Register.click();
	}
	
	public void clicklogin() {
		
		Login.click();
	}
	public void clicklogout() {
		logout.click();
	}
}
