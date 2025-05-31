package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import testBase.TestBase;

public class Registarionpage extends TestBase  {
	
	
	// constructor 
	public Registarionpage(WebDriver driver) {
		
		super(driver);
		}
 
	
	

@FindBy (xpath="//input[@id='input-firstname']") 
@CacheLookup private WebElement txtfirstName;

@FindBy(xpath="//input[@id='input-lastname']")
@CacheLookup private WebElement txtlastName;

@FindBy(xpath="//input[@id='input-email']")
@CacheLookup private WebElement txteMail;

@FindBy(xpath="//input[@id='input-telephone']") 
@CacheLookup private WebElement txttelephone;

@FindBy(xpath="//input[@id='input-password']")
@CacheLookup private WebElement txtpassword;

@FindBy(xpath="//input[@id='input-confirm']") 
@CacheLookup private WebElement txtpasswordConfirm;

@FindBy(xpath="//input[@name='agree']") 
@CacheLookup private WebElement chkagree;

@FindBy(xpath="//input[@value='Continue']") 
@CacheLookup private WebElement btncontinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
@CacheLookup private WebElement msgcnfrm;

//Actions/methods 


public void addPersonalDetail(String fname ,String lname,String Email,String telephone) 
{
	
	txtfirstName.sendKeys(fname);
	txtlastName.sendKeys(lname);
	txteMail.sendKeys(Email);
	txttelephone.sendKeys(telephone);
	}

public void addPassword(String pwd,String confirmpwd) {
	
	txtpassword.sendKeys(pwd);
	txtpasswordConfirm.sendKeys(confirmpwd);
}

public void submit() {
	
	chkagree.click();
	btncontinue.click();
}
public String getconfirmationmsg() {
	
	return (msgcnfrm.getText());
	
}
}
