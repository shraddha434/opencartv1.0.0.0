package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class Login  extends TestBase{

	public Login(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver,this );
	
	}
	
	//Locators 
	


@FindBy (xpath="//input[@id='input-email']")
WebElement txtEmail ;

@FindBy (xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy (xpath="//input[@value='Login']")
WebElement btnLogin;

//Actions /Methods

public void addlogin(String email ,String pswd) throws InterruptedException {
	txtEmail.sendKeys(email);
	Thread.sleep(5000);
	
	txtPassword.sendKeys(pswd);
	
	btnLogin.click();
	
	
}


}
